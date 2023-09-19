package br.gov.mt.pjc.srv.publico.mapper.impl;

import br.gov.mt.pjc.srv.publico.dto.request.ServidorEfetivoRequest;
import br.gov.mt.pjc.srv.publico.entity.ServidorEfetivo;
import br.gov.mt.pjc.srv.publico.mapper.ICopiaPropriedades;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CopiarPropriedadesServidorEfetivoImpl implements ICopiaPropriedades<ServidorEfetivo, ServidorEfetivoRequest> {

    private final ModelMapper mapper;
    @Override
    public void copiar(ServidorEfetivoRequest source, ServidorEfetivo entity) {
        mapper.map(source, entity);
    }
}
