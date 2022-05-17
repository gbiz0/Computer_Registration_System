create table produto(
	idproduto serial not null,
	fornecedorproduto varchar(40),
	precoproduto int,
	constraint pk_produto primary key(idproduto) 
);

create table tipo
(
	idtipo serial not null,
	tipocomputador varchar(40),
	constraint pk_tipo primary key(idtipo)
);

create table computadores 
(
	idcomputador serial not null,
	ssdcomputador int,
	ramcomputador int,
        idproduto int,
        idtipo int,
        constraint pk_computador primary key (idcomputador),
	constraint fk_computadores_produto foreign key idproduto) references produto(idproduto),
        constraint fk_computadores_tipo foreign key(idtipo) references tipo(idtipo)
);
