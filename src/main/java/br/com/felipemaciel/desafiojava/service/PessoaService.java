package br.com.felipemaciel.desafiojava.service;

import br.com.felipemaciel.desafiojava.request.PessoaRequest;
import br.com.felipemaciel.desafiojava.entity.Pessoa;

import java.util.List;

public interface PessoaService {

        public Pessoa criarPessoa(Pessoa pessoa);

        public Pessoa lerPessoa(Long id);

        public List<Pessoa> lerPessoaPorNome(PessoaRequest pessoaRequest);

        public Pessoa atualizarPessoa(Long id, Pessoa pessoa);

        public void excluirPessoa(Long id);
}
