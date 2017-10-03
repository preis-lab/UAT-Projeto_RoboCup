

--INSERCAO DOS ESTADOS
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Acre', 'AC');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Alagoas', 'AL');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Amapá', 'AP');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Amazonas', 'AM');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Bahia', 'BA');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Ceará', 'CE');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Distrito Federal', 'DF');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Espírito Santo', 'ES');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Goiás', 'GO');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Maranhão', 'MA');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Mato Grosso	', 'MT');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Mato Grosso do Sul	', 'MS');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Minas Gerais	', 'MG');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Pará', 'PA');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Paraíba', 'PB');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Paraná', 'PR');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Pernambuco', 'PE');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Piauí', 'PI');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Rio de Janeiro	', 'RJ');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Rio Grande do Norte	', 'RN');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Rio Grande do Sul	', 'RS');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Rondônia', 'RO');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Roraima', 'RR');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Santa Catarina	', 'SC');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'São Paulo	', 'SP');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Sergipe', 'SE');
INSERT INTO `estado` (`estado_id`, `nome`, `uf`) VALUES (NULL, 'Tocantins', 'TO');

INSERT INTO cidade(`cidade_id`, `nome`,`estado_estado_id`) VALUES (NULL,'Sao Paulo',(SELECT estado_id from estado where uf = "SP"));
INSERT INTO cidade(`cidade_id`, `nome`,`estado_estado_id`) VALUES (NULL,'Cotia',(SELECT estado_id from estado where uf = "SP"));
INSERT INTO cidade(`cidade_id`, `nome`,`estado_estado_id`) VALUES (NULL,'Campinas',(SELECT estado_id from estado where uf = "SP"));
INSERT INTO cidade(`cidade_id`, `nome`,`estado_estado_id`) VALUES (NULL,'Guarulhos',(SELECT estado_id from estado where uf = "SP"));

INSERT INTO bairro(`bairro_id`, `nome`,`cidade_cidade_id`) VALUES (NULL,'Aclimação',(SELECT cidade_id from cidade where nome = "Sao Paulo"));
INSERT INTO bairro(`bairro_id`, `nome`,`cidade_cidade_id`) VALUES (NULL,'Vila Zilda',(SELECT cidade_id from cidade where nome = "Sao Paulo"));
INSERT INTO bairro(`bairro_id`, `nome`,`cidade_cidade_id`) VALUES (NULL,'Cambuci',(SELECT cidade_id from cidade where nome = "Sao Paulo"));
INSERT INTO bairro(`bairro_id`, `nome`,`cidade_cidade_id`) VALUES (NULL,'Jardim Tremembé',(SELECT cidade_id from cidade where nome = "Sao Paulo"));

INSERT INTO rua (`cep`, `nome`) VALUES (1538001, 'Lins de Vasconcelos'), (2063000, 'Morvan dias de figueiredo'), (2362210, 'São Mauro Confessor');

INSERT INTO `logradouro` (`logradouro_id`, `tipo`) VALUES
(1, 'aeroporto\r\n'),
(2, 'alameda\r\n'),
(3, 'área\r\n'),
(4, 'avenida\r\n'),
(5, 'ampo\r\n'),
(6, 'chácara\r\n'),
(7, 'colônia\r\n'),
(8, 'condomínio\r\n'),
(9, 'conjunto\r\n'),
(10, 'distrito\r\n'),
(11, 'esplanada\r\n'),
(12, 'estação\r\n'),
(13, 'estrada\r\n'),
(14, 'favela\r\n'),
(15, 'fazenda\r\n'),
(16, 'feira\r\n'),
(17, 'jardim\r\n'),
(18, 'ladeira\r\n'),
(19, 'lago\r\n'),
(20, 'lagoa\r\n'),
(21, 'largo\r\n'),
(22, 'loteamento\r\n'),
(23, 'morro\r\n'),
(24, 'núcleo\r\n'),
(25, 'parque\r\n'),
(26, 'passarela\r\n'),
(27, 'pátio\r\n'),
(28, 'praça\r\n'),
(29, 'quadra\r\n'),
(30, 'recanto\r\n'),
(31, 'residencial\r\n'),
(32, 'rodovia\r\n'),
(33, 'rua\r\n'),
(34, 'setor\r\n'),
(35, 'sítio\r\n'),
(36, 'travessa\r\n'),
(37, 'trecho\r\n'),
(38, 'trevo\r\n'),
(39, 'vale\r\n'),
(40, 'vereda\r\n'),
(41, 'via\r\n'),
(42, 'viaduto\r\n'),
(43, 'viela\r\n'),
(44, 'vila\r\n');
