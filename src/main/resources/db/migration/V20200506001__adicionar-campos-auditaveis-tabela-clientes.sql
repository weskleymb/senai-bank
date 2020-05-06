alter table cliente
    add column data_criacao datetime not null,
    add column data_modificacao datetime,
    add column ativo int;
