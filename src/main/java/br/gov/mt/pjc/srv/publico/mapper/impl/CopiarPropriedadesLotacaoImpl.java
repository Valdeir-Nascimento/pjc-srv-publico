package br.gov.mt.pjc.srv.publico.mapper.impl;

import br.gov.mt.pjc.srv.publico.dto.request.LotacaoRequest;
import br.gov.mt.pjc.srv.publico.dto.request.ServidorTemporarioRequest;
import br.gov.mt.pjc.srv.publico.entity.Lotacao;
import br.gov.mt.pjc.srv.publico.entity.ServidorTemporario;
import br.gov.mt.pjc.srv.publico.mapper.ICopiaPropriedades;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CopiarPropriedadesLotacaoImpl implements ICopiaPropriedades<Lotacao, LotacaoRequest> {

    private final ModelMapper mapper;

    @Override
    public void copiar(LotacaoRequest source, Lotacao entity) {
        mapper.map(source, entity);
    }
}
