package br.com.isiflix.appmercado.service;

import br.com.isiflix.appmercado.model.Produto;
import br.com.isiflix.appmercado.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements IProdutoService{

    @Autowired
    private ProdutoRepository repository;
    @Override
    public Produto criarNovoProduto(Produto prod) {
        if (prod.getNome() == null || prod.getNome().length() == 0)
            return null;
        return repository.save(prod);
    }

    @Override
    public List<Produto> listarTodos() {
        return (List<Produto>)repository.findAll();
    }

    @Override
    public List<Produto> buscarPorPalavraChave(String key) {
        return repository.findAllByNomeContaining(key);
    }

    @Override
    public Produto buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
