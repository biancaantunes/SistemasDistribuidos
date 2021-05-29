package br.com.controller;

import br.com.model.Pagamento;
import br.com.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/api/pagamento")
    public List<Pagamento> findAll(){
        return pagamentoService.findAll();
    }

    @PostMapping("/api/pagamento")
    public void save(Pagamento pagamento){
        pagamentoService.save(pagamento);
    }

    @GetMapping("/api/pagamento/{id}")
    @Cacheable("pagamento")
    public Pagamento findById(@PathVariable("id") String id){
        System.out.println("Find Information.. " + id);
        return pagamentoService.findById(id);
    }

    @GetMapping("/api/pagamento/{id}/clean")
    @CacheEvict("pagamento")
    public Pagamento findByIdWithOutCache(@PathVariable("id") String id){
        System.out.println("Find Information.. " + id);
        return pagamentoService.findById(id);
    }
}
