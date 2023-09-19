package br.gov.mt.pjc.srv.publico.mapper.impl;

import br.gov.mt.pjc.srv.publico.dto.request.UnidadeRequest;
import br.gov.mt.pjc.srv.publico.dto.response.UnidadeResponse;
import br.gov.mt.pjc.srv.publico.entity.Unidade;
import br.gov.mt.pjc.srv.publico.mapper.IBaseMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UnidadeMapperImpl implements IBaseMapper<Unidade, UnidadeRequest, UnidadeResponse> {

    private final ModelMapper mapper;

    @Override
    public Unidade toEntity(UnidadeRequest request) {
        return mapper.map(request, Unidade.class);
    }

    @Override
    public UnidadeResponse toResponse(Unidade entity) {
        return mapper.map(entity, UnidadeResponse.class);
    }

    @Override
    public List<UnidadeResponse> toList(List<Unidade> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public Unidade toConvert(UnidadeResponse response) {
        return mapper.map(response, Unidade.class);
    }

}
