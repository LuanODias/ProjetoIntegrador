CREATE TABLE IF NOT EXISTS colaborador(
	id_colaborador SERIAL PRIMARY KEY,
	nome CHARACTER VARYING(50) NOT NULL,
	matricula CHARACTER VARYING(9) NOT NULL
)

CREATE TABLE IF NOT EXISTS veiculo(
	id_veiculo SERIAL PRIMARY KEY,
	ano CHARACTER VARYING(4) NOT NULL,
	modelo CHARACTER VARYING(20) NOT NULL,
	autonomia DOUBLE PRECISION NOT NULL
)

CREATE TABLE IF NOT EXISTS chamado(
	id_chamado SERIAL PRIMARY KEY,
	numero_chamado CHARACTER VARYING (9) NOT NULL,
	km_rodado INTEGER NOT NULL,
	CO2 CHARACTER VARYING NOT NULL,
	data_chamado CHARACTER VARYING (10) NOT NULL, 
	veiculo INTEGER REFERENCES veiculo (id_veiculo) NOT NULL,
	colaborador INTEGER REFERENCES colaborador (id_colaborador) NOT NULL
)

INSERT INTO colaborador (nome, matricula) VALUES ('Michel', '3473281989')
INSERT INTO veiculo (ano, modelo, autonomia) VALUES ('2010', 'STRADA', 	9.1)
INSERT INTO chamado (mumero_chamado, km_rodado, CO2, data_chamado, veiculo, colaborador) VALUES ('132465789', '7', 1.08, '1999-12-04', 1, 2)

ALTER TABLE chamado RENAME mumero_chamado TO numero_chamado

SELECT * FROM chamado


