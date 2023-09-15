package br.com.felipemaciel.desafiojava.controller;

import br.com.felipemaciel.desafiojava.request.PessoaRequest;
import br.com.felipemaciel.desafiojava.entity.Pessoa;
import br.com.felipemaciel.desafiojava.service.PessoaService;
import br.com.felipemaciel.desafiojava.service.impl.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaServiceImpl pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(pessoaService.criarPessoa(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> lerPessoa(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.lerPessoa(id));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> lerPessoaPorNome(@RequestBody PessoaRequest pessoa) {
        return ResponseEntity.ok(pessoaService.lerPessoaPorNome(pessoa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(pessoaService.atualizarPessoa(id, pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPessoa(@PathVariable Long id) {
        pessoaService.excluirPessoa(id);
        return ResponseEntity.noContent().build();
    }
}
