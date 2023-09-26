package br.gov.mt.pjc.srv.publico.controller;

import br.gov.mt.pjc.srv.publico.dto.request.LotacaoRequest;
import br.gov.mt.pjc.srv.publico.dto.response.LotacaoResponse;
import br.gov.mt.pjc.srv.publico.service.IBaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/lotacoes")
public class LotacaoController {

    private final IBaseService<LotacaoRequest, LotacaoResponse> lotacaoService;

    @GetMapping
    public ResponseEntity<List<LotacaoResponse>> listarTodos() {
        List<LotacaoResponse> lotacoes = lotacaoService.listarTodos();
        return ResponseEntity.ok().body(lotacoes);
    }

    @GetMapping("/{idLotacao}")
    public ResponseEntity<LotacaoResponse> buscarPorId(@PathVariable Integer idLotacao) {
        LotacaoResponse lotacaoResponse = lotacaoService.buscarPorId(idLotacao);
        return ResponseEntity.ok().body(lotacaoResponse);
    }

    @PostMapping
    public ResponseEntity<LotacaoResponse> cadastrar(@Valid @RequestBody LotacaoRequest request) {
        LotacaoResponse lotacaoResponse = lotacaoService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(lotacaoResponse);
    }

    @PutMapping("/{idLotacao}")
    public ResponseEntity<LotacaoResponse> editar(@PathVariable Integer idLotacao, @Valid @RequestBody LotacaoRequest request) {
        LotacaoResponse lotacaoResponse = lotacaoService.editar(idLotacao, request);
        return ResponseEntity.ok().body(lotacaoResponse);
    }

    @DeleteMapping("/{idLotacao}")
    public ResponseEntity<Void> excluir(@PathVariable Integer idLotacao) {
        lotacaoService.excluir(idLotacao);
        return ResponseEntity.noContent().build();
    }
}
