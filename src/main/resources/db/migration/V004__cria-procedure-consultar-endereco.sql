CREATE OR REPLACE FUNCTION spe_consultar_endereco_funcional(p_nome VARCHAR)
RETURNS TABLE (endereco VARCHAR) AS $$
BEGIN
    RETURN QUERY
    SELECT CONCAT(ende.end_logradouro, ', ', ende.end_numero, ', ', ende.end_bairro) AS endereco
    FROM pessoa pes
    INNER JOIN lotacao lot ON lot.pes_id = pes.pes_id
    INNER JOIN unidade uni ON uni.unid_id = lot.unid_id
    INNER JOIN unidade_endereco uend ON uend.unid_id = uni.unid_id
    INNER JOIN endereco ende ON ende.end_id = uend.end_id
    WHERE pes.pes_nome ILIKE '%' || p_nome || '%';
END;
$$ LANGUAGE plpgsql;
