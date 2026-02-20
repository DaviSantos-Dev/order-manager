package domain.repositories;

import domain.entities.Product;

import java.util.List;

public interface ProductRepository {
    //Contrato
    void addProduct(Product product);
    List<Product> listProducts();
    Product searchById(int id);
    List<Product> searchByName(String nome);
    void deleteProduct(Product product);
}

