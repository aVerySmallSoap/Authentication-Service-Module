package Services;

import Interfaces.IConnector;
import Interfaces.Service;

import java.sql.Connection;
import java.sql.DriverManager;
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

//    @Override
//    public boolean registerToDB(String pass, String salt){
//        try{
//            System.out.println("A");
//            return true;
//        }catch (SQLException e){
//            throw new RuntimeException(e.getMessage());
//        }
//    }
}
