package br.gov.mt.pjc.srv.publico.repository.impl;

import br.gov.mt.pjc.srv.publico.dto.response.FuncionarioEfetivoResponse;
import br.gov.mt.pjc.srv.publico.repository.IFuncionarioEfetivoRepository;
import br.gov.mt.pjc.srv.publico.repository.validator.IValidarUnidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FuncionarioEfetivoRepositoryImpl implements IFuncionarioEfetivoRepository {

    private final JdbcTemplate jdbcTemplate;
    private final IValidarUnidadeRepository validarUnidadeRepository;

    @Override
    public List<FuncionarioEfetivoResponse> getFuncionariosEfetivosPorUnidade(Integer idUnidade) {
        validarUnidadeRepository.validar(idUnidade);
        String sql = "SELECT nome, idade, unidade_lotacao, fotografia  FROM speConsultarFuncionariosEfetivos(?)";
        List<FuncionarioEfetivoResponse> funcionarios = jdbcTemplate.query(
                sql,
                new Object[]{idUnidade},
                BeanPropertyRowMapper.newInstance(FuncionarioEfetivoResponse.class)
        );
        if (CollectionUtils.isEmpty(funcionarios)) {
            return Collections.emptyList();
        }
        return funcionarios;
    }

}
