package persistencia.T2.UI;

import persistencia.T2.entity.Aluno;

import javax.swing.*;

public class View {
    public static String idAluno(){
        return JOptionPane.showInputDialog(null, "ID do Aluno", "ID", JOptionPane.QUESTION_MESSAGE);
    }
    public static String idDisciplina(){
        return JOptionPane.showInputDialog(null, "ID da Disciplina", "ID", JOptionPane.QUESTION_MESSAGE);
    }
    public static String data(){
        return JOptionPane.showInputDialog(null, "data", "Date", JOptionPane.QUESTION_MESSAGE);
    }
    public static String codigo(){
        return JOptionPane.showInputDialog(null, "Código da disciplina", "Código", JOptionPane.QUESTION_MESSAGE);
    }
    public static String nomeDisp(){
        return JOptionPane.showInputDialog(null, "nome", "nome da disciplina", JOptionPane.QUESTION_MESSAGE);
    }
    public static String aluMatri(){
        return JOptionPane.showInputDialog(null, "Matrícula do Aluno", "Matrícula", JOptionPane.QUESTION_MESSAGE);
    }
}
