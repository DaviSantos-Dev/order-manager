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
    public void setIdProduto(int productId) {
        this.productId = productId;
    }
    public double getProductPrice(){
        return productPrice;
    }
    public void setProductPrice(double productPrice){
        this.productPrice = productPrice;
    }
    public int getProductQuantity(){
        return productQuantity;
    }
    public ProductStatus getStatusProduto(){
        return productStatus;
    }

    //Métodos
    public void decreaseQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("A quantidade deve maior que zero");
        }
        if (productQuantity < quantity) {
            throw new IllegalStateException("Insufficient quantity");
        }
        if (productQuantity == quantity) {
            productQuantity -= quantity;
            productStatus = ProductStatus.OUT_OF_STOCK;
        }else {
            productQuantity -= quantity;
        }
    }

    public void increaseQuantity(int quantity){
        if (productQuantity == 0) {
            productQuantity += quantity;
            productStatus = ProductStatus.ACTIVE;
        }
        productQuantity += quantity;
    }

    public void desactivateProduct(){
        productStatus = ProductStatus.INACTIVE;
    }

    @Override
    public String toString(){
        return "ID: " + productId +
                "\nProduct Name: " + productName + " - Price: R$" + productPrice
                + "\nQuantity: " + productQuantity;
    }
}
