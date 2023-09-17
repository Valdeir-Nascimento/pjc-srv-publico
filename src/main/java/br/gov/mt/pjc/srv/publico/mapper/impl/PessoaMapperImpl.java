package br.gov.mt.pjc.srv.publico.mapper.impl;

import br.gov.mt.pjc.srv.publico.dto.PessoaRequest;
import br.gov.mt.pjc.srv.publico.dto.PessoaResponse;
import br.gov.mt.pjc.srv.publico.entity.Pessoa;
import br.gov.mt.pjc.srv.publico.mapper.IBaseMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PessoaMapperImpl implements IBaseMapper<Pessoa, PessoaRequest, PessoaResponse> {

    private final ModelMapper mapper;

    @Override
    public Pessoa toEntity(PessoaRequest request) {
        return mapper.map(request, Pessoa.class);
    }

    @Override
    public PessoaResponse toResponse(Pessoa entity) {
        return mapper.map(entity, PessoaResponse.class);
    }

    @Override
    public List<PessoaResponse> toList(List<Pessoa> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public Pessoa toConvert(PessoaResponse response) {
        return mapper.map(response, Pessoa.class);
    }

}
