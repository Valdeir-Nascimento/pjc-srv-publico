package br.gov.mt.pjc.srv.publico.exception;

public class ServidorTemporarioNaoEncontradoException extends RuntimeException {

    public ServidorTemporarioNaoEncontradoException(Integer id) {
        super(String.format("Não foi encontrado cadastro de servidor temporário com Id: %d", id));
    }

}
