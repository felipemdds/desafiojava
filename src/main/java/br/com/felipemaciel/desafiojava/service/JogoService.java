package br.com.felipemaciel.desafiojava.service;

import br.com.felipemaciel.desafiojava.entity.Jogo;

import java.util.List;
import java.util.Optional;

public interface JogoService {

    public List<Jogo> getJogos();

    public Jogo getJogoById(Long id);

    public Jogo createJogo(Jogo jogo);

    public Jogo updateJogo(Long id, Jogo jogo);

    public void deleteJogo(Long id);
}
