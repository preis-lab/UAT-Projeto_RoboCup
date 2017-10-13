
-- Questao 6

UPDATE `aluno` SET `nome`='Paulo Henrique Pereira Reis' where usuario_id=76729;


--Questao 7
DELETE FROM `equipe` WHERE `equipe_id`= 2
/*
O lancamento e deletado porque na hora de criar a tabela foi adicionado o ON DELETE CASCADE

*/

--Questao 8
SELECT c.data, concat(p.rua,' ',case p.numero when 0 then 'S/N' else p.numero end,' ',p.cep,' ',cid.nome) as "Endereco", e.nome as "Equipe"
from competicao as c, endereco as p,equipe as e, cidade as cid
WHERE c.data BETWEEN '2015-01-01' and '2017-12-31' and
	p.numero = c.numero AND p.cep = c.cep AND
    cid.cidade_id = p.cidade_id AND
    e.turma_id in (SELECT turma_id from turma where competicao_id in (c.competicao_id));

--Questao 9
SELECT `distanciadoalvo` as "Distancai do Alvo", `angulolancamento` as "Angulo lancamento", `velocidadevento` as "Velocidade Vento", `altitudemaxima` as "Altitude Maxima", `tempopropulsao` as "Tempo propulsão", `picoaceleracao`as "Pico Aceleracao", `aceleracaomedia` as "Aceleracao Media", `tempoapogeudescida` as "Tempo apogueu descida", `altitudeejecao` as "Altitude Ajecao", `taxadescida` as "Taxa Descida", `duracaovoo` as "Duracao Voo", `distanciaentrequedaalvo`as "Distancia entre queda e alvo"
from lancamento as l ,equipe as e
WHERE l.equipe_id in (SELECT turma_id from turma WHERE competicao_id in ((SELECT competicao_id from competicao WHERE year(data) = '2017'))) and e.nome = 'UAT'

--Questao 10
