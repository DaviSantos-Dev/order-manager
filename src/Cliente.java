public class Cliente extends ListaDeClientes{
    //Atributos
    private final int idCliente;
    private String nomeCliente;
    private String tipoCliente;

    //Construtor
    public Cliente (int id, String nome, boolean vip){
        idCliente = lastIdUser + 1;
        nomeCliente = nome;
        ativarVip(vip); // Usado o metodo para não permitir uma entrada diferente dos padrões do metodo
    }

    //Getters e Setters
    public int getIdCliente(){
        return idCliente;
    }
    public String getNomeCliente(){
        return nomeCliente;
    }
    public void setNomeCliente(String nome){
        nomeCliente = nome;
    }
    public String getTipoCliente(){
        return tipoCliente;
    }

    //Metodos
    public void ativarVip(boolean estado){
        tipoCliente = (estado) ? "Vip" : "Normal";
    }
}
