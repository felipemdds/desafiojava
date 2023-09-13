package br.com.felipemaciel.desafiojava.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "batalhas")
public class Batalha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_jogo")
    private Long idJogo;

    @Column(name = "id_atacante")
    private Long idAtacante;

    @Column(name = "id_defensor")
    private Long idDefensor;

    @Column(name = "dadoAtaque")
    private Integer dadoAtaque;

    @Column(name = "dadoDefesa")
    private Integer dadoDefesa;

    @Column(name = "dano")
    private Integer dano;

    @Column(name = "vencedor")
    private Long idVencedor;
}
