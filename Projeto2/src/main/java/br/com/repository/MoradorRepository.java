package br.com.repository;

import br.com.model.Morador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoradorRepository extends MongoRepository<Morador, String>{
}
