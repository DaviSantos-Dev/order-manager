package console;

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


}
