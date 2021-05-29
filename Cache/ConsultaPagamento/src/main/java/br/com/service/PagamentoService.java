package br.com.service;

import br.com.model.Pagamento;
import br.com.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> findAll(){
        return pagamentoRepository.findAll();
    }

    public void save(Pagamento pagamento){
        pagamentoRepository.save(pagamento);
    }

    public Pagamento findById(String id){
        return pagamentoRepository.findById(id).get();
    }
}
