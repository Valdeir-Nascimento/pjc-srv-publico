package br.gov.mt.pjc.srv.publico.dto.request;

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
