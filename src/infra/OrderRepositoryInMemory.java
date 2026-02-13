package infra;

import domain.entities.Order;
import domain.entities.Product;
import domain.exceptions.BusinessRuleException;
import domain.repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryInMemory implements OrderRepository {
    //Atributos
    List<Order> orders =  new ArrayList<>();

    //Construtor
    public OrderRepositoryInMemory() {} //Sempre deve ser instanciado vazio.

    //Métodos
    @Override
    public void addOrder(Order order) {
        try{
            orders.add(order);
            order.setOrderId(nextId());
        } catch (RuntimeException e) {
            throw new BusinessRuleException("Error: Order couldn't  be added!");
        }

    }

    @Override
    public List<Order> listOrders() {
        return new ArrayList<>(orders);
    }

    @Override
    public Order searchById(int id) {
        for (Order order : orders) {
            if (order.getOrderId() == id) {
                return order;
            }
        }
        throw new BusinessRuleException("Order not found");
    }

    @Override
    public List<Order> searchByClient(String name) { //Retorna lista de pedidos do usuário
        List<Order> newList = new ArrayList<>();
        for (Order order : orders) {
            if (order.getClient().getClientName().equals(name)) {
                newList.add(order);
            }
        }
        return newList;
    }

    private int nextId(){
        int currentId = 1;
        for (Order order : orders) {
            if (order.getOrderId() > currentId){
                currentId = order.getOrderId() + 1;
            }
        }
        return currentId;
    }
}
