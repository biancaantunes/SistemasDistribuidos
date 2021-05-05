package br.com.service;

import br.com.model.Livro;
import br.com.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public void save(Livro livro){
        livroRepository.save(livro);
    }

    public List<Livro> findAll (){
        return livroRepository.findAll();
    }

    public Optional<Livro> findById(String id){
        return livroRepository.findById(id);
    }

    public void delete(String id){
        livroRepository.deleteById(id);
    }
}
