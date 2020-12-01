CREATE TABLE boleto (
  codigo binary(16) PRIMARY KEY NOT NULL,
  automovel_id BIGINT NOT NULL,
  marca_id INT NOT NULL,
  modelo_id INT NOT NULL,
  valor decimal(10, 2) NOT NULL,
  vencimento datetime NOT NULL,
  status varchar(7) NOT NULL DEFAULT 'CRIADO' COMMENT 'CRIADO, PAGO, VENCIDO',
  data_cadastro datetime NOT NULL,
  data_atualizacao datetime NOT NULL
););