package br.com.felipemaciel.desafiojava.service;

import br.com.felipemaciel.desafiojava.request.AtribuiPersonagemRequest;
import br.com.felipemaciel.desafiojava.entity.Personagem;

import java.util.List;

public interface PersonagemService {

    public List<Personagem> getPersonagens(Long idJogo);

    public List<Personagem> getPersonagensVivos(Long idJogo);

    public Personagem getPersonagemById(Long id);

    public Personagem createPersonagem(Personagem personagem);

    public Personagem updatePersonagem(Long id, Personagem personagem);

    public void deletePersonagem(Long id);

    public List<Personagem> getPersonagemByNomeAndIdJogo(String nome, Long idJogo);

    public void criaEquipes(Long idJogo);

    public Personagem pegaPersonagem(AtribuiPersonagemRequest atribuiPersonagemRequest);

    public List<Personagem> getPersonagensByClasseAndIdJogo(String classe, Long idJogo);

    public Personagem subtraiPV(Long idJogo, Long idPersonagem, Integer dano);
}
