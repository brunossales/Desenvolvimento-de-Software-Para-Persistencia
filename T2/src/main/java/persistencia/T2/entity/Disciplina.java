package persistencia.T2.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NamedQueries(
        {
                @NamedQuery(name = "findCodigo", query = "SELECT D.alunos FROM Disciplina D WHERE D.codigo = :cod")
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
        sb.append("ID: ").append(id).append(", Código: ").append(codigo).append(", Nome: ").append(nome).append("\n");
        return sb.toString();
    }

}
