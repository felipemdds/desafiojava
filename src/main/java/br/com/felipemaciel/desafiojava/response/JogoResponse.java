package br.com.felipemaciel.desafiojava.response;

import br.com.felipemaciel.desafiojava.entity.Personagem;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class JogoResponse {
    private String mensagem;
    private List<Personagem> personagensVivos;
}
