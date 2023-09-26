package br.gov.mt.pjc.srv.publico.controller;

import br.gov.mt.pjc.srv.publico.dto.request.ServidorEfetivoRequest;
import br.gov.mt.pjc.srv.publico.dto.response.ServidorEfetivoResponse;
import br.gov.mt.pjc.srv.publico.service.IBaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/servidores-efetivos")
public class ServidorEfetivoController {

    private final IBaseService<ServidorEfetivoRequest, ServidorEfetivoResponse> servidorEfetivoService;

    @GetMapping
    public ResponseEntity<List<ServidorEfetivoResponse>> listar() {
        List<ServidorEfetivoResponse> servidoresEfetivos = servidorEfetivoService.listarTodos();
        return ResponseEntity.ok().body(servidoresEfetivos);
    }

    @GetMapping("/{idServidorEfetivo}")
    public ResponseEntity<ServidorEfetivoResponse> buscar(@PathVariable Integer idServidorEfetivo) {
        ServidorEfetivoResponse pessoaResponse = servidorEfetivoService.buscarPorId(idServidorEfetivo);
        return ResponseEntity.ok().body(pessoaResponse);
    }

    @PostMapping
    public ResponseEntity<ServidorEfetivoResponse> cadastrar(@Valid @RequestBody ServidorEfetivoRequest request) {
        ServidorEfetivoResponse servidorEfetivoResponse = servidorEfetivoService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(servidorEfetivoResponse);
    }

    @PutMapping("/{idServidorEfetivo}")
    public ResponseEntity<ServidorEfetivoResponse> editar(@PathVariable Integer idServidorEfetivo, @Valid @RequestBody ServidorEfetivoRequest request) {
        ServidorEfetivoResponse servidorEfetivoResponse = servidorEfetivoService.editar(idServidorEfetivo, request);
        return ResponseEntity.ok().body(servidorEfetivoResponse);
    }

    @DeleteMapping("/{idServidorEfetivo}")
    public ResponseEntity<Void> excluir(@PathVariable Integer idServidorEfetivo) {
        servidorEfetivoService.excluir(idServidorEfetivo);
        return ResponseEntity.noContent().build();
    }

}
