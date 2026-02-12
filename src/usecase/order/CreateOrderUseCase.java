package usecase.order;

import domain.entities.Client;
import domain.entities.Order;
import domain.entities.OrderItem;
import domain.exceptions.BusinessRuleException;
import domain.repositories.OrderRepository;

import java.util.List;

public class CreateOrderUseCase {
    //Repositories
    OrderRepository orderRepository;

    //Constructor
    public CreateOrderUseCase(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    //Executor
    public Order execute(Client client, List<OrderItem> orderItems){
        try{
            Order newOrder = new Order(client);
            orderItems.forEach(newOrder::addItem);
            orderRepository.addOrder(newOrder);
            return newOrder;
        } catch (BusinessRuleException e){
            System.out.println(e.getMessage());
        }
        throw new BusinessRuleException("Error: Order couldn't  be added!");
    }
}
