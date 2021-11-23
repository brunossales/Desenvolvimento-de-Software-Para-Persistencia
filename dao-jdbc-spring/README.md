# Código feito pelo Professor e implementei usando o Spring 💻 

## Usando a conexão com o banco de dados postgresql

## Usando o Lombok para facilitar muitas linhas de código

## Criar o esquema relacional no PostgreSQL
----------------------------------------
```sql
create database contatos;

create table clientes (
  id serial primary key,
  cpf varchar(11),
  nome varchar(50),
  fone varchar(11),
  renda decimal(10,2)
);
```
