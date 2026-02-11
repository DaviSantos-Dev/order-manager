package infra;

import domain.entities.Client;
import domain.repositories.ClientRepository;

import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryInMemory implements ClientRepository {
    //Atributos
    private List<Client> clients = new ArrayList<>();

    //Construtor
    public ClientRepositoryInMemory() {} //Sempre deve ser instanciado vazio.


    //Métodos
    @Override
    public void addClient(Client client) {
        this.clients.add(client);
    }

    @Override
    public List<Client> listClients() {
        return List.of();
    }

    @Override
    public Client searchById(int id) {
        for (Client client : clients) {
            if (client.getClientId() == id) {
                return client;
            }
        }
        return null;
    }

    @Override
    public List<Client> searchByName(String nome) {
        List<Client> newList = new ArrayList<>();
        for (Client client : clients) {
            if (client.getClientName().equals(nome)) {
                newList.add(client);
            }
        }
        return newList;
    }

    @Override
    public int nextId(){
        int nextId = 1;
        for (Client client : clients) {
            if (client.getClientId() >= nextId){
                nextId = client.getClientId() + 1;
            }
        }
        return nextId;
    }

    @Override
    public boolean passwordValidation(String password){
        for (Client client : clients) {
            if (client.getClientPassword().equals(password)){
                return false;
            }
        }
        return true;
    }
}
