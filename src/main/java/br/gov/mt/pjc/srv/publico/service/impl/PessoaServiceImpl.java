package br.gov.mt.pjc.srv.publico.service.impl;

import br.gov.mt.pjc.srv.publico.dto.PessoaRequest;
import br.gov.mt.pjc.srv.publico.dto.PessoaResponse;
import br.gov.mt.pjc.srv.publico.entity.Pessoa;
import br.gov.mt.pjc.srv.publico.exception.PessoaNaoEncontradaException;
import br.gov.mt.pjc.srv.publico.mapper.IBaseMapper;
import br.gov.mt.pjc.srv.publico.mapper.ICopiaPropriedades;
import br.gov.mt.pjc.srv.publico.repository.IPessoaRepository;
import br.gov.mt.pjc.srv.publico.service.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements IBaseService<Pessoa, PessoaRequest, PessoaResponse> {

    private final IPessoaRepository pessoaRepository;
    private final ICopiaPropriedades<Pessoa, PessoaRequest> copiaPropriedadesRequest;
    private final IBaseMapper<Pessoa, PessoaRequest, PessoaResponse> baseMapper;

    @Override
    public List<PessoaResponse> listarTodos() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return baseMapper.toList(pessoas);
    }

    @Override
    public PessoaResponse buscarPorId(Integer id) {
        Pessoa pessoaAtual = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));
        return baseMapper.toResponse(pessoaAtual);
    }

    @Override
    public PessoaResponse criar(PessoaRequest request) {
        Pessoa pessoa = baseMapper.toEntity(request);
        pessoa = pessoaRepository.save(pessoa);
        return baseMapper.toResponse(pessoa);
    }

    @Override
    public PessoaResponse atualizar(Integer id, PessoaRequest request) {
        PessoaResponse pessoaAtual = buscarPorId(id);
        Pessoa entity = baseMapper.toConvert(pessoaAtual);
        copiaPropriedadesRequest.copiar(request, entity);
        entity = pessoaRepository.save(entity);
        return baseMapper.toResponse(entity);
    }

    @Override
    public void excluir(Integer id) {
        try {
            pessoaRepository.deleteById(id);
            pessoaRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new PessoaNaoEncontradaException(id);
        }
    }

}
