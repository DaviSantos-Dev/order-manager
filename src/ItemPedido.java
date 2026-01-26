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
        return produto.getPrecoProduto() * this.quantidade;
    }

    //ToString
    @Override
    public String toString(){
        return "Produto: " + produto.getNomeProduto() + "\n" +
                "Quantidade: " + produto.getPrecoProduto();
    }
}
