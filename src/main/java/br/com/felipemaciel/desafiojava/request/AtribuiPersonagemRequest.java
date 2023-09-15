package br.com.felipemaciel.desafiojava.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AtribuiPersonagemRequest {
    private String nomePersonagem;
    private Long idJogador;
    private Long idJogo;
}
