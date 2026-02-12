package console;
import domain.entities.Client;
import domain.entities.OrderItem;

import java.util.List;
import java.util.Scanner;

public abstract class SystemUI {
    protected static Scanner scan = new Scanner(System.in);

    //Padrões para criação de telas
    public void separationRows(){
        System.out.println("======================");
    }
    public void showTitle(String titulo){
        separationRows();
        System.out.println(titulo);
        separationRows();
    }

    //Clients I/O
    public String enterName() {
        System.out.print("Digite seu nome: ");
        return scan.nextLine();
    }

    public String enterEmail() {
        System.out.print("Digite seu email: ");
        return scan.nextLine();
    }

    public String enterPassword(){
        System.out.print("Digite sua senha: ");
        return scan.nextLine();
    }
    public void createUserUi(){
        String novoNome = enterName();
        String novoSenha = enterPassword();
    }

    //Orders I/O
    public String enterProductName(){
        System.out.print("Qual produto deseja? ");
        return scan.nextLine();
    }
    public int enterProductCode(){
        System.out.println("Digite o código do produto que deseja: ");
        return Integer.parseInt(scan.nextLine());
    }
    public int enterQuantity(){
        System.out.print("Quantos deseja? ");
        return Integer.parseInt(scan.nextLine());
    }


    //Exibição de pedido
    public void mostrarPedido(List<OrderItem> produtos){
        int index = 1;
        for (OrderItem item : produtos){
            System.out.println("======================");
            System.out.println("Item Nº" + index + ":");
            System.out.println(item.toString());
            System.out.println("======================");
            index++;
        }
    }

    //Telas de criação
    public void clientCreated(Client client){
        System.out.printf("O usuario de cliente: %s, foi criado com sucesso \n", client);
    }


}
