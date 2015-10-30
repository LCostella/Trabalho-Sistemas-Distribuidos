CREATE TABLE cidade 
(
	
	codigo int PRIMARY KEY,

	nome varchar(30) not null unique,

	estado varchar(20)

);

CREATE TABLE cep
(

	cep int PRIMARY KEY,

	codigocidade int not null,

	FOREIGN KEY (codigocidade) REFERENCES cidade (codigo)

);


CREATE TABLE contato 
(

	codigo int PRIMARY KEY,

	nome varchar(30) not null,

	email varchar(40) unique,

	endereco varchar(50),

	complemento varchar(40),

	cep int,

	emailalternativo varchar(40),

	FOREIGN KEY (cep) REFERENCES cep (cep)

);
