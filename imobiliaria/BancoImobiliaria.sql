CREATE TABLE Categoria (
  id_categoria INTEGER NOT NULL,
  descricao VARCHAR NOT NULL,
  PRIMARY KEY(id_categoria)
);

CREATE TABLE Cliente (
  id_cliente INTEGER NOT NULL,
  cpf VARCHAR NOT NULL,
  nome VARCHAR NULL,
  endereco VARCHAR NULL,
  PRIMARY KEY(id_cliente)
);

CREATE TABLE Tipo_imovel (
  id_tipo_imovel INTEGER NOT NULL,
  descricao VARCHAR NOT NULL,
  PRIMARY KEY(id_tipo_imovel)
);

CREATE TABLE Proprietario (
  id_proprietario INTEGER NOT NULL,
  cpf VARCHAR NOT NULL,
  nome VARCHAR NULL,
  telefone VARCHAR NULL,
  endereco VARCHAR NULL,
  PRIMARY KEY(id_proprietario)
);

CREATE TABLE Imobiliaria (
  id_imobiliaria INTEGER NOT NULL,
  cnpj INTEGER NOT NULL,
  nome VARCHAR(20) NOT NULL,
  PRIMARY KEY(id_imobiliaria)
);

CREATE TABLE Imovel (
  id_imovel INTEGER NOT NULL,
  Imobiliaria_id_imobiliaria INTEGER NOT NULL,
  Proprietario_id_proprietario INTEGER NOT NULL,
  Tipo_imovel_id_tipo_imovel INTEGER NOT NULL,
  valor_imovel INTEGER NULL,
  endereco VARCHAR NULL,
  area VARCHAR NULL,
  descricao_imovel VARCHAR NULL,
  PRIMARY KEY(id_imovel)
 );

CREATE TABLE Cliente_has_Imovel (
  Cliente_id_cliente INTEGER NOT NULL,
  Imovel_id_imovel INTEGER NOT NULL,
  data_aluguel DATE NULL,
  PRIMARY KEY(Cliente_id_cliente, Imovel_id_imovel),
  FOREIGN KEY (Imovel_id_imovel) REFERENCES Imovel(id_imovel),
  FOREIGN KEY (Cliente_id_cliente) REFERENCES Cliente(id_cliente)
);

CREATE TABLE contato_cliente (
  id_contato_cliente INTEGER NOT NULL,
  Cliente_id_cliente INTEGER NOT NULL,
  descricao VARCHAR NULL,
  PRIMARY KEY(id_contato_cliente),
  FOREIGN KEY(Cliente_id_cliente) REFERENCES Cliente(id_cliente)
);

CREATE TABLE Contato_Imobiliaria (
  id_contato_imobiliaria INTEGER NOT NULL,
  Imobiliaria_id_imobiliaria INTEGER NOT NULL,
  descricao VARCHAR NOT NULL,
  PRIMARY KEY(id_contato_imobiliaria),
  FOREIGN KEY (Imobiliaria_id_imobiliaria) REFERENCES Imobiliaria(id_imobiliaria)
);

CREATE TABLE contato_proprietario (
  id_contato_proprietario INTEGER NOT NULL,
  Proprietario_id_proprietario INTEGER NOT NULL,
  descricao VARCHAR NULL,
  PRIMARY KEY(id_contato_proprietario),
  FOREIGN KEY (Proprietario_id_proprietario) REFERENCES Proprietario(id_proprietario)
);


CREATE TABLE Imovel_Categoria (
  Categoria_id_categoria INTEGER NOT NULL,
  Imovel_id_imovel INTEGER NOT NULL,
  PRIMARY KEY(Categoria_id_categoria, Imovel_id_imovel),
  FOREIGN KEY (Imovel_id_imovel) REFERENCES Imovel(id_imovel),
  FOREIGN KEY (Categoria_id_categoria) REFERENCES Categoria(id_categoria)
);


CREATE TABLE Usuario (
  id_usuario INTEGER NOT NULL,
  login VARCHAR NOT NULL,
  senha VARCHAR NULL,
  PRIMARY KEY(id_usuario)
);