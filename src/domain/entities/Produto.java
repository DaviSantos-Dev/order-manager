//É apenas uma classe para criar novos produtos

package domain.entities;
import domain.enums.StatusProduto;

public class Produto {
    //Atributos
    private int idProduto;
    private String nomeProduto;
    private double precoProduto;
    private int estoqueProduto;
    private StatusProduto statusProduto;

    //Constructor
    public Produto(String nome, double preco, int estoque){
        nomeProduto = nome;
        precoProduto = preco;
        estoqueProduto = estoque;
        statusProduto = StatusProduto.ATIVO;
    }
    public Produto(String nome, double preco){
        nomeProduto = nome;
        precoProduto = preco;
        estoqueProduto = 0;
        statusProduto = StatusProduto.SEM_ESTOQUE;
    }

    //Getters e Setters
    public String getNomeProduto(){
        return this.nomeProduto;
    }
    public void setNomeProduto(String nomeProduto){
        this.nomeProduto = nomeProduto;
    }
    public int getIdProduto() {
        return idProduto;
    }
    public double getPrecoProduto(){
        return precoProduto;
    }
    public int getEstoqueProduto(){
        return estoqueProduto;
    }
    public StatusProduto getStatusProduto(){
        return statusProduto;
    }

    //Metodos
    public void reduzirEstoque(int quantidade){
        if (quantidade <= estoqueProduto) {
            estoqueProduto -= quantidade;
        } else{
            throw new RuntimeException("Estoque insuficiente");
        }
    }
    public void aumentarEstoque(int quantidade){
        estoqueProduto += quantidade;
    }
}
