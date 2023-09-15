package br.com.felipemaciel.desafiojava.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "jogos")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @Column(name = "vencedor")
    private Long vencedor;

    @Column(name = "turno")
    private Integer turno;

    @Column(name = "ordem")
    private Integer ordem;

    @Column(name = "idPersonagemIniciativa")
    private Long idPersonagemIniciativa;
}
