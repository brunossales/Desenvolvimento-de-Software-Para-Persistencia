package persistencia.T2.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NamedQueries(
        {
                @NamedQuery(name = "findCodigo", query = "SELECT D.alunos as alunos FROM Disciplina D WHERE D.codigo = :cod")
        }
)

@Entity
@Table(name = "disciplinas")
@AllArgsConstructor
@NoArgsConstructor

public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;

    @Column(unique = true, name = "codigo_disciplina")
    @Getter @Setter private Integer codigo;

    @Column(name = "nome_disciplina")
    @Getter @Setter private String nome;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "Alu_Disc",
                joinColumns = @JoinColumn(name = "disciplinaID"),
                inverseJoinColumns = @JoinColumn(name = "AlunoId"))
    @Getter @Setter private List<Aluno> alunos;

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID_Disciplina: ").append(id).append(", Código_Disciplina: ").append(codigo).append(", Nome_Disciplina: ").append(nome).append("\n");
        return sb.toString();
    }

}
