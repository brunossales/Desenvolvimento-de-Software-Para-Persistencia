package model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Funcionario {
    @Getter @Setter @NonNull private int id;
    @Getter @Setter @NonNull private String cpf;
    @Getter @Setter @NonNull private int matricula;
    @Getter @Setter private String nome;
    @Getter @Setter private String email;
    @Getter @Setter private String telefone;
}
