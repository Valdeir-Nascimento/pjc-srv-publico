CREATE TABLE pessoa
(
    pes_id              SERIAL PRIMARY KEY,
    pes_nome            VARCHAR(200) NOT NULL,
    pes_data_nascimento DATE         NOT NULL,
    pes_sexo            VARCHAR(9)   NOT NULL,
    pes_mae             VARCHAR(200) NOT NULL,
    pes_pai             VARCHAR(200) NOT NULL
);

CREATE TABLE foto_pessoa
(
    fp_id     SERIAL PRIMARY KEY,
    fp_data   DATE NOT NULL,
    fp_bucket VARCHAR(50),
    fp_hash   VARCHAR(50),
    pes_id    INT  NOT NULL
);

CREATE TABLE servidor_efetivo
(
    se_id        SERIAL PRIMARY KEY,
    se_matricula VARCHAR(20) NOT NULL,
    pes_id       INT         NOT NULL
);

CREATE TABLE servidor_temporario
(
    st_id            SERIAL PRIMARY KEY,
    st_data_emissao  DATE NOT NULL,
    st_data_demissao DATE NULL,
    pes_id           INT  NOT NULL
);

CREATE TABLE lotacao
(
    lot_id           SERIAL PRIMARY KEY,
    lot_data_lotacao DATE NULL,
    lot_data_remocao DATE NULL,
    lot_portaria     VARCHAR(100),
    pes_id           INT  NOT NULL,
    unid_id          INT  NOT NULL
);

CREATE TABLE unidade
(
    unid_id    SERIAL PRIMARY KEY,
    unid_nome  VARCHAR(200) NOT NULL,
    unid_sigla VARCHAR(20)
);

CREATE TABLE endereco
(
    end_id              SERIAL PRIMARY KEY,
    end_tipo_logradouro VARCHAR(50)  NOT NULL,
    end_logradouro      VARCHAR(200) NOT NULL,
    end_numero          INT          NOT NULL,
    end_bairro          VARCHAR(100),
    cid_id              INT          NOT NULL
);

CREATE TABLE cidade
(
    cid_id   SERIAL PRIMARY KEY,
    cid_nome VARCHAR(200) NOT NULL,
    cid_uf   CHAR(2)      NOT NULL
);

CREATE TABLE pessoa_endereco
(
    pes_id INT NOT NULL,
    end_id INT NOT NULL
);

CREATE TABLE unidade_endereco
(
    unid_id INT NOT NULL,
    end_id  INT NOT NULL
);

ALTER TABLE foto_pessoa
    ADD CONSTRAINT fk_foto_pessoa__pessoa__pes_id
        FOREIGN KEY (pes_id) REFERENCES pessoa (pes_id);

ALTER TABLE servidor_temporario
    ADD CONSTRAINT fk_servidor_temporario__pessoa__pes_id
        FOREIGN KEY (pes_id) REFERENCES pessoa (pes_id);

ALTER TABLE servidor_efetivo
    ADD CONSTRAINT fk_servidor_efetivo__pessoa__pes_id
        FOREIGN KEY (pes_id) REFERENCES pessoa (pes_id);

ALTER TABLE lotacao
    ADD CONSTRAINT fk_lotacao__pessoa__pes_id
        FOREIGN KEY (pes_id) REFERENCES pessoa (pes_id);

ALTER TABLE lotacao
    ADD CONSTRAINT fk_lotacao__unidade__unid_id
        FOREIGN KEY (unid_id) REFERENCES unidade (unid_id);

ALTER TABLE endereco
    ADD CONSTRAINT fk_endereco__cidade__cid_id
        FOREIGN KEY (cid_id) REFERENCES cidade (cid_id);

ALTER TABLE pessoa_endereco
    ADD CONSTRAINT fk_pessoa_endereco__pessoa__pes_id
        FOREIGN KEY (pes_id) REFERENCES pessoa (pes_id);

ALTER TABLE pessoa_endereco
    ADD CONSTRAINT fk_pessoa_endereco__endereco__end_id
        FOREIGN KEY (end_id) REFERENCES endereco (end_id);

ALTER TABLE unidade_endereco
    ADD CONSTRAINT fk_unidade_endereco__unidade__unid_id
        FOREIGN KEY (unid_id) REFERENCES unidade (unid_id);

ALTER TABLE unidade_endereco
    ADD CONSTRAINT fk_unidade_endereco__endereco__end_id
        FOREIGN KEY (end_id) REFERENCES endereco (end_id);
