
CREATE TABLE aluno (
    rm                 INTEGER NOT NULL,
    nome               VARCHAR2(30) NOT NULL,
    turma_turma_id     INTEGER,
    equipe_equipe_id   INTEGER
);

ALTER TABLE aluno ADD CONSTRAINT aluno_pk PRIMARY KEY ( rm );

CREATE TABLE bairro (
    bairro_id          INTEGER NOT NULL,
    nome               VARCHAR2(30) NOT NULL,
    cidade_cidade_id   INTEGER
);

ALTER TABLE bairro ADD CONSTRAINT bairro_pk PRIMARY KEY ( bairro_id );

CREATE TABLE cidade (
    cidade_id          INTEGER NOT NULL,
    nome               VARCHAR2(30) NOT NULL,
    estado_estado_id   INTEGER
);

ALTER TABLE cidade ADD CONSTRAINT cidade_pk PRIMARY KEY ( cidade_id );

CREATE TABLE competicao (
    competicao_id              INTEGER NOT NULL,
    nome                       VARCHAR2(30) NOT NULL,
    data                       DATE NOT NULL,
    logradouro_logradouro_id   INTEGER
);

ALTER TABLE competicao ADD CONSTRAINT competicao_pk PRIMARY KEY ( competicao_id );

CREATE TABLE endereco (
    endereco_id        INTEGER NOT NULL,
    cep                VARCHAR2(8) NOT NULL,
    nome_rua           VARCHAR2(30) NOT NULL,
    numero             INTEGER NOT NULL,
    bairro_bairro_id   INTEGER
);

ALTER TABLE endereco ADD CONSTRAINT endereco_pk PRIMARY KEY ( endereco_id );

CREATE TABLE equipe (
    equipe_id        INTEGER NOT NULL,
    nome             VARCHAR2(30) NOT NULL,
    classificado     CHAR(1) NOT NULL,
    turma_turma_id   INTEGER
);

ALTER TABLE equipe ADD CONSTRAINT equipe_pk PRIMARY KEY ( equipe_id );

CREATE TABLE estado (
    estado_id   INTEGER NOT NULL,
    nome        VARCHAR2(30) NOT NULL
);

ALTER TABLE estado ADD CONSTRAINT estado_pk PRIMARY KEY ( estado_id );

CREATE TABLE foguete (
    foguete_id   INTEGER NOT NULL,
    peso         FLOAT NOT NULL,
    tamanho      FLOAT NOT NULL
);

ALTER TABLE foguete ADD CONSTRAINT foguete_pk PRIMARY KEY ( foguete_id );

CREATE TABLE lancamento (
    lancamento_id             INTEGER NOT NULL,
    distanciadoalvo           FLOAT NOT NULL,
    angulolancamento          FLOAT NOT NULL,
    velocidadevento           FLOAT NOT NULL,
    altitudemaxima            FLOAT NOT NULL,
    tempopropulsao            DATE NOT NULL,
    picoaceleracao            FLOAT NOT NULL,
    aceleracaomedia           FLOAT NOT NULL,
    tempoapogeudescida        DATE NOT NULL,
    altitudeejecao            FLOAT NOT NULL,
    taxadescida               FLOAT NOT NULL,
    duracaovoo                DATE NOT NULL,
    distanciaentrequedaalvo   FLOAT NOT NULL,
    equipe_equipe_id          INTEGER,
    foguete_foguete_id        INTEGER
);

ALTER TABLE lancamento ADD CONSTRAINT lancamento_pk PRIMARY KEY ( lancamento_id );

CREATE TABLE logradouro (
    logradouro_id             INTEGER NOT NULL,
    nome                      VARCHAR2(30) NOT NULL,
    endereco_endereco_id      INTEGER,
    tipo_logradouro_tipo_id   INTEGER
);

ALTER TABLE logradouro ADD CONSTRAINT logradouro_pk PRIMARY KEY ( logradouro_id );

CREATE TABLE periodo (
    periodo_id    INTEGER NOT NULL,
    descricao     VARCHAR2(30) NOT NULL,
    horainicial   DATE NOT NULL,
    horafinal     DATE NOT NULL
);

ALTER TABLE periodo ADD CONSTRAINT periodo_pk PRIMARY KEY ( periodo_id );

CREATE TABLE tipo_logradouro (
    tipo_id     INTEGER NOT NULL,
    descricao   VARCHAR2(30) NOT NULL
);

ALTER TABLE tipo_logradouro ADD CONSTRAINT tipo_logradouro_pk PRIMARY KEY ( tipo_id );

CREATE TABLE turma (
    turma_id                   INTEGER NOT NULL,
    nome                       VARCHAR2(30) NOT NULL,
    competicao_competicao_id   INTEGER,
    periodo_periodo_id         INTEGER,
    turma_id1                  INTEGER NOT NULL
);

ALTER TABLE turma ADD CONSTRAINT turma_pk PRIMARY KEY ( turma_id );

ALTER TABLE aluno
    ADD CONSTRAINT aluno_equipe_fk FOREIGN KEY ( equipe_equipe_id )
        REFERENCES equipe ( equipe_id );

ALTER TABLE aluno
    ADD CONSTRAINT aluno_turma_fk FOREIGN KEY ( turma_turma_id )
        REFERENCES turma ( turma_id );

ALTER TABLE bairro
    ADD CONSTRAINT bairro_cidade_fk FOREIGN KEY ( cidade_cidade_id )
        REFERENCES cidade ( cidade_id );

ALTER TABLE cidade
    ADD CONSTRAINT cidade_estado_fk FOREIGN KEY ( estado_estado_id )
        REFERENCES estado ( estado_id );

ALTER TABLE competicao
    ADD CONSTRAINT competicao_logradouro_fk FOREIGN KEY ( logradouro_logradouro_id )
        REFERENCES logradouro ( logradouro_id );

ALTER TABLE endereco
    ADD CONSTRAINT endereco_bairro_fk FOREIGN KEY ( bairro_bairro_id )
        REFERENCES bairro ( bairro_id );

ALTER TABLE equipe
    ADD CONSTRAINT equipe_turma_fk FOREIGN KEY ( turma_turma_id )
        REFERENCES turma ( turma_id );

ALTER TABLE lancamento
    ADD CONSTRAINT lancamento_equipe_fk FOREIGN KEY ( equipe_equipe_id )
        REFERENCES equipe ( equipe_id );

ALTER TABLE lancamento
    ADD CONSTRAINT lancamento_foguete_fk FOREIGN KEY ( foguete_foguete_id )
        REFERENCES foguete ( foguete_id );

ALTER TABLE logradouro
    ADD CONSTRAINT logradouro_endereco_fk FOREIGN KEY ( endereco_endereco_id )
        REFERENCES endereco ( endereco_id );

ALTER TABLE logradouro
    ADD CONSTRAINT logradouro_tipo_logradouro_fk FOREIGN KEY ( tipo_logradouro_tipo_id )
        REFERENCES tipo_logradouro ( tipo_id );

ALTER TABLE turma
    ADD CONSTRAINT turma_competicao_fk FOREIGN KEY ( competicao_competicao_id )
        REFERENCES competicao ( competicao_id );

ALTER TABLE turma
    ADD CONSTRAINT turma_periodo_fk FOREIGN KEY ( periodo_periodo_id )
        REFERENCES periodo ( periodo_id );

