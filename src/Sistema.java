import java.util.Scanner;

public class Sistema {
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
    public static void telaInicial(){
        mostrarTitulo("Inicio do Sistema");
        System.out.print("Digite seu nome: ");
        String nome = scan.nextLine();
        System.out.print("Deseja ser VIP(S/N)? ");
        String opcao = scan.nextLine();
    }

}
