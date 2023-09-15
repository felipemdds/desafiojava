package br.com.felipemaciel.desafiojava.controller;

import br.com.felipemaciel.desafiojava.request.AtribuiPersonagemRequest;
import br.com.felipemaciel.desafiojava.entity.Personagem;
import br.com.felipemaciel.desafiojava.service.PersonagemService;
import br.com.felipemaciel.desafiojava.service.impl.PersonagemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonagemController {

    @Autowired
    private PersonagemServiceImpl personagemService;

    @GetMapping("/personagens")
    public List<Personagem> getPersonagens(Long idJogo) {
        return personagemService.getPersonagens(idJogo);
    }

    @GetMapping("/personagens/{id}")
    public Personagem getPersonagemById(@PathVariable Long id) {
        return personagemService.getPersonagemById(id);
    }


    @PostMapping("/personagens")
    public Personagem createPersonagem(@RequestBody Personagem personagem) {
        return personagemService.createPersonagem(personagem);
    }

    @PutMapping("/personagens/{id}")
    public Personagem updatePersonagem(@PathVariable Long id, @RequestBody Personagem personagem) {
        return personagemService.updatePersonagem(id, personagem);
    }

    @DeleteMapping("/personagens/{id}")
    public void deletePersonagem(@PathVariable Long id) {
        personagemService.deletePersonagem(id);
    }

    @PostMapping("/personagens/escolher")
    public Personagem escolherPersonagem(@RequestBody AtribuiPersonagemRequest atribuiPersonagemRequest) {
        return personagemService.pegaPersonagem(atribuiPersonagemRequest);
    }
}
