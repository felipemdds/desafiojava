package br.com.felipemaciel.desafiojava.service.impl;

import br.com.felipemaciel.desafiojava.entity.Batalha;
import br.com.felipemaciel.desafiojava.entity.Jogo;
import br.com.felipemaciel.desafiojava.repository.BatalhaRepository;
import br.com.felipemaciel.desafiojava.service.BatalhaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BatalhaServiceImpl implements BatalhaService {

    @Autowired
    private BatalhaRepository batalhaRepository;

    public List<Batalha> getBatalhas() {
        return batalhaRepository.findAll();
    }

    public Batalha getBatalhaById(Long id) {
        return batalhaRepository.findById(id).orElse(null);
    }

    public Batalha createBatalha(Batalha batalha) {
        batalhaRepository.save(batalha);
        return batalha;
    }

    public Batalha updateBatalha(Long id, Batalha batalha) {
        Batalha batalhaAtual = batalhaRepository.findById(id).orElse(null);
        batalhaAtual.setIdAtacante(batalha.getIdAtacante());
        batalhaAtual.setIdDefensor(batalha.getIdDefensor());
        batalhaAtual.setIdJogo(batalha.getIdJogo());
        batalhaRepository.save(batalhaAtual);
        return batalhaAtual;
    }

    public void deleteBatalha(Long id) {
        batalhaRepository.deleteById(id);
    }
}
