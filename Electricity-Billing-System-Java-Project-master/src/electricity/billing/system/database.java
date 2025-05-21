package electricity.billing.system;

import java.sql.*;

public class database {
    Connection connection;
    Statement statement;

    public database() {
        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bill_system", "root", "snehar");

            // Create statement object
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
