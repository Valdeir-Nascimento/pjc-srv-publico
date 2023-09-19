package br.gov.mt.pjc.srv.publico.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PessoaResponse {

    private String id;
    private String nome;
    private String dataNascimento;
    private String sexo;
    private String mae;
    private String pai;

}
