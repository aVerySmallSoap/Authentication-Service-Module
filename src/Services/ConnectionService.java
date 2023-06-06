package Services;

import Interfaces.IConnector;
import Interfaces.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionService implements Service, IConnector {

    private static ConnectionService instance;

    private ConnectionService(){}

    public static ConnectionService getInstance(){
        if(instance == null){
            instance = new ConnectionService();
        }
        return instance;
    }

    @Override
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String retrieveFromDB(String user) {
        return null;
    }

    @Override
    public void registerToDB(String pass, String salt){
        try{
            try(PreparedStatement pt = getConnection().prepareStatement("insert into salty (`password`,`salt`) values (?,?)")){
                pt.setObject(1, pass);
                pt.setObject(2, salt);
                pt.executeUpdate();
            }
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
