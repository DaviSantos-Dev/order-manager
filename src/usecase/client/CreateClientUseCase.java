package usecase.client;

import domain.entities.Client;
import domain.exceptions.BusinessRuleException;
import domain.repositories.ClientRepository;

public class CreateClientUseCase {
    //Repositories
    private final ClientRepository clientRepository;

    //Construtor
    public  CreateClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //Executor
    public Client execute(String clientName,String email,String password, boolean vip){
        int currentId = clientRepository.nextId();

        if(clientName == null || clientName.isBlank()){
            throw new BusinessRuleException("Client name cannot be empty");
        }
        if(password == null || password.isBlank()){
            throw new BusinessRuleException("Password cannot be empty");
        }
        if(!clientRepository.emailExists(email)){
            throw new BusinessRuleException("Email already exists");
        }
        Client client = new Client(currentId, clientName,email,  password, vip);
        clientRepository.addClient(client);

        return client;
    }
}
