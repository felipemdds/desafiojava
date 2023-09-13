package br.com.felipemaciel.desafiojava.controller;

import br.com.felipemaciel.desafiojava.entity.Jogo;
import br.com.felipemaciel.desafiojava.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping("/jogos")
    public List<Jogo> getJogos() {
        return jogoService.getJogos();
    }

    @GetMapping("/jogos/{id}")
    public Jogo getJogoById(@PathVariable Long id) {
        return jogoService.getJogoById(id);
    }

    @PostMapping("/jogos")
    public Jogo createJogo(@RequestBody Jogo jogo) {
        return jogoService.createJogo(jogo);
    }

    @PutMapping("/jogos/{id}")
    public Jogo updateJogo(@PathVariable Long id, @RequestBody Jogo jogo) {
        return jogoService.updateJogo(id, jogo);
    }

    @DeleteMapping("/jogos/{id}")
    public void deleteJogo(@PathVariable Long id) {
        jogoService.deleteJogo(id);
    }
}