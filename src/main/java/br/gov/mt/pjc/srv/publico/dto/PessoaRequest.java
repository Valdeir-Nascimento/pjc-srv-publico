package br.gov.mt.pjc.srv.publico.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PessoaRequest {

    private String nome;
    private String dataNascimento;
    private String sexo;
    private String mae;
    private String pai;

}
