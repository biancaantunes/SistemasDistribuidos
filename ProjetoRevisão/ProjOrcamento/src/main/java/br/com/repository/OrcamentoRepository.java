package br.com.repository;

import br.com.model.Ambiente;
import br.com.model.Orcamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoRepository extends MongoRepository<Orcamento, String> {
}
