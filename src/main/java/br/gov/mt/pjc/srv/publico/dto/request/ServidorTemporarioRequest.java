package br.gov.mt.pjc.srv.publico.dto.request;

import br.gov.mt.pjc.srv.publico.dto.BaseDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ServidorTemporarioRequest {

    @NotNull
    private LocalDate dataEmissao;
    private LocalDate dataDemissao;
    private BaseDTO pessoa;

}
