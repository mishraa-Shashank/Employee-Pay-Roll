import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Shashank
 */
public class DataBaseConnection {
    public static void main(String[] args) {
        System.out.println("Welcome Employee payroll program");
        /**
         * connecting database using java
         */
        String jdbcUrl = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "Kirti";
        Connection connection;
        /*
        using try catch block to handle the exception
         */
        try {
            System.out.println("Connecting to database: "+jdbcUrl);
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            System.out.println("Connection is successful "+connection);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}