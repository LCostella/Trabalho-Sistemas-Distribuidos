CREATE TABLE cidade (
	codigo int PRIMARY KEY,
	nome varchar(100) not null,
	estado varchar(100)
);
CREATE TABLE cep(
	cep int PRIMARY KEY,
	codigocidade int not null,
	FOREIGN KEY (codigocidade) REFERENCES cidade (codigo)
);

CREATE TABLE contato (
	codigo int PRIMARY KEY,
	nome varchar(100) not null,
	email varchar(50) unique,
	endereco varchar(200),
	complemento varchar(100),
	cep int,
	emailalternativo varchar(50),
	FOREIGN KEY (cep) REFERENCES cep (cep)
);

