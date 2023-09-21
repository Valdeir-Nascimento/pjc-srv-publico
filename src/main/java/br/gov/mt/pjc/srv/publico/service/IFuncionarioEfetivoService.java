package br.gov.mt.pjc.srv.publico.service;

import br.gov.mt.pjc.srv.publico.dto.request.FuncionarioEfetivoResponse;

import java.util.List;

public interface IFuncionarioEfetivoService {

    List<FuncionarioEfetivoResponse> consultar();

}
