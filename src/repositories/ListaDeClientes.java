//Cria e lista usuários, e também define o id do usuário (repositories)

package repositories;
import domain.entities.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ListaDeClientes {
    //Atributos
    protected List<Cliente> clientes = new ArrayList<>();
    protected int lastIdUser = 0;

    //Metodos
    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }
}
