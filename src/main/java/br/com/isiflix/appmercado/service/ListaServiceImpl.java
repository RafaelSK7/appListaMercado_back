package br.com.isiflix.appmercado.service;

import br.com.isiflix.appmercado.model.ItemLista;
import br.com.isiflix.appmercado.model.Lista;
import br.com.isiflix.appmercado.repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListaServiceImpl implements IListaService{

    @Autowired
    private ListaRepository repository;

    @Override
    public Lista criarNovaLista(Lista nova) {
        return repository.save(nova);
    }

    @Override
    public void removerLista(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Lista fecharLista(Integer id) {
        Lista l = repository.findById(id).get();
        double total = 0.0;
        for (ItemLista item: l.getItens()){
            total += l.getValorTotal();
        }
        l.setValorTotal(total);
        l.setStatus(1); // lista concluida;
        return repository.save(l);
    }

    @Override
    public Lista buscarPeloId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Lista> buscarTodas() {
        return (List<Lista>) repository.findAll();
    }
}
