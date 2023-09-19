package br.gov.mt.pjc.srv.publico.mapper.impl;

import br.gov.mt.pjc.srv.publico.dto.request.ServidorEfetivoRequest;
import br.gov.mt.pjc.srv.publico.dto.response.ServidorEfetivoResponse;
import br.gov.mt.pjc.srv.publico.entity.ServidorEfetivo;
import br.gov.mt.pjc.srv.publico.mapper.IBaseMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ServidorEfetivoMapperImpl implements IBaseMapper<ServidorEfetivo, ServidorEfetivoRequest, ServidorEfetivoResponse> {

    private final ModelMapper mapper;

    @Override
    public ServidorEfetivo toEntity(ServidorEfetivoRequest request) {
        return mapper.map(request, ServidorEfetivo.class);
    }

    @Override
    public ServidorEfetivoResponse toResponse(ServidorEfetivo entity) {
        return mapper.map(entity, ServidorEfetivoResponse.class);
    }

    @Override
    public List<ServidorEfetivoResponse> toList(List<ServidorEfetivo> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public ServidorEfetivo toConvert(ServidorEfetivoResponse response) {
        return mapper.map(response, ServidorEfetivo.class);
    }
}
