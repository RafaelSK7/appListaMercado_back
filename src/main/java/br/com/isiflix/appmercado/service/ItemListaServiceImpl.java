package br.com.isiflix.appmercado.service;

import br.com.isiflix.appmercado.model.ItemLista;
import br.com.isiflix.appmercado.repository.ItemListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemListaServiceImpl implements IItemListaService{

    @Autowired
    private ItemListaRepository repository;

    @Override
    public ItemLista inserirItem(ItemLista novo) {
        return repository.save(novo);
    }

    @Override
    public ItemLista alterarItem(ItemLista item) {
        return repository.save(item);
    }

    @Override
    public void removerItem(Integer numSeq) {
        repository.deleteById(numSeq);
    }
}
