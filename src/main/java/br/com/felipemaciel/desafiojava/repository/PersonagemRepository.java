package br.com.felipemaciel.desafiojava.repository;

import br.com.felipemaciel.desafiojava.entity.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}
