package application;

import console.AuthUI;
import console.ClientUI;
import console.MainMenuUI;
import console.OrderUI;
import domain.entities.Client;
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

        AddOrderItemUseCase addOrder = new AddOrderItemUseCase(productRepository);
        CreateOrderUseCase createOrder = new CreateOrderUseCase(orderRepository);
        NonUserEntryUseCase nonUserEntry = new NonUserEntryUseCase(clientRepository);

        //Inicializando Ui
        ClientUI clientUI = new ClientUI(clientRepository, newClient);
        AuthUI authUI = new AuthUI(authClient, nonUserEntry, clientUI);
        OrderUI orderUI = new OrderUI(addOrder, createOrder);
        MainMenuUI userInterface = new MainMenuUI(clientUI, authUI,orderUI);

        //Iniciando Sistema
        userInterface.start();



        /*Criando produtos
        ("Notebook Dell Inspiron", 3500.00, 10);
        ("Mouse Gamer Logitech", 150.90, 50);
        ("Teclado Mecânico Redragon", 320.50, 30);
        ("Monitor LG 24 Polegadas", 899.99, 15);
        ("Headset HyperX", 280.00, 25);
        ("SSD Kingston 480GB", 210.00, 40);
        ("HD Seagate 1TB", 250.00, 20);
        ("Placa de Vídeo RTX 3060", 2200.00, 5);
        ("Processador Ryzen 5 5600", 950.00, 12);
        ("Memória RAM 16GB DDR4", 380.00, 35);
        ("Gabinete Gamer", 420.00, 18);
        ("Fonte Corsair 650W", 520.00, 14);
        ("Cadeira Gamer", 780.00, 8);
        ("Smartphone Samsung Galaxy", 1800.00, 22);
        ("Carregador USB-C", 89.90, 60);
        ("Cabo HDMI", 45.00, 70);
        ("Webcam Full HD", 230.00, 16);
        ("Impressora HP", 650.00, 9);
        ("Roteador Wi-Fi", 190.00, 27);
        ("Tablet Lenovo", 1200.00, 11);

        */
    }
}