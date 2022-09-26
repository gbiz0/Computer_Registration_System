create table produto
(
	idproduto serial        not null,
	fornecedorproduto       varchar(40),
	precoproduto            int,
	constraint pk_produto   primary key(idproduto) 
);

create table tipo
(
	idtipo serial           not null,
	tipocomputador          varchar(40),
	constraint pk_tipo      primary key(idtipo)
);

create table computadores 
(
	idcomputador serial     not null,
	ssdcomputador           int,
	ramcomputador           int,
        idproduto               int,
        idtipo                  int,
        constraint pk_computador primary key (idcomputador),
	constraint fk_computadores_produto foreign key (idproduto) references produto(idproduto),
        constraint fk_computadores_tipo foreign key(idtipo) references tipo(idtipo)
);


create table usuario
(
	idusuario serial        not null,
	nomeusuario             varchar(40),
	emailusuario            varchar (40),
	senhausuario            varchar(40),
        constraint pk_usuario   primary key (idusuario)
);

create table item
(
        iditem serial           not null,
        nomeitem                varchar (40),
        constraint pk_item      primary key (iditem)
);

create table itemcomputador
(
	idcomputador            int not null,
	iditem                  int not null,
	constraint pk_itemcomputador primary key (idcomputador, iditem),
        constraint fk_itemcomputador_computaores foreign key (idcomputador) references computadores(idcomputador),
        constraint fk_itemcomputador_item foreign key (iditem) references item(iditem)
);

INSERT INTO tipo(tipoComputador) VALUES('Laptop');
INSERT INTO tipo(tipoComputador) VALUES('Desktop');
INSERT INTO tipo(tipoComputador) VALUES('Smartphone');
INSERT INTO tipo(tipoComputador) VALUES('Servidor');

INSERT INTO item(nomeitem) VALUES('Processador');
INSERT INTO item(nomeitem) VALUES('WaterCooler');
INSERT INTO item(nomeitem) VALUES('Placa de Vídeo');

INSERT INTO usuario(nomeusuario, senhausuario) VALUES('oi@gmail.com', '12345678');
INSERT INTO usuario(nomeusuario, senhausuario) VALUES('bizo', '123');