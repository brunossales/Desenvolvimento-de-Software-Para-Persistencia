package com.l5ps.L5.DAO;

import com.l5ps.L5.UI.UI;
import com.l5ps.L5.Util.JPAUtil;
import com.l5ps.L5.model.Funcionario;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@NoArgsConstructor
@Repository
@Primary
public class GenericJPADAO<T> implements GenericDAO<T>{
    protected  Class<T> persistentClass;
    public GenericJPADAO(Class<T> persistentClass){this.persistentClass = persistentClass;}

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> cq = getEm().getCriteriaBuilder().createQuery(persistentClass);
        cq.from(persistentClass);
        return getEm().createQuery(cq).getResultList();
    }

    @Override
    public T findId(int id) {
        return getEm().find(persistentClass, id);
    }

    @Override
    public void insert(T fun) {
        try {
            beginTransaction();
            getEm().merge(fun);
            commit();
            UI.viewInser();
        }catch (Exception e){
            rollback();
            UI.viewForExcep();
        }
    }

    @Override
    public void updateNome(int id, String nome) {
        Funcionario fu = (Funcionario) findId(id);
        try{
            beginTransaction();
            fu.setNome(nome);
            commit();
            UI.viewUpdate();
        }catch (Exception e){
            rollback();
            UI.viewForExcep();
        }
    }

    @Override
    public void updateEmail(int id, String Email) {
        Funcionario fu = (Funcionario) findId(id);
        try {
            beginTransaction();
            fu.setEmail(Email);
            commit();
            UI.viewUpdate();
        }catch (Exception e){
            rollback();
            UI.viewForExcep();
        }
    }

    @Override
    public void updateTelefone(int id, String Telefone) {
        Funcionario fu = (Funcionario) findId(id);
        try {
            beginTransaction();
            fu.setTelefone(Telefone);
            commit();
            UI.viewUpdate();
        }catch (Exception e){
            rollback();
            UI.viewForExcep();
        }
    }


    @Override
    public void delete(int id) {
        try {
            beginTransaction();
            getEm().remove(getEm().find(persistentClass,id));
            commit();
            UI.viewForDele();
        } catch (Exception e){
            rollback();
            UI.viewForExcep();
        }
    }

    public EntityManager getEm(){ return JPAUtil.getEntityManager();}
    public void beginTransaction(){JPAUtil.beginTransaction();}
    public void commit(){JPAUtil.commit();}
    public void rollback(){JPAUtil.rollback();}
    public void close(){JPAUtil.closeEntityManager();}

}
