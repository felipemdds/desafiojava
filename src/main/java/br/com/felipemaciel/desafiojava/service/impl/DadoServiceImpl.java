package br.com.felipemaciel.desafiojava.service.impl;

import java.util.Arrays;
import java.util.Random;

import br.com.felipemaciel.desafiojava.entity.Personagem;
import br.com.felipemaciel.desafiojava.service.DadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class DadoServiceImpl implements DadoService {

    private PersonagemServiceImpl personagemService;

    public Integer jogarDados(Integer quantidadeDados, Integer quantidadeFaces){
        Random random = new Random();

        int[] dados = new int[quantidadeDados];

        for (int i = 0; i < quantidadeDados; i++) {
            dados[i] = random.nextInt(quantidadeFaces) + 1;
        }

        return Arrays.stream(dados).sum();
    }

    public Integer calculaDano(Long idPersonagem, Integer dado){
        Personagem personagem = personagemService.getPersonagemById(idPersonagem);
        return dado+personagem.getForca();
    }
}
