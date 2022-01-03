package persistencia.T2.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "disciplinas")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;

    @Column(unique = true, name = "codigo_disciplina")
    @Getter @Setter private Integer codigo;

    @Column(name = "nome_disciplina")
    @Getter @Setter private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @Getter @Setter private Aluno aluno;
}
