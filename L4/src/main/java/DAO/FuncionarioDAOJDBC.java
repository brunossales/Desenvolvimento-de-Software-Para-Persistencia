package DAO;

import model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAOJDBC implements  FuncionarioDao{
    Connection conn = null;
    public FuncionarioDAOJDBC() throws SQLException {
        conn = ConectionFactory.getConnection();
        System.out.println("Deu certo");
    }
    @Override
    public List<Funcionario> findAll(){
        List<Funcionario> funcs = new ArrayList<Funcionario>();
        String sql = "select * from funcionario";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Funcionario fu = map(rs);
                funcs.add(fu);
            }
        } catch (SQLException throwables) {
            throw new DAOException("Erro no FindAll ", throwables);
        }
        return funcs;
    }

    @Override
    public Funcionario findId(int id) {
        String sql = "SELECT * FROM funcionario WHERE idfun = ?";
        Funcionario funAux = null;
        try{
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next())
                funAux = map(rs);
        } catch (SQLException throwables) {
            throw  new DAOException("Erro no findId ", throwables);
        }
        return funAux;
    }

    @Override
    public void insert(Funcionario fun) {
        String sql = "INSERT INTO funcionario (idfun, cpf, matricula, nome, email, telefone)" +
                " VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, fun.getId());
            ps.setString(2, fun.getCpf());
            ps.setInt(3, fun.getMatricula());
            ps.setString(4, fun.getNome());
            ps.setString(5, fun.getEmail());
            ps.setString(6, fun.getTelefone());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new DAOException("Problema em inserir", throwables);
        }
    }

    @Override
    public void updateNome(int id, String nome) {
        String sql = "UPDATE funcionario SET nome = ? WHERE idFun = ?";
        try{
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nome);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throw  new DAOException("Erro no UpdateNome ", throwables);
        }
    }

    @Override
    public void updateEmail(int id, String email) {
        String sql = "UPDATE funcionario SET email = ? WHERE idFun = ?";
        try{
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, email);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throw new DAOException("Erro no UpdateNome ", throwables);
        }
    }

    @Override
    public void updateTelefone(int id, String telefone) {
        String sql = "UPDATE funcionario SET telefone = ? WHERE idFun = ?";
        try{
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, telefone);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throw new DAOException("Erro no UpdateTelefone ", throwables);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM funcionario WHERE idFun = ?";
        try{
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throw new DAOException("Erro no delete ", throwables);
        }
    }

    private Funcionario map (ResultSet rs) throws SQLException {
        Funcionario aux = new Funcionario();
        aux.setId(rs.getInt("id"));
        aux.setCpf(rs.getString("cpf"));
        aux.setMatricula(rs.getInt("matricula"));
        aux.setEmail(rs.getString("email"));
        aux.setNome(rs.getString("nome"));
        aux.setTelefone(rs.getString("telefone"));
        return aux;
    }
}
