package br.gov.mt.pjc.srv.publico.exception;

public class ServidorEfetivoNaoEncontradoException extends RuntimeException {

    public ServidorEfetivoNaoEncontradoException(Integer id) {
        super(String.format("Não foi encontrado cadastro de servidor efetivo com Id: %d", id));
    }

}
