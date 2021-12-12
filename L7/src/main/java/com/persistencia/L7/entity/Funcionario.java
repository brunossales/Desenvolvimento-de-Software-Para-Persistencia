package com.persistencia.L7.entity;

import lombok.*;

import javax.persistence.*;

@NamedQueries(
        {
                @NamedQuery(name = "findAll", query = "SELECT f FROM Funcionario f")
        }
)

@Entity
@Table(name = "funcionarios")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Funcionario {
    @Id @Getter @Setter @NonNull @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    @Getter @Setter @NonNull private String cpf;
    @Getter @Setter @NonNull private String nome;
    @Getter @Setter private String email;
    @Getter @Setter private String telefone;
}
