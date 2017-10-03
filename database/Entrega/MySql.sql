CREATE TABLE administrador (
    usuario_id   INTEGER NOT NULL
);

ALTER TABLE administrador ADD CONSTRAINT administrador_pk PRIMARY KEY ( usuario_id );

CREATE TABLE aluno (
    usuario_id         INTEGER NOT NULL,
    equipe_equipe_id   INTEGER
);

ALTER TABLE aluno ADD CONSTRAINT aluno_pk PRIMARY KEY ( usuario_id );

CREATE TABLE bairro (
    bairro_id          INTEGER NOT NULL,
    nome               varchar(50) NOT NULL,
    cidade_cidade_id   INTEGER
);

ALTER TABLE bairro ADD CONSTRAINT bairro_pk PRIMARY KEY ( bairro_id );
ALTER TABLE bairro MODIFY COLUMN bairro_id INTEGER AUTO_INCREMENT;


CREATE TABLE cidade (
    cidade_id          INTEGER NOT NULL,
    nome               varchar(30) NOT NULL,
    estado_estado_id   INTEGER
);

ALTER TABLE cidade ADD CONSTRAINT cidade_pk PRIMARY KEY ( cidade_id );
ALTER TABLE cidade MODIFY COLUMN cidade_id INTEGER AUTO_INCREMENT;


CREATE TABLE competicao (
    competicao_id          INTEGER NOT NULL,
    nome                   varchar(30) NOT NULL,
    data                   DATE NOT NULL,
    endereco_endereco_id   INTEGER
);

ALTER TABLE competicao ADD CONSTRAINT competicao_pk PRIMARY KEY ( competicao_id );
ALTER TABLE competicao MODIFY COLUMN competicao_id INTEGER AUTO_INCREMENT;


CREATE TABLE endereco (
    endereco_id                INTEGER NOT NULL,
    cep                        varchar(8) NOT NULL,
    nome_rua                   varchar(30) NOT NULL,
    numero                     INTEGER NOT NULL,
    bairro_bairro_id           INTEGER,
    logradouro_logradouro_id   INTEGER
);

ALTER TABLE endereco ADD CONSTRAINT endereco_pk PRIMARY KEY ( endereco_id );
ALTER TABLE endereco MODIFY COLUMN endereco_id INTEGER AUTO_INCREMENT;


CREATE TABLE equipe (
    equipe_id        INTEGER NOT NULL,
    nome             varchar(30) NOT NULL,
    classificado     CHAR(1) NOT NULL,
    turma_turma_id   INTEGER
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
    equipe_equipe_id          INTEGER,
    foguete_foguete_id        INTEGER
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

CREATE TABLE turma (
    turma_id                   INTEGER NOT NULL,
    nome                       varchar(30) NOT NULL,
    competicao_competicao_id   INTEGER,
    periodo_periodo_id         INTEGER
);

ALTER TABLE turma ADD CONSTRAINT turma_pk PRIMARY KEY ( turma_id );
ALTER TABLE turma MODIFY COLUMN turma_id INTEGER AUTO_INCREMENT;

CREATE TABLE usuario (
    usuario_id              INTEGER NOT NULL,
    nome                    varchar(30) NOT NULL,
    senha                   varchar(30) NOT NULL,
    nivel_acesso_nivel_id   INTEGER
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( usuario_id );
ALTER TABLE usuario MODIFY COLUMN usuario_id INTEGER AUTO_INCREMENT;

ALTER TABLE administrador
    ADD CONSTRAINT administrador_usuario_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuario ( usuario_id );

ALTER TABLE aluno
    ADD CONSTRAINT aluno_equipe_fk FOREIGN KEY ( equipe_equipe_id )
        REFERENCES equipe ( equipe_id );

ALTER TABLE aluno
    ADD CONSTRAINT aluno_usuario_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuario ( usuario_id );

ALTER TABLE bairro
    ADD CONSTRAINT bairro_cidade_fk FOREIGN KEY ( cidade_cidade_id )
        REFERENCES cidade ( cidade_id );

ALTER TABLE cidade
    ADD CONSTRAINT cidade_estado_fk FOREIGN KEY ( estado_estado_id )
        REFERENCES estado ( estado_id );

ALTER TABLE competicao
    ADD CONSTRAINT competicao_endereco_fk FOREIGN KEY ( endereco_endereco_id )
        REFERENCES endereco ( endereco_id );

ALTER TABLE endereco
    ADD CONSTRAINT endereco_bairro_fk FOREIGN KEY ( bairro_bairro_id )
        REFERENCES bairro ( bairro_id );

ALTER TABLE endereco
    ADD CONSTRAINT endereco_logradouro_fk FOREIGN KEY ( logradouro_logradouro_id )
        REFERENCES logradouro ( logradouro_id );

ALTER TABLE equipe
    ADD CONSTRAINT equipe_turma_fk FOREIGN KEY ( turma_turma_id )
        REFERENCES turma ( turma_id );

ALTER TABLE lancamento
    ADD CONSTRAINT lancamento_equipe_fk FOREIGN KEY ( equipe_equipe_id )
        REFERENCES equipe ( equipe_id );

ALTER TABLE lancamento
    ADD CONSTRAINT lancamento_foguete_fk FOREIGN KEY ( foguete_foguete_id )
        REFERENCES foguete ( foguete_id );

ALTER TABLE turma
    ADD CONSTRAINT turma_competicao_fk FOREIGN KEY ( competicao_competicao_id )
        REFERENCES competicao ( competicao_id );

ALTER TABLE turma
    ADD CONSTRAINT turma_periodo_fk FOREIGN KEY ( periodo_periodo_id )
        REFERENCES periodo ( periodo_id );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_nivel_acesso_fk FOREIGN KEY ( nivel_acesso_nivel_id )
        REFERENCES nivel_acesso ( nivel_id );
