package br.com.isiflix.appmercado.service;

import br.com.isiflix.appmercado.model.ItemLista;
import br.com.isiflix.appmercado.model.Lista;

import java.util.List;

public interface IListaService {
    public Lista criarNovaLista(Lista nova);
    public void removerLista(Integer id);
    public Lista fecharLista(Integer id);
    public Lista buscarPeloId(Integer id);
    public List<Lista> buscarTodas();
}
