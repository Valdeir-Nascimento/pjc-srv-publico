package br.gov.mt.pjc.srv.publico.service.impl;

import br.gov.mt.pjc.srv.publico.dto.request.ServidorTemporarioRequest;
import br.gov.mt.pjc.srv.publico.dto.response.ServidorTemporarioResponse;
import br.gov.mt.pjc.srv.publico.entity.ServidorTemporario;
import br.gov.mt.pjc.srv.publico.exception.ServidorTemporarioNaoEncontradoException;
import br.gov.mt.pjc.srv.publico.mapper.IBaseMapper;
import br.gov.mt.pjc.srv.publico.mapper.ICopiaPropriedades;
import br.gov.mt.pjc.srv.publico.repository.IServidorTemporarioRepository;
import br.gov.mt.pjc.srv.publico.service.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServidorTemporarioImpl implements IBaseService<ServidorTemporarioRequest, ServidorTemporarioResponse> {

    private final IServidorTemporarioRepository servidorTemporarioRepository;
    private final IBaseMapper<ServidorTemporario, ServidorTemporarioRequest, ServidorTemporarioResponse> baseMapper;
    private final ICopiaPropriedades<ServidorTemporario, ServidorTemporarioRequest> copiaPropriedades;

    @Override
    public List<ServidorTemporarioResponse> listarTodos() {
        List<ServidorTemporario> servidoresTemporarios = servidorTemporarioRepository.findAll();
        return servidoresTemporarios.stream().map(baseMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ServidorTemporarioResponse buscarPorId(Integer id) {
        ServidorTemporario servidorTemporario = servidorTemporarioRepository.findById(id)
                .orElseThrow(() -> new ServidorTemporarioNaoEncontradoException(id));
        return baseMapper.toResponse(servidorTemporario);
    }

    @Override
    public ServidorTemporarioResponse cadastrar(ServidorTemporarioRequest request) {
        ServidorTemporario servidorTemporario = baseMapper.toEntity(request);
        servidorTemporario = servidorTemporarioRepository.save(servidorTemporario);
        return baseMapper.toResponse(servidorTemporario);
    }

    @Override
    public ServidorTemporarioResponse editar(Integer id, ServidorTemporarioRequest request) {
        ServidorTemporarioResponse servidorTemporarioResponse = buscarPorId(id);
        ServidorTemporario servidorTemporario = baseMapper.toConvert(servidorTemporarioResponse);
        copiaPropriedades.copiar(request, servidorTemporario);
        servidorTemporario = servidorTemporarioRepository.save(servidorTemporario);
        return baseMapper.toResponse(servidorTemporario);
    }

    @Override
    public void excluir(Integer id) {
        try {
            servidorTemporarioRepository.deleteById(id);
            servidorTemporarioRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new ServidorTemporarioNaoEncontradoException(id);
        }
    }
}
