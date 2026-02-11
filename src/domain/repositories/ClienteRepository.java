package domain.repositories;
import domain.entities.Cliente;

import java.util.List;

public interface ClienteRepository {
    //Contrato
    void adicionar(Cliente cliente);
    List<Cliente> listarClientes();
    Cliente buscarPorId(int id);
    List<Cliente> buscarPorNome(String nome);
}
/*public class ClienteRepository {
    //Atributos
    private List<Cliente> clientes = new ArrayList<>();
    private int lastId = 0;

    //Getters e Setters
    public int getLastIdUser() {
        return lastId;
    }
    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }

    //Metodos
    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }
    public Cliente buscarPorId(int id){
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == id) {
                return cliente;
            }
        }
        return null;
    }
    public List<Cliente> buscarPorNome(String nome){
        List<Cliente> newList = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getNomeCliente().equals(nome)) {
                newList.add(cliente);
            }
        }
        return newList;
    }
}*/
