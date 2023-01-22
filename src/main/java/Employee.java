import java.time.LocalDate;

/**
 * @author Shashank
 */
public class Employee {
    /**
     * 1) declaring variables
     * 2) using getters & setters to get & set the values of variables
     * 3) using toString() method to print the data
     */

    /*
    1) declaring variables
     */
    private int id;
    private String name;
    private double salary;
    private LocalDate date;

    /*
    2) using getters & setters to get & set the values of variables
     */
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /*
    3) using toString() method to print the data
     */
    @Override
    public String toString() {
        return "Employee { " +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", salary = " + salary +
                ", date = " + date +
                '}';
    }
}
