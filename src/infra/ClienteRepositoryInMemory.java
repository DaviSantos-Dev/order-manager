package infra;

import domain.entities.Cliente;
import domain.repositories.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryInMemory implements ClienteRepository {
    //Atributos
    private List<Cliente> clientes = new ArrayList<>();

    //Construtor
    public ClienteRepositoryInMemory() {} //Sempre deve ser instanciado vazio.


    //Métodos
    @Override
    public void adicionar(Cliente cliente) {
        this.clientes.add(cliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return List.of();
    }

    @Override
    public Cliente buscarPorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == id) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> buscarPorNome(String nome) {
        List<Cliente> newList = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getNomeCliente().equals(nome)) {
                newList.add(cliente);
            }
        }
        return newList;
    }
}
