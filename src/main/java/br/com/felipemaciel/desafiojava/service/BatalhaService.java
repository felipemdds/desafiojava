package br.com.felipemaciel.desafiojava.service;

import br.com.felipemaciel.desafiojava.entity.Batalha;
import br.com.felipemaciel.desafiojava.entity.Jogo;
import br.com.felipemaciel.desafiojava.request.BatalhaRequest;
import br.com.felipemaciel.desafiojava.response.AtaqueResponse;

import java.util.List;

public interface BatalhaService {

    public List<Batalha> getBatalhas();

    public Batalha getBatalhaById(Long id);

    public Batalha createBatalha(BatalhaRequest batalha);

    public Batalha updateBatalha(Long id, Batalha batalha);

    public void deleteBatalha(Long id);

    public AtaqueResponse ataque (Long idJogo, Long idAtacante, Long idOponente, Integer dano);

    public Integer calculaAtaque (Long idPersonagem, Integer dado);
    public Integer calculaDefesa (Long idPersonagem, Integer dado);
}
