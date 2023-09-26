package br.gov.mt.pjc.srv.publico.repository.impl;

import br.gov.mt.pjc.srv.publico.dto.response.EnderecoResponse;
import br.gov.mt.pjc.srv.publico.repository.IEnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EnderecoRepositoryImpl implements IEnderecoRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<EnderecoResponse> buscarEndereco(String nome) {
        String sql = "SELECT * FROM speConsultarEnderecoFuncional(?)";
        return jdbcTemplate.query(sql, new Object[]{nome}, (rs, rowNum) -> {
            EnderecoResponse enderecoFuncionalDTO = new EnderecoResponse();
            enderecoFuncionalDTO.setEndereco(rs.getString("endereco"));
            return enderecoFuncionalDTO;
        });
    }

}
