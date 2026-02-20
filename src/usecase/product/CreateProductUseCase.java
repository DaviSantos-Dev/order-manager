package usecase.product;

import domain.entities.Client;
import domain.entities.Product;
import domain.exceptions.BusinessRuleException;
import domain.repositories.ProductRepository;

public class CreateProductUseCase {
    //Repositories
    private ProductRepository productRepository;

    //Constructor
    public CreateProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Executor
    public void execute(String name, double price, int quantity) {
        if (price <= 0) {
            throw new BusinessRuleException("Price must be greater than zero");
        }
        if (quantity < 0) {
            throw new BusinessRuleException("Quantity can't be negative");
        }
        if (name.isBlank()) {
            throw new BusinessRuleException("Product name can't be empty");
        }
        if (quantity == 0) {
            productRepository.addProduct(new Product(name, price));
        } else {
            productRepository.addProduct(new Product(name, price, quantity));
        }
    }
}
