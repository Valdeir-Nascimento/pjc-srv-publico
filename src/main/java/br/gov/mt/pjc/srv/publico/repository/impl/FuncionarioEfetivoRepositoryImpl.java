package br.gov.mt.pjc.srv.publico.repository.impl;

import br.gov.mt.pjc.srv.publico.dto.request.FuncionarioEfetivoResponse;
import br.gov.mt.pjc.srv.publico.repository.IFuncionarioEfetivoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FuncionarioEfetivoRepositoryImpl implements IFuncionarioEfetivoRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<FuncionarioEfetivoResponse> getFuncionariosEfetivos() {
        String sql = "SELECT * FROM speConsultarFuncionariosEfetivos()";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            FuncionarioEfetivoResponse funcionario = new FuncionarioEfetivoResponse();
            funcionario.setNome(rs.getString("nome"));
            funcionario.setIdade(rs.getInt("idade"));
            funcionario.setUnidadeLotacao(rs.getString("unidade_lotacao"));
            funcionario.setFotografia(rs.getString("fotografia"));
            return funcionario;
        });
    }

}
