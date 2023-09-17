package br.gov.mt.pjc.srv.publico.exception;

public class PessoaNaoEncontradaException extends RuntimeException {

    public PessoaNaoEncontradaException(Integer id) {
        super(String.format("Não foi encontrado cadastro de pessoa com Id: %d", id));
    }

}
