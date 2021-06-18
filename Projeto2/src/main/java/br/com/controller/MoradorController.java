package br.com.controller;


import br.com.model.Morador;
import br.com.constant.Constant;
import br.com.service.MoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.Cacheable;

import java.util.List;
import java.util.Optional;

@RestController
public class MoradorController {

    @Autowired
    private MoradorService moradorService;

    @PostMapping(Constant.API_MORADOR)
    public void save(@RequestBody Morador morador){
        moradorService.sendMoradorRabbit(morador);
    }

    @GetMapping(Constant.API_MORADOR)
    public List<Morador> findAll(){
        return moradorService.findAll();
    }

    @PutMapping(Constant.API_MORADOR)
    public void update (@RequestBody Morador morador){
        moradorService.save(morador);
    }

    @DeleteMapping(Constant.API_MORADOR + "/{id}")
    public void delete(@PathVariable("id") String id){
        moradorService.delete(id);
    }

    @GetMapping(Constant.API_MORADOR + "/{id}")
    @Cacheable("morador")
    public Optional<Morador> findById(@PathVariable("id") String id){
        System.out.println("Find Information.. " + id);
        return moradorService.findById(id);
    }

}
