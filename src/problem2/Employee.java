package problem2;

import java.util.Objects;

public class Employee {

     String name;
     Long Salary;
     String Department;

    public Employee(String name, Long salary, String department) {
        this.name = name;
        Salary = salary;
        Department = department;
    }

    public String getName() {
        return name;
    }

    public Long getSalary() {
        return Salary;
    }

    public String getDepartment() {
        return Department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", Salary=" + Salary +
                ", Department='" + Department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(Salary, employee.Salary) && Objects.equals(Department, employee.Department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Salary, Department);
    }
}
