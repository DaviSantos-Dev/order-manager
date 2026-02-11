package domain.repositories;

import domain.entities.Order;

import java.util.List;

public interface OrderRepository {
    //Contrato
    void addOrder(Order order);
    List<Order> listOrders();
    Order searchById(int id);
    List<Order> searchByClient(String name);
}
