package br.com.felipemaciel.desafiojava.service;

public interface DadoService {
    public Integer jogarDados(Integer quantidadeDados, Integer quantidadeFaces);

    public Integer calculaDano(Long idPersonagem, Integer dado);
}
