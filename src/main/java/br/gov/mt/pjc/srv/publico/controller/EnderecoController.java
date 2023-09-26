package br.gov.mt.pjc.srv.publico.controller;

import br.gov.mt.pjc.srv.publico.dto.response.EnderecoResponse;
import br.gov.mt.pjc.srv.publico.service.IEnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/enderecos")
public class EnderecoController {

    private final IEnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoResponse>> buscarEndereco(@RequestParam String nome) {
        List<EnderecoResponse> enderecos = enderecoService.buscarEndereco(nome);
        return ResponseEntity.ok().body(enderecos);
    }

}
