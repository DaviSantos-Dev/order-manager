package usecase;

import domain.entities.Client;
import domain.exceptions.BusinessRuleException;
import domain.repositories.ClientRepository;

public class CreateClientUseCase {
    //Atributos
    private final ClientRepository clientRepository;

    //Construtor
    public  CreateClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client execute(String clientName,String password, boolean vip){
        int currentId = clientRepository.nextId();

        if(clientName == null || clientName.isEmpty() || clientName.isBlank()){
            throw new BusinessRuleException("Client name cannot be empty");
        }
        if(!clientRepository.passwordValidation(password)){
            throw new BusinessRuleException("Password already exists");
        }
        Client client = new Client(currentId, clientName, password, vip);
        clientRepository.addClient(client);

        return client;
    }
}
