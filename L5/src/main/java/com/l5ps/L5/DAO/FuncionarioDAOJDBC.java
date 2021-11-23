package com.l5ps.L5.DAO;

import com.l5ps.L5.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class FuncionarioDAOJDBC implements  FuncionarioDAO{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    private Connection conn;
    public FuncionarioDAOJDBC()  {}
    @Override
    public List<Funcionario> findAll(){
        String sql = "select * from funcionario";
        return jdbcTemplate.query(sql, (rs, rowNum) -> map(rs));
    }

    @Override
    public Funcionario findId(int id) {
        String sql = "SELECT * FROM funcionario WHERE idfun = :id";
        SqlParameterSource namedParameter = new MapSqlParameterSource().addValue("id", id);
        return jdbcTemplate.queryForObject(sql, namedParameter, ((rs, rowNum) -> map(rs)));
    }

    @Override
    public void insert(Funcionario fun) {
        String insert_sql = "INSERT INTO funcionario (idfun, cpf, matricula, nome, email, telefone)" +
                " VALUES (:id,:cpf,:matricula,:nome,:email,:telefone)";
        SqlParameterSource namedParameter = new MapSqlParameterSource()
                .addValue("id", fun.getId())
                .addValue("cpf", fun.getCpf())
                .addValue("matricula", fun.getMatricula())
                .addValue("nome", fun.getNome())
                .addValue("email", fun.getEmail())
                .addValue("telefone", fun.getTelefone());
        jdbcTemplate.update(insert_sql, namedParameter);
    }

    @Override
    public void updateNome(int id, String nome) {
        String update_sql = "UPDATE funcionario SET nome = :nome WHERE idFun = :id";
        SqlParameterSource namedParameter = new MapSqlParameterSource()
                .addValue("nome", nome)
                .addValue("id", id);
        jdbcTemplate.update(update_sql, namedParameter);
    }

    @Override
    public void updateEmail(int id, String email) {
        String update_sql = "UPDATE funcionario SET email = :email WHERE idFun = :id";
        SqlParameterSource namedParameter = new MapSqlParameterSource()
                .addValue("email", email)
                .addValue("id", id);
        jdbcTemplate.update(update_sql, namedParameter);
    }

    @Override
    public void updateTelefone(int id, String telefone) {
        String update_sql = "UPDATE funcionario SET telefone = :telefone WHERE idFun = :id";
        SqlParameterSource namedParameter = new MapSqlParameterSource()
                .addValue("telefone", telefone)
                .addValue("id", id);
        jdbcTemplate.update(update_sql, namedParameter);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM funcionario WHERE idFun = :id";
        SqlParameterSource namedParameter = new MapSqlParameterSource().addValue("id", id);
        jdbcTemplate.update(sql, namedParameter);
    }

    private Funcionario map (ResultSet rs) throws SQLException {
        Funcionario aux = new Funcionario();
        aux.setId(rs.getInt("idFun"));
        aux.setCpf(rs.getString("cpf"));
        aux.setMatricula(rs.getInt("matricula"));
        aux.setEmail(rs.getString("email"));
        aux.setNome(rs.getString("nome"));
        aux.setTelefone(rs.getString("telefone"));
        return aux;
    }
}
