package console;

import domain.entities.Client;
import domain.entities.Order;
import domain.entities.OrderItem;
import domain.exceptions.BusinessRuleException;
import usecase.order.AddOrderItemUseCase;
import usecase.order.CreateOrderUseCase;

import java.util.ArrayList;
import java.util.List;

public class OrderUI extends SystemUI {
    //Atributos
    AddOrderItemUseCase addOrderItem;
    CreateOrderUseCase createOrder;

    //Construtor
    public OrderUI(AddOrderItemUseCase addOrderItem, CreateOrderUseCase createOrder) {
        this.addOrderItem = addOrderItem;
        this.createOrder = createOrder;
    }

    //Métodos
    public void createOrder(Client client) {
        int orderItemId = 0;
        List<OrderItem> items = new ArrayList<>();
        while (true) {
            int productCode = enterProductCode();
            int quantity = enterQuantity();
            items.add(addOrderItem.execute(productCode, quantity));
            System.out.println("Produto adicionado com sucesso");
            System.out.println("Deseja continuar? (S/N)");
            String option = scan.nextLine();
            if (option.equals("N")) {
                break;
            }
        }try {
            Order order = createOrder.execute(client, items);
            System.out.printf("Order nº %d succesfully created!%n", order.getOrderId());
        } catch (BusinessRuleException e){
            System.out.println(e.getMessage());
        }
    }
}