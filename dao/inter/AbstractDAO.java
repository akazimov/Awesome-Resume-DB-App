package dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

public class AbstractDAO {
    public static Connection connect() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/resume";
            String username = "********";
            String password = "********";
            return DriverManager.getConnection(url,username,password);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
