package infra;

import domain.entities.Product;
import domain.exceptions.BusinessRuleException;
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
        products.add(product);
        product.setIdProduto(nextId());
    }

    @Override
    public List<Product> listProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public Product searchById(int id) {
        for (Product product : products) {
            if (product.getIdProduto() == id){
                return product;
            }
        }
        throw new BusinessRuleException("Product not found");
    }

    @Override
    public List<Product> searchByName(String nome) {
        List<Product> newList = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(nome)){
                newList.add(product);
            }
        }
        return newList;
    }

    @Override
    public void deleteProduct(Product product) {
        products.remove(product);
    }

    private int nextId(){
        int currentId = 1;
        for (Product product : products) {
            if (product.getIdProduto() >= currentId){
                currentId = product.getIdProduto() + 1;
            }
        }
        return currentId;
    }
}
