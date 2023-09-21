package br.gov.mt.pjc.srv.publico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class PessoaRequest {

    @NotBlank
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @NotBlank
    private String sexo;
    @NotBlank
    private String mae;
    @NotBlank
    private String pai;

}
