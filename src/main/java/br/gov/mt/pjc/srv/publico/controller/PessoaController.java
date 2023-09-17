package br.gov.mt.pjc.srv.publico.controller;

import br.gov.mt.pjc.srv.publico.dto.PessoaRequest;
import br.gov.mt.pjc.srv.publico.dto.PessoaResponse;
import br.gov.mt.pjc.srv.publico.entity.Pessoa;
import br.gov.mt.pjc.srv.publico.service.IBaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/pessoas")
public class PessoaController {

    private final IBaseService<Pessoa, PessoaRequest, PessoaResponse> pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> listar() {
        List<PessoaResponse> pessoas = pessoaService.listarTodos();
        return ResponseEntity.ok().body(pessoas);
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<PessoaResponse> buscar(@PathVariable Integer idPessoa) {
        PessoaResponse pessoaResponse = pessoaService.buscarPorId(idPessoa);
        return ResponseEntity.ok().body(pessoaResponse);
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> cadastrar(@Valid @RequestBody PessoaRequest request) {
        PessoaResponse pessoaResponse = pessoaService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaResponse);
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaResponse> editar(@PathVariable Integer idPessoa, @Valid @RequestBody PessoaRequest request) {
        PessoaResponse pessoaResponse = pessoaService.editar(idPessoa, request);
        return ResponseEntity.ok().body(pessoaResponse);
    }

}
