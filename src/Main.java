import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        HashMap<Integer,Employee> employeeHashMap = new HashMap<>();
        EmployeeManager employeeManager = new EmployeeManager(employeeHashMap);
        employeeManager.addEmployee("John", "Doe", "Manager", 75000);
        employeeManager.addEmployee("Jane", "Smith", "Accountant",  60000);
        employeeManager.addEmployee("Michael", "Johnson", "Accountant", 55000);
        employeeManager.addEmployee("Emily", "Jones", "Marketing Specialist", 50000);
        employeeManager.addEmployee("David", "Brown", "Accountant", 45000);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            System.out.println("1.Dodaj pracownika");
            System.out.println("2.Usuń pracownika");
            System.out.println("3.Zaktualizuj dane o pracowniku");
            System.out.println("4.Wyszukaj pracownika po ID");
            System.out.println("5.Wyświetl liste wszystkich pracownikow");
            System.out.println("6.Wyszukaj pracownika po pozycji");
            System.out.println("Inna wartosc zakonczy program");
            int input = Integer.parseInt(bufferedReader.readLine());
            switch (input){
                case 1:
                    String firstName;
                    String lastName;
                    String position1;
                    int salary;

                    Scanner scanner = new Scanner(System.in);

                    System.out.println("Podaj imię ");
                    firstName = scanner.next();
                    System.out.println("Podaj nazwisko");
                    lastName = scanner.next();
                    System.out.println("Podaj pozycję ");
                    position1 = scanner.next();
                    System.out.println("Podaj wynagrodzenie ");
                    salary = scanner.nextInt();

                    employeeManager.addEmployee(firstName, lastName, position1, salary);
                    break;
                case 2:
                {
                    int id = Integer.parseInt(bufferedReader.readLine());
                    employeeManager.removeEmployee(employeeManager.searchEmployeeByID(id));
                    break;
                }
                case 3:
                {
                    int id = Integer.parseInt(bufferedReader.readLine());
                    Employee employee = employeeManager.searchEmployeeByID(id);
                    if(employee != null){
                        employee.setSalary(10000);
                        employeeManager.updateEmployee(id,employee);}
                    break;

                }
                case 4:
                {
                    int id = Integer.parseInt(bufferedReader.readLine());
                    Employee employee = employeeManager.searchEmployeeByID(id);
                    System.out.println(employee);
                    break;
                }
                case 5:
                {
                    employeeManager.listAllEmployees();
                    break;
                }
                case 6:
                {
                    String position = bufferedReader.readLine();
                    HashSet<Employee> employeeHashSet = employeeManager.searchEmployeesByPosition(position);
                    for (Employee employee: employeeHashSet
                    ) {
                        System.out.println(employee);
                    }
                    break;

                }
                default:
                    System.exit(0);
            }
        }
    }
}