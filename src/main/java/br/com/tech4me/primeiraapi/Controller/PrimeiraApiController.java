
package br.com.tech4me.primeiraapi.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.primeiraapi.Model.Mensagem;

@RestController
@RequestMapping("/api/mensagens")
public class PrimeiraApiController {

    List<Mensagem> mensagens = new ArrayList<>();

    @GetMapping
    public List<Mensagem> getMensagem() {
        return mensagens;

    }

    @GetMapping(value = "/{nome}") //Passando o nome no endpoint
    public String getNome (@PathVariable String nome) { //Buscando
        return String.format("%s disse olá", nome);
    }    
    

    @PostMapping 
    public Mensagem cadastrarMensagem(@RequestBody Mensagem mensagem) { //Buscando mensagem no 'body'
        mensagens.add(mensagem); //Guardando a mensagem na lista
        return mensagem; //Exibindo pro usuário
    }

    @PutMapping
    public Mensagem alterarMensagem(@RequestBody Mensagem mensagem) { //Buscando mensagem no 'body'
        String categoria = mensagem.getCategoria() + "Alterada no PUT"; 
        mensagem.setCategoria(categoria); //Setando a categoria da mensagem
        return mensagem; //exibindo para o Usuário 
    }
}
