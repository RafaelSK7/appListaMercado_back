package br.com.isiflix.appmercado.repository;

import br.com.isiflix.appmercado.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
