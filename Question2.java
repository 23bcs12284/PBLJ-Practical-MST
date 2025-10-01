import java.util.*;

// Custom Exception
class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

class EmployeeDirectory {
    private HashMap<Integer, String> employees = new HashMap<>();

    // Add employee
    public void addEmployee(int id, String name) {
        employees.put(id, name);
    }

    // Get employee name by ID
    public String getEmployee(int id) throws EmployeeNotFoundException {
        if (!employees.containsKey(id)) {
            throw new EmployeeNotFoundException("Employee ID not found!");
        }
        return employees.get(id);
    }

    // Display all employees
    public void displayEmployees() {
        System.out.println("Employee Map: " + employees);
    }
}

public class Question2 {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        System.out.println("Adding employees...");
        directory.addEmployee(101, "John");
        directory.addEmployee(102, "Jane");
        directory.addEmployee(103, "Mike");

        directory.displayEmployees();

        try {
            System.out.println("Name for ID 102: " + directory.getEmployee(102));
        } catch (EmployeeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("Name for ID 999: " + directory.getEmployee(999));
        } catch (EmployeeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
