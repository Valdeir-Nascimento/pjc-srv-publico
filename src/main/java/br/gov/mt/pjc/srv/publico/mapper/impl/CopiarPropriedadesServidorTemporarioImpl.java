package br.gov.mt.pjc.srv.publico.mapper.impl;

import br.gov.mt.pjc.srv.publico.dto.request.ServidorEfetivoRequest;
import br.gov.mt.pjc.srv.publico.dto.request.ServidorTemporarioRequest;
import br.gov.mt.pjc.srv.publico.entity.ServidorEfetivo;
import br.gov.mt.pjc.srv.publico.entity.ServidorTemporario;
import br.gov.mt.pjc.srv.publico.mapper.ICopiaPropriedades;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CopiarPropriedadesServidorTemporarioImpl implements ICopiaPropriedades<ServidorTemporario, ServidorTemporarioRequest> {

    private final ModelMapper mapper;

    @Override
    public void copiar(ServidorTemporarioRequest source, ServidorTemporario entity) {
        mapper.map(source, entity);
    }
}
