package console;
import domain.entities.Client;
import domain.entities.OrderItem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public abstract class SystemUi {
    public static Scanner scan = new Scanner(System.in);

    //Padrões para criação de telas
    public void separationRows(){
        System.out.println("======================");
    }
    public void showTitle(String titulo){
        separationRows();
        System.out.println(titulo);
        separationRows();
    }

    //Padrões de I/O
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

    public int telaInicial(){
        int opcao = 0;
        showTitle("Inicio do Sistema");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Criar Pedido");
        System.out.println("2 - Consultar Pedido");
        System.out.println("3 - Encerrar programa");
        separationRows();
        System.out.print("Sua opção: ");
        while (true){
            try {
                opcao = Integer.parseInt(scan.nextLine());
                return opcao;
            } catch (InputMismatchException e) {
                System.out.println("Erro: 'Valor inválido'");
            }
        }
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
