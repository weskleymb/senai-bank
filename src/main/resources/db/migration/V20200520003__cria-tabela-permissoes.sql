create table if not exists permissoes
(
    id               bigint      not null auto_increment,
    ativo            bit(1)      not null,
    data_criacao     date        not null,
    data_modificacao date,
    permissao        varchar(20) not null,
    primary key (id),
    unique key (permissao)
);
