package console;

import domain.entities.Client;
import domain.entities.Product;
import domain.exceptions.BusinessRuleException;
import domain.repositories.ProductRepository;
import usecase.product.CreateProductUseCase;
import usecase.product.DeleteProductUseCase;
import usecase.product.UpdateProductUseCase;

import javax.swing.plaf.nimbus.NimbusStyle;

public class ProductUI extends SystemUI{
    //Repositories & Usecases
    private ProductRepository productRepository;
    private CreateProductUseCase createProductUseCase;
    private UpdateProductUseCase updateProductUseCase;
    private DeleteProductUseCase deleteProductUseCase;

    //Constructor
    public ProductUI(ProductRepository productRepository,  CreateProductUseCase createProductUseCase) {
        this.productRepository = productRepository;
        this.createProductUseCase = createProductUseCase;
    }

    //Métodos
    public void listProducts(){
        for (Product product: productRepository.listProducts()){
        System.out.println("ID: " + product.getIdProduto() + "Produto: " + product.getProductName() + "Quantidade: " + product.getProductQuantity());
        }
    }

    public void createProduct(){
        showTitle("Criação de Produto");
        try {
            System.out.println("Qual o nome do  produto?");
            String productName = scan.nextLine();
            System.out.println("Qual o preço desejado?");
            double productPrice = Double.parseDouble(scan.nextLine());
            System.out.println("Qual o quantidade Inicial?");
            int productQuantity = Integer.parseInt(scan.nextLine());
            createProductUseCase.execute(productName, productPrice, productQuantity);
        } catch (NumberFormatException e) {
            System.out.println("Error: Value format invallid");
        } catch (BusinessRuleException e) {
            System.out.println(e.getMessage());
        }

    }

    public void updateProduct(){
        showTitle("Alteração de Produto");
        try{
            System.out.println("Qual o ID do  produto?");
            Product product = productRepository.searchById(Integer.parseInt(scan.nextLine()));

            System.out.println("Deseja alterar o nome do produto? (Caso não, deixar vazio)");
            System.out.print("Resposta: ");
            String name = scan.nextLine();

            System.out.println("Deseja alterar o valor do produto? (Caso não, deixar vazio)");
            System.out.print("Resposta: ");
            double price = Double.parseDouble(scan.nextLine());

            System.out.println("Deseja desativar o produto? (S/N)");
            System.out.print("Resposta: ");
            boolean status = scan.nextLine() == "S";

            updateProductUseCase.execute(product, name, price, status);
        } catch (BusinessRuleException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Value format invallid");
        }
    }

    public void deleteProduct(Client client){
        showTitle("Exclusão de pedido");
        try{
            System.out.println("Qual o ID do  produto?");
            Product product = productRepository.searchById(Integer.parseInt(scan.nextLine()));
            deleteProductUseCase.execute(client, product);
        } catch (BusinessRuleException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Value format invallid");
        }
    }

    public void showProducts(Client client) {
        boolean ProductMenuRunning = true;
        int option;
        showTitle("Produtos disponíveis");
        listProducts();
        separationRows();
        while (ProductMenuRunning) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Criar novo produto");
            System.out.println("2 - Alterar produto");
            System.out.println("3 - Excluir produto");
            System.out.println("4 - Voltar para menu inicial");
            separationRows();
            try {
                System.out.print("Sua opção: ");
                option = Integer.parseInt(scan.nextLine());
                switch (option) {
                    case 1:
                        createProduct();
                        ProductMenuRunning = false;
                    case 2:
                        updateProduct();
                        ProductMenuRunning = false;
                    case 3:

                        break;
                    case 4:
                        ProductMenuRunning = false;
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid value, enter a number");
            } catch (BusinessRuleException e) {
                System.out.println("Error: Invalid value, enter a valid mumber");
            }
        }
    }

}
