package br.com.felipemaciel.desafiojava.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AtaqueRequest {
    private Long idJogo;
    private Long idAtacante;
    private Long idOponente;
    private Integer dado;
}
