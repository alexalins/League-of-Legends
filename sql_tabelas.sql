create table adm(
	id serial primary key,
	nome varchar(50),
	login varchar(50),
	senha varchar(50)
)

create table jogador(
	id serial primary key,
	nome varchar(50),
	login varchar(50),
	senha varchar(50)
)

create table personagem(
	id serial primary key,
	nome varchar(50),
	des varchar(100)
)

create table jogador_personagem(
	id serial primary key,
	idJ integer,
	nomep varchar(50),
	dadop varchar(50)
)