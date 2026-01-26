public class Produto {
    //Atributos
    private int idProduto;
    private String nomeProduto;
    private double precoProduto;
    private int estoqueProduto;
    private boolean produtoAtivo;

    //Constructor
    public Produto(int id, String nome, double preco, int estoque){
        idProduto = id + 1;
        nomeProduto = nome;
        precoProduto = preco;
        estoqueProduto = estoque;
    }
    public Produto(int id, String nome, double preco){
        idProduto = id + 1;
        nomeProduto = nome;
        precoProduto = preco;
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

    //Metodos
    public void reduzirEstoque(int quantidade){
        estoqueProduto -= quantidade;
    }
    public void aumentarEstoque(int quantidade){
        estoqueProduto += quantidade;
    }
}
