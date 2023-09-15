package br.com.felipemaciel.desafiojava.repository;

import br.com.felipemaciel.desafiojava.entity.Personagem;
import br.com.felipemaciel.desafiojava.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

    List<Personagem> findByNomeAndIdJogo(String nome, Long idJogo);

    List<Personagem> findByOrdemAndIdJogo(Integer ordem, Long idJogo);

    List<Personagem> findByIdAndIdJogo(Long id, Long idJogo);

    List<Personagem> findByJogoOrderByOrdem(Long idJogo);

    List<Personagem> getPersonagensByClasseAndIdJogo(String classe, Long idJogo);

    @Query("SELECT p FROM personagens p WHERE p.vida > 0 and p.idJogo = :idJogo")
    List<Personagem> findVivosByJogoOrderByOrdem(@Param("idJogo") Long idJogo);

}
