package br.gov.mt.pjc.srv.publico.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ServidorTemporarioResponse {

    private Integer id;
    private LocalDate dataEmissao;
    private LocalDate dataDemissao;
    private PessoaResponse pessoa;

}
