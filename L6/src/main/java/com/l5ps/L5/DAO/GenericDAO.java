package com.l5ps.L5.DAO;

import com.l5ps.L5.model.Funcionario;

import java.util.List;

public interface GenericDAO<T> {
    public List<T> findAll();
    public T findId(int id);
    public void insert(T fun);
    //Update de acordo com o id, como id, cpf e matricula são unicos, o Usuário não pode altera-los
    public void updateNome(int id, String nome);
    public void updateEmail(int id, String Email);
    public void updateTelefone(int id, String Telefone);
    public void delete(int id);
}
