package usecase.client;

import domain.entities.Client;
import domain.repositories.ClientRepository;

public class NonUserEntryUseCase {
    //Repositories
    ClientRepository clientRepository;

    //Constructor
    public NonUserEntryUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //Executor
    public Client execute(){
        Client client =  clientRepository.searchById(0);
        return client;
    }
}
