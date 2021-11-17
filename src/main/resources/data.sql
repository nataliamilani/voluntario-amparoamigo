CREATE TABLE IF NOT EXISTS voluntario
(id_voluntario INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100),
data_nascimento DATE,
cpf_cnpj VARCHAR(14),
celular VARCHAR(14),
logradouro VARCHAR(200),
cidade VARCHAR(100),
estado VARCHAR(100),
email VARCHAR(100),
senha VARCHAR(20),
CONSTRAINT uc_voluntario UNIQUE (cpf_cnpj)
);

INSERT IGNORE INTO voluntario (nome, data_nascimento, cpf_cnpj, celular, logradouro, cidade, estado, email, senha) VALUES ('Teste Voluntario', '1995-12-26', '11111111111', '+5511995474383', 'Rua Teste', 'Cidade Teste', 'Estado Teste', 'teste@teste.com', 'teste');