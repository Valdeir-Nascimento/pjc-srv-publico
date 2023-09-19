package br.gov.mt.pjc.srv.publico.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServidorEfetivoResponse {

    private Integer id;
    private String matricula;
    private PessoaResponse pessoa;

}
