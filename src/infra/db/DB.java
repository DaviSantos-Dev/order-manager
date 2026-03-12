package infra.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Properties prop = loadProperties();

    public static Connection getConnection(){
        try{
            String url = prop.getProperty("url");
            return DriverManager.getConnection(url, prop);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    private static void createDB(){
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            Statement stt = conn.createStatement()){
            //Coletando a query e separando por comandos para evitar erro
            String sql = Files.readString(Path.of("databaseCreation.sql"));
            String [] commands = sql.split(";");

            //Loop para executar todos comandos
            for (String cmd : commands){
                if(cmd.trim().isEmpty()){
                    try{
                        stt.executeQuery(cmd);
                    } catch (SQLException e){
                        throw new DbException("Falha ao executar: " + cmd);
                    }
                }

            }
            System.out.println("Database created");

        } catch (SQLException | IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    private static Properties loadProperties(){
        try(FileInputStream fls =  new FileInputStream("db.properties")){
            Properties prop = new Properties();
            prop.load(fls);
            return prop;

        } catch(IOException e){
            throw new DbException(e.getMessage());
        }
    }
}
