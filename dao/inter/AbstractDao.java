package database.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

public class AbstractDao {
    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/resume";
            String username = "****";
            String password = "********";
            Connection connection = DriverManager.getConnection(url,username,password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
