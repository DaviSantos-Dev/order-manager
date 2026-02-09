// Ele leva o produto para o pedido (Quase como um objeto de relacionamento)

package domain.entities;

public class ItemPedido {
    //Atributos
    private Produto produto;
    private int quantidade;

    //Construtor
    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    //Getters e Setters
    public Produto getProduto() {
        return produto;
    }
    public int getQuantidade() {
        return quantidade;
    }

    //Metodos
    public double calcularSubTotal(Produto produto){
        return produto.getPrecoProduto() * quantidade;
    }

    //ToString
    @Override
    public String toString(){
        return "domain.entities.Produto: " + produto.getNomeProduto() + "\n" +
                "Quantidade: " + quantidade;
    }
}
