
-- Questao 6

UPDATE `aluno` SET `nome`='Paulo Henrique Pereira Reis' where usuario_id=76729;


--Questao 7
DELETE FROM `equipe` WHERE `equipe_id`= 3
/*
O lancamento e deletado porque na hora de criar a tabela foi adicionado o ON DELETE CASCADE

*/

--Questao 8
SELECT nome as "Nome da Equipe", c.data as "Data da competicao" FROM `equipe` , `competicao` as c WHERE `turma_id` in (
    SELECT turma_id FROM turma WHERE competicao_id in (
    	SELECT competicao_id
		FROM competicao
		WHERE data BETWEEN "2015-01-01" and "2017-12-31"
	)
);
