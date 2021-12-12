package com.persistencia.L7.UI;

import com.persistencia.L7.DAO.FuncionarioDAO;
import com.persistencia.L7.entity.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.swing.*;


@SpringBootApplication
@ComponentScan("com.persistencia.L7")
@EntityScan("com.persistencia.L7.entity")
@EnableJpaRepositories("com.persistencia.L7.DAO")
public class Main implements CommandLineRunner {
    @Autowired
    private FuncionarioDAO funDAO;
    public static void main(String[] args){
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
        builder.headless(false).run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        Funcionario funcionario;
        String op = null, cpf, id, st;
        do{
            try{
                op = UiUtil.menu();
                switch (op){
                    case "1":
                        funcionario = new Funcionario();
                        UiUtil.obterFuncionario(funcionario);
                        funDAO.save(funcionario);
                        UiUtil.inf();
                        break;
                    case "2":
                        id = UiUtil.pushId();
                        funcionario = funDAO.buscaPrimeiroId(Integer.parseInt(id));
                        UiUtil.obterFuncionario(funcionario);
                        funDAO.save(funcionario);
                        break;
                    case "3":
                        cpf = UiUtil.pushCpf();
                        funcionario = funDAO.findFirstByCpf(cpf);
                        UiUtil.obterFuncionario(funcionario);
                        funDAO.save(funcionario);
                        break;
                    case "4":
                        cpf = UiUtil.pushCpf();
                        funcionario = funDAO.findFirstByCpf(cpf);
                        if (funcionario != null){
                            funDAO.deleteById(funcionario.getId());
                            UiUtil.inf();
                        }
                        else
                            UiUtil.warn();
                        break;
                    case "5":
                        id = UiUtil.pushId();
                        funcionario = funDAO.buscaPrimeiroId(Integer.parseInt(id));
                        if (funcionario != null){
                            funDAO.deleteById(funcionario.getId());
                            UiUtil.inf();
                        }
                        else
                            UiUtil.warn();
                        break;
                    case "6":
                        id = UiUtil.pushId();
                        funcionario = funDAO.buscaPrimeiroId(Integer.parseInt(id));
                        UiUtil.listFun(funcionario);
                        break;
                    case "7":
                        cpf = UiUtil.pushCpf();
                        funcionario = funDAO.findFirstByCpf(cpf);
                        UiUtil.listFun(funcionario);
                        break;
                    case "8":
                        UiUtil.listFuns(funDAO.buscaTodos());
                        break;
                    case "9":
                        st = UiUtil.sherch();
                        UiUtil.listFuns(
                                funDAO.findByTelefoneStartingWith(st)
                        );
                        break;
                    case "10":
                        UiUtil.exit();
                        break;
                    default:
                        UiUtil.invalid();
                }
            }catch (NullPointerException z){
                UiUtil.exit();
            }
        }while(!op.equals("10"));
    }
}
