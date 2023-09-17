package br.gov.mt.pjc.srv.publico.mapper.impl;

import br.gov.mt.pjc.srv.publico.dto.PessoaResponse;
import br.gov.mt.pjc.srv.publico.entity.Pessoa;
import br.gov.mt.pjc.srv.publico.mapper.IResponseMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PessoaResponseMapperImpl implements IResponseMapper<Pessoa, PessoaResponse> {

    private final ModelMapper mapper;

    @Override
    public PessoaResponse toResponse(Pessoa entity) {
        return mapper.map(entity, PessoaResponse.class);
    }

}
