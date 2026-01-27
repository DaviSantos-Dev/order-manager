// Cria um objeto cliente, e define suas permissões (domain?)

package domain.entities;
import domain.Enums.TipoCliente;

public class Cliente{
    //Atributos
    private final int idCliente;
    private String nomeCliente;
    private TipoCliente tipoCliente;

    //Construtor
    public Cliente (int id, String nome, boolean vip){
        idCliente = id + 1;
        nomeCliente = nome;
        ativarVip(vip); // Usado o metodo para não permitir uma entrada diferente dos padrões do metodo
    }
    public Cliente(){
        this.idCliente = 0;
        this.nomeCliente = "Anônimo";
        this.tipoCliente = TipoCliente.NON_USER;
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
    public TipoCliente getTipoCliente(){
        return tipoCliente;
    }

    //Metodos
    public void ativarVip(boolean estado){
        tipoCliente = (estado) ? TipoCliente.VIP : TipoCliente.NORMAL;
    }
}
