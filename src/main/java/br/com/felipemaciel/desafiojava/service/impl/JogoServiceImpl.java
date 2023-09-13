package br.com.felipemaciel.desafiojava.service.impl;

import br.com.felipemaciel.desafiojava.entity.Jogo;
import br.com.felipemaciel.desafiojava.repository.JogoRepository;
import br.com.felipemaciel.desafiojava.service.JogoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JogoServiceImpl implements JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public List<Jogo> getJogos() {
        return jogoRepository.findAll();
    }

    public Jogo getJogoById(Long id) {
        return jogoRepository.findById(id).orElse(null);
    }

    public Jogo createJogo(Jogo jogo) {
        jogoRepository.save(jogo);
        return jogo;
    }

    public Jogo updateJogo(Long id, Jogo jogo) {
        Jogo jogoAtual = jogoRepository.findById(id).orElse(null);
        jogoAtual.setDataHora(jogo.getDataHora());
        jogoAtual.setVencedor(jogo.getVencedor());
        jogoRepository.save(jogoAtual);
        return jogoAtual;
    }

    public void deleteJogo(Long id) {
        jogoRepository.deleteById(id);
    }
}
