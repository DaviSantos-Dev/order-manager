package console;

import domain.entities.Client;
import domain.entities.Order;
import domain.entities.OrderItem;
import domain.exceptions.BusinessRuleException;
import domain.repositories.OrderRepository;
import usecase.order.AddOrderItemUseCase;
import usecase.order.CreateOrderUseCase;
import usecase.order.DeleteOrderUseCase;

import java.util.ArrayList;
import java.util.List;

public class OrderUI extends SystemUI {
    //Atributos
    AddOrderItemUseCase addOrderItem;
    CreateOrderUseCase createOrder;
    OrderRepository orderRepository;
    DeleteOrderUseCase deleteOrder;

    //Construtor
    public OrderUI(AddOrderItemUseCase addOrderItem, CreateOrderUseCase createOrder, OrderRepository orderRepository, DeleteOrderUseCase deleteOrder) {
        this.addOrderItem = addOrderItem;
        this.createOrder = createOrder;
        this.orderRepository = orderRepository;
        this.deleteOrder = deleteOrder;
    }

    //Métodos
    public void showOrderItems(List<OrderItem> produtos){
        int index = 1;
        for (OrderItem item : produtos){
            System.out.println("======================");
            System.out.println("Item Nº" + index + ":");
            System.out.println(item.toString());
            System.out.println("======================");
            index++;
        }
    }

    public void listOrders(Client client){
        for (Order order: orderRepository.listOrders()){
            if (order.getClient().equals(client)){
                System.out.println("ID: " + order.getOrderId() + "Status: " + order.getOrderStatus());
            }
        }
    }

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

    public void deleteOrder(Client client) {
        showTitle("Chose the Order to Delete");
        int orderToDelete = enterProductCode();
        try{
            deleteOrder.execute(client, orderToDelete);
        }catch (BusinessRuleException e){
            System.out.println(e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Unexpected error occurred.");
        }
    }

    public void showOrder(Client client){
        boolean orderMenuRunning = true;
        int option;
        showTitle("Seus pedidos");
        listOrders(client);
        separationRows();
        while (orderMenuRunning) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Criar novo pedido");
            System.out.println("2 - Excluir pedido");
            System.out.println("3 - Voltar para menu inicial");
            separationRows();
            try {
                System.out.print("Sua opção: ");
                option = Integer.parseInt(scan.nextLine());
                switch (option) {
                    case 1:
                        createOrder(client);
                        orderMenuRunning = false;
                        break;
                    case 2:
                        deleteOrder(client);
                        break;
                    case 3:
                        orderMenuRunning = false;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid value, enter a number");
            } catch (BusinessRuleException e) {
                System.out.println("Error: Invalid value, enter a valid mumber");
            }
        }
    }
}