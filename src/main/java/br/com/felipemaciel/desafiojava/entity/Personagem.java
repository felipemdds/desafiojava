package br.com.felipemaciel.desafiojava.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "personagens")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    private Integer vida;

    @NotNull
    private Integer força;

    @NotNull
    private Integer defesa;

    @NotNull
    private Integer agilidade;

    @NotNull
    @Min(1)
    private Integer quantidadeDeDados;

    @NotNull
    @Min(2)
    private Integer facesDoDado;

    @NotBlank
    private Long idJogo;
}
