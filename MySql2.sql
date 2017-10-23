
CREATE TABLE cidade (
    cidade_id   INTEGER NOT NULL,
    nome        varchar(50) NOT NULL
);

ALTER TABLE cidade ADD CONSTRAINT cidade_pk PRIMARY KEY ( cidade_id );
ALTER TABLE cidade MODIFY COLUMN cidade_id INTEGER AUTO_INCREMENT;

CREATE TABLE competicao (
    competicao_id        INTEGER NOT NULL,
    data                 DATE NOT NULL,
    numero               INTEGER,
    tipo_competicao_id   INTEGER,
    ativa                CHAR(1) NOT NULL,
    cep                  varchar(8)
);

ALTER TABLE competicao ADD CONSTRAINT competicao_pk PRIMARY KEY ( competicao_id );
ALTER TABLE competicao MODIFY COLUMN competicao_id INTEGER AUTO_INCREMENT;

CREATE TABLE endereco (
    numero      INTEGER NOT NULL,
    cep         varchar(8) NOT NULL,
    descricao   varchar(30) NOT NULL,
    cidade_id   INTEGER,
    rua         varchar(50) NOT NULL
);

ALTER TABLE endereco ADD CONSTRAINT endereco_pk PRIMARY KEY ( numero,cep );

CREATE TABLE equipe (
    equipe_id      INTEGER NOT NULL,
    nome           varchar(30) NOT NULL,
    classificado   CHAR(1) NOT NULL,
    turma_id       INTEGER
);

ALTER TABLE equipe ADD CONSTRAINT equipe_pk PRIMARY KEY ( equipe_id );
ALTER TABLE equipe MODIFY COLUMN equipe_id INTEGER AUTO_INCREMENT;

CREATE TABLE foguete (
    foguete_id   INTEGER NOT NULL,
    peso         FLOAT NOT NULL,
    tamanho      FLOAT NOT NULL
);

ALTER TABLE foguete ADD CONSTRAINT foguete_pk PRIMARY KEY ( foguete_id );
ALTER TABLE foguete MODIFY COLUMN foguete_id INTEGER AUTO_INCREMENT;

CREATE TABLE lancamento (
    lancamento_id             INTEGER NOT NULL,
    distanciadoalvo           FLOAT NOT NULL,
    angulolancamento          FLOAT NOT NULL,
    velocidadevento           FLOAT NOT NULL,
    altitudemaxima            FLOAT NOT NULL,
    tempopropulsao            float NOT NULL,
    picoaceleracao            FLOAT NOT NULL,
    aceleracaomedia           FLOAT NOT NULL,
    tempoapogeudescida        float NOT NULL,
    altitudeejecao            FLOAT NOT NULL,
    taxadescida               FLOAT NOT NULL,
    duracaovoo                float NOT NULL,
    distanciaentrequedaalvo   FLOAT NOT NULL,
    equipe_id                 INTEGER,
    foguete_id                INTEGER
);

ALTER TABLE lancamento ADD CONSTRAINT lancamento_pk PRIMARY KEY ( lancamento_id );
ALTER TABLE lancamento MODIFY COLUMN lancamento_id INTEGER AUTO_INCREMENT;

CREATE TABLE tipo_competicao (
    tipo_competicao_id   INTEGER NOT NULL,
    nome                 varchar(30) NOT NULL
);

ALTER TABLE tipo_competicao ADD CONSTRAINT tipo_competicao_pk PRIMARY KEY ( tipo_competicao_id );
ALTER TABLE tipo_competicao MODIFY COLUMN tipo_competicao_id INTEGER AUTO_INCREMENT;

CREATE TABLE turma (
    turma_id        INTEGER NOT NULL,
    nome            varchar(30) NOT NULL,
    competicao_id   INTEGER
);

ALTER TABLE turma ADD CONSTRAINT turma_pk PRIMARY KEY ( turma_id );
ALTER TABLE turma MODIFY COLUMN turma_id INTEGER AUTO_INCREMENT;

CREATE TABLE administrador (
  usuario_id     INTEGER NOT NULL,
  nome           varchar(30) NOT NULL,
  senha          varchar(30) NOT NULL,
  nivel_acesso   INTEGER NOT NULL
);

ALTER TABLE administrador ADD CONSTRAINT administrador_pk PRIMARY KEY ( usuario_id );

CREATE TABLE aluno (
  usuario_id     INTEGER NOT NULL,
  nome           varchar(30) NOT NULL,
  senha          varchar(30) NOT NULL,
  nivel_acesso   INTEGER NOT NULL,
    equipe_id    INTEGER
);

ALTER TABLE aluno ADD CONSTRAINT aluno_pk PRIMARY KEY ( usuario_id );


ALTER TABLE aluno
    ADD CONSTRAINT aluno_equipe_fk FOREIGN KEY ( equipe_id )
        REFERENCES equipe ( equipe_id );

ALTER TABLE competicao
    ADD CONSTRAINT competicao_endereco_fk FOREIGN KEY ( numero,cep )
        REFERENCES endereco ( numero,cep );

ALTER TABLE competicao
    ADD CONSTRAINT competicao_tipo_competicao_fk FOREIGN KEY ( tipo_competicao_id )
        REFERENCES tipo_competicao ( tipo_competicao_id );

ALTER TABLE endereco
    ADD CONSTRAINT endereco_cidade_fk FOREIGN KEY ( cidade_id )
        REFERENCES cidade ( cidade_id );

ALTER TABLE equipe
    ADD CONSTRAINT equipe_turma_fk FOREIGN KEY ( turma_id )
        REFERENCES turma ( turma_id );

ALTER TABLE lancamento
    ADD CONSTRAINT lancamento_equipe_fk FOREIGN KEY ( equipe_id )
        REFERENCES equipe ( equipe_id ) ON DELETE CASCADE;

ALTER TABLE lancamento
    ADD CONSTRAINT lancamento_foguete_fk FOREIGN KEY ( foguete_id )
        REFERENCES foguete ( foguete_id );

ALTER TABLE turma
    ADD CONSTRAINT turma_competicao_fk FOREIGN KEY ( competicao_id )
        REFERENCES competicao ( competicao_id );
