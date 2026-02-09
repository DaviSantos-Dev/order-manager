//Reponsável por gerar as interfaces para o terminal

package console;
import domain.entities.ItemPedido;

import java.util.List;
import java.util.Scanner;

public class SystemUi {
    static Scanner scan = new Scanner(System.in);
    //Padrões para criação de telas
    public static void linhasDeSeparacao(){
        System.out.println("======================");
    }
    public static void mostrarTitulo(String titulo){
        linhasDeSeparacao();
        System.out.println(titulo);
        linhasDeSeparacao();
    }

    //Criando telas para funcionamento do sistema
    public static void telaDeLogin() {
        mostrarTitulo("Inicio do Sistema");
        System.out.print("Digite seu nome: ");
        String nome = scan.nextLine();
        if (!nome.isEmpty()) {
            System.out.print("Deseja ser VIP(S/N)? ");
            String opcao = scan.nextLine();
        }
    }

    //Não sei ainda
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
