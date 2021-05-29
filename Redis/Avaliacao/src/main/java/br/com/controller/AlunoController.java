package br.com.controller;

import br.com.model.Aluno;
import br.com.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/api/aluno")
    public List<Aluno> findAll(){
        return alunoService.findAll();
    }

    @PostMapping("/api/aluno")
    public void save(Aluno aluno){
        aluno.setMedia(calcularMedia(aluno.getNota1(), aluno.getNota2(), aluno.getNota3()));
        alunoService.save(aluno);
    }

    @GetMapping("/api/aluno/{id}")
    @Cacheable("aluno")
    public Aluno findById(@PathVariable("id") String id){
        System.out.println("Find Information.. " + id);
        return alunoService.findById(id);
    }

    public float calcularMedia(float n1, float n2, float n3){
        return ((n1 + n2 + n3) / 3);
    }
}
