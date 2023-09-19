package br.gov.mt.pjc.srv.publico.exception;

public class UnidadeNaoEncontradaException extends RuntimeException {

    public UnidadeNaoEncontradaException(Integer id) {
        super(String.format("Não foi encontrado cadastro de unidade com Id: %d", id));
    }

}
