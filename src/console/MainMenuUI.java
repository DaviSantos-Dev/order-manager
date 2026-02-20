package console;

import domain.entities.Client;
import domain.exceptions.BusinessRuleException;

public class MainMenuUI extends SystemUI {
    //Interfaces de Usuário
    private AuthUI authUI;
    private OrderUI orderUI;
    private ClientUI clientUI;
    private ProductUI productUI;

    //Construtor
    public MainMenuUI(ClientUI clientUI, AuthUI authUI, OrderUI orderUI,  ProductUI productUI) {
        this.authUI = authUI;
        this.orderUI = orderUI;
        this.clientUI = clientUI;
        this.productUI = productUI;
    }

    //Métodos
    public void start(){
        Client authenticatedUser = authUI.start();
        telaInicial(authenticatedUser);
    }

    public void telaInicial(Client user){
        boolean systemRunning = true;
        int option = 0;
        showTitle("Inicio do Sistema");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Criar Pedido");
        System.out.println("2 - Consultar meus Pedidos");
        System.out.println("3 - Ver produtos disponíveis");
        System.out.println("4 - Encerrar programa");
        separationRows();
        while (systemRunning){
            try {
        System.out.print("Sua opção: ");
                option = Integer.parseInt(scan.nextLine());
                switch(option){
                    case 1:
                        orderUI.createOrder(user);
                        break;
                    case 2:
                        orderUI.showOrder(user);
                        break;
                    case 3:
                        ;
                        break;
                    case 4:
                        systemRunning = false;
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Erro: 'Valor inválido'");
            } catch (BusinessRuleException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
