package br.gov.mt.pjc.srv.publico.service.impl;

import br.gov.mt.pjc.srv.publico.dto.request.ServidorEfetivoRequest;
import br.gov.mt.pjc.srv.publico.dto.response.ServidorEfetivoResponse;
import br.gov.mt.pjc.srv.publico.entity.ServidorEfetivo;
import br.gov.mt.pjc.srv.publico.exception.ServidorEfetivoNaoEncontradoException;
import br.gov.mt.pjc.srv.publico.mapper.IBaseMapper;
import br.gov.mt.pjc.srv.publico.mapper.ICopiaPropriedades;
import br.gov.mt.pjc.srv.publico.repository.IServidorEfetivoRepository;
import br.gov.mt.pjc.srv.publico.service.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServidorEfetivoServiceImpl implements IBaseService<ServidorEfetivo, ServidorEfetivoRequest, ServidorEfetivoResponse> {

    private final IServidorEfetivoRepository servidorEfetivoRepository;
    private final ICopiaPropriedades<ServidorEfetivo, ServidorEfetivoRequest> copiaPropriedades;
    private final IBaseMapper<ServidorEfetivo, ServidorEfetivoRequest, ServidorEfetivoResponse> baseMapper;


    @Override
    public List<ServidorEfetivoResponse> listarTodos() {
        List<ServidorEfetivo> servidoresEfetivos = servidorEfetivoRepository.findAll();
        return baseMapper.toList(servidoresEfetivos);
    }

    @Override
    public ServidorEfetivoResponse buscarPorId(Integer id) {
        ServidorEfetivo servidorEfetivoAtual = servidorEfetivoRepository.findById(id)
                .orElseThrow(() -> new ServidorEfetivoNaoEncontradoException(id));
        return baseMapper.toResponse(servidorEfetivoAtual);
    }

    @Override
    public ServidorEfetivoResponse criar(ServidorEfetivoRequest request) {
        ServidorEfetivo servidorEfetivo = baseMapper.toEntity(request);
        servidorEfetivo = servidorEfetivoRepository.save(servidorEfetivo);
        return baseMapper.toResponse(servidorEfetivo);
    }

    @Override
    public ServidorEfetivoResponse editar(Integer id, ServidorEfetivoRequest request) {
        ServidorEfetivoResponse servidorEfetivoResponse = buscarPorId(id);
        ServidorEfetivo servidorEfetivo = baseMapper.toConvert(servidorEfetivoResponse);
        copiaPropriedades.copiar(request, servidorEfetivo);
        servidorEfetivo = servidorEfetivoRepository.save(servidorEfetivo);
        return baseMapper.toResponse(servidorEfetivo);
    }

    @Override
    public void excluir(Integer id) {
        try {
            servidorEfetivoRepository.deleteById(id);
            servidorEfetivoRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new ServidorEfetivoNaoEncontradoException(id);
        }
    }

}
