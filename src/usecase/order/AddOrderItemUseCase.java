package usecase.order;

import domain.entities.OrderItem;
import domain.entities.Product;
import domain.exceptions.BusinessRuleException;
import domain.repositories.ProductRepository;

public class AddOrderItemUseCase {
    //Repositories
    ProductRepository productRepository;

    //Constructor
    public AddOrderItemUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Executor
    public OrderItem execute(int productCode, int quantity) {
        try{
            Product product = productRepository.searchById(productCode);
            OrderItem orderItem = new OrderItem(product, quantity);
            return orderItem;
        }
        catch (BusinessRuleException e){
            System.out.println("Error: " + e.getMessage());
        }
        throw new RuntimeException("Unexpected error.");
    }
}
