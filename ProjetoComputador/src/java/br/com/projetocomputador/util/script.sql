/*******bd_computador*******/
create table produto(
	idProduto serial not null,
	fornecedorProduto varchar (40),
	precoProduto int,
	constraint pk_produto primary key (idproduto) 
);

create table computadores 
(
	idComputador serial not  null,
	ssdComputador int,
	ramComputador int,
        idProduto int,
        constraint pk_computador primary key  (idComputador),
	constraint fk_computadores_produto foreign key (idProduto)
	references produto (idProduto)
);