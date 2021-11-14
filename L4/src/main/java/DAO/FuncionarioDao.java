package DAO;

import model.Funcionario;

import java.sql.SQLException;
import java.util.List;

public interface FuncionarioDao {
    public List<Funcionario> findAll();
    public Funcionario findId(int id);
    public void insert(Funcionario fun);
    //Update de acordo com o id, como id, cpf e matricula são unicos, o Usuário não pode altera-los
    public void updateNome(int id, String nome);
    public void updateEmail(int id, String email);
    public void updateTelefone(int id, String telefone);
    public void delete(int id);
}
