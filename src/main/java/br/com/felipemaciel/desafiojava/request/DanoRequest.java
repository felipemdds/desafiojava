package br.com.felipemaciel.desafiojava.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DanoRequest {

    private Long idPersonagem;

    private Integer dado;
}
