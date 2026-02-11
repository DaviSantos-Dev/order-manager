package domain.entities;
import domain.enums.ProductStatus;

public class Product {
    //Atributos
    private int productId;
    private String productName;
    private double productPrice;
    private int productQuantity;
    private ProductStatus productStatus;

    //Constructor
    public Product(String productName, double productPrice, int productQuantity){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productStatus = ProductStatus.ACTIVE;
    }
    public Product(String productName, double productPrice){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = 0;
        this.productStatus = ProductStatus.OUT_OF_STOCK;
    }

    //Getters e Setters
    public String getProductName(){
        return this.productName;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public int getIdProduto() {
        return productId;
    }
    public double getProductPrice(){
        return productPrice;
    }
    public int getProductQuantity(){
        return productQuantity;
    }
    public ProductStatus getStatusProduto(){
        return productStatus;
    }

    //Metodos
    public void decreaseQuantity(int quantity){
        if (quantity <= productQuantity) {
            productQuantity -= quantity;
        } else{
            throw new RuntimeException("Insufficient quantity");
        }
    }
    public void increaseQuantity(int quantity){
        productQuantity += quantity;
    }
}
