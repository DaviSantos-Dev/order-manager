//Cria e lista usuários, e também define o id do usuário

package repositories;
import domain.entities.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ListaDeClientes {
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
}
