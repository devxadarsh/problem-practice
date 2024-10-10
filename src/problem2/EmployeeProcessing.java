package problem2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeProcessing {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Ram", 5000L, "IT"),
                new Employee("Shyam", 7000L, "Mechanical"),
                new Employee("Mohan", 46500L, "HR"),
                new Employee("John", 60000L, "HR"),
                new Employee("Alice", 75000L, "Finance"),
                new Employee("Bob", 45000L, "HR"),
                new Employee("Charlie", 80000L, "Finance"),
                new Employee("David", 55000L, "IT"),
                new Employee("Eve", 50000L, "IT")
        );

        Map<String, List<Employee>> result = employees.stream()
                .filter(employee -> employee.getSalary() > 50000L)
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .sorted(Comparator.comparingLong(Employee::getSalary))
                                .limit(2)
                                .collect(Collectors.toList())
                ));

        result.forEach((dept, emps) -> {
            System.out.println("Department: " + dept);
            emps.forEach(System.out::println);
        });
    }
}
