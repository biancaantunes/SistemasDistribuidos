package br.com.repository;

import br.com.model.Ambiente;
import br.com.model.Squad;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbienteRepository extends MongoRepository<Ambiente, String> {
}
