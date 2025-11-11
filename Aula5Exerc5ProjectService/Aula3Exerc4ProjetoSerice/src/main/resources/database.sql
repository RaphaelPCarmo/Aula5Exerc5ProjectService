CREATE TABLE Projeto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    estado VARCHAR(50),
    qtdPessoas INT,
    gestorProjeto VARCHAR(100),
    liderTecnico VARCHAR(100),
    gerente VARCHAR(100),
    dataInicio VARCHAR(20),
    dataFim VARCHAR(20)
);

CREATE TABLE Pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    endereco VARCHAR(150),
    telefone VARCHAR(20)
);
