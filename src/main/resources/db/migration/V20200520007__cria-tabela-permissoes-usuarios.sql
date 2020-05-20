create table if not exists permissoes_usuarios
(
    id_usuario   bigint not null,
    id_permissao bigint not null,
    primary key (id_usuario, id_permissao),
    foreign key fk_usuario (id_usuario) references usuarios (id),
    foreign key fk_permissao (id_permissao) references permissoes (id)
);
