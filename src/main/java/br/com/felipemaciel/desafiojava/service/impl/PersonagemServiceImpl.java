package br.com.felipemaciel.desafiojava.service.impl;

import br.com.felipemaciel.desafiojava.entity.Personagem;
import br.com.felipemaciel.desafiojava.repository.PersonagemRepository;
import br.com.felipemaciel.desafiojava.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemServiceImpl implements PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public List<Personagem> getPersonagens() {
        return personagemRepository.findAll();
    }

    public Personagem getPersonagemById(Long id) {
        return personagemRepository.findById(id).orElse(null);
    }

    public Personagem createPersonagem(Personagem personagem) {
        personagemRepository.save(personagem);
        return personagem;
    }

    public Personagem updatePersonagem(Long id, Personagem personagem) {
        Personagem personagemAtual = personagemRepository.findById(id).orElseThrow(null);
        personagemAtual.setVida(personagem.getVida());
        personagemAtual.setForça(personagem.getForça());
        personagemAtual.setDefesa(personagem.getDefesa());
        personagemAtual.setAgilidade(personagem.getAgilidade());
        personagemAtual.setQuantidadeDeDados(personagem.getQuantidadeDeDados());
        personagemAtual.setFacesDoDado(personagem.getFacesDoDado());
        personagemRepository.save(personagemAtual);
        return personagemAtual;
    }

    public void deletePersonagem(Long id) {
        personagemRepository.deleteById(id);
    }


}
