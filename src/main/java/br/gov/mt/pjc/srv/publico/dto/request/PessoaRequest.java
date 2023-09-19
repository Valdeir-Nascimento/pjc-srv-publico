package br.gov.mt.pjc.srv.publico.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PessoaRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String dataNascimento;
    @NotBlank
    private String sexo;
    @NotBlank
    private String mae;
    @NotBlank
    private String pai;

}
