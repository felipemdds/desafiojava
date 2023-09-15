package br.com.felipemaciel.desafiojava.service.impl;

import br.com.felipemaciel.desafiojava.entity.Batalha;
import br.com.felipemaciel.desafiojava.entity.Jogo;
import br.com.felipemaciel.desafiojava.entity.Personagem;
import br.com.felipemaciel.desafiojava.repository.BatalhaRepository;
import br.com.felipemaciel.desafiojava.request.BatalhaRequest;
import br.com.felipemaciel.desafiojava.response.AtaqueResponse;
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

    private DadoServiceImpl dadoService;

    private JogoServiceImpl jogoService;

    private PersonagemServiceImpl personagemService;

    public List<Batalha> getBatalhas() {
        return batalhaRepository.findAll();
    }

    public Batalha getBatalhaById(Long id) {
        return batalhaRepository.findById(id).orElse(null);
    }

    public Batalha createBatalha(BatalhaRequest batalhaReq) {
        Batalha batalha = new Batalha();
        batalha.setIdJogo(batalhaReq.getIdJogo());
        batalha.setIdAtacante(batalhaReq.getIdAtacante());
        batalha.setIdDefensor(batalhaReq.getIdDefensor());
        batalha.setDano(batalhaReq.getDano());
        batalha.setTurno(batalhaReq.getTurno());



        batalhaRepository.save(batalha);
        return batalha;
    }

    public AtaqueResponse ataque (Long idJogo, Long idAtacante, Long idOponente, Integer dano){

        Personagem atacado = personagemService.subtraiPV(idJogo, idOponente, dano);

        return new AtaqueResponse(atacado.getNome(),dano, atacado.getVida());
    }

    public Integer calculaAtaque (Long idPersonagem, Integer dado){
        Personagem personagem = personagemService.getPersonagemById(idPersonagem);
        Integer soma = dado + personagem.getForca() + personagem.getAgilidade();
        return soma;
    }
    public Integer calculaDefesa (Long idPersonagem, Integer dado){
        Personagem personagem = personagemService.getPersonagemById(idPersonagem);
        Integer soma = dado + personagem.getDefesa() + personagem.getAgilidade();
        return soma;
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
