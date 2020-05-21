create table if not exists usuarios
(
    id               bigint      not null auto_increment,
    ativo            bit(1)      not null,
    data_criacao     date        not null,
    data_modificacao date,
    login            varchar(20) not null,
    nome             varchar(60) not null,
    senha            varchar(60) not null,
    primary key (id),
    unique key (login)
);
