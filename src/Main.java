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
            System.out.println("4.Wyszukaj pracownika po pozycji");
            System.out.println("5.Wyświetl liste wszystkich pracownikow");
            System.out.println("Inna wartosc zakonczy program");
            int input = Integer.parseInt(bufferedReader.readLine());
            Scanner scanner = new Scanner(System.in);

            switch (input){
                case 1:
                    String firstName;
                    String lastName;
                    String position1;
                    int salary;


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
                    System.out.println("Podaj id");
                    int id = Integer.parseInt(bufferedReader.readLine());
                    String position;
                    Employee newEmployee = employeeManager.searchEmployeeByID(id);
                    System.out.println(" Podaj nową pozycję ");
                    String inputPosition = scanner.next();
                    if(!inputPosition.isEmpty()) {
                        position = inputPosition;
                        newEmployee.setPosition(position);
                    }


                    System.out.println("Podaj wynagrodzenie");
                    int inputSalary = scanner.nextInt();
                    newEmployee.setSalary(inputSalary);
                    employeeManager.updateEmployee(id, newEmployee);
                    break;

                }
                case 4:
                {
                    String position = bufferedReader.readLine();
                    HashSet<Employee> employeeHashSet = employeeManager.searchEmployeesByPosition(position);
                    for (Employee employee: employeeHashSet
                    ) {
                        System.out.println(employee);
                    }
                    break;
                }
                case 5:
                {
                    employeeManager.listAllEmployees();
                    break;
                }
                default:
                    System.exit(0);
            }
        }
    }
}