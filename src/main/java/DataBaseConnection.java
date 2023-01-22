import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shashank
 */
public class DataBaseConnection {
    List<Employee> empList;

    /**
     * created a  getConnection() method to connecting database using java
     */
    public Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "Kirti";
        Connection connection;
        System.out.println("Connecting to database: " + jdbcUrl);
        connection = DriverManager.getConnection(jdbcUrl, userName, password);
        System.out.println("Connection is successful " + connection);
        return connection;
    }

    /**
     * created a method to get the data
     * @param resultSet - will result a set
     * @throws SQLException - throes a sql exception
     */
    public void getData(ResultSet resultSet) throws SQLException {
        empList = new ArrayList<>();
        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("ID"));
            employee.setName(resultSet.getString("Name"));
            employee.setSalary(resultSet.getDouble("Salary"));
            employee.setDate(resultSet.getDate("Start").toLocalDate());

            empList.add(employee);
        }
    }

    /**
     * created a method to retrieve data from the database
     */
    public void retrieveData() {
        empList = new ArrayList<>();
        /*
        using try catch block to handle the exception
         */
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "Select * from employee_payroll";
            ResultSet resultSet = statement.executeQuery(sql);
            getData(resultSet);
            empList.forEach(System.out::println);
            System.out.println("Data Retrieve Successfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.retrieveData();
    }
}