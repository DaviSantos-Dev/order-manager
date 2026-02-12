//Nota: Inicialmente não existe o objetivo de se fazer uma authenticação avançada. apenas o simples, e-mail e senha.
package console;
import domain.entities.Client;
import domain.exceptions.BusinessRuleException;
import usecase.client.AuthClientUseCase;

import java.util.InputMismatchException;

public class AuthUI extends SystemUI {
    //Atributos
    AuthClientUseCase authClientUseCase;

    //Construtor
    public AuthUI(AuthClientUseCase authClientUseCase) {
        this.authClientUseCase = authClientUseCase;
    }

    public Client start(){
        boolean authClientIsrunning = true;
        while (authClientIsrunning) {
            showTitle("Formas de Login");
            System.out.println("Escolha sua opção:");
            System.out.println("1 - Entrar com seu usuário e senha");
            System.out.println("2 - Cadastrar novo usuário");
            System.out.println("3 - Entrar sem usuário");
            System.out.println("4 - Fechar o programa");
            System.out.print("Sua opção: ");
            try {
                int option = Integer.parseInt(scan.nextLine());
                switch (option) {
                    case 1:
                         return loginInterface();
                    case 2:
                        createUserUi();
                        break;
                    case 3:

                    case 4:
                        authClientIsrunning = false;
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
        throw new RuntimeException();
    }
    public Client loginInterface(){
        showTitle("Login");
        String email = enterEmail();
        String password = enterPassword();
        Client client;
        try {
            client = authClientUseCase.execute(email, password);
            return client;
        } catch (BusinessRuleException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
        throw new RuntimeException("Unexpected error: Bababoi");
    }



}
