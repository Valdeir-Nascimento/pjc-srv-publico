package br.gov.mt.pjc.srv.publico.mapper.impl;

import br.gov.mt.pjc.srv.publico.dto.request.LotacaoRequest;
import br.gov.mt.pjc.srv.publico.dto.response.LotacaoResponse;
import br.gov.mt.pjc.srv.publico.entity.Lotacao;
import br.gov.mt.pjc.srv.publico.mapper.IBaseMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LotacaoMapperImpl implements IBaseMapper<Lotacao, LotacaoRequest, LotacaoResponse> {

    private final ModelMapper mapper;

    @Override
    public Lotacao toEntity(LotacaoRequest request) {
        return mapper.map(request, Lotacao.class);
    }

    @Override
    public LotacaoResponse toResponse(Lotacao entity) {
        return mapper.map(entity, LotacaoResponse.class);
    }

    @Override
    public List<LotacaoResponse> toList(List<Lotacao> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public Lotacao toConvert(LotacaoResponse response) {
        return mapper.map(response, Lotacao.class);
    }
}
