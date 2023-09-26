package br.gov.mt.pjc.srv.publico.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioEfetivoResponse {

    private String nome;
    private Integer idade;
    private String unidadeLotacao;
    private String fotografia;

}
