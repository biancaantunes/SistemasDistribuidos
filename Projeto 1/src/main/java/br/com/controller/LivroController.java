package br.com.controller;

import br.com.constant.Constant;
import br.com.model.Livro;
import br.com.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping(Constant.API_LIVRO)
    public void save(@RequestBody Livro livro){
        livroService.save(livro);
    }

    @GetMapping(Constant.API_LIVRO)
    public List<Livro> findAll(){
        return livroService.findAll();
    }

    @PutMapping(Constant.API_LIVRO)
    public void update (@RequestBody Livro livro){
        livroService.save(livro);
    }

    @DeleteMapping(Constant.API_LIVRO + "/{id}")
    public void delete(@PathVariable("id") String id){
        livroService.delete(id);
    }

    @GetMapping(Constant.API_LIVRO + "/{id}")
    public Optional<Livro> findById(@PathVariable("id") String id){
        return livroService.findById(id);
    }
}
