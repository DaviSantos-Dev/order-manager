//Reponsável por gerar as interfaces para o terminal

package console;
import application.Main;
import domain.entities.ItemPedido;

import java.util.InputMismatchException;
import java.util.List;

public class SystemUi {
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
        return Main.scan.nextLine();
    }

    public String solicitarSenha(){
        System.out.print("Digite sua senha: ");
        return Main.scan.nextLine();
    }
    public int login(){
        mostrarTitulo("Login");
        System.out.println("Escolha sua opção:");
        System.out.println("1 - Entrar com seu usuário e senha");
        System.out.println("2 - Cadastrar novo usuário");
        System.out.println("3 - Fechar o programa");
        try{
            int opcao = Main.scan.nextInt();
            return opcao;
        } catch(InputMismatchException e){
            System.out.println("Opção inválida");
            return login();
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
            try {
                opcao = Integer.parseInt(Main.scan.nextLine());
                return opcao;
            } catch (InputMismatchException e) {
                System.out.println("Erro: 'Valor inválido'");
                return telaInicial();
            }
    }

    //Exibição de pedido
    public void mostrarPedido(List<ItemPedido> produtos){
        int index = 1;
        for (ItemPedido item : produtos){
            System.out.println("======================");
            System.out.println("Item Nº" + index + ":");
            System.out.println(item.toString());
            System.out.println("======================");
            index++;
        }
    }


}
