package br.com.felipemaciel.desafiojava.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadoPersonagem implements Comparator {
        private Long idPersonagem;
        private String nomePersonagem;
        private Integer dadoPersonagem;

    @Override
    public int compare(Object o, Object t1) {
        return 0;
    }
}
