CREATE TABLE IF NOT EXISTS voluntario
(id_voluntario INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100),
data_nascimento DATE,
cpf_cnpj VARCHAR(14),
celular VARCHAR(14),
logradouro VARCHAR(200),
cidade VARCHAR(100),
estado VARCHAR(100),
tiposervico1 VARCHAR(100),
tiposervico2 VARCHAR(100),
tiposervico3 VARCHAR(100),
categoria1 VARCHAR(100),
categoria2 VARCHAR(100),
categoria3 VARCHAR(100),
descricao VARCHAR(100),
email VARCHAR(100),
senha VARCHAR(20),
CONSTRAINT uc_voluntario UNIQUE (cpf_cnpj)
);

INSERT IGNORE INTO voluntario
(
nome,
data_nascimento,
cpf_cnpj,
celular,
logradouro,
cidade,
estado,
tiposervico1,
tiposervico2,
tiposervico3,
categoria1,
categoria2,
categoria3,
descricao,
email,
senha
)
VALUES
('Teste Voluntario',
'1995-12-26',
'11111111111',
'+5511995474383',
'Rua Teste',
'Cidade Teste',
'Estado Teste',
'Professor',
'Dentista',
 null,
'Educação',
'Saúde',
 null,
'Sou dentista e também dou aulas de higiene bucal',
'teste@teste.com',
'teste'
);