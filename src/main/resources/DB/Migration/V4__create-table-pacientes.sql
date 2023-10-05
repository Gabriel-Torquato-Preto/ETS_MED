CREATE TABLE pacientes(
id INTEGER not null auto_increment,
nome VARCHAR(100),
email VARCHAR(100),
cpf VARCHAR(14),
telefone VARCHAR(12),
logradouro VARCHAR(100) NOT NULL,
bairro VARCHAR(100) NOT NULL,
cep VARCHAR(9) NOT NULL,
complemento VARCHAR(100) NOT NULL,
numero VARCHAR(20),
uf CHAR(2) NOT NULL,
cidade VARCHAR(100) NOT NULL,
PRIMARY KEY (id)
)