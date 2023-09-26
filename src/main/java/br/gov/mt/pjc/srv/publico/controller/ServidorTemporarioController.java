package br.gov.mt.pjc.srv.publico.controller;

import br.gov.mt.pjc.srv.publico.dto.request.ServidorTemporarioRequest;
import br.gov.mt.pjc.srv.publico.dto.response.ServidorTemporarioResponse;
import br.gov.mt.pjc.srv.publico.service.IBaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/servidores-temporarios")
public class ServidorTemporarioController {

    private final IBaseService<ServidorTemporarioRequest, ServidorTemporarioResponse> servidorTemporarioService;

    @GetMapping
    public ResponseEntity<List<ServidorTemporarioResponse>> listarTodos() {
        List<ServidorTemporarioResponse> servidoresTemporarios = servidorTemporarioService.listarTodos();
        return ResponseEntity.ok().body(servidoresTemporarios);
    }

    @GetMapping("/{idServidorTemporario}")
    public ResponseEntity<ServidorTemporarioResponse> buscarPorId(@PathVariable Integer idServidorTemporario) {
        ServidorTemporarioResponse servidorTemporarioResponse = servidorTemporarioService.buscarPorId(idServidorTemporario);
        return ResponseEntity.ok().body(servidorTemporarioResponse);
    }

    @PostMapping
    public ResponseEntity<ServidorTemporarioResponse> cadastrar(@Valid @RequestBody ServidorTemporarioRequest request) {
        ServidorTemporarioResponse servidorTemporarioResponse = servidorTemporarioService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(servidorTemporarioResponse);
    }

    @PutMapping("/{idServidorTemporario}")
    public ResponseEntity<ServidorTemporarioResponse> editar(@PathVariable Integer idServidorTemporario, @Valid @RequestBody ServidorTemporarioRequest request) {
        ServidorTemporarioResponse servidorTemporarioResponse = servidorTemporarioService.editar(idServidorTemporario, request);
        return ResponseEntity.ok().body(servidorTemporarioResponse);
    }

    @GetMapping("/{idServidorTemporario}")
    public ResponseEntity<Void> excluir(@PathVariable Integer idServidorTemporario) {
        servidorTemporarioService.excluir(idServidorTemporario);
        return ResponseEntity.noContent().build();
    }

}
