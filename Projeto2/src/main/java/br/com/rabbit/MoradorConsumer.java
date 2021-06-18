package br.com.rabbit;

import br.com.model.Morador;
import br.com.service.MoradorService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MoradorConsumer {

    @Autowired
    private MoradorService moradorService;

    @RabbitListener(queues = {"${queue.morador.name}"})
    public void receive (@Payload Morador Morador){
        System.out.println("Id: "+ Morador.get_id() + "\nNome: " + Morador.getName() +
                "\nIdade: " + Morador.getIdade() + "\nCPF: " + Morador.getCpf() +
                "\nNumero Bloco: " + Morador.getNumero_bloco() +
                "\nNumero Apartamento: " + Morador.getNumero_apartamento());

        moradorService.save(Morador);
    }
}