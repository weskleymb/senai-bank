alter table clientes
    add column id_usuario bigint not null default 1,
    add foreign key (id_usuario) references usuarios(id);
