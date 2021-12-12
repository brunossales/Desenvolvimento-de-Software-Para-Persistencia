package com.persistencia.L7.UI;

import com.persistencia.L7.entity.Funcionario;

import javax.swing.*;
import java.util.List;

public class  UiUtil {
    public static void obterFuncionario(Funcionario fu){
        String cpf = JOptionPane.showInputDialog("CPF", fu.getCpf());
        String nome = JOptionPane.showInputDialog("Nome", fu.getNome());
        String email = JOptionPane.showInputDialog("Email", fu.getEmail());
        String telefone = JOptionPane.showInputDialog("Telefone", fu.getTelefone());

        fu.setCpf(cpf);
        fu.setNome(nome);
        fu.setEmail(email);
        fu.setTelefone(telefone);
    }
    public static String menu(){
        String saida = JOptionPane.showInputDialog(null,"1 - Inserir\n"
                        + "2 - Update by ID\n"
                        + "3 - Update by CPF\n"
                        + "4 - Delete by CPF\n"
                        + "5 - Delete by ID\n"
                        + "6 - Find First by ID\n"
                        + "7 - Find First by CPF\n"
                        + "8 - Find All\n"
                        + "9 - Telefone Starting with...\n"
                        + "10 - Exit",
                "Menu"
                , JOptionPane.QUESTION_MESSAGE);
        return saida;
    }
    public static void inf(){
        JOptionPane.showMessageDialog(null,"Operação realizada!", "Successfully",  JOptionPane.INFORMATION_MESSAGE);
    }
    public static void listFuns(List<Funcionario> listFun){
        StringBuilder saida = new StringBuilder();
        for(Funcionario fu : listFun)
            saida.append(fu).append("\n");
        JOptionPane.showMessageDialog(null,
                saida.length() == 0 ? "Not Found Funcionario" : saida.toString(),
                "List for of Funcincionarios",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public static void listFun(Funcionario fu){
        JOptionPane.showMessageDialog(null,
                fu == null ? "Not Found Funcionario" : fu.toString(),
                "List for of Funcionario",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public static void exit(){
        JOptionPane.showMessageDialog(null,
                "Exiting For the Menu...",
                "Exit",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public static String pushCpf(){
       return JOptionPane.showInputDialog(null,
               "Digite o CPF do Funcionario Para Pesquisa",
                "Digite o CPF",
                JOptionPane.QUESTION_MESSAGE);
    }
    public static String pushId(){
        return JOptionPane.showInputDialog(null,
                "Digite o ID do Funcionario Para Pesquisa",
                "Digite o ID",
                JOptionPane.QUESTION_MESSAGE);
    }
    public static void warn(){
        JOptionPane.showMessageDialog(null,
                "Não foi possível realizar a operação, porque não foi encontrado o Funcionario",
                "Not Found",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public static String sherch(){
        return JOptionPane.showInputDialog(null,
                "String que telefone comece...",
                "Digite uma substring para o Telefone",
                JOptionPane.QUESTION_MESSAGE);
    }
    public static void invalid(){
        JOptionPane.showInputDialog(null,
                "Opção inválida",
                "Warn",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
