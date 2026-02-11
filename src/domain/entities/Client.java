package domain.entities;
import domain.enums.ClientType;

public class Client {
    //Atributos
    private final int clientId;
    private String clientName;
    private ClientType clientType;

    //Construtor
    public Client(int id, String name, boolean vip){
        clientId = id + 1;
        clientName = name;
        activateVip(vip);
    }
    public Client(){
        this.clientId = 0;
        this.clientName = "Anonymous";
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

    //Metodos
    public void activateVip(boolean vip){
        if(clientType != ClientType.NON_USER){}
        clientType = (vip) ? ClientType.VIP : ClientType.NORMAL;
    }
}
