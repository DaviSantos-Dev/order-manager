package console;

import domain.entities.Client;
import domain.repositories.ClientRepository;
import usecase.client.CreateClientUseCase;

public class ClientUI extends SystemUI{
    //Repositories
    private ClientRepository clientRepository;

    //Usecases
    private CreateClientUseCase createClient;

    //Constructor
    public ClientUI(ClientRepository clientRepository,  CreateClientUseCase createClient) {
        this.clientRepository = clientRepository;
        this.createClient = createClient;
    }

    //Executor
    public void start(){

    }
    public Client createUser(){
        String newName = enterName();
        String newEmail = enterEmail();
        String newPassword = enterPassword();

        Client client = createClient.execute(newName, newEmail, newPassword, false);
        return client;
    }
}
