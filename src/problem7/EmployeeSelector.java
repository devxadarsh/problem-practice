package problem7;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeSelector {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Ram", "IT", 50000),
                new Employee("Shyam", "HR", 70000),
                new Employee("Mohan", "IT", 60000),
                new Employee("Sita", "HR", 55000),
                new Employee("Geeta", "Finance", 80000),
                new Employee("Radha", "IT", 65000)
        );

        Employee secondRanked = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(2)
                .skip(1)
                .findFirst().orElse(null);

        assert secondRanked != null;
        System.out.println(secondRanked.getName());


        Map<String, Optional<Employee>> departmentWiseRanked = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                ));

        departmentWiseRanked.forEach((department, employee) -> {
            if (employee.isPresent()) {
                System.out.println("Department: " + department +
                        ", Top salaries Employee: " +  employee.get().getName() +
                        ", Salary: " + employee.get().getSalary());
            }
        });

        Map<String, Employee> topSalariesByDept = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getDepartment,
                        e -> e,
                        (e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2
                ));

        topSalariesByDept.forEach((department, employee) ->
                System.out.println("Department: " + department +
                        ", Top salaries Employee: " +  employee.getName() +
                        ", Salary: " + employee.getSalary()));


        List<Employee> topSalariesByDept1 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream()
                .map(entry -> {
                    Employee topEmployee = entry.getValue().stream()
                            .max(Comparator.comparing(Employee::getSalary)).get();
                    return new Employee(topEmployee.getDepartment(), topEmployee.getName(), topEmployee.getSalary());
                })
                .toList();

        // Print the top salaried employee in each department
        topSalariesByDept1.forEach(System.out::println);
    }

}
