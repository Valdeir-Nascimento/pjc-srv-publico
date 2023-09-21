package br.gov.mt.pjc.srv.publico.controller;

import br.gov.mt.pjc.srv.publico.dto.request.FuncionarioEfetivoResponse;
import br.gov.mt.pjc.srv.publico.service.IFuncionarioEfetivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/funcionarios-efetivos")
public class FuncionarioEfetivoController {

    private final IFuncionarioEfetivoService funcionarioEfetivoService;

    @GetMapping
    public ResponseEntity<List<FuncionarioEfetivoResponse>> consultarFuncionariosEfetivos() {
        List<FuncionarioEfetivoResponse> funcionarios = funcionarioEfetivoService.consultar();
        return ResponseEntity.ok().body(funcionarios);
    }

}
