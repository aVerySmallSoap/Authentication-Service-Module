package Interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnector {
    Connection getConnection() throws SQLException;
//    boolean registerToDB(String pass, String salt)throws SQLException;
}
