package br.gov.mt.pjc.srv.publico.repository.validator.impl;

import br.gov.mt.pjc.srv.publico.exception.UnidadeNaoEncontradaException;
import br.gov.mt.pjc.srv.publico.repository.IUnidadeRepository;
import br.gov.mt.pjc.srv.publico.repository.validator.IValidarUnidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ValidarUnidadeRepositoryImpl implements IValidarUnidadeRepository {

    private final IUnidadeRepository unidadeRepository;

    @Override
    public void validar(Integer idUnidade) {
        boolean unidadeEncontrada = unidadeRepository.existsById(idUnidade);
        if (!unidadeEncontrada) {
            throw new UnidadeNaoEncontradaException(idUnidade);
        }
    }

}
