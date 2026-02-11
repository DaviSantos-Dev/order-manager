package infra;

import domain.entities.Order;
import domain.repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryInMemory implements OrderRepository {
    //Atributos
    List<Order> orders =  new ArrayList<>();

    //Construtor

    //Métodos
    @Override
    public void addOrder(Order order) {
        orders.add(order)      ;
    }

    @Override
    public List<Order> listOrders() {
        return List.of();
    }

    @Override
    public Order searchById(int id) {
        for (Order order : orders) {
            if (order.getOrderId() == id) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> searchByClient(String name) { //Retorna lista de pedidos do usuário
        List<Order> newList = new ArrayList<>();
        for (Order order : orders) {
            if (order.getClient().getClientName().equals(name)) {
                newList.add(order);
            }
        }
        return newList;    }
}
