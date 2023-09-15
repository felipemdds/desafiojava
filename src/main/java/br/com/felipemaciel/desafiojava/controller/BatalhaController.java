package br.com.felipemaciel.desafiojava.controller;

import br.com.felipemaciel.desafiojava.entity.Batalha;
import br.com.felipemaciel.desafiojava.request.AtaqueRequest;
import br.com.felipemaciel.desafiojava.request.BatalhaRequest;
import br.com.felipemaciel.desafiojava.response.AtaqueResponse;
import br.com.felipemaciel.desafiojava.service.BatalhaService;
import br.com.felipemaciel.desafiojava.service.impl.BatalhaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BatalhaController {

    @Autowired
    private BatalhaServiceImpl batalhaService;

    @GetMapping("/batalhas")
    public List<Batalha> getBatalhas() {
        return batalhaService.getBatalhas();
    }

    @GetMapping("/batalhas/{id}")
    public Batalha getBatalhaById(@PathVariable Long id) {
        return batalhaService.getBatalhaById(id);
    }

    @PostMapping("/batalhas")
    public Batalha createBatalha(@RequestBody BatalhaRequest batalha) {
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

    @PostMapping("/batalhas/ataque")
    public AtaqueResponse ataque (@RequestBody AtaqueRequest ataqueRequest){
        return batalhaService.ataque(ataqueRequest.getIdJogo(), ataqueRequest.getIdAtacante(), ataqueRequest.getIdOponente(), ataqueRequest.getDado());
    }

    @PostMapping("/batalhas/calcula_ataque")
    public Integer calculaAtaque (@RequestBody AtaqueRequest ataqueRequest){
        return batalhaService.calculaDefesa(ataqueRequest.getIdOponente(), ataqueRequest.getDado());
    }
    @PostMapping("/batalhas/calcula_defesa")
    public Integer calculaDefesa (@RequestBody AtaqueRequest ataqueRequest){
        return batalhaService.calculaDefesa(ataqueRequest.getIdOponente(), ataqueRequest.getDado());
    }
}
