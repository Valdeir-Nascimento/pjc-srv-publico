package br.gov.mt.pjc.srv.publico.mapper.impl;

import br.gov.mt.pjc.srv.publico.dto.request.ServidorTemporarioRequest;
import br.gov.mt.pjc.srv.publico.dto.response.ServidorTemporarioResponse;
import br.gov.mt.pjc.srv.publico.entity.ServidorTemporario;
import br.gov.mt.pjc.srv.publico.mapper.IBaseMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ServidorTemporarioMapperImpl implements IBaseMapper<ServidorTemporario, ServidorTemporarioRequest, ServidorTemporarioResponse> {

    private final ModelMapper mapper;

    @Override
    public ServidorTemporario toEntity(ServidorTemporarioRequest request) {
        return mapper.map(request, ServidorTemporario.class);
    }

    @Override
    public ServidorTemporarioResponse toResponse(ServidorTemporario entity) {
        return mapper.map(entity, ServidorTemporarioResponse.class);
    }

    @Override
    public List<ServidorTemporarioResponse> toList(List<ServidorTemporario> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public ServidorTemporario toConvert(ServidorTemporarioResponse response) {
        return mapper.map(response, ServidorTemporario.class);
    }
}
