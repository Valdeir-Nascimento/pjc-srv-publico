CREATE OR REPLACE FUNCTION spe_consultar_pessoas_efetivadas()
RETURNS TABLE (
    nome varchar,
    idade integer,
    unidade_lotacao varchar,
    fotografia bytea
) AS $$
BEGIN
    RETURN QUERY
    SELECT pes.pes_nome as nome,
           EXTRACT(YEAR FROM AGE(pes.pes_data_nascimento)) as idade,
           uni.unid_nome as unidade_lotacao,
           fot.fp_bucket as fotografia
    FROM pessoa pes
    INNER JOIN foto_pessoa fot ON pes.pes_id = fot.pes_id
    INNER JOIN servidor_efetivo srv ON srv.pes_id = pes.pes_id
    INNER JOIN lotacao lot ON lot.pes_id = pes.pes_id
    INNER JOIN unidade uni ON uni.unid_id = lot.unid_id
    ORDER BY pes.pes_nome;
END;
$$ LANGUAGE plpgsql;
