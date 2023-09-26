package br.gov.mt.pjc.srv.publico.controller;

import br.gov.mt.pjc.srv.publico.dto.request.UnidadeRequest;
import br.gov.mt.pjc.srv.publico.dto.response.UnidadeResponse;
import br.gov.mt.pjc.srv.publico.service.IBaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/unidades")
public class UnidadeController {
    
    private final IBaseService<UnidadeRequest, UnidadeResponse> unidadeService;

    @GetMapping
    public ResponseEntity<List<UnidadeResponse>> listar() {
        List<UnidadeResponse> pessoas = unidadeService.listarTodos();
        return ResponseEntity.ok().body(pessoas);
    }

    @GetMapping("/{idUnidade}")
    public ResponseEntity<UnidadeResponse> buscar(@PathVariable Integer idUnidade) {
        UnidadeResponse UnidadeResponse = unidadeService.buscarPorId(idUnidade);
        return ResponseEntity.ok().body(UnidadeResponse);
    }

    @PostMapping
    public ResponseEntity<UnidadeResponse> cadastrar(@Valid @RequestBody UnidadeRequest request) {
        UnidadeResponse UnidadeResponse = unidadeService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(UnidadeResponse);
    }

    @PutMapping("/{idUnidade}")
    public ResponseEntity<UnidadeResponse> editar(@PathVariable Integer idUnidade, @Valid @RequestBody UnidadeRequest request) {
        UnidadeResponse UnidadeResponse = unidadeService.editar(idUnidade, request);
        return ResponseEntity.ok().body(UnidadeResponse);
    }

    @DeleteMapping("/{idUnidade}")
    public ResponseEntity<Void> excluir(@PathVariable Integer idUnidade) {
        unidadeService.excluir(idUnidade);
        return ResponseEntity.noContent().build();
    }
    
}
