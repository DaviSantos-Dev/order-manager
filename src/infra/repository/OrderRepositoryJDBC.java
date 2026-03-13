package infra.repository;

import domain.entities.Order;
import domain.repositories.OrderRepository;
import infra.db.DB;
import infra.db.DbException;

import java.sql.*;
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
        return  null;
    }

    @Override
    public Order searchById(int id) {
        return null;
    }

    @Override
    public List<Order> searchByClientId(int id) {
        return List.of();
    }
}
