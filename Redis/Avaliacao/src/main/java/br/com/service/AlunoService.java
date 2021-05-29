package br.com.service;

import br.com.model.Aluno;
import br.com.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }

    public void save(Aluno aluno){
        alunoRepository.save(aluno);
    }

    public Aluno findById(String id){
        return alunoRepository.findById(id).get();
    }
}
