package com.l5ps.L5.UI;

import com.l5ps.L5.model.Funcionario;

import javax.swing.*;

public class UI {
    public static String view(){
        return JOptionPane.showInputDialog(null,
                "1 - Find All\n"
                        + "2 - Find ID\n"
                        + "3 - Insert\n"
                        + "4 - UpdateNome\n"
                        + "5 - UpdateEmail\n"
                        + "6 - UpdateTelefone\n"
                        + "7 - Delete\n"
                        + "8 - Exit",
                "Menu", JOptionPane.QUESTION_MESSAGE);
    }
    public static  String viewForId(){
        return JOptionPane.showInputDialog(null, "Digite o id do Funcionário", "ID", JOptionPane.QUESTION_MESSAGE);
    }

    public static Funcionario viewForInsert(){
        String op1 = JOptionPane.showInputDialog(null, "ID - int");
        String op2 = JOptionPane.showInputDialog(null, "CPF - String");
        String op3 = JOptionPane.showInputDialog(null, "Matricula - int");
        String op4 = JOptionPane.showInputDialog(null, "Nome - String");
        String op5 = JOptionPane.showInputDialog(null, "Email - String");
        String op6 = JOptionPane.showInputDialog(null, "Telefone - String");
        Funcionario funcs = new Funcionario(Integer.parseInt(op1), op2, Integer.parseInt(op3), op4, op5, op6);
        return funcs;
    }

    public static void viewUpdate(){
        JOptionPane.showMessageDialog(null, "Mudado!", "Update", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void viewInser(){
        JOptionPane.showMessageDialog(null, "Inserido!", "Insertion", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void viewForExcep(){
        JOptionPane.showMessageDialog(null, "Problema ao fazer a operação");
    }
    public static void viewForDele(){
        JOptionPane.showMessageDialog(null, "Deletado!", "Delete Funcionário", JOptionPane.INFORMATION_MESSAGE);
    }

}
