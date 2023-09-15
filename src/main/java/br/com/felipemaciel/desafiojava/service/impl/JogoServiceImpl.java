package br.com.felipemaciel.desafiojava.service.impl;

import br.com.felipemaciel.desafiojava.entity.Jogo;
import br.com.felipemaciel.desafiojava.entity.Personagem;
import br.com.felipemaciel.desafiojava.entity.Pessoa;
import br.com.felipemaciel.desafiojava.repository.JogoRepository;
import br.com.felipemaciel.desafiojava.request.BatalhaRequest;
import br.com.felipemaciel.desafiojava.response.AtaqueResponse;
import br.com.felipemaciel.desafiojava.response.DadoPersonagem;
import br.com.felipemaciel.desafiojava.response.IniciativaResponse;
import br.com.felipemaciel.desafiojava.response.JogoResponse;
import br.com.felipemaciel.desafiojava.service.BatalhaService;
import br.com.felipemaciel.desafiojava.service.JogoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class JogoServiceImpl implements JogoService {

    @Autowired
    private JogoRepository jogoRepository;
    private PersonagemServiceImpl personagemService;
    private DadoServiceImpl dadoService;
    private BatalhaServiceImpl batalhaService;
    private PessoaServiceImpl pessoaService;

    public List<Jogo> getJogos() {
        return jogoRepository.findAll();
    }

    public Jogo getJogoById(Long id) {
        return jogoRepository.findById(id).orElse(null);
    }

    public Jogo createJogo(Jogo jogo) {
        jogo.setTurno(1);
        jogo.setOrdem(0);
        jogo.setDataHora(LocalDateTime.now());
        Jogo jogoSalvo = jogoRepository.save(jogo);
        personagemService.criaEquipes(jogoSalvo.getId());

        return jogoSalvo;
    }

    public Jogo updateJogo(Long id, Jogo jogo) {
        Jogo jogoAtual = jogoRepository.findById(id).orElse(null);
        if(jogoAtual != null) {
            jogoAtual.setDataHora(jogo.getDataHora());
            jogoAtual.setVencedor(jogo.getVencedor());
            jogoAtual.setIdPersonagemIniciativa(jogo.getIdPersonagemIniciativa());
            jogoRepository.save(jogoAtual);
            return jogoAtual;
        }else{
            return null;
        }
    }

    public void deleteJogo(Long id) {
        jogoRepository.deleteById(id);
    }

    public IniciativaResponse iniciativa(Long idJogo){
        Random rand = new Random();
        List<DadoPersonagem> listaDadoPersonagem = new ArrayList<>();
        List<Personagem> listaPersonagens = personagemService.getPersonagens(idJogo);
        for (int i = 0; i < listaPersonagens.size(); i++) {
            int randomIndex = rand.nextInt(listaPersonagens.size());
            Personagem personagemEscolhido = listaPersonagens.get(randomIndex);
            listaDadoPersonagem.add(
                    new DadoPersonagem(
                            personagemEscolhido.getId(),
                            personagemEscolhido.getNome(),
                            dadoService.jogarDados(1,12)
                    )
            );
            listaPersonagens.remove(randomIndex);
        }

        DadoPersonagem dadoPersonagemWithHighestValue =
                new DadoPersonagem(0L,"",0);

        for (DadoPersonagem dadoPersonagem : listaDadoPersonagem) {
            if (dadoPersonagem.getDadoPersonagem() > dadoPersonagemWithHighestValue.getDadoPersonagem()) {
                dadoPersonagemWithHighestValue = dadoPersonagem;
            }
        }

        // Create a comparator to compare persons by name
        Comparator<DadoPersonagem> comparator = new Comparator<DadoPersonagem>() {
            @Override
            public int compare(DadoPersonagem dp1, DadoPersonagem dp2) {
                return dp1.getDadoPersonagem().compareTo(dp2.getDadoPersonagem());
            }
        };

        // Sort the list of persons by name
        Collections.sort(listaDadoPersonagem, comparator.reversed());
        int index = 0;
        for (DadoPersonagem dadoPersonagem : listaDadoPersonagem){
            personagemService.updateOrdemPersonagem(idJogo, dadoPersonagem.getIdPersonagem(), index++);
        }

        Jogo jogoAtual = getJogoById(idJogo);
        jogoAtual.setIdPersonagemIniciativa(dadoPersonagemWithHighestValue.getIdPersonagem());
        updateJogo(idJogo, jogoAtual);

        return new IniciativaResponse(
                dadoPersonagemWithHighestValue.getNomePersonagem()+" terá a iniciativa, pois tirou "+dadoPersonagemWithHighestValue.getDadoPersonagem()+" no dado.",listaDadoPersonagem);

    }

    public JogoResponse continuarJogo (Long idJogo, Long idJogador){
        Random rand = new Random();
        Jogo jogoAtual = getJogoById(idJogo);
        Integer turno = jogoAtual.getTurno();
        Pessoa pessoaAtual = pessoaService.lerPessoa(idJogador);
        List<Personagem> personagens = personagemService.getPersonagens(idJogo);

        for(Personagem personagem : personagens) {
            if (personagem.getOrdem() >= jogoAtual.getOrdem()) {
                if (personagem.getId().equals(pessoaAtual.getPersonagemId())) {
                    return new JogoResponse("Agora é sua vez de batalhar.", personagemService.getPersonagensVivos(idJogo));
                } else {
                    if (personagem.getClasse().equals("Herói")) {
                        List<Personagem> monstrosVivos = personagemService.getPersonagensByClasseAndIdJogo("Monstros", idJogo);
                        int randomIndex = rand.nextInt(monstrosVivos.size());
                        Personagem personagemEscolhido = monstrosVivos.get(randomIndex);

                        Integer dadoAtaque = dadoService.jogarDados(1, 12);
                        Integer dadoDefesa = dadoService.jogarDados(1, 12);

                        Integer ataqueCalculado = batalhaService.calculaAtaque(personagem.getId(), dadoAtaque);
                        Integer defesaCalculada = batalhaService.calculaDefesa(personagemEscolhido.getId(), dadoDefesa);

                        if (ataqueCalculado > defesaCalculada) {

                            Integer dadoDano = dadoService.jogarDados(personagem.getQuantidadeDeDados(), personagem.getFacesDoDado());
                            AtaqueResponse ataque = batalhaService.ataque(idJogo, personagem.getId(), personagemEscolhido.getId(), dadoDano);
                            batalhaService.createBatalha(
                                    new BatalhaRequest(
                                            idJogo,
                                            jogoAtual.getTurno(),
                                            personagem.getId(),
                                            personagemEscolhido.getId(),
                                            dadoService.calculaDano(personagem.getId(), ataque.getDanoCausado())
                                    ));
                        }
                    }else{
                        List<Personagem> vivos = personagemService.getPersonagensVivos(idJogo);
                        int randomIndex = rand.nextInt(vivos.size());
                        Personagem personagemEscolhido = vivos.get(randomIndex);

                        Integer dadoAtaque = dadoService.jogarDados(1, 12);
                        Integer dadoDefesa = dadoService.jogarDados(1, 12);

                        Integer ataqueCalculado = batalhaService.calculaAtaque(personagem.getId(), dadoAtaque);
                        Integer defesaCalculada = batalhaService.calculaDefesa(personagemEscolhido.getId(), dadoDefesa);

                        if (ataqueCalculado > defesaCalculada) {
                            Integer dadoDano = dadoService.jogarDados(personagem.getQuantidadeDeDados(), personagem.getFacesDoDado());
                            AtaqueResponse ataque = batalhaService.ataque(idJogo, personagem.getId(), personagemEscolhido.getId(), dadoDano);

                            batalhaService.createBatalha(
                                    new BatalhaRequest(
                                            idJogo,
                                            jogoAtual.getTurno(),
                                            personagem.getId(),
                                            personagemEscolhido.getId(),
                                            dadoService.calculaDano(personagem.getId(), ataque.getDanoCausado())
                                    ));

                        }
                    }
                }
            }
        }
        jogoAtual.setTurno(turno+1);
        return new JogoResponse("O turno "+turno+" acabou.", personagemService.getPersonagensVivos(idJogo));


        }
}
