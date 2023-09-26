package br.gov.mt.pjc.srv.publico.service.impl;

import br.gov.mt.pjc.srv.publico.dto.request.LotacaoRequest;
import br.gov.mt.pjc.srv.publico.dto.response.LotacaoResponse;
import br.gov.mt.pjc.srv.publico.entity.Lotacao;
import br.gov.mt.pjc.srv.publico.exception.LotacaoNaoEncontradaException;
import br.gov.mt.pjc.srv.publico.mapper.IBaseMapper;
import br.gov.mt.pjc.srv.publico.mapper.ICopiaPropriedades;
import br.gov.mt.pjc.srv.publico.repository.ILotacaoRepository;
import br.gov.mt.pjc.srv.publico.service.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LotacaoServiceImpl implements IBaseService<LotacaoRequest, LotacaoResponse> {

    private final ILotacaoRepository lotacaoRepository;
    private final IBaseMapper<Lotacao, LotacaoRequest, LotacaoResponse> baseMapper;
    private final ICopiaPropriedades<Lotacao, LotacaoRequest> copiaPropriedades;

    @Override
    public List<LotacaoResponse> listarTodos() {
        List<Lotacao> lotacoes = lotacaoRepository.findAll();
        return lotacoes.stream().map(baseMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public LotacaoResponse buscarPorId(Integer id) {
        Lotacao lotacao = lotacaoRepository.findById(id)
                .orElseThrow(() -> new LotacaoNaoEncontradaException(id));
        return baseMapper.toResponse(lotacao);
    }

    @Override
    public LotacaoResponse cadastrar(LotacaoRequest request) {
        Lotacao lotacao = baseMapper.toEntity(request);
        lotacao = lotacaoRepository.save(lotacao);
        return baseMapper.toResponse(lotacao);
    }

    @Override
    public LotacaoResponse editar(Integer id, LotacaoRequest request) {
        LotacaoResponse lotacaoResponse = buscarPorId(id);
        Lotacao lotacao = baseMapper.toConvert(lotacaoResponse);
        copiaPropriedades.copiar(request, lotacao);
        lotacao = lotacaoRepository.save(lotacao);
        return baseMapper.toResponse(lotacao);
    }

    @Override
    public void excluir(Integer id) {
        try {
            lotacaoRepository.deleteById(id);
            lotacaoRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new LotacaoNaoEncontradaException(id);
        }
    }
}
