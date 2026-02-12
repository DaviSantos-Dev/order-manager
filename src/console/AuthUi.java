//Nota: Inicialmente não existe o objetivo de se fazer uma authenticação avançada. apenas o simples, e-mail e senha.
package console;
import domain.entities.Client;
import domain.exceptions.BusinessRuleException;
import usecase.AuthClientUseCase;

import java.util.InputMismatchException;

public class AuthUi extends SystemUi{
    //Atributos
    AuthClientUseCase authClient;

    //Construtor
    public AuthUi(AuthClientUseCase authClient) {
        this.authClient = authClient;
    }

    public void initialize(){
        boolean systemRunning = true;
        while (systemRunning) {
            showTitle("Formas de Login");
            System.out.println("Escolha sua opção:");
            System.out.println("1 - Entrar com seu usuário e senha");
            System.out.println("2 - Cadastrar novo usuário");
            System.out.println("3 - Fechar o programa");
            System.out.print("Sua opção: ");
            try {
                int option = Integer.parseInt(scan.nextLine());
                switch (option) {
                    case 1:
                        loginInterface();
                        break;
                    case 2:
                        createUserUi();
                        break;
                    case 3:
                        systemRunning = false;
                        break;
                    default:
                        System.out.println("Invallid option");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invallid option");
            }
            catch (NumberFormatException e) {
                System.out.println("Only numbers can be accepted");
            }
        }
    }
    public void loginInterface(){
        showTitle("Login");
        String email = enterEmail();
        String password = enterPassword();
        try {
            Client client = authClient.execute(email, password);

        } catch (BusinessRuleException e) {
            System.out.println(e.getMessage());
        }
    }



}
