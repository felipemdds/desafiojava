package br.com.felipemaciel.desafiojava.service;

import br.com.felipemaciel.desafiojava.entity.Batalha;
import br.com.felipemaciel.desafiojava.entity.Jogo;

import java.util.List;

public interface BatalhaService {

    public List<Batalha> getBatalhas();

    public Batalha getBatalhaById(Long id);

    public Batalha createBatalha(Batalha batalha);

    public Batalha updateBatalha(Long id, Batalha batalha);

    public void deleteBatalha(Long id);
}
