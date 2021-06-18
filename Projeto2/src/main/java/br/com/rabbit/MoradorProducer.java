package br.com.rabbit;

import br.com.model.Morador;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MoradorProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("moradorQueue")
    @Autowired
    private Queue queue;

    public void send(Morador morador){
        rabbitTemplate.convertAndSend(this.queue.getName(), morador);
    }
}