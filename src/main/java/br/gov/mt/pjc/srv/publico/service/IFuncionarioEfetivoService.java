package br.gov.mt.pjc.srv.publico.service;

import br.gov.mt.pjc.srv.publico.dto.response.FuncionarioEfetivoResponse;

import java.util.List;

public interface IFuncionarioEfetivoService {

    List<FuncionarioEfetivoResponse> consultar(Integer idUnidade);

}
