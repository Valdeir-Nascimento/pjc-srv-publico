package br.gov.mt.pjc.srv.publico.exception;

public class LotacaoNaoEncontradaException extends RuntimeException {

    public LotacaoNaoEncontradaException(Integer id) {
        super(String.format("Não foi encontrado cadastro de lotação com Id: %d", id));
    }

}
