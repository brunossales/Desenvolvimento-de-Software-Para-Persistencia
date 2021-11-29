package com.l5ps.L5.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "funcionario")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @NonNull private int id;
    @Getter @Setter @NonNull private String cpf;
    @Getter @Setter @NonNull private int matricula;
    @Getter @Setter private String nome;
    @Getter @Setter private String email;
    @Getter @Setter private String telefone;
}

