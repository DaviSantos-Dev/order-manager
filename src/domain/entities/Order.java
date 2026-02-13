package domain.entities;
import domain.enums.OrderStatus;
import java.util.ArrayList;
import java.util.List;

public class Order {
    //Atributos
    private int OrderId;
    private Client client;
    private List<OrderItem> Products;
    private OrderStatus orderStatus;;

    //Construtor
    public Order(Client client){
        this.client = client;
        this.Products = new ArrayList<OrderItem>();
        this.orderStatus = OrderStatus.CREATED;
    }

    //Getters e Setters
    public int getOrderId() {
        return this.OrderId;
    }
    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }
    public Client getClient() {
        return this.client;
    }
    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    //Metodos
    public void addItem(OrderItem item){
        Products.add(item);
    }
    public void removeItem(OrderItem item){
        Products.remove(item);
    }
    public double total(){
        double total = 0;
        for (OrderItem item : Products){
            total += item.calculateSubTotal();
        }
        return total;
    }
    public void payOrder() {
        if (orderStatus.equals(OrderStatus.CREATED)){
            orderStatus = OrderStatus.PAID;
        }
    }
    public void cancelOrder(){
        if (orderStatus.equals(OrderStatus.CREATED)) {
            orderStatus = OrderStatus.CANCELED;
        }
    }


    //ToString
    @Override
    public String toString(){
        return "ID: " + OrderId + "\n" +
                "Client: " + client + "\n" +
                "Product: " + Products + "\n" +
                "Status: " + orderStatus + "\n";
    }
}
