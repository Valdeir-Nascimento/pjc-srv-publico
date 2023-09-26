package br.gov.mt.pjc.srv.publico.service.impl;

import br.gov.mt.pjc.srv.publico.dto.request.UnidadeRequest;
import br.gov.mt.pjc.srv.publico.dto.response.UnidadeResponse;
import br.gov.mt.pjc.srv.publico.entity.Unidade;
import br.gov.mt.pjc.srv.publico.exception.UnidadeNaoEncontradaException;
import br.gov.mt.pjc.srv.publico.mapper.IBaseMapper;
import br.gov.mt.pjc.srv.publico.mapper.ICopiaPropriedades;
import br.gov.mt.pjc.srv.publico.repository.IUnidadeRepository;
import br.gov.mt.pjc.srv.publico.service.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnidadeServiceImpl implements IBaseService<UnidadeRequest, UnidadeResponse> {

    private final IUnidadeRepository unidadeRepository;
    private final ICopiaPropriedades<Unidade, UnidadeRequest> copiaPropriedades;
    private final IBaseMapper<Unidade, UnidadeRequest, UnidadeResponse> baseMapper;

    @Override
    public List<UnidadeResponse> listarTodos() {
        List<Unidade> unidades = unidadeRepository.findAll();
        return baseMapper.toList(unidades);
    }

    @Override
    public UnidadeResponse buscarPorId(Integer id) {
        Unidade unidade = unidadeRepository.findById(id)
                .orElseThrow(() -> new UnidadeNaoEncontradaException(id));
        return baseMapper.toResponse(unidade);
    }

    @Override
    public UnidadeResponse cadastrar(UnidadeRequest request) {
        Unidade unidade = baseMapper.toEntity(request);
        unidade = unidadeRepository.save(unidade);
        return baseMapper.toResponse(unidade);
    }

    @Override
    public UnidadeResponse editar(Integer id, UnidadeRequest request) {
        UnidadeResponse unidadeResponse = buscarPorId(id);
        Unidade unidade = baseMapper.toConvert(unidadeResponse);
        copiaPropriedades.copiar(request, unidade);
        unidade = unidadeRepository.save(unidade);
        return baseMapper.toResponse(unidade);
    }

    @Override
    public void excluir(Integer id) {
        try {
            unidadeRepository.deleteById(id);
            unidadeRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new UnidadeNaoEncontradaException(id);
        }
    }
}
