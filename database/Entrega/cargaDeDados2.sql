INSERT INTO `cidade` (`cidade_id`, `nome`) VALUES (NULL, 'Cotia');
INSERT INTO `cidade` (`cidade_id`, `nome`) VALUES (NULL, 'São Paulo');

INSERT INTO `endereco` (`numero`, `cep`, `descricao`, `cidade_id`, `rua`) VALUES ('1222', '01538001', 'Prédio 2 Fiap', (select cidade_id from cidade where nome = 'São Paulo'), 'Av. Lins de Vasconcelos');
INSERT INTO `endereco` (`numero`, `cep`, `descricao`, `cidade_id`, `rua`) VALUES ('0', '06712100', 'Cemucam', (select cidade_id from cidade where nome = 'Cotia'), 'Rua Mesopotâmias');

INSERT INTO `tipo_competicao` (`tipo_competicao_id`, `nome`) VALUES (NULL, 'Space Cup'), (NULL, 'Robo Cup');

INSERT INTO `competicao` (`competicao_id`, `data`, `numero`, `tipo_competicao_id`, `ativa`, `cep`) VALUES (NULL, '2017-10-07', '0', '1', '1', '06712100');
INSERT INTO `competicao` (`competicao_id`, `data`, `numero`, `tipo_competicao_id`, `ativa`, `cep`) VALUES (NULL, '2017-10-28', '1222', '2', '0', '01538001');

INSERT INTO `turma` (`turma_id`, `nome`, `competicao_id`) VALUES (NULL, '2SIS', '1'), (NULL, '2SIR', '1');

INSERT INTO `equipe` (`equipe_id`, `nome`, `classificado`, `turma_id`) VALUES (NULL, 'Uat', '1', '1'), (NULL, 'Fenomeno', '1', '1');

INSERT INTO `aluno` (`usuario_id`, `nome`, `senha`, `nivel_acesso`, `equipe_id`) VALUES ('76729', 'Paulo Henrique', '12345', '1', '1'), ('77316', 'Daniel', '12345', '1', '1');

INSERT INTO `administrador` (`usuario_id`, `nome`, `senha`, `nivel_acesso`) VALUES ('0', 'root', '1234', '2');

INSERT INTO `foguete` (`foguete_id`, `peso`, `tamanho`) VALUES (NULL, '500', '500'), (NULL, '300', '300');

INSERT INTO `lancamento` (`lancamento_id`, `distanciadoalvo`, `angulolancamento`, `velocidadevento`, `altitudemaxima`, `tempopropulsao`, `picoaceleracao`, `aceleracaomedia`, `tempoapogeudescida`, `altitudeejecao`, `taxadescida`, `duracaovoo`, `distanciaentrequedaalvo`, `equipe_id`, `foguete_id`)
VALUES (NULL, '34', '13', '34', '34', TIME('00:00:50'), '32', '12', TIME('00:00:50'), '23', '23', TIME('00:00:50'), '23', '1', '1');

INSERT INTO `lancamento` (`lancamento_id`, `distanciadoalvo`, `angulolancamento`, `velocidadevento`, `altitudemaxima`, `tempopropulsao`, `picoaceleracao`, `aceleracaomedia`, `tempoapogeudescida`, `altitudeejecao`, `taxadescida`, `duracaovoo`, `distanciaentrequedaalvo`, `equipe_id`, `foguete_id`)
VALUES (NULL, '34', '13', '34', '34', TIME('00:00:50'), '32', '12', TIME('00:00:50'), '23', '23', TIME('00:00:50'), '23', '2', '2');
