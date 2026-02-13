package domain.entities;

public class OrderItem {
    //Atributos
    private Product product;
    private int quantity;

    //Construtor
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    //Getters e Setters
    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Metodos
    public double calculateSubTotal(){
        return product.getProductPrice() * quantity;
    }

    //ToString
    @Override
    public String toString(){
        return "Product: " + product.getProductName() + "\n" +
                "Quantity: " + quantity;
    }
}
