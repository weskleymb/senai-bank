create table if not exists clientes
(
    id bigint not null auto_increment,
    ativo bit not null,
    data_criacao date not null,
    data_modificacao date,
    cpf char(11) not null,
    nome varchar(100) not null,
    sexo varchar(10) not null,
    primary key (id),
    unique key uk_cpf (cpf)
);
