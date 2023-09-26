package br.gov.mt.pjc.srv.publico.repository;

import br.gov.mt.pjc.srv.publico.dto.response.EnderecoResponse;

import java.util.List;

public interface IEnderecoRepository {

    List<EnderecoResponse> buscarEndereco(String nome);

}
