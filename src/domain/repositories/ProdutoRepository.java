package domain.repositories;

import domain.entities.Produto;

import java.util.List;

public interface ProdutoRepository {
    //Contrato
    void adicionarProduto(Produto produto);
    List<Produto> listarProdutos();
    Produto buscarPorId(int id);
    List<Produto> buscarPorNome(String nome);
}

