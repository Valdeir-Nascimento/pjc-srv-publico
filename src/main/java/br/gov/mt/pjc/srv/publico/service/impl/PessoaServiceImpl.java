package br.gov.mt.pjc.srv.publico.service.impl;

import br.gov.mt.pjc.srv.publico.dto.PessoaRequest;
import br.gov.mt.pjc.srv.publico.dto.PessoaResponse;
import br.gov.mt.pjc.srv.publico.entity.Pessoa;
import br.gov.mt.pjc.srv.publico.mapper.IResponseMapper;
import br.gov.mt.pjc.srv.publico.repository.PessoaRepository;
import br.gov.mt.pjc.srv.publico.service.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements IBaseService<Pessoa, PessoaRequest, PessoaResponse> {

    private final PessoaRepository pessoaRepository;
    private final IResponseMapper<Pessoa, PessoaResponse> responseMapper;

    @Override
    public List<PessoaResponse> listarTodos() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoas.stream().map(responseMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PessoaResponse encontrarPorId(Long id) {
        return null;
    }

    @Override
    public PessoaResponse criar(PessoaRequest request) {
        return null;
    }

    @Override
    public PessoaResponse atualizar(Long id, PessoaRequest request) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }

}
