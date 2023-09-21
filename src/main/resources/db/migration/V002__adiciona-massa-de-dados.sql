INSERT INTO pessoa(pes_nome, pes_data_nascimento, pes_sexo, pes_mae, pes_pai)
VALUES ('Débora Fernanda Gomes', '1948-08-27', 'FEMININO', 'Mariah Olivia Stefany', 'Ian Vitor Emanuel Gomes'),
       ('Edson João Mendes', '1958-05-05', 'MASCULINO', 'Carla Aparecida', 'Marcos Vinicius Cauã Osvaldo Mendes'),
       ('Calebe Fernando Almeida', '1975-06-24', 'MASCULINO', 'Bruna Julia', 'Danilo Lucca Enzo Almeida'),
       ('Theo Osvaldo Benício Nunes', '1980-07-04', 'MASCULINO', 'Agatha Elaine', 'Julio Augusto Nunes'),
       ('Tânia Aparecida Costa', '2003-04-17', 'FEMININO', 'Pietra Emanuelly', 'Cláudio Antonio Costas'),
       ('Agatha Tatiane Luiza Almeida', '1969-05-19', 'FEMININO', 'Raimunda Joana', 'Mateus Jorge Carlos Almeida'),
       ('Márcio João Daniel Teixeira', '1951-03-02', 'MASCULINO', 'Natália Fabiana', 'Roberto Cauã Teixeiras'),
       ('Nathan Rafael Gomes', '1974-03-18', 'MASCULINO', 'Alana Andrea Rebeca Gomes', 'João Arthur Thales Gomes'),
       ('Fernanda Andreia Aurora Novaes', '1972-08-07', 'FEMININO', 'Isabella Emilly', 'Ruan Edson Fábio Novaes'),
       ('Valentina Ester Rodrigues', '1999-10-28', 'FEMININO', 'Allana Sebastiana', 'Renan Rafael Rodrigues'),
       ('Lavínia Tânia Melo', '1994-11-11', 'FEMININO', 'Giovanna Regina Teresinha', 'Ian Roberto Edson Melo');


INSERT INTO foto_pessoa(fp_data, fp_bucket, fp_hash, pes_id)
VALUES (CURRENT_DATE, NULL, 'gB6lBlmGni', 1),
       (CURRENT_DATE, NULL, 'gB6lBlmGni', 2),
       (CURRENT_DATE, NULL, 'PIh8FqtNJo', 3),
       (CURRENT_DATE, NULL, 'kdN0Mtnr7S', 4),
       (CURRENT_DATE, NULL, 'FOhXxyggnA', 5),
       (CURRENT_DATE, NULL, 'uPLwQbqHBa', 6),
       (CURRENT_DATE, NULL, 'O2WTPmbDM', 7);


INSERT INTO servidor_temporario(st_data_emissao, st_data_demissao, pes_id)
VALUES (CURRENT_DATE, NULL, 4),
       (CURRENT_DATE, NULL, 5),
       (CURRENT_DATE, NULL, 6);


INSERT INTO servidor_efetivo(se_matricula, pes_id)
VALUES ('161026254', 1),
       ('169766895', 2),
       ('139941824', 3);


INSERT INTO unidade(unid_nome, unid_sigla)
VALUES ('Polícia Judiciária Civil', 'PJC-MT'),
       ('Polícia Judiciária Civil', 'PJC-PI'),
       ('Polícia Judiciária Civil', 'PJC-PB'),
       ('Polícia Judiciária Civil', 'PJC-MA');


INSERT INTO lotacao(lot_data_lotacao, lot_data_remocao, lot_portaria, pes_id, unid_id)
VALUES (CURRENT_DATE, NULL, '00001', 1, 1),
       (CURRENT_DATE, NULL, '00002', 2, 1),
       (CURRENT_DATE, NULL, '00003', 3, 2),
       (CURRENT_DATE, NULL, '00004', 4, 2),
       (CURRENT_DATE, NULL, '00005', 5, 3),
       (CURRENT_DATE, NULL, '00006', 6, 3);


INSERT INTO cidade(cid_nome, cid_uf)
VALUES ('Teresina', 'PI'),
       ('São Luís', 'MA'),
       ('João Pessoa', 'PB');


INSERT INTO endereco(end_tipo_logradouro, end_logradouro, end_numero, end_bairro, cid_id)
VALUES ('COMERCIAL', 'Praça Gabino Besouro', 196, 'Centro', 1),
       ('COMERCIAL', 'Quadra AV 107 Norte Avenida LO 4', 612, 'Plano Diretor Norte', 2),
       ('COMERCIAL', 'Rua Professor Adolfo Santana', 754, 'Buenos Aires', 3),
       ('RESIDENCIAL', 'Rua Itapuá', 754, 'Buenos Aires', 3),
       ('RESIDENCIAL', 'Rua Carriça', 754, 'Buenos Aires', 1),
       ('RESIDENCIAL', 'Vila Cinco Irmãos', 754, 'Buenos Aires', 1),
       ('RESIDENCIAL', 'Rua Monsenhor Mota', 754, 'Buenos Aires', 2),
       ('RESIDENCIAL', 'Rua Mar Adriático', 754, 'Buenos Aires', 2),
       ('RESIDENCIAL', 'Rua Professor Adolfo Santana', 754, 'Buenos Aires', 1);


INSERT INTO unidade_endereco(unid_id, end_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);


INSERT INTO pessoa_endereco(pes_id, end_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (6, 6);
