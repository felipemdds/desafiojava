package br.com.felipemaciel.desafiojava.service.impl;

import br.com.felipemaciel.desafiojava.request.AtribuiPersonagemRequest;
import br.com.felipemaciel.desafiojava.entity.Personagem;
import br.com.felipemaciel.desafiojava.repository.PersonagemRepository;
import br.com.felipemaciel.desafiojava.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemServiceImpl implements PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    private PessoaServiceImpl pessoaService;

    public List<Personagem> getPersonagens(Long idJogo) {
        return personagemRepository.findByJogoOrderByOrdem(idJogo);
    }

    public List<Personagem> getPersonagensVivos(Long idJogo) {
        return personagemRepository.findVivosByJogoOrderByOrdem(idJogo);
    }

    public Personagem getPersonagemById(Long id) {
        return personagemRepository.findById(id).orElse(null);
    }

    public List<Personagem> getPersonagemByNomeAndIdJogo(String nome, Long idJogo) {
        return personagemRepository.findByNomeAndIdJogo(nome, idJogo);
    }

    public List<Personagem> getPersonagemByOrdemAndIdJogo(Integer ordem, Long idJogo) {
        return personagemRepository.findByOrdemAndIdJogo(ordem, idJogo);
    }

    public List<Personagem> getPersonagemByIdAndIdJogo(Long idPersonagem, Long idJogo) {
        return personagemRepository.findByIdAndIdJogo(idPersonagem, idJogo);
    }

    public List<Personagem> getPersonagensByClasseAndIdJogo(String classe, Long idJogo) {
        return personagemRepository.getPersonagensByClasseAndIdJogo(classe, idJogo);
    }

    public Personagem createPersonagem(Personagem personagem) {
        personagemRepository.save(personagem);
        return personagem;
    }

    public Personagem updatePersonagem(Long id, Personagem personagem) {
        Personagem personagemAtual = personagemRepository.findById(id).orElseThrow(null);
        personagemAtual.setVida(personagem.getVida());
        personagemAtual.setForca(personagem.getForca());
        personagemAtual.setDefesa(personagem.getDefesa());
        personagemAtual.setAgilidade(personagem.getAgilidade());
        personagemAtual.setQuantidadeDeDados(personagem.getQuantidadeDeDados());
        personagemAtual.setFacesDoDado(personagem.getFacesDoDado());
        personagemRepository.save(personagemAtual);
        return personagemAtual;
    }

    public Personagem updateOrdemPersonagem(Long idJogo, Long idPersonagem, Integer ordem) {
        List<Personagem> personagemAtual = personagemRepository.findByIdAndIdJogo(idPersonagem, idJogo);
        personagemAtual.get(0).setOrdem(ordem);
        personagemRepository.save(personagemAtual.get(0));
        return personagemAtual.get(0);
    }

    public Personagem subtraiPV(Long idJogo, Long idPersonagem, Integer dano) {
        List<Personagem> personagemAtual = personagemRepository.findByIdAndIdJogo(idPersonagem, idJogo);
        Integer pv = personagemAtual.get(0).getVida();
        personagemAtual.get(0).setVida(pv - dano);
        personagemRepository.save(personagemAtual.get(0));
        return personagemAtual.get(0);
    }

    public Personagem pegaPersonagem(AtribuiPersonagemRequest atribuiPersonagemRequest){
        List<Personagem> listaPersonagem = getPersonagemByNomeAndIdJogo(atribuiPersonagemRequest.getNomePersonagem(), atribuiPersonagemRequest.getIdJogo());
        Personagem escolhido = listaPersonagem.get(0);
        escolhido.setIdDono(atribuiPersonagemRequest.getIdJogador());
        pessoaService.atualizarPersonagemPessoa(atribuiPersonagemRequest.getIdJogador(), escolhido.getId());
        return updatePersonagem(escolhido.getId(),escolhido);
    }
    public void deletePersonagem(Long id) {
        personagemRepository.deleteById(id);
    }

    public void criaEquipes(Long idJogo){

        Personagem guerreiro = Personagem.builder()
                .nome("Guerreiro")
                .vida(20)
                .forca(7)
                .defesa(5)
                .agilidade(6)
                .quantidadeDeDados(1)
                .facesDoDado(12)
                .classe("Herói")
                .idJogo(idJogo)
                .build();
        createPersonagem(guerreiro);

        Personagem barbaro = Personagem.builder()
                .nome("Bárbaro")
                .vida(21)
                .forca(10)
                .defesa(2)
                .agilidade(5)
                .quantidadeDeDados(2)
                .facesDoDado(8)
                .classe("Herói")
                .idJogo(idJogo)
                .build();
        createPersonagem(barbaro);

        Personagem cavaleiro = Personagem.builder()
                .nome("Cavaleiro")
                .vida(26)
                .forca(6)
                .defesa(8)
                .agilidade(3)
                .quantidadeDeDados(2)
                .facesDoDado(6)
                .classe("Herói")
                .idJogo(idJogo)
                .build();
        createPersonagem(cavaleiro);

        Personagem orc = Personagem.builder()
                .nome("Orc")
                .vida(42)
                .forca(7)
                .defesa(1)
                .agilidade(2)
                .quantidadeDeDados(3)
                .facesDoDado(4)
                .classe("Monstro")
                .idJogo(idJogo)
                .build();
        createPersonagem(orc);

        Personagem gigante = Personagem.builder()
                .nome("Gigante")
                .vida(34)
                .forca(10)
                .defesa(4)
                .agilidade(4)
                .quantidadeDeDados(2)
                .facesDoDado(6)
                .classe("Monstro")
                .idJogo(idJogo)
                .build();
        createPersonagem(gigante);

        Personagem lobisomen = Personagem.builder()
                .nome("Lobisomen")
                .vida(34)
                .forca(7)
                .defesa(4)
                .agilidade(7)
                .quantidadeDeDados(2)
                .facesDoDado(4)
                .classe("Monstro")
                .idJogo(idJogo)
                .build();
        createPersonagem(lobisomen);
    }

}
