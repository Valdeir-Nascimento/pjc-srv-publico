package br.gov.mt.pjc.srv.publico.controller;

import br.gov.mt.pjc.srv.publico.dto.request.ServidorEfetivoRequest;
import br.gov.mt.pjc.srv.publico.dto.response.ServidorEfetivoResponse;
import br.gov.mt.pjc.srv.publico.entity.ServidorEfetivo;
import br.gov.mt.pjc.srv.publico.service.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/servidores-efetivos")
public class ServidorEfetivoController {

    private final IBaseService<ServidorEfetivo, ServidorEfetivoRequest, ServidorEfetivoResponse> servidorEfetivoService;

    @GetMapping
    public ResponseEntity<List<ServidorEfetivoResponse>> listar() {
        List<ServidorEfetivoResponse> servidoresEfetivos = servidorEfetivoService.listarTodos();
        return ResponseEntity.ok().body(servidoresEfetivos);
    }

}
