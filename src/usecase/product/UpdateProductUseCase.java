package usecase.product;

import domain.entities.Client;
import domain.entities.Product;
import domain.exceptions.BusinessRuleException;
import domain.repositories.ProductRepository;

public class UpdateProductUseCase {
    //Repositories
    private ProductRepository productRepository;

    //Constructor
    public UpdateProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Executor
    public void execute(Product product, String name, double price, boolean active){
        if(!active){
            product.desactivateProduct();
        }
        if (price <= 0){
            throw new BusinessRuleException("Error: Value must to be greater than zero.");
        } else{
            product.setProductPrice(price);
        }
        if (!name.isEmpty()){
            product.setProductName(name);
        }

    }
}
