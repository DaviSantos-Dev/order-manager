package application;

import console.*;
import domain.entities.Client;
import domain.entities.Product;
import domain.repositories.ClientRepository;
import domain.repositories.OrderRepository;
import domain.repositories.ProductRepository;
import infra.ClientRepositoryInMemory;
import infra.OrderRepositoryInMemory;
import infra.ProductRepositoryInMemory;
import usecase.client.AuthClientUseCase;
import usecase.client.CreateClientUseCase;
import usecase.client.NonUserEntryUseCase;
import usecase.order.AddOrderItemUseCase;
import usecase.order.CreateOrderUseCase;
import usecase.order.DeleteOrderUseCase;
import usecase.product.CreateProductUseCase;
import usecase.product.DeleteProductUseCase;
import usecase.product.UpdateProductUseCase;

public class Main {

    public static void main(String[] args) {
        //Inicializando repositórios
        ClientRepository clientRepository = new ClientRepositoryInMemory();
        ProductRepository productRepository = new ProductRepositoryInMemory();
        OrderRepository orderRepository = new OrderRepositoryInMemory();

        //Adicionando user anônimo
        clientRepository.addClient(new Client());

        //Inicializando Usecases
        CreateClientUseCase newClient = new CreateClientUseCase(clientRepository);
        AuthClientUseCase authClient = new AuthClientUseCase(clientRepository);
        NonUserEntryUseCase nonUserEntry = new NonUserEntryUseCase(clientRepository);

        AddOrderItemUseCase addOrder = new AddOrderItemUseCase(productRepository);
        CreateOrderUseCase createOrder = new CreateOrderUseCase(orderRepository);
        DeleteOrderUseCase deleteOrder = new DeleteOrderUseCase(orderRepository);

        CreateProductUseCase  createProduct = new CreateProductUseCase(productRepository);
        DeleteProductUseCase deleteProduct = new DeleteProductUseCase(productRepository);
        UpdateProductUseCase updateProduct = new UpdateProductUseCase(productRepository);


        //Inicializando Ui
        ClientUI clientUI = new ClientUI(clientRepository, newClient);
        AuthUI authUI = new AuthUI(authClient, nonUserEntry, clientUI);
        OrderUI orderUI = new OrderUI(addOrder, createOrder, orderRepository, deleteOrder);
        ProductUI productUI = new ProductUI(productRepository, createProduct, updateProduct,  deleteProduct);
        MainMenuUI userInterface = new MainMenuUI(clientUI, authUI,orderUI, productUI);

        //Adicionando produtos iniciais
        productRepository.addProduct(new Product("Notebook Dell Inspiron", 3500.00, 10));
        productRepository.addProduct(new Product("Mouse Gamer Logitech", 150.90, 50));
        productRepository.addProduct(new Product("Teclado Mecânico Redragon", 320.50, 30));
        productRepository.addProduct(new Product("Monitor LG 24 Polegadas", 899.99, 15));
        productRepository.addProduct(new Product("Headset HyperX", 280.00, 25));
        productRepository.addProduct(new Product("SSD Kingston 480GB", 210.00, 40));
        productRepository.addProduct(new Product("HD Seagate 1TB", 250.00, 20));
        productRepository.addProduct(new Product("Placa de Vídeo RTX 3060", 2200.00, 5));
        productRepository.addProduct(new Product("Processador Ryzen 5 5600", 950.00, 12));
        productRepository.addProduct(new Product("Memória RAM 16GB DDR4", 380.00, 35));
        productRepository.addProduct(new Product("Gabinete Gamer", 420.00, 18));
        productRepository.addProduct(new Product("Fonte Corsair 650W", 520.00, 14));
        productRepository.addProduct(new Product("Cadeira Gamer", 780.00, 8));
        productRepository.addProduct(new Product("Smartphone Samsung Galaxy", 1800.00, 22));
        productRepository.addProduct(new Product("Carregador USB-C", 89.90, 60));
        productRepository.addProduct(new Product("Cabo HDMI", 45.00, 70));
        productRepository.addProduct(new Product("Webcam Full HD", 230.00, 16));
        productRepository.addProduct(new Product("Impressora HP", 650.00, 9));
        productRepository.addProduct(new Product("Roteador Wi-Fi", 190.00, 27));
        productRepository.addProduct(new Product("Tablet Lenovo", 1200.00, 11));

        //Iniciando Sistema
        userInterface.start();



        /*Criação produtos


        */
    }
}