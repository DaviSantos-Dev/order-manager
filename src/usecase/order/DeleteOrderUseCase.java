package usecase.order;

import domain.entities.Client;
import domain.entities.Order;
import domain.exceptions.BusinessRuleException;
import domain.repositories.OrderRepository;

public class DeleteOrderUseCase {
    //Repositories
    private OrderRepository orderRepository;

    //Constructor
    public DeleteOrderUseCase(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    //Executor
    public void execute(Client client, int orderId) {
        Order order = orderRepository.searchById(orderId);
        if (client.equals(order.getClient())) {
            orderRepository.deleteOrder(order);
        } else {
            throw new BusinessRuleException("Error: You can't delete this order");
        }
    }

}
