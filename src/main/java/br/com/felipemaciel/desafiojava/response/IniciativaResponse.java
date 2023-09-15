package br.com.felipemaciel.desafiojava.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class IniciativaResponse {
    private String mensagem;
    private List<DadoPersonagem> dadosPersonagens;
}
