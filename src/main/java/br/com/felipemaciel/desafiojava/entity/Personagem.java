package br.com.felipemaciel.desafiojava.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "personagens")
@NoArgsConstructor
@AllArgsConstructor
@Builder //precisa do AllArgsConstructor
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
    private Integer forca;

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

    @NotNull
    private String classe;

    @NotNull
    private Long idJogo;

    @NotNull
    private Long idDono;

    private Integer ordem;

}
