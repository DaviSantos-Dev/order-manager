package domain.repositories;

import domain.entities.Cliente;
import domain.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public interface ProdutoRepository {
    //Contrato
    void adicionarProduto(Produto produto);
    List<Produto> listarProdutos();
    Produto buscarPorId(int id);
    List<Produto> buscarPorNome(String nome);
}

/*public class ProdutoRepository {
    //Atributos
    private List<Produto> produtos = new ArrayList<>();
    private int lastId = 0;

    //Getters e Setters
    public List<Produto>  getProdutos() {
        return produtos;
    }
    public int getLastId() {
        return lastId;
    }

    //Metodos
    public void addProduto(Produto produto){
        produtos.add(produto);
    }
    public Produto buscarPorId(int id){

    }
    public List<Produto> buscarPorNome(String nome){

    }

}*/
