package com.persistencia.L7.UI;

import com.persistencia.L7.entity.Funcionario;

import javax.swing.*;
import java.util.List;

public class  UiUtil {
    public static void obterFuncionario(Funcionario fu){
        String cpf = JOptionPane.showInputDialog(null, fu.getCpf(), JOptionPane.QUESTION_MESSAGE);
        String nome = JOptionPane.showInputDialog(null,"Nome", fu.getNome(), JOptionPane.QUESTION_MESSAGE);
        String email = JOptionPane.showInputDialog(null, "Email", fu.getEmail(), JOptionPane.QUESTION_MESSAGE);
        String telefone = JOptionPane.showInputDialog(null, "Telefone", fu.getTelefone(), JOptionPane.QUESTION_MESSAGE);

        fu.setCpf(cpf);
        fu.setNome(nome);
        fu.setEmail(email);
        fu.setTelefone(telefone);
    }
    public static String menu(){
        String saida = JOptionPane.showInputDialog(null, "Menu",
                "1 - Inserir\n"
                        + "2 - Update by ID\n"
                        + "3 - Delete by CPF\n"
                        + "4 - Delete by ID\n"
                        + "5 - Find First by ID\n"
                        + "6 - Find First by CPF\n"
                        + "7 - Find All\n"
                        + "8 - Delete by Id\n"
                        + "9 - Nome or Telefone or Email Starting with...\n"
                        + "10 - Exit"
                , JOptionPane.QUESTION_MESSAGE);
        return saida;
    }
    public static void inf(){
        JOptionPane.showMessageDialog(null, "Successfully", "Operação realizada!", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void listFuns(List<Funcionario> listFun){
        StringBuilder saida = new StringBuilder();
        for(Funcionario fu : listFun)
            saida.append(fu).append("\n");
        JOptionPane.showMessageDialog(null,
                "List for of Funcincionarios",
                saida.length() == 0 ? "Not Found Funcionario" : saida.toString(),
                JOptionPane.INFORMATION_MESSAGE);
    }
    public static void listFun(Funcionario fu){
        JOptionPane.showMessageDialog(null,
                "List for of Funcionario",
                fu == null ? "Not Found Funcionario" : fu.toString(),
                JOptionPane.INFORMATION_MESSAGE);
    }
    public static void exit(){
        JOptionPane.showMessageDialog(null,
                "Exit",
                "Exiting For the Menu...",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public static String pushCpf(){
       return JOptionPane.showInputDialog(null,
                "Digite o CPF",
                "Digite o CPF do Funcionario Para Pesquisa",
                JOptionPane.QUESTION_MESSAGE);
    }
    public static String pushId(){
        return JOptionPane.showInputDialog(null,
                "Digite o ID",
                "Digite o ID do Funcionario Para Pesquisa",
                JOptionPane.QUESTION_MESSAGE);
    }
    public static void warn(){
        JOptionPane.showMessageDialog(null,
                "Not Found",
                "Não foi possível realizar a operação, porque não foi encontrado o Funcionario",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public static String sherch(){
        return JOptionPane.showInputDialog(null,
                "Digite uma substring para Nome, Telefone ou Email",
                "String que nome, telefone ou email comece...",
                JOptionPane.QUESTION_MESSAGE);
    }
    public static void invalid(){
        JOptionPane.showInputDialog(null,
                "Warn",
                "Opção inválida",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
