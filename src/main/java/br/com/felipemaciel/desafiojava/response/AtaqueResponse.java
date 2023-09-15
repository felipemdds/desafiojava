package br.com.felipemaciel.desafiojava.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtaqueResponse {

        private String nomePersonagem;
        private Integer danoCausado;
        private Integer vida;

}
