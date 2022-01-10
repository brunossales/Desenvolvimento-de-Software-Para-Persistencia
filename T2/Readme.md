# Trabalho Prático 02 📈 

## Enunciado do trabalho:

### 1️⃣ Crie uma aplicação que use um banco relacional contendo uma tabela de alunos e suas disciplinas cursadas, com suas respectivas classes Java. Cada aluno deve ter um id, cpf, matrícula, nome, email e data de nascimento. Cada disciplina tem somente id, código e nome. Os campos id, código, matrícula e email, considerados individualmente, não devem permitir duplicação, ou seja devem ser únicos. Existe uma associação entre alunos e disciplinas de modo que um aluno pode cursar várias disciplinas e uma disciplinas pode ser cursada por vários alunos. As tabelas devem ser criadas a partir dos mapeamentos das classes (entidades) através do JPA.

### 2️⃣  Use o padrão de persistência DAO neste trabalho usando os recursos do Spring Boot / Spring Data JPA. 

### 3️⃣  Crie uma classe para adicionar via DAO pelo menos 6 alunos com suas respectivas disciplinas cursadas no banco de dados. Pelo menos 50% dos alunos devem ter disciplinas cursadas.

### 4️⃣  Crie uma classe para inserir, atualizar e deletar alunos e disciplinas separadamente. A classe deve permitir também adicionar disciplinas cadastradas a um determinado aluno também já cadastrado.

### 5️⃣  Crie e exiba o resultado de consultas usando @Query ou @NamedQuery ou consultas do Spring Data JPA baseadas apenas em nomes de métodos (pelo menos uma consulta de cada um desses tipos) no Spring para as consultas abaixo:

- ### a) Mostrar os nomes os alunos e todas as suas disciplinas cursadas somente para alunos com nomes contendo determinada string. Ou seja: a string de busca deve ser um parâmetro nomeado da consulta.

- ### b) Dado um código de disciplina, mostrar todos os alunos que a cursaram.

- ### c) Mostrar os nomes de todos os alunos com suas respectivas quantidades de disciplinas cursadas.

- ### d) Dada uma matrícula, mostrar o nome e email do aluno.

- ### e) Dada uma data, mostrar somente os alunos que nasceram depois dela. 

## Veja como ficou a tela Inicial: 

<div align="center">

![Imagem](https://github.com/brunossales/Desenvolvimento-de-Software-Para-Persistencia/blob/main/T2/src/main/resources/data/menu.png)

</div>
