package br.com.felipemaciel.desafiojava.service.impl;

import br.com.felipemaciel.desafiojava.request.PessoaRequest;
import br.com.felipemaciel.desafiojava.entity.Pessoa;
import br.com.felipemaciel.desafiojava.repository.PessoaRepository;
import br.com.felipemaciel.desafiojava.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa criarPessoa(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
        return pessoa;
    }

    public Pessoa lerPessoa(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public List<Pessoa> lerPessoaPorNome(PessoaRequest pessoaRequest) {
        return pessoaRepository.findByNome(pessoaRequest.getNome());
    }

    public Pessoa atualizarPessoa(Long id, Pessoa pessoa) {
        Pessoa pessoaAtual = pessoaRepository.findById(id).orElse(null);
        pessoaAtual.setNome(pessoa.getNome());
        pessoaAtual.setPersonagemId(pessoa.getPersonagemId());
        pessoaAtual.setIdJogo(pessoa.getIdJogo());
        pessoaRepository.save(pessoaAtual);
        return pessoaAtual;
    }

    public Pessoa atualizarPersonagemPessoa(Long id, Long idPersonagem) {
        Pessoa pessoaAtual = pessoaRepository.findById(id).orElse(null);
        pessoaAtual.setPersonagemId(idPersonagem);
        pessoaRepository.save(pessoaAtual);
        return pessoaAtual;
    }

    public void excluirPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}