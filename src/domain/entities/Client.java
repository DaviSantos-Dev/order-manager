package domain.entities;
import domain.enums.ClientType;

public class Client {
    //Atributos
    private final int clientId;
    private String clientName;
    private String clientEmail;
    private String clientPassword;
    private ClientType clientType;

    //Construtor
    public Client(int id, String name,String email, String password, boolean vip){
        clientId = id + 1;
        clientName = name;
        clientEmail = email;
        clientPassword = password;
        activateVip(vip);
    }
    public Client(){
        this.clientId = 0;
        this.clientName = "Anonymous";
        this.clientEmail = "empty";
        this.clientPassword = "empty";
        this.clientType = ClientType.NON_USER;
    }

    //Getters e Setters
    public int getClientId() {
        return clientId;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String nome){
        clientName = nome;
    }
    public ClientType getClientType() {
        return clientType;
    }
    public String getClientPassword() {
        return clientPassword;
    }
    public String getClientEmail() {
        return clientEmail;
    }

    //Metodos
    public void activateVip(boolean vip){
        if(clientType != ClientType.NON_USER){
            throw  new IllegalArgumentException("Sò é possível ativar VIP para clientes cadastrados");
        }
        clientType = (vip) ? ClientType.VIP : ClientType.NORMAL;
    }
    public String showClient(){
        return "Name: " + clientName + "ID: " + clientId + "\n" +
                "Email: " + clientEmail + "\n" +
                "Password: " + clientPassword;
    }

    //toString
    @Override
    public String toString() {
        return "ID: " + clientId + "\n" +
                "Name: " + clientName + "\n" +
                "Email: " + clientEmail + "\n" +
                "Password: " + clientPassword + "\n" +
                "VIP: " + (clientType == ClientType.VIP ? "Activated" : "Desactivated");
    }
}
