select * from medicos;

insert into medicos(id,crm,email,bairro,cep,cidade,complemento,nome)
VALUES ('6','456767','miguelluiz55@gmail.com','gloria','123409090','Zn sul','Apt','Miguel Luiz');


insert into medicos(id,crm,email,bairro,cep,cidade,complemento,nome,logadouro,uf,especialidade)
VALUES ('4',
		'565656',
		'daianaprudencio09@gmail.com',
		'Santa Luzia',
		'0909989',
		'Rj',
		'casa',
		'Daiana Prudencio',
		'Rua n',
		'rnz',
		'Fisioterapia');

DELETE  FROM medicos where id=7;

UPDATE medicos set id= '1', crm='12348'
where id = 4;

UPDATE medicos set id= '2',crm='90909'
where id = 5;

UPDATE medicos set id= '3',crm='88888'
where id = 6;


