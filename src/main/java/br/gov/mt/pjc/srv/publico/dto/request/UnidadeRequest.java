package br.gov.mt.pjc.srv.publico.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UnidadeRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String sigla;

}
