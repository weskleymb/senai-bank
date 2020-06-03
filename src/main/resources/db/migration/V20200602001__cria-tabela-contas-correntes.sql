create table if not exists contas_correntes(
    id bigint not null auto_increment,
    ativo bit(1) not null,
    data_criacao date not null,
    data_modificacao date,
    agencia bigint not null,
    saldo decimal(12,2) default 0.0,
    id_titular bigint not null,
    primary key (id),
    foreign key (id_titular) references clientes(id)
);
