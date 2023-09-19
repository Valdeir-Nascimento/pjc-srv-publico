package br.gov.mt.pjc.srv.publico.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServidorEfetivoRequest {

    @NotBlank
    private String matricula;
    @Valid
    private BaseRequest pessoa;

}
