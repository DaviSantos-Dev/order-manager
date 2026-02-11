package console;
import domain.entities.OrderItem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SystemUi {
    public static Scanner scan = new Scanner(System.in);

    //Padrões para criação de telas
    public void linhasDeSeparacao(){
        System.out.println("======================");
    }
    public void mostrarTitulo(String titulo){
        linhasDeSeparacao();
        System.out.println(titulo);
        linhasDeSeparacao();
    }

    //Criando telas para funcionamento do sistema
    public String solicitarNome() {
        System.out.print("Digite seu nome: ");
        return scan.nextLine();
    }

    public String solicitarSenha(){
        System.out.print("Digite sua senha: ");
        return scan.nextLine();
    }
    public int login(){
        mostrarTitulo("Login");
        System.out.println("Escolha sua opção:");
        System.out.println("1 - Entrar com seu usuário e senha");
        System.out.println("2 - Cadastrar novo usuário");
        System.out.println("3 - Fechar o programa");
        while (true) {
            try {
                int opcao = scan.nextInt();
                return opcao;
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida");
            }
        }
    }
    public void cadastrarUsuario(){
        String novoNome = solicitarNome();
        String novoSenha = solicitarSenha();
        //Restante da implementação com usecase
    }

    public int telaInicial(){
        int opcao = 0;
        mostrarTitulo("Inicio do Sistema");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Criar Pedido");
        System.out.println("2 - Consultar Pedido");
        System.out.println("3 - Encerrar programa");
        linhasDeSeparacao();
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


}
