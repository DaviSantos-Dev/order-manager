package domain.repositories;
import domain.entities.Client;

import java.util.List;

public interface ClientRepository {
    //Contrato
    void addClient(Client client);
    List<Client> listClients();
    Client searchById(int id);
    List<Client> searchByName(String nome);
    int nextId();
    boolean emailExists(String email);
}

