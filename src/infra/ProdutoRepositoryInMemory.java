package infra;

import domain.entities.Produto;
import domain.repositories.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositoryInMemory implements ProdutoRepository {
    //Atributos
    private List<Produto> produtos = new ArrayList<>();

    //Construtor
    public ProdutoRepositoryInMemory() {} //Sempre deve ser instanciado vazio.

    //Métodos
    @Override
    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    @Override
    public List<Produto> listarProdutos() {
        return List.of();
    }

    @Override
    public Produto buscarPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getIdProduto() == id){
                return produto;
            }
        }
        return null;
    }

    @Override
    public List<Produto> buscarPorNome(String nome) {
        List<Produto> newList = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getNomeProduto().toLowerCase().equals(nome.toLowerCase())){
                newList.add(produto);
            }
        }
        return newList;
    }
}
