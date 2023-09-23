package br.gov.mt.pjc.srv.publico.repository;

import br.gov.mt.pjc.srv.publico.dto.request.FuncionarioEfetivoResponse;

import java.util.List;

public interface IFuncionarioEfetivoRepository {

    List<FuncionarioEfetivoResponse> getFuncionariosEfetivosPorUnidade(Integer idUnidade);

}
