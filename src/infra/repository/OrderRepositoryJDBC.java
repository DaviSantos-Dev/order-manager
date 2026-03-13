package infra.repository;

import domain.entities.Client;
import domain.entities.Order;
import domain.repositories.OrderRepository;
import infra.db.DB;
import infra.db.DbException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryJDBC implements OrderRepository {

    @Override
    public void addOrder(Order order) {
        try(Connection conn = DB.getConnection();
            PreparedStatement stt = conn.prepareStatement(
                    "INSERT INTO orders (Client_Id, Order_Status) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)){

            stt.setInt(1, order.getClient().getClientId());
            stt.setString(2, order.getOrderStatus().name());

            int rowsAffected = stt.executeUpdate();
            if (rowsAffected == 0) {
                throw new DbException("Error while inserting order");
            }
            try(ResultSet rs = stt.getGeneratedKeys()) {
                if(rs.next()) {
                    order.setOrderId(rs.getInt(1));
                }
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public List<Order> listOrders() {
        List<Order> orders = new ArrayList<>();
        try(Connection conn = DB.getConnection();
            PreparedStatement stt = conn.prepareStatement(
            "SELECT o.Id as Order_Id, " +
                "c.Name as Client_Name, " +
                "c.Email as Client_Email, " +
                "c.Password as Client_Password, " +
                "o.Status as Order_Status " +
                "From Orders as o " +
                "JOIN Clients as c " +
                "ON o.Client_Id = c.Id");
            ResultSet rs = stt.executeQuery()){

            while(rs.next()){
                Order order = mapOrder(rs);
                orders.add(order);
            }
            return   orders;
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Order searchById(int id) {
        Order order = null;
        try(Connection conn = DB.getConnection();
            PreparedStatement stt = conn.prepareStatement(
            "SELECT o.Id as Order_Id, " +
                "c.Name as Client_Name, " +
                "c.Email as Client_Email, " +
                "c.Password as Client_Password, " +
                "o.Status as Order_Status " +
                "From Orders as o " +
                "JOIN Clients as c " +
                "ON o.Client_Id = c.Id " +
                "WHERE o.Id = ?")){

            stt.setInt(1, id);

            try (ResultSet rs = stt.executeQuery()){
                if (rs.next()){
                    order = mapOrder(rs);
                }
            }
            return order;
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public List<Order> searchByClientId(int id) {
        List<Order> orders = new ArrayList<>();
        try(Connection conn = DB.getConnection();
            PreparedStatement stt = conn.prepareStatement(
            "SELECT o.Id as Order_Id, " +
                "c.Name as Client_Name, " +
                "c.Email as Client_Email, " +
                "c.Password as Client_Password, " +
                "o.Status as Order_Status " +
                "From Orders as o " +
                "JOIN Clients as c " +
                "ON o.Client_Id = c.Id " +
                "WHERE c.Id = ?")){

            stt.setInt(1, id);

            try (ResultSet rs = stt.executeQuery()){
                while (rs.next()){
                    orders.add(mapOrder(rs));
                }
            }
            return orders;
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    private Order mapOrder(ResultSet rs){
        try {
            String clientName = rs.getString("Client_Name");
            String clientEmail = rs.getString("Client_Email");
            String clientPassword = rs.getString("Client_Password");
            Client client = new Client(clientName, clientEmail, clientPassword);

            Order order = new Order(client);
            String status = rs.getString("Order_Status");
            if (status.equals("PAID")) {
                order.payOrder();
            }
            else if (status.equals("CANCELED")) {
                order.cancelOrder();
            }

            order.setOrderId(rs.getInt("Order_Id"));

            return order;
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
    }

}