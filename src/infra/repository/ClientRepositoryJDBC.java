package infra.repository;

import domain.entities.Client;
import domain.enums.ClientType;
import domain.repositories.ClientRepository;
import infra.db.DB;
import infra.db.DbException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryJDBC implements ClientRepository {

    @Override
    public void addClient(Client client) {
        try(Connection conn = DB.getConnection();
            PreparedStatement stt = conn.prepareStatement(
                    "INSERT INTO Clients " +
                    "(Name, Email, Password, Client_Type) " +
                    "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)){
            conn.setAutoCommit(false);

            stt.setString(1, client.getClientName());
            stt.setString(2, client.getClientEmail());
            stt.setString(3, client.getClientPassword());
            stt.setString(4, client.getClientType().toString());

            int rowsAffected = stt.executeUpdate();

            if(rowsAffected > 0){
                ResultSet rs = stt.getGeneratedKeys();
                System.out.printf("Done! The ID of %s is %d\n", client.getClientName(), rs.getInt(1));
            }
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public List<Client> listClients() {
        try(Connection conn = DB.getConnection();
            PreparedStatement stt = conn.prepareStatement("SELECT * FROM Clients");
            ResultSet rs = stt.executeQuery()){

            List<Client> clients = new ArrayList<>();
            while(rs.next()) {

                String name = rs.getString("Name");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                ClientType clientType = ClientType.valueOf(rs.getString("Client_Type").toUpperCase());

                clients.add(new Client(name, email, password, clientType));
            }
            return clients;
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Client searchById(int id) {
        try(Connection conn = DB.getConnection();
            PreparedStatement pst= conn.prepareStatement("SELECT * FROM clients WHERE id = ?")){
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            String name = rs.getString("Name");
            String email = rs.getString("Email");
            String password = rs.getString("Password");
            ClientType clientType = ClientType.valueOf(rs.getString("Client_Type").toUpperCase());


            Client client = new Client(name, email, password, clientType);
            client.setClientId(id);

            return client;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public boolean emailExists(String email) {
        return false;
    }

    @Override
    public void updateClient(Client client) {

    }

    @Override
    public void deleteClient(int id) {

    }
}
