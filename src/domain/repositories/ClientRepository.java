package domain.repositories;
import domain.entities.Client;

import java.util.List;

public interface ClientRepository {
    //Contrato
    void addClient(Client client);
    List<Client> listClients();
    Client searchById(int id);
    boolean emailExists(String email);
    void updateClient(Client client);
}

