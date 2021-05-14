package Controller;

import leo.Main;
import leo.model.Avaliacao;
import leo.service.AvaliacaoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
@WebAppConfiguration
public class AvaliacaoControllerTest {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Test
    public void save() throws Exception {

        long qtd = 20000;

        avaliacaoService.deleteAll();

        for ( int i = 1 ; i <= qtd ; i++){
            avaliacaoService.sendAvaliacaoRabbit(new Avaliacao(i, "Descrição " + i, 2, "Léo"));
        }

        Thread.sleep(15000);
        List<Avaliacao> lst = avaliacaoService.findAll();

        System.out.println("Qtd:" + lst.size());
        Assert.assertEquals(lst.size(), qtd);
    }

}
