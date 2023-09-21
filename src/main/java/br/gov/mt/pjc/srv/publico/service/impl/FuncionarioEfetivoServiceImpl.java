package br.gov.mt.pjc.srv.publico.service.impl;

import br.gov.mt.pjc.srv.publico.dto.request.FuncionarioEfetivoResponse;
import br.gov.mt.pjc.srv.publico.repository.IFuncionarioEfetivoRepository;
import br.gov.mt.pjc.srv.publico.service.IFuncionarioEfetivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioEfetivoServiceImpl implements IFuncionarioEfetivoService {

    private final IFuncionarioEfetivoRepository servidorEfetivoRepository;

    @Override
    public List<FuncionarioEfetivoResponse> consultar() {
        return servidorEfetivoRepository.getFuncionariosEfetivos();
    }

}
