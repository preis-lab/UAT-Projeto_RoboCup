CREATE TABLE administrador (
    usuario_id   INTEGER NOT NULL,
    nome         varchar(30) NOT NULL,
    senha        varchar(30) NOT NULL,
    nivel_id     INTEGER
);
ALTER TABLE administrador ADD CONSTRAINT administrador_pk PRIMARY KEY ( usuario_id );

CREATE TABLE aluno (
    usuario_id   INTEGER NOT NULL,
    equipe_id    INTEGER,
    nome         varchar(30) NOT NULL,
    senha        varchar(30) NOT NULL,
    nivel_id     INTEGER
);

ALTER TABLE aluno ADD CONSTRAINT aluno_pk PRIMARY KEY ( usuario_id );

CREATE TABLE bairro (
    bairro_id   INTEGER NOT NULL,
    nome        varchar(50) NOT NULL,
    cidade_id   INTEGER
);

ALTER TABLE bairro ADD CONSTRAINT bairro_pk PRIMARY KEY ( bairro_id );
ALTER TABLE bairro MODIFY COLUMN bairro_id INTEGER AUTO_INCREMENT;

CREATE TABLE cidade (
    cidade_id   INTEGER NOT NULL,
    nome        varchar(30) NOT NULL,
    estado_id   INTEGER
);

ALTER TABLE cidade ADD CONSTRAINT cidade_pk PRIMARY KEY ( cidade_id );
ALTER TABLE cidade MODIFY COLUMN cidade_id INTEGER AUTO_INCREMENT;

CREATE TABLE competicao (
    competicao_id        INTEGER NOT NULL,
    data                 DATE NOT NULL,
    numero               INTEGER,
    tipo_competicao_id   INTEGER,
    ativa                CHAR(1) NOT NULL,
    cep                  INTEGER
);

ALTER TABLE competicao ADD CONSTRAINT competicao_pk PRIMARY KEY ( competicao_id );
ALTER TABLE competicao MODIFY COLUMN competicao_id INTEGER AUTO_INCREMENT;

CREATE TABLE endereco (
    numero   INTEGER NOT NULL,
    cep      INTEGER NOT NULL
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

CREATE TABLE estado (
    estado_id   INTEGER NOT NULL,
    nome        varchar(30) NOT NULL,
    uf          varchar(2) NOT NULL
);

ALTER TABLE estado ADD CONSTRAINT estado_pk PRIMARY KEY ( estado_id );
ALTER TABLE estado MODIFY COLUMN estado_id INTEGER AUTO_INCREMENT;

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
    tempopropulsao            DATE NOT NULL,
    picoaceleracao            FLOAT NOT NULL,
    aceleracaomedia           FLOAT NOT NULL,
    tempoapogeudescida        DATE NOT NULL,
    altitudeejecao            FLOAT NOT NULL,
    taxadescida               FLOAT NOT NULL,
    duracaovoo                DATE NOT NULL,
    distanciaentrequedaalvo   FLOAT NOT NULL,
    equipe_id                 INTEGER,
    foguete_id                INTEGER
);

ALTER TABLE lancamento ADD CONSTRAINT lancamento_pk PRIMARY KEY ( lancamento_id );
ALTER TABLE lancamento MODIFY COLUMN lancamento_id INTEGER AUTO_INCREMENT;

CREATE TABLE logradouro (
    logradouro_id   INTEGER NOT NULL,
    tipo            varchar(30) NOT NULL
);

ALTER TABLE logradouro ADD CONSTRAINT logradouro_pk PRIMARY KEY ( logradouro_id );
ALTER TABLE logradouro MODIFY COLUMN logradouro_id INTEGER AUTO_INCREMENT;

CREATE TABLE nivel_acesso (
    nivel_id    INTEGER NOT NULL,
    descricao   varchar(30) NOT NULL
);

ALTER TABLE nivel_acesso ADD CONSTRAINT nivel_acesso_pk PRIMARY KEY ( nivel_id );
ALTER TABLE nivel_acesso MODIFY COLUMN nivel_id INTEGER AUTO_INCREMENT;

CREATE TABLE periodo (
    periodo_id    INTEGER NOT NULL,
    descricao     varchar(30) NOT NULL,
    horainicial   DATE NOT NULL,
    horafinal     DATE NOT NULL
);

ALTER TABLE periodo ADD CONSTRAINT periodo_pk PRIMARY KEY ( periodo_id );
ALTER TABLE periodo MODIFY COLUMN periodo_id INTEGER AUTO_INCREMENT;

CREATE TABLE rua (
    cep             INTEGER NOT NULL,
    nome            varchar(50) NOT NULL,
    bairro_id       INTEGER,
    logradouro_id   INTEGER
);

ALTER TABLE rua ADD CONSTRAINT rua_pk PRIMARY KEY ( cep );

CREATE TABLE tipo_competicao (
    tipo_competicao_id   INTEGER NOT NULL,
    nome                 varchar(30) NOT NULL
);

ALTER TABLE tipo_competicao ADD CONSTRAINT tipo_competicao_pk PRIMARY KEY ( tipo_competicao_id );
ALTER TABLE tipo_competicao MODIFY COLUMN tipo_competicao_id INTEGER AUTO_INCREMENT;

CREATE TABLE turma (
    turma_id        INTEGER NOT NULL,
    nome            varchar(30) NOT NULL,
    competicao_id   INTEGER,
    periodo_id      INTEGER
);

ALTER TABLE turma ADD CONSTRAINT turma_pk PRIMARY KEY ( turma_id );
ALTER TABLE turma MODIFY COLUMN turma_id INTEGER AUTO_INCREMENT;

ALTER TABLE administrador
    ADD CONSTRAINT administrador_nivel_acesso_fk FOREIGN KEY ( nivel_id )
        REFERENCES nivel_acesso ( nivel_id );

ALTER TABLE aluno
    ADD CONSTRAINT aluno_equipe_fk FOREIGN KEY ( equipe_id )
        REFERENCES equipe ( equipe_id );

ALTER TABLE aluno
    ADD CONSTRAINT aluno_nivel_acesso_fk FOREIGN KEY ( nivel_id )
        REFERENCES nivel_acesso ( nivel_id );

ALTER TABLE bairro
    ADD CONSTRAINT bairro_cidade_fk FOREIGN KEY ( cidade_id )
        REFERENCES cidade ( cidade_id );

ALTER TABLE cidade
    ADD CONSTRAINT cidade_estado_fk FOREIGN KEY ( estado_id )
        REFERENCES estado ( estado_id );

ALTER TABLE competicao
    ADD CONSTRAINT competicao_endereco_fk FOREIGN KEY ( numero,cep )
        REFERENCES endereco ( numero,cep );

ALTER TABLE competicao
    ADD CONSTRAINT competicao_tipo_competicao_fk FOREIGN KEY ( tipo_competicao_id )
        REFERENCES tipo_competicao ( tipo_competicao_id );

ALTER TABLE endereco
    ADD CONSTRAINT endereco_rua_fk FOREIGN KEY ( cep )
        REFERENCES rua ( cep );

ALTER TABLE equipe
    ADD CONSTRAINT equipe_turma_fk FOREIGN KEY ( turma_id )
        REFERENCES turma ( turma_id );

ALTER TABLE lancamento
    ADD CONSTRAINT lancamento_equipe_fk FOREIGN KEY ( equipe_id )
        REFERENCES equipe ( equipe_id ) ON DELETE CASCADE;

ALTER TABLE lancamento
    ADD CONSTRAINT lancamento_foguete_fk FOREIGN KEY ( foguete_id )
        REFERENCES foguete ( foguete_id );

ALTER TABLE rua
    ADD CONSTRAINT rua_bairro_fk FOREIGN KEY ( bairro_id )
        REFERENCES bairro ( bairro_id );

ALTER TABLE rua
    ADD CONSTRAINT rua_logradouro_fk FOREIGN KEY ( logradouro_id )
        REFERENCES logradouro ( logradouro_id );

ALTER TABLE turma
    ADD CONSTRAINT turma_competicao_fk FOREIGN KEY ( competicao_id )
        REFERENCES competicao ( competicao_id );

ALTER TABLE turma
    ADD CONSTRAINT turma_periodo_fk FOREIGN KEY ( periodo_id )
        REFERENCES periodo ( periodo_id );
