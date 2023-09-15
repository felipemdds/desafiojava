package br.com.felipemaciel.desafiojava.controller;

import br.com.felipemaciel.desafiojava.entity.Jogo;
import br.com.felipemaciel.desafiojava.request.DanoRequest;
import br.com.felipemaciel.desafiojava.service.BatalhaService;
import br.com.felipemaciel.desafiojava.service.impl.DadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DadoController {
    @Autowired
    private DadoServiceImpl dadoService;

    @PostMapping("/dados/calcula_dano")
    public Integer calculaDano(@RequestBody DanoRequest danoReq) {
        return dadoService.calculaDano(danoReq.getIdPersonagem(), danoReq.getDado());
    }
}
