import java.util.ArrayList;


abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    public String toString() {
        return "Employee Name: " + name + ", ID: " + id + ", Salary: " + calculateSalary();
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("Kunal", 1, 50000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Gaurav", 2, 20, 80);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Employees in the system:");
        payrollSystem.displayEmployees();

        payrollSystem.removeEmployee(2);
        System.out.println("After removing employee with ID 2:");

        payrollSystem.displayEmployees();


    }
}