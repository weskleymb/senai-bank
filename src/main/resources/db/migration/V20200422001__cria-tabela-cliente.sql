create table cliente(
	id bigint not null auto_increment,
	nome varchar(60) not null,
	cpf char(11) not null,
	sexo varchar(20),
	primary key(id)
);
