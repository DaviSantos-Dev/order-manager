package usecase.product;

import domain.entities.Client;
import domain.entities.Product;
import domain.enums.ClientType;
import domain.exceptions.BusinessRuleException;
import domain.repositories.ProductRepository;

public class DeleteProductUseCase {
    //Repositories
    private ProductRepository productRepository;

    //Constructor
    public DeleteProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Executor
    public void execute(Client client, Product product){
        if (client.getClientType().equals(ClientType.NON_USER)){
            throw new BusinessRuleException("Error: Non user can't delete product");
        }
        productRepository.deleteProduct(product);
    }
}
