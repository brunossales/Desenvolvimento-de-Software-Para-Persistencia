package persistencia.T2.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "alunos")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Aluno {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Getter @Setter private int id;

     @NonNull @Getter @Setter private String cpf;

     @Column(unique = true)
     @NonNull @Getter @Setter private Integer matricula;

     @Column(name = "nome_aluno")
     @Setter @Getter private String nome;

     @Column(unique = true)
     @NonNull @Setter @Getter private String email;

     @Column(name = "data_nascimento")
     @Setter @Getter private Date dataNasc;

     @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
     @Setter @Getter private List<Disciplina> disciplinas;
}
