package com.persistencia.L7.DAO;

import com.persistencia.L7.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioDAO extends JpaRepository<Funcionario, Integer> {
    //O Sprning já reconhece e procura o primeiro com o cpf
    public Funcionario findFirstByCpf(String cpf);

    //Lista de funcionarios iniciado por "tal" telfone(ddd)
     public List<Funcionario> findByTelefoneStartingWith(String str);

    //Query do Spring data JPA
    @Query("SELECT f FROM Funcionario f WHERE f.id = :id")
    public Funcionario buscaPrimeiroId(Integer id);

    //Named Query do JPA - consulta nomeada
    @Query(name = "findAll")
    public List<Funcionario> buscaTodos();


}
