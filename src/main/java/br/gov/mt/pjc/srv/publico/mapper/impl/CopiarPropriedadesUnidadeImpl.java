package br.gov.mt.pjc.srv.publico.mapper.impl;

import br.gov.mt.pjc.srv.publico.dto.request.UnidadeRequest;
import br.gov.mt.pjc.srv.publico.entity.Unidade;
import br.gov.mt.pjc.srv.publico.mapper.ICopiaPropriedades;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CopiarPropriedadesUnidadeImpl implements ICopiaPropriedades<Unidade, UnidadeRequest> {

    private final ModelMapper mapper;

    @Override
    public void copiar(UnidadeRequest source, Unidade entity) {
        mapper.map(source, entity);
    }

}
