import java.util.*;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class SortEmployee {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", 25, 50000),
            new Employee("Alice", 30, 60000),
            new Employee("Bob", 22, 55000)
        );

        // Sort by Name
        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        System.out.println("Sorted by Name: " + employees);

        // Sort by Age
        employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println("Sorted by Age: " + employees);

        // Sort by Salary
        employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println("Sorted by Salary: " + employees);
    }
}
