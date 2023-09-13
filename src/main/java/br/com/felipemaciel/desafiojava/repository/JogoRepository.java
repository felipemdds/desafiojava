package br.com.felipemaciel.desafiojava.repository;

import br.com.felipemaciel.desafiojava.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
}