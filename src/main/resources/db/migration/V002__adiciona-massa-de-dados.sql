INSERT INTO pessoa(pes_id, pes_nome, pes_data_nascimento, pes_sexo, pes_mae, pes_pai)
VALUES (1, 'Débora Fernanda Gomes', '1948-08-27', 'FEMININO', 'Mariah Olivia Stefany', 'Ian Vitor Emanuel Gomes'),
       (2, 'Edson João Mendes', '1958-05-05', 'MASCULINO', 'Carla Aparecida', 'Marcos Vinicius Cauã Osvaldo Mendes'),
       (3, 'Calebe Fernando Almeida', '1975-06-24', 'MASCULINO', 'Bruna Julia', 'Danilo Lucca Enzo Almeida'),
       (4, 'Theo Osvaldo Benício Nunes', '1980-07-04', 'MASCULINO', 'Agatha Elaine', 'Julio Augusto Nunes'),
       (5, 'Tânia Aparecida Costa', '2003-04-17', 'FEMININO', 'Pietra Emanuelly', 'Cláudio Antonio Costas'),
       (6, 'Agatha Tatiane Luiza Almeida', '1969-05-19', 'FEMININO', 'Raimunda Joana', 'Mateus Jorge Carlos Almeida'),
       (7, 'Márcio João Daniel Teixeira', '1951-03-02', 'MASCULINO', 'Natália Fabiana', 'Roberto Cauã Teixeiras'),
       (8, 'Nathan Rafael Gomes', '1974-03-18', 'MASCULINO', 'Alana Andrea Rebeca Gomes', 'João Arthur Thales Gomes'),
       (9, 'Fernanda Andreia Aurora Novaes', '1972-08-07', 'FEMININO', 'Isabella Emilly', 'Ruan Edson Fábio Novaes'),
       (10, 'Valentina Ester Rodrigues', '1999-10-28', 'FEMININO', 'Allana Sebastiana', 'Renan Rafael Rodrigues'),
       (11, 'Lavínia Tânia Melo', '1994-11-11', 'FEMININO', 'Giovanna Regina Teresinha', 'Ian Roberto Edson Melo');

INSERT INTO foto_pessoa(fp_id, fp_data, fp_bucket, fp_hash, pes_id)
VALUES (1, CURRENT_DATE, NULL, 'gB6lBlmGni', 1),
       (2, CURRENT_DATE, NULL, 'gB6lBlmGni', 2),
       (3, CURRENT_DATE, NULL, 'PIh8FqtNJo', 3),
       (4, CURRENT_DATE, NULL, 'kdN0Mtnr7S', 4),
       (5, CURRENT_DATE, NULL, 'FOhXxyggnA', 5),
       (6, CURRENT_DATE, NULL, 'uPLwQbqHBa', 6),
       (7, CURRENT_DATE, NULL, 'O2WTPmbDM', 7);

INSERT INTO servidor_temporario(st_id, st_data_emissao, st_data_demissao, pes_id)
VALUES (1, CURRENT_DATE, NULL, 4),
       (2, CURRENT_DATE, NULL, 5),
       (3, CURRENT_DATE, NULL, 6);

INSERT INTO servidor_efetivo(se_id, se_matricula, pes_id)
VALUES (1, '161026254', 1),
       (2, '169766895', 2),
       (3, '139941824', 3);

INSERT INTO unidade(unid_id, unid_nome, unid_sigla)
VALUES (1, 'Polícia Judiciária Civil', 'PJC-MT'),
       (2, 'Polícia Judiciária Civil', 'PJC-PI'),
       (3, 'Polícia Judiciária Civil', 'PJC-PB'),
       (4, 'Polícia Judiciária Civil', 'PJC-MA');


INSERT INTO lotacao(lot_id, lot_data_lotacao, lot_data_remocao, lot_portaria, pes_id, unid_id)
VALUES (1, CURRENT_DATE, NULL, '00001', 1, 1),
       (2, CURRENT_DATE, NULL, '00002', 2, 1),
       (3, CURRENT_DATE, NULL, '00003', 3, 2),
       (4, CURRENT_DATE, NULL, '00004', 4, 2),
       (5, CURRENT_DATE, NULL, '00005', 5, 3),
       (6, CURRENT_DATE, NULL, '00006', 6, 3);


INSERT INTO cidade(cid_id, cid_nome, cid_uf)
VALUES (1, 'Teresina', 'PI'),
       (2, 'São Luís', 'MA'),
       (3, 'João Pessoa', 'PB');

INSERT INTO endereco(end_id, end_tipo_logradouro, end_logradouro, end_numero, end_bairro, cid_id)
VALUES (1, 'COMERCIAL', 'Praça Gabino Besouro', 196, 'Centro', 1),
       (2, 'COMERCIAL', 'Quadra AV 107 Norte Avenida LO 4', 612, 'Plano Diretor Norte', 2),
       (3, 'COMERCIAL', 'Rua Professor Adolfo Santana', 754, 'Buenos Aires', 3),
       (4, 'RESIDENCIAL', 'Rua Itapuá', 754, 'Buenos Aires', 3),
       (5, 'RESIDENCIAL', 'Rua Carriça', 754, 'Buenos Aires', 1),
       (6, 'RESIDENCIAL', 'Vila Cinco Irmãos', 754, 'Buenos Aires', 1),
       (7, 'RESIDENCIAL', 'Rua Monsenhor Mota', 754, 'Buenos Aires', 2),
       (8, 'RESIDENCIAL', 'Rua Mar Adriático', 754, 'Buenos Aires', 2),
       (9, 'RESIDENCIAL', 'Rua Professor Adolfo Santana', 754, 'Buenos Aires', 1);



INSERT INTO unidade_endereco(unid_id, end_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);

INSERT INTO