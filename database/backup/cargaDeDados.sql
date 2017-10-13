INSERT INTO `estado` VALUES (NULL, 'Acre', 'AC');
INSERT INTO `estado` VALUES (NULL, 'Alagoas', 'AL');
INSERT INTO `estado` VALUES (NULL, 'Amapá', 'AP');
INSERT INTO `estado` VALUES (NULL, 'Amazonas', 'AM');
INSERT INTO `estado` VALUES (NULL, 'Bahia', 'BA');
INSERT INTO `estado` VALUES (NULL, 'Ceará', 'CE');
INSERT INTO `estado` VALUES (NULL, 'Distrito Federal', 'DF');
INSERT INTO `estado` VALUES (NULL, 'Espírito Santo', 'ES');
INSERT INTO `estado` VALUES (NULL, 'Goiás', 'GO');
INSERT INTO `estado` VALUES (NULL, 'Maranhão', 'MA');
INSERT INTO `estado` VALUES (NULL, 'Mato Grosso	', 'MT');
INSERT INTO `estado` VALUES (NULL, 'Mato Grosso do Sul	', 'MS');
INSERT INTO `estado` VALUES (NULL, 'Minas Gerais	', 'MG');
INSERT INTO `estado` VALUES (NULL, 'Pará', 'PA');
INSERT INTO `estado` VALUES (NULL, 'Paraíba', 'PB');
INSERT INTO `estado` VALUES (NULL, 'Paraná', 'PR');
INSERT INTO `estado` VALUES (NULL, 'Pernambuco', 'PE');
INSERT INTO `estado` VALUES (NULL, 'Piauí', 'PI');
INSERT INTO `estado` VALUES (NULL, 'Rio de Janeiro	', 'RJ');
INSERT INTO `estado` VALUES (NULL, 'Rio Grande do Norte	', 'RN');
INSERT INTO `estado` VALUES (NULL, 'Rio Grande do Sul	', 'RS');
INSERT INTO `estado` VALUES (NULL, 'Rondônia', 'RO');
INSERT INTO `estado` VALUES (NULL, 'Roraima', 'RR');
INSERT INTO `estado` VALUES (NULL, 'Santa Catarina	', 'SC');
INSERT INTO `estado` VALUES (NULL, 'São Paulo	', 'SP');
INSERT INTO `estado` VALUES (NULL, 'Sergipe', 'SE');
INSERT INTO `estado` VALUES (NULL, 'Tocantins', 'TO');

INSERT INTO `cidade` VALUES (NULL,'Sao Paulo',(SELECT estado_id from estado where uf = "SP"));
INSERT INTO `cidade` VALUES (NULL,'Cotia',(SELECT estado_id from estado where uf = "SP"));
INSERT INTO `cidade` VALUES (NULL,'Campinas',(SELECT estado_id from estado where uf = "SP"));
INSERT INTO `cidade` VALUES (NULL,'Guarulhos',(SELECT estado_id from estado where uf = "SP"));

INSERT INTO `bairro` VALUES (NULL,'Aclimação',(SELECT cidade_id from cidade where nome = "Sao Paulo"));
INSERT INTO `bairro` VALUES (NULL,'Vila Zilda',(SELECT cidade_id from cidade where nome = "Sao Paulo"));
INSERT INTO `bairro` VALUES (NULL,'Cambuci',(SELECT cidade_id from cidade where nome = "Sao Paulo"));
INSERT INTO `bairro` VALUES (NULL,'Jardim Tremembé',(SELECT cidade_id from cidade where nome = "Sao Paulo"));
INSERT INTO `bairro` VALUES (NULL,'Vila Maria',(SELECT cidade_id from cidade where nome = "Sao Paulo"));

INSERT INTO `logradouro` VALUES (NULL,'aeroporto');
INSERT INTO `logradouro` VALUES (NULL,'alameda');
INSERT INTO `logradouro` VALUES (NULL,'área');
INSERT INTO `logradouro` VALUES (NULL,'avenida');
INSERT INTO `logradouro` VALUES (NULL,'ampo');
INSERT INTO `logradouro` VALUES (NULL,'chácara');
INSERT INTO `logradouro` VALUES (NULL,'colônia');
INSERT INTO `logradouro` VALUES (NULL,'condomínio');
INSERT INTO `logradouro` VALUES (NULL,'conjunto');
INSERT INTO `logradouro` VALUES (NULL,'distrito');
INSERT INTO `logradouro` VALUES (NULL,'esplanada');
INSERT INTO `logradouro` VALUES (NULL,'estação');
INSERT INTO `logradouro` VALUES (NULL,'estrada');
INSERT INTO `logradouro` VALUES (NULL,'favela');
INSERT INTO `logradouro` VALUES (NULL,'fazenda');
INSERT INTO `logradouro` VALUES (NULL,'feira');
INSERT INTO `logradouro` VALUES (NULL,'jardim');
INSERT INTO `logradouro` VALUES (NULL,'ladeira');
INSERT INTO `logradouro` VALUES (NULL,'lago');
INSERT INTO `logradouro` VALUES (NULL,'lagoa');
INSERT INTO `logradouro` VALUES (NULL,'largo');
INSERT INTO `logradouro` VALUES (NULL,'loteamento');
INSERT INTO `logradouro` VALUES (NULL,'morro');
INSERT INTO `logradouro` VALUES (NULL,'núcleo');
INSERT INTO `logradouro` VALUES (NULL,'parque');
INSERT INTO `logradouro` VALUES (NULL,'passarela');
INSERT INTO `logradouro` VALUES (NULL,'pátio');
INSERT INTO `logradouro` VALUES (NULL,'praça');
INSERT INTO `logradouro` VALUES (NULL,'quadra');
INSERT INTO `logradouro` VALUES (NULL,'recanto');
INSERT INTO `logradouro` VALUES (NULL,'residencial');
INSERT INTO `logradouro` VALUES (NULL,'rodovia');
INSERT INTO `logradouro` VALUES (NULL,'rua');
INSERT INTO `logradouro` VALUES (NULL,'setor');
INSERT INTO `logradouro` VALUES (NULL,'sítio');
INSERT INTO `logradouro` VALUES (NULL,'travessa');
INSERT INTO `logradouro` VALUES (NULL,'trecho');
INSERT INTO `logradouro` VALUES (NULL,'trevo');
INSERT INTO `logradouro` VALUES (NULL,'vale');
INSERT INTO `logradouro` VALUES (NULL,'vereda');
INSERT INTO `logradouro` VALUES (NULL,'via');
INSERT INTO `logradouro` VALUES (NULL,'viaduto');
INSERT INTO `logradouro` VALUES (NULL,'viela');
INSERT INTO `logradouro` VALUES (NULL,'vila');

INSERT INTO `nivel_acesso` VALUES (null,'Administrador');
INSERT INTO `nivel_acesso` VALUES (null,'Aluno');

INSERT INTO `periodo` VALUES (NULL, 'Noturno', TIME('19:20:00'), TIME('22:50:00'));
INSERT INTO `periodo` VALUES (NULL, 'Diurno', TIME('7:20:00'), TIME('10:50:00'));

INSERT INTO `rua` VALUES (02063000,'Morvan Dias de Figueiredo',(SELECT bairro_id from bairro WHERE nome LIKE 'Vila Maria'),(SELECT logradouro_id FROM logradouro WHERE tipo like 'avenida'));
INSERT INTO `rua` VALUES (01538001,'Lins de Vasconcelos',(SELECT bairro_id from bairro WHERE nome LIKE 'Cambuci'),(SELECT logradouro_id FROM logradouro WHERE tipo like 'avenida'));
INSERT INTO `rua` VALUES (04108040,'Ximbo',(SELECT bairro_id from bairro WHERE nome LIKE 'Aclimacao'),(SELECT logradouro_id FROM logradouro WHERE tipo like 'rua'));

INSERT INTO `endereco` VALUES ('1222', (SELECT cep FROM rua WHERE nome like 'Lins de Vascon%'));
INSERT INTO `endereco` VALUES ('2875', (SELECT cep FROM rua WHERE nome like 'Morvan Dias%'));

INSERT INTO `tipo_competicao` VALUES (NULL, 'Space Cup');
INSERT INTO `tipo_competicao` VALUES (NULL, 'Robo Cup');

INSERT INTO `competicao` VALUES (NULL,'2017-10-07',1222,(SELECT tipo_competicao_id FROM tipo_competicao WHERE nome = 'Space Cup'),1, 01538001);
INSERT INTO `competicao` VALUES (NULL,'2017-10-07',1222,(SELECT tipo_competicao_id FROM tipo_competicao WHERE nome = 'Robo Cup'),0, 01538001);

INSERT INTO `turma` VALUES (NULL,'2SIS',(SELECT competicao_id FROM competicao where tipo_competicao_id = (SELECT tipo_competicao_id from tipo_competicao where nome = 'Space Cup')),(SELECT periodo_id FROM periodo WHERE descricao = 'noturno'));
INSERT INTO `turma` VALUES (NULL,'2SIR',(SELECT competicao_id FROM competicao where tipo_competicao_id = (SELECT tipo_competicao_id from tipo_competicao where nome = 'Space Cup')),(SELECT periodo_id FROM periodo WHERE descricao = 'noturno'));
INSERT INTO `turma` VALUES (NULL,'2SIT',(SELECT competicao_id FROM competicao where tipo_competicao_id = (SELECT tipo_competicao_id from tipo_competicao where nome = 'Space Cup')),(SELECT periodo_id FROM periodo WHERE descricao = 'noturno'));

INSERT INTO `equipe` VALUES (null,'UAT',1,(SELECT turma_id FROM turma WHERE nome = '2SIS'));
INSERT INTO `equipe` VALUES (null,'Fenomeno',1,(SELECT turma_id FROM turma WHERE nome = '2SIR'));
INSERT INTO `equipe` VALUES (null,'Jacirando',1,(SELECT turma_id FROM turma WHERE nome = '2SIT'));

INSERT INTO `aluno` VALUES (76729,(SELECT equipe_id FROM equipe WHERE nome = 'UAT'),'Paulo Henrique','1234',(SELECT nivel_id from nivel_acesso WHERE descricao = 'Aluno'));
INSERT INTO `administrador` VALUES (00000,'root','12345',(SELECT nivel_id from nivel_acesso WHERE descricao = 'Administrador'));
INSERT INTO `aluno` VALUES (76287,(SELECT equipe_id FROM equipe WHERE nome = 'UAT'),'Vitor','1234',(SELECT nivel_id from nivel_acesso WHERE descricao = 'Aluno'));

INSERT INTO `foguete` VALUES (null,3,1);
INSERT INTO `foguete` VALUES (null,6,2);

INSERT INTO `lancamento` VALUES (NULL, '4', '5', '6', '7', TIME('00:00:50'), '8', '9', TIME('00:01:35'), '10', '5', TIME('00:00:59'), '6', (SELECT equipe_id FROM equipe WHERE nome = 'UAT'), '2');
INSERT INTO `lancamento` VALUES (NULL, '5', '6', '7', '8', TIME('00:00:50'), '8', '11', TIME('00:02:20'), '2', '1', TIME('00:00:22'), '3', (SELECT equipe_id FROM equipe WHERE nome = 'Fenomeno'), '1');
INSERT INTO `lancamento` VALUES (NULL, '2', '2', '2', '9', TIME('00:00:15'), '8', '11', TIME('00:02:20'), '2', '1', TIME('00:00:21'), '1', (SELECT equipe_id FROM equipe WHERE nome = 'Jacirando'), '1');
