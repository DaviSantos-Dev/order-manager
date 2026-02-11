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

