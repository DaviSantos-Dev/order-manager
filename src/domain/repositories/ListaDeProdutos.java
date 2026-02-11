package domain.repositories;

import domain.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class ListaDeProdutos {
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
        for (Produto produto : produtos) {
            if (produto.getIdProduto() == id){
                return produto;
            }
        }
        return null;
    }
    public List<Produto> buscarPorNome(String nome){
        List<Produto> newList = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getNomeProduto().toLowerCase().equals(nome.toLowerCase())){
                newList.add(produto);
            }
        }
        return newList;
    }

}
