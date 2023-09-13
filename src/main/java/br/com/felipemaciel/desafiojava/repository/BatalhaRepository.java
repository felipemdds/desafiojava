package br.com.felipemaciel.desafiojava.repository;

import br.com.felipemaciel.desafiojava.entity.Batalha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatalhaRepository extends JpaRepository<Batalha, Long> {
}