package StreamsAPI;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
    String name;
    String department;
    double salary;
    int age;

    public Employee(String name, String department, double salary, int age) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }
    // Add Getters
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }

    @Override
    public String toString() { return name + " (" + department + ")"; }


    // Get a list of just the names of all employees (List<String>).
    public static List<String> getListOfNamesOfAllEmployees(List<Employee> employees){
        System.out.println("6. ------------------");
        List<String> collect = employees.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("------------------");
        return collect;
    }
    // Calculate the total salary of all employees.
    public static Double calculateTotalSalary(List<Employee> employees){
        System.out.println("7. ------------------");
        Double collect = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        Double collect1 = employees.stream().map(Employee::getSalary).reduce(0.0, Double::sum);
        System.out.println(collect);
        System.out.println(collect1);
        System.out.println("------------------");
        return collect;
    }

    // Find the employee with the highest salary.
    public static Employee employeeWithHighestSalary(List<Employee> employees){
        System.out.println("8. ------------------");
        Employee limit = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst().get();
        Employee limit1 = employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
        System.out.println(limit1);
        System.out.println("------------------");
        return limit;
    }

    // Find the youngest employee in the "IT" department.
    public static Employee youngestEmployeeInTheDepartment(List<Employee> employees, String dept){
        System.out.println("9. ------------------");
        Employee employee = employees.stream().filter(emp -> dept.equals(emp.getDepartment())).min(Comparator.comparingInt(Employee::getAge)).get();
        System.out.println(employee);
        System.out.println("------------------");
        return employee;
    }

    // Group employees by Department (Map<String, List<Employee>>).
    public static Map<String, List<Employee>> groupEmpByDept(List<Employee> employees){
        System.out.println("10. ------------------");
        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(collect);
        System.out.println("------------------");
        return collect;
    }

    // Count how many employees are in each department.
    public static Map<String, Long> countEmpInAllDept(List<Employee> employees){
        System.out.println("11. ------------------");
        Map<String, Long> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println(collect);
        System.out.println("------------------");
        return collect;
    }

    // Find the average salary of each department.
    public static Map<String, Double> findAvgSalaryOfEveryDept(List<Employee> employees){
        System.out.println("12. ------------------");
        Map<String, Double> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect);
        System.out.println("------------------");
        return collect;
    }

    // Sort employees by Department, then by Salary.
    public static List<Employee> sortByDeptThenSalary(List<Employee> employees){
        System.out.println("12. ------------------");
        List<Employee> collect = employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary)).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("------------------");
        return collect;
    }
}


