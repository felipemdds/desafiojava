package br.com.felipemaciel.desafiojava.service;

import br.com.felipemaciel.desafiojava.entity.Personagem;

import java.util.List;

public interface PersonagemService {

    public List<Personagem> getPersonagens();

    public Personagem getPersonagemById(Long id);

    public Personagem createPersonagem(Personagem personagem);

    public Personagem updatePersonagem(Long id, Personagem personagem);

    public void deletePersonagem(Long id);
}
