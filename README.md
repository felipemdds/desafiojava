# AD&D


> Poojeto Java responsável pelo gerenciamento de partidas de AD&D(RPG) 

### Meu intuito foi utilizar conceitos diferentes para a mesma finalidade e aplicando o máximo possível dos conhecimentos adquiridos nas últimas semanas.
### Gostaria de ter tido mais tempo para conseguir finalizar o projeto e incluir tudo que tinha em mente, como utilizar o Kafka para replicar o banco de dados (redundância), subir a aplicação utilizando Docker e os testes.

### Ajustes e melhorias

O projeto ainda está em desenvolvimento e as próximas atualizações serão voltadas nas seguintes tarefas:

- [x] Criar os endpoints requisitados
- [x] Implementar a lógica de jogar multiplos dados e de multiplas faces
- [x] Implementar as lógicas de dano
- [x] Implementar o ataque e defesa dos "Bots"
- [x] Implementar o ataque do usuário
- [ ] Implementar a defesa do usuário
- [ ] TBD..

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

* Você instalou a versão `17` do `JDK`
* Você tem o `postgres` instalado



## ☕ Usando as APIs do AD&D

Para usar os endpoints e jogar, siga estas etapas:


Primeiro devemos criar um jogo
Para isso, devemos fazer uma requisição `POST`, sem corpo e nem parâmetro, para o endereço: 
```
localhost:8080/jogos
```

O segundo passo é criar a "pessoa" que jogará a jogo
Devemos fazer isso fazendo uma requisição Post com os dados para o endereço:
```
localhost:8080/pessoas
```

Podemos consultar os personagens a qualquer momento utilizando uma requisição `GET`:
```
localhost:8080/personagens
```

Para escolher o personagem, devemos requisitar (`POST`) passando algumas informações como `nomePersonagem`, `idJogador` e `idJogo`
```
localhost:8080/personagens/escolher
```

Para definir a iniciativa passamos o id do Jogo no body da requisição (`POST`)
```
localhost:8080/jogos/iniciativa
```

Outros endpoints
```
localhost:8080/dados/jogar_dados
localhost:8080/dados/calcula_dano
localhost:8080/batalhas/ataque
localhost:8080/batalhas/calcula_ataque
localhost:8080/batalhas/calcula_defesa
```
