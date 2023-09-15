package br.com.felipemaciel.desafiojava.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BatalhaRequest {
    private Long idJogo;

    private int turno;

    private Long idAtacante;

    private Long idDefensor;

    private Integer dano;
}
