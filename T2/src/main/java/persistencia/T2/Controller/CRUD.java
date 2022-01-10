package persistencia.T2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import persistencia.T2.DAO.AlunoDAO;
import persistencia.T2.DAO.DisciplinaDAO;
import persistencia.T2.UI.View;
import persistencia.T2.entity.Aluno;
import persistencia.T2.entity.Disciplina;
import persistencia.T2.entity.entitysAux.NameAndCountD;
import persistencia.T2.entity.entitysAux.NamedAndEmail;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ComponentScan("persistencia.T2")
public class CRUD implements CommandLineRunner {
    @Autowired
    private AlunoDAO alunoDAO;

    @Autowired
    private DisciplinaDAO disciplinaDAO;

    Aluno alunoAux;
    Disciplina disciplinaAux;
    List<Aluno> alunos;
    List<Disciplina> disciplinas;
    SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(CRUD.class);
        builder.headless(false).run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        String op = null;
        do{
            try {
                op = JOptionPane.showInputDialog(null,
                        "Digite as seguintes opções:\n"
                                + "  'insertA' - Inserir Aluno\n"
                                + "  'insertD' - Inserir Disciplina\n"
                                + "  'association' ou 'asso' - Associar uma disciplina com um aluno\n"
                                + "  'updateA' - Update de Aluno\n"
                                + "  'updateD - Update de Disciplina\n"
                                + "  'deleteA - Delete Aluno\n"
                                + "  'deleteD - Delete Disciplina\n"
                                + "  'viewAllA - Ver todos os Alunos\n"
                                + "  'viewAllD - Ver todas as disciplinas\n"
                                + "  'nomedisc' ou 'buscaA' - Busca da letra A, trazer os nome e as disciplinas de determinado aluno\n"
                                + "  'aluedisc' ou 'buscaB' - Busca da letra B, traz os alunos que fazem parte de tal disciplina\n"
                                + "  'aluquantdisc' ou 'buscaC' - Busca da letra C, traz traz os alunos e a quantidade de disciplinas\n"
                                + "  'matnomemail' ou 'buscaD' - Busca da letra D, traz a matricula, nome e email de um determinado aluno\n"
                                + "  'buscapordata' ou 'buscaE' - Busca da letra E, traz os alunos que nasceram depois de uma determinada data\n"
                                + "  'exit' - sair da execução\n",
                        "Menu", JOptionPane.QUESTION_MESSAGE);
                if (op.equalsIgnoreCase("insertA"))
                    inserirAluno();
                else if(op.equalsIgnoreCase("insertD"))
                    inserirDisciplinas();
                else if(op.equalsIgnoreCase("association") || op.equalsIgnoreCase("asso"))
                    addDisciplinaAaluno();
                else if(op.equalsIgnoreCase("updateA"))
                    updateAluno();
                else if(op.equalsIgnoreCase("updateD"))
                    updateDisciplina();
                else if(op.equalsIgnoreCase("deleteA"))
                    deleteAluno();
                else if(op.equalsIgnoreCase("deleteD"))
                    deleteDisciplina();
                else if(op.equalsIgnoreCase("viewAllA"))
                    viewAllAlunos();
                else if(op.equalsIgnoreCase("viewAllD"))
                    viewAllDisciplinas();
                else if(op.equalsIgnoreCase("nomedisc") || op.equalsIgnoreCase("buscaA"))
                    nomEdiscBA();
                else if(op.equalsIgnoreCase("aluedisc") || op.equalsIgnoreCase("buscaB"))
                    alunosDiscBB();
                else if(op.equalsIgnoreCase("aluquantdisc") || op.equalsIgnoreCase("buscaC"))
                    alunoQuantDiscBC();
                else if(op.equalsIgnoreCase("matnomemail") || op.equalsIgnoreCase("buscaD"))
                    matriNomeEmaBD();
                else if(op.equalsIgnoreCase("buscapordata") || op.equalsIgnoreCase("buscaE"))
                    buscaPorData();
                else if(op.equalsIgnoreCase("exit"))
                    JOptionPane.showMessageDialog(null, "Encerrando", "Exit", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Digite uma opção válida", "Opção inválida", JOptionPane.ERROR_MESSAGE);

            }catch (NullPointerException z){
                JOptionPane.showMessageDialog(null, "Fim da Execução", "Fim", JOptionPane.ERROR_MESSAGE);
                op = "exit";
            }catch (RuntimeException e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }while (!op.equalsIgnoreCase("exit"));
    }

    public void inserirDisciplinas() {
        String op;
        do {
            String nome = View.nomeDisp();
            String cod = View.codigo();
            disciplinaAux = disciplinaDAO.findFirstByCodigo(Integer.parseInt(cod));
            if(disciplinaAux != null)
                throw new RuntimeException("Já Existe uma disciplina com esse código");
            Disciplina d = new Disciplina();
            d.setNome(nome);
            d.setCodigo(Integer.parseInt(cod));
            disciplinaDAO.save(d);
            op = JOptionPane.showInputDialog(null, "Deseja mais Adicionar Disciplina?", "sim ou nao");
        } while (!op.equals("nao"));
    }
    public void inserirAluno() throws ParseException {
        String op;
        do {
            String cpf = JOptionPane.showInputDialog(null, "Cpf");
            String matricula = JOptionPane.showInputDialog(null, "Mat");
            String nome = JOptionPane.showInputDialog(null, "nome");
            String email = JOptionPane.showInputDialog(null, "email");
            String data = JOptionPane.showInputDialog(null, "data");
            alunoAux = alunoDAO.findFirstByCpf(cpf);
            if(alunoAux != null)
                throw new RuntimeException("Esse Aluno já existe");
            Aluno a = new Aluno();
            a.setCpf(cpf);
            a.setNome(nome);
            a.setMatricula(Integer.parseInt(matricula));
            Date dataa = formato.parse(data);
            a.setDataNasc(dataa);
            a.setEmail(email);
            alunoDAO.save(a);
            op = JOptionPane.showInputDialog(null, "Deseja mais Adicionar Alunos?", "sim ou nao");
        }while(!op.equals("nao"));
    }
    public void addDisciplinaAaluno(){
        String op;
        do{
            String idAluno = View.idAluno();
            String disc = View.idDisciplina();
            disciplinaAux = disciplinaDAO.buscaPrimeiraDisciplina(Integer.parseInt(disc));
            alunoAux = alunoDAO.buscaPrimeiroAluno(Integer.parseInt(idAluno));
            disciplinaAux.getAlunos().add(alunoAux);
            if(disciplinaAux == null || alunoAux == null)
                throw new RuntimeException("Não encontrado");
            disciplinaDAO.save(disciplinaAux);
            op = JOptionPane.showInputDialog(null, "Deseja adicionar mais disciplinas a um aluno?", "sim ou nao");
        }while(!op.equals("nao"));
    }
    public void deleteAluno(){
        String idAluno = View.idAluno();
        if(!alunoDAO.findById(Integer.parseInt(idAluno)).isPresent())
            throw new RuntimeException("Aluno não encontrado");
        alunoDAO.deleteById(Integer.parseInt(idAluno));
    }
    public void deleteDisciplina(){
        String idDisciplina = View.idDisciplina();
        if(!disciplinaDAO.findById(Integer.parseInt(idDisciplina)).isPresent())
            throw new RuntimeException("Disciplina não encontrada");
        disciplinaDAO.deleteById(Integer.parseInt(idDisciplina));
    }
    public void updateAluno() throws ParseException {
        String idAluno = View.idAluno();
        alunoAux = alunoDAO.buscaPrimeiroAluno(Integer.parseInt(idAluno));
        if(!alunoDAO.findById(Integer.parseInt(idAluno)).isPresent())
            throw new RuntimeException("Aluno não encontrado");
        obterAluno(alunoAux);
        alunoDAO.save(alunoAux);
    }
    public void updateDisciplina(){
        String idDisciplina = View.idDisciplina();
        disciplinaAux = disciplinaDAO.buscaPrimeiraDisciplina(Integer.parseInt(idDisciplina));
        if(!disciplinaDAO.findById(Integer.parseInt(idDisciplina)).isPresent())
            throw new RuntimeException("Disciplina não encontrada");
        obterDisciplina(disciplinaAux);
        disciplinaDAO.save(disciplinaAux);
    }
    public void obterAluno(Aluno al) throws ParseException {
        String cpf = JOptionPane.showInputDialog(null, "Cpf", al.getCpf());
        String matricula = JOptionPane.showInputDialog(null, "Mat", al.getMatricula());
        String nome = JOptionPane.showInputDialog(null, "nome", al.getNome());
        String email = JOptionPane.showInputDialog(null, "email", al.getEmail());
        String data = JOptionPane.showInputDialog(null, "data", al.getDataNasc());

        al.setCpf(cpf);
        al.setMatricula(Integer.parseInt(matricula));
        al.setEmail(email);
        al.setNome(nome);
        Date dataa = formato.parse(data);
        al.setDataNasc(dataa);
    }
    public void obterDisciplina(Disciplina di){
        String nome = JOptionPane.showInputDialog(null, "nome", di.getNome());
        String cod = JOptionPane.showInputDialog(null, "codigo", di.getCodigo());

        di.setNome(nome);
        di.setCodigo(Integer.parseInt(cod));
    }
    public void viewAllAlunos(){
        alunos = alunoDAO.findAll();
        StringBuilder sb = new StringBuilder();
        for (Aluno a : alunos) {
            sb.append("ID: ").append(a.getId()).append(", Matricula: ").append(a.getMatricula())
                    .append(", Nome: ").append(a.getNome())
                    .append(", Email: ").append(a.getEmail()).append(", CPF: ")
                    .append(a.getCpf()).append(", Disciplinas: ").append(a.getDisciplinas()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        alunos.clear();
    }
    public void viewAllDisciplinas(){
        disciplinas = disciplinaDAO.findAll();
        JOptionPane.showMessageDialog(null, disciplinas.toString());
        disciplinas.clear();
    }
    public void nomEdiscBA(){
        String subs = JOptionPane.showInputDialog(null, "Substring para nome");
        alunos = alunoDAO.findByNomeStartingWith(subs);
        StringBuilder sb = new StringBuilder();
        for (Aluno a : alunos) {
            sb.append("Nome: ").append(a.getNome()).append(", Disciplinas:\n").append("  ")
                    .append(a.getDisciplinas()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        alunos.clear();


        //O Spring não tá armazenando o retorno da Query na interface, como fez em "matriNomeEmaBD()"

        //List<NamedAndDisciplin> namedAndDisciplina = (List<NamedAndDisciplin>) alunoDAO.procuraPorSubstringBA(subs);
        //StringBuilder sb = new StringBuilder();
        //for (NamedAndDisciplin a : namedAndDisciplina) {
        //    sb.append("Nome: ").append(a.nome())
        //            .append("\nDisciplinas: ").append(a.disciplinas());
        //}
        //JOptionPane.showMessageDialog(null, sb.toString());
        //alunos.clear();
    }
    public void alunosDiscBB(){
        String idd = View.codigo();
        alunos = disciplinaDAO.buscaPorCodigo(Integer.parseInt(idd));
        if(alunos.get(0) == null)
            throw  new RuntimeException("Aluno não encontrado");
        StringBuilder sb = new StringBuilder();
        sb.append("Alunos que fazem parte da disciplina de código ").append(idd).append("\n");
        for (Aluno a : alunos) {
            sb.append("\tNome: ").append(a.getNome()).append(", CPF: ").append(a.getCpf())
                    .append(", Matricula: ").append(a.getMatricula()).append(", Data de Nascimento: ").append(a.getDataNasc()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        alunos.clear();
    }
    public void alunoQuantDiscBC(){
        List<NameAndCountD> nc = (List<NameAndCountD>) alunoDAO.buscaCountBC();
        StringBuilder sb = new StringBuilder();
        for (NameAndCountD a : nc) {
            sb.append("Nome: ").append(a.getNome()).append(", Número de Disciplinas: ")
                    .append(a.getCount()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    public void matriNomeEmaBD(){
        String mat = View.aluMatri();
        List<NamedAndEmail> al = (List<NamedAndEmail>) alunoDAO.buscaPorCodigoBD(Integer.parseInt(mat));
        StringBuilder sb = new StringBuilder();
        for (NamedAndEmail a : al ) {
            sb.append("Nome: ").append(a.getNome()).append(", Email: ").append(a.getEmail()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        al.clear();
    }
    public void buscaPorData() throws ParseException {
        String data = View.data();
        Date dataa = formato.parse(data);
        alunos = alunoDAO.buscaPorDataBE(dataa);
        StringBuilder sb = new StringBuilder();
        for (Aluno a : alunos) {
            sb.append("ID: ").append(a.getId()).append(", Nome: ").append(a.getNome()).append(", Data de Nascimento: ").append(a.getDataNasc())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        alunos.clear();
    }

}
