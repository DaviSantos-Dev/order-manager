package usecase;

import domain.entities.Client;
import domain.exceptions.BusinessRuleException;
import domain.repositories.ClientRepository;

import java.util.List;

public class AuthClientUseCase {
    //Atributos
    private final ClientRepository clientRepository;

    //Construtor
    public AuthClientUseCase(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    //Executor
    public Client execute(String email, String password) {
        List<Client> clients = clientRepository.listClients();
        for (Client client : clients) {
            if (client.getClientEmail().equals(email) && client.getClientPassword().equals(password)) {
                return client;
            }
        }
        throw new BusinessRuleException("Email or password incorrect, please try again");
    }
}
