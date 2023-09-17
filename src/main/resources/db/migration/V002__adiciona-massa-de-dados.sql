INSERT INTO pessoa(pes_id, pes_nome, pes_data_nascimento, pes_sexo, pes_mae, pes_pai)
VALUES (1, 'Débora Fernanda Gomes', '1948-08-27', 'FEMININO', 'Mariah Olivia Stefany', 'Ian Vitor Emanuel Gomes'),
       (2, 'Edson João Mendes', '1958-05-05', 'MASCULINO', 'Carla Aparecida', 'Marcos Vinicius Cauã Osvaldo Mendes'),
       (3, 'Calebe Fernando Almeida', '1975-06-24', 'MASCULINO', 'Bruna Julia', 'Danilo Lucca Enzo Almeida'),
       (4, 'Theo Osvaldo Benício Nunes', '1980-07-04', 'MASCULINO', 'Agatha Elaine', 'Julio Augusto Nunes'),
       (5, 'Tânia Aparecida Costa', '2003-04-17', 'FEMININO', 'Pietra Emanuelly', 'Cláudio Antonio Costas');

INSERT INTO foto_pessoa(fp_id, fp_data, fp_bucket, fp_hash, pes_id)
VALUES (1, CURRENT_DATE, NULL, 'gB6lBlmGni', 1),
       (2, CURRENT_DATE, NULL, 'gB6lBlmGni', 2),
       (3, CURRENT_DATE, NULL, 'PIh8FqtNJo', 3);

INSERT INTO servidor_temporario(st_id, st_data_emissao, st_data_demissao, pes_id)
VALUES (1, CURRENT_DATE, NULL, 1),
       (2, CURRENT_DATE, NULL, 2),
       (3, CURRENT_DATE, NULL, 3);

INSERT INTO servidor_efetivo(se_id, se_matricula, pes_id)
VALUES (1, '161026254', 1),
       (2, '169766895', 2),
       (3, '139941824', 3);

INSERT INTO unidade(unid_id, unid_nome, unid_sigla)
VALUES (1, 'Polícia Judiciária Civil', 'PJC-MT');
