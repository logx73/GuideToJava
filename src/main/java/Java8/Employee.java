package Java8;

public class Employee {
    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

//    @Override
//    public int compareTo(Object o) {
//        Employee employee = (Employee) o;
//        if(this.getSalary() > employee.getSalary()){
//            return 1;
//        }else {
//            return -1;
//        }
//    }
}
