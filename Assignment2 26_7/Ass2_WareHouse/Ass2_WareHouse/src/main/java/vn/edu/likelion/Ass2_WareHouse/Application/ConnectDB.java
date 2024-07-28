package vn.edu.likelion.Ass2_WareHouse.Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    private String url;
    private String user;
    private String pass;
    private Connection connection;

    public ConnectDB() {
        url = "jdbc:oracle:thin:@localhost:1521:orcl21";
        user = "C##sa";
        pass = "123456";
    }

    public Connection openConnection() throws SQLException {
        connection = DriverManager.getConnection(url, user, pass);
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null) connection.close();
    }

    public Connection getConnection() {
        return connection;
    }
}
