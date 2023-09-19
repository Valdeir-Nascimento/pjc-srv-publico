package br.gov.mt.pjc.srv.publico.mapper.impl;

import br.gov.mt.pjc.srv.publico.dto.request.PessoaRequest;
import br.gov.mt.pjc.srv.publico.entity.Pessoa;
import br.gov.mt.pjc.srv.publico.mapper.ICopiaPropriedades;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CopiarPropriedadesPessoaImpl implements ICopiaPropriedades<Pessoa, PessoaRequest> {

    private final ModelMapper mapper;

    @Override
    public void copiar(PessoaRequest source, Pessoa entity) {
        mapper.map(source, entity);
    }

}
