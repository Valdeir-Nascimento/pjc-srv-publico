CREATE OR REPLACE FUNCTION speConsultarFuncionariosEfetivos()
RETURNS TABLE (
    nome VARCHAR,
    idade INTEGER,
    unidade_lotacao VARCHAR,
    fotografia VARCHAR
) AS $$
BEGIN
    RETURN QUERY
    SELECT pes.pes_nome AS nome,
           EXTRACT(YEAR FROM AGE(pes.pes_data_nascimento))::INTEGER AS idade,
           uni.unid_nome AS unidade_lotacao,
           fot.fp_bucket AS fotografia
    FROM pessoa pes
    INNER JOIN foto_pessoa fot ON pes.pes_id = fot.pes_id
    INNER JOIN servidor_efetivo srv ON srv.pes_id = pes.pes_id
    INNER JOIN lotacao lot ON lot.pes_id = pes.pes_id
    INNER JOIN unidade uni ON uni.unid_id = lot.unid_id
    ORDER BY pes.pes_nome;
END;
$$ LANGUAGE plpgsql;
