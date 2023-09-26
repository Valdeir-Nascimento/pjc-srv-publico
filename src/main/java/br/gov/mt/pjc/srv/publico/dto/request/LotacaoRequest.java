package br.gov.mt.pjc.srv.publico.dto.request;

import br.gov.mt.pjc.srv.publico.dto.BaseDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LotacaoRequest {

    @NotNull
    private LocalDate dataLotacao;

    @Valid
    private BaseDTO pessoa;

    @Valid
    private BaseDTO unidade;

    @NotBlank
    private String portaria;

    private LocalDate dataRemocao;

}
