package br.com.felipemaciel.desafiojava.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@Table(name = "pessoa")
public class Pessoa {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "nome")
        private String nome;

        @Column(name = "personagem")
        private Long personagemId;

        @Column(name = "idJogo")
        private Long idJogo;
}
