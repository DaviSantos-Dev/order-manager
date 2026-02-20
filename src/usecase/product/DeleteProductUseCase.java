package usecase.product;

import domain.entities.Client;
import domain.entities.Product;
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

    }
}
