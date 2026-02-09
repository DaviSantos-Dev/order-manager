//Faz uma lista de ItemPedido

package domain.entities;
import domain.Enums.StatusPedido;
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
    public void adicionarItem(ItemPedido item){
        produtos.add(item);
    }
    public void removerItem(ItemPedido item){
        produtos.remove(item);
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
                "domain.entities.Cliente: " + cliente + "\n" +
                "domain.entities.Produto: " + produtos + "\n" +
                "Status: " + statusPedido + "\n";
    }
}
