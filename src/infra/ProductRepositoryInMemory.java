package infra;

import domain.entities.Product;
import domain.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryInMemory implements ProductRepository {
    //Atributos
    private List<Product> products = new ArrayList<>();

    //Construtor
    public ProductRepositoryInMemory() {} //Sempre deve ser instanciado vazio.

    //Métodos
    @Override
    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public List<Product> listProducts() {
        return List.of();
    }

    @Override
    public Product searchById(int id) {
        for (Product product : products) {
            if (product.getIdProduto() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> searchByName(String nome) {
        List<Product> newList = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductName().toLowerCase().equals(nome.toLowerCase())){
                newList.add(product);
            }
        }
        return newList;
    }
}
