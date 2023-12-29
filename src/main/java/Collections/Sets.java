package Collections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Employee{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId);
    }

    private int empId;
    private String name;

    public Employee(int empId, String name){
        this.empId = empId;
        this.name = name;
    }
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class Sets {
    public static void main(String[] args) {
        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(new Employee(1,"lokesh"));
        employeeSet.add(new Employee(1,"pritesh"));
        System.out.println(employeeSet.size());
    }
}
