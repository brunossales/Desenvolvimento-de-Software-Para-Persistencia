package persistencia.T2.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@NamedQueries(
        {
          @NamedQuery(name = "nomeEemail", query = "SELECT A.nome as nome, A.email as email FROM Aluno A WHERE A.matricula = :matricula"),
          @NamedQuery(name = "dataBE", query = "SELECT A FROM Aluno A WHERE A.dataNasc > :data")
        }
)


@Entity
@Table(name = "alunos")
@AllArgsConstructor
@NoArgsConstructor

public class Aluno {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Getter @Setter private int id;

     @Getter @Setter private String cpf;

     @Column(unique = true)
     @Getter @Setter private Integer matricula;

     @Column(name = "nome_aluno")
     @Setter @Getter private String nome;

     @Column(unique = true)
     @Setter @Getter private String email;

     @Column(name = "data_nascimento")
     @Setter @Getter private Date dataNasc;

     @ManyToMany(mappedBy = "alunos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     @Setter @Getter private List<Disciplina> disciplinas;

     public String toString(){
          StringBuilder sb = new StringBuilder();
          sb.append("ID: ").append(id).append(", CPF: ").append(cpf).append(", Matrícula: ")
                  .append(matricula).append(", Nome: ").append(nome).append(", Email: ").append(email)
                  .append(", Data de Nascimento: ").append(dataNasc).append("\nDisciplinas: ");
          for (Disciplina d : disciplinas) {
               sb.append("\t").append(d).append("\n");
          }
          return sb.toString();
     }
}
