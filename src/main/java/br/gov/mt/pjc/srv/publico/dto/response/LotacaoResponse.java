package br.gov.mt.pjc.srv.publico.dto.response;

import br.gov.mt.pjc.srv.publico.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class LotacaoResponse {

    private Integer id;
    private LocalDate dataLotacao;
    private LocalDate dataRemocao;
    private String portaria;
    private BaseDTO pessoa;
    private BaseDTO unidade;

}
