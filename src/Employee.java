public class Employee {
    private String firstName;
    private String lastName;
    private String position;
    private int employeeID;
    private int salary;
    private static int licznik = 0;

    public Employee(String firstName, String lastName, String position,  int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.employeeID = licznik++;
        this.salary = salary;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", employeeID=" + employeeID +
                ", salary=" + salary +
                '}';
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getSalary() {
        return salary;
    }

    public static int getLicznik() {
        return licznik;
    }

    public static void setLicznik(int licznik) {
        Employee.licznik = licznik;
    }
}