package br.com.felipemaciel.desafiojava.controller;

import br.com.felipemaciel.desafiojava.entity.Batalha;
import br.com.felipemaciel.desafiojava.service.BatalhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BatalhaController {

    @Autowired
    private BatalhaService batalhaService;

    @GetMapping("/batalhas")
    public List<Batalha> getBatalhas() {
        return batalhaService.getBatalhas();
    }

    @GetMapping("/batalhas/{id}")
    public Batalha getBatalhaById(@PathVariable Long id) {
        return batalhaService.getBatalhaById(id);
    }

    @PostMapping("/batalhas")
    public Batalha createBatalha(@RequestBody Batalha batalha) {
        return batalhaService.createBatalha(batalha);
    }

    @PutMapping("/batalhas/{id}")
    public Batalha updateBatalha(@PathVariable Long id, @RequestBody Batalha batalha) {
        return batalhaService.updateBatalha(id, batalha);
    }

    @DeleteMapping("/batalhas/{id}")
    public void deleteBatalha(@PathVariable Long id) {
        batalhaService.deleteBatalha(id);
    }
}
