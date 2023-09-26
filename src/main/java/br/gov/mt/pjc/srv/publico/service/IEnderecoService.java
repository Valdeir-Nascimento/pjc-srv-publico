package br.gov.mt.pjc.srv.publico.service;

import br.gov.mt.pjc.srv.publico.dto.response.EnderecoResponse;

import java.util.List;

public interface IEnderecoService {

    List<EnderecoResponse> buscarEndereco(String nome);

}
