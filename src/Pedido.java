import java.util.ArrayList;
import java.util.List;

public class Pedido {
    //Atributos
    private int idPedido;
    private Cliente cliente;
    private List<ItemPedido> produtos;
    private StatusPedido statusPedido;;

    //Construtor
    public Pedido(int idPedido, Cliente cliente){
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.produtos = new ArrayList<ItemPedido>();
        this.statusPedido = StatusPedido.CRIADO;
    }

    //Getters e Setters
    public int getIdPedido(){
        return this.idPedido;
    }
    public Cliente getCliente(){
        return this.cliente;
    }
    public StatusPedido getStatusPedido(){
        return this.statusPedido;
    }

    //Metodos
    public void mostrarPedido(){
        int index = 1;
        for (ItemPedido item : produtos){
            System.out.println("======================");
            System.out.println("Item Nº" + index + ":");
            System.out.println(item.toString());
            System.out.println("======================");
            index++;
        }
    }
    public double calcularTotal(){
        double total = 0;
        for (ItemPedido item : produtos){
            total += item.calcularSubTotal(item.getProduto());
        }
        return total;
    }
    public void pagarPedido() {
        if (statusPedido.equals(StatusPedido.CRIADO)){
            statusPedido = StatusPedido.PAGO;
        }
    }
    public void cancelarPedido(){
        if (statusPedido.equals(StatusPedido.CRIADO)) {
            statusPedido = StatusPedido.CANCELADO;
        }
    }


    //ToString
    @Override
    public String toString(){
        return "ID: " + idPedido + "\n" +
                "Cliente: " + cliente + "\n" +
                "Produto: " + produtos + "\n" +
                "Status: " + statusPedido + "\n";
    }
}
