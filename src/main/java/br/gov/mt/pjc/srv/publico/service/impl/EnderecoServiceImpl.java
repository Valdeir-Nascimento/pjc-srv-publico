package br.gov.mt.pjc.srv.publico.service.impl;

import br.gov.mt.pjc.srv.publico.dto.response.EnderecoResponse;
import br.gov.mt.pjc.srv.publico.repository.IEnderecoRepository;
import br.gov.mt.pjc.srv.publico.service.IEnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements IEnderecoService {

    private final IEnderecoRepository enderecoRepository;

    @Override
    public List<EnderecoResponse> buscarEndereco(String nome) {
        return enderecoRepository.buscarEndereco(nome);
    }

}
