package br.com.service;

import br.com.model.Morador;
import br.com.rabbit.MoradorProducer;
import br.com.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;

    @Autowired
    private MoradorProducer moradorProducer;

    public void sendMoradorRabbit(Morador Morador){
        moradorProducer.send(Morador);
    }

    public void save(Morador Morador){
        moradorRepository.save(Morador);
    }

    public List<Morador> findAll (){
        return moradorRepository.findAll();
    }

    public Optional<Morador> findById(String id){
        return moradorRepository.findById(id);
    }

    public void delete(String id){
        moradorRepository.deleteById(id);
    }

    public void deleteAll(){
        moradorRepository.deleteAll();
    }
}
