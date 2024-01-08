package Java8;

import java.util.*;
import java.util.stream.Collectors;



public class streams {
    @FunctionalInterface
    interface SumOfIntegers {
        int sum(int a, int b);
    }

    public static void main(String[] args) {
        //Dummy Dataset
        Employee e1 = new Employee(1, "Lokesh", 75000);
        Employee e2 = new Employee(2, "Pritesh", 25000);
        Employee e3 = new Employee(3, "Mitesh", 50000);

        // Find Second-Highest Salary from the list of Employee
        List<Employee> employeeList = Arrays.asList(e1, e2, e3);
        Optional<Employee> employee = employeeList.stream().sorted(Comparator.comparingInt(Employee::getSalary)).skip(1).findFirst();
        System.out.println("Second Highest Salary " + employee.get().getName() + " Rs " + employee.get().getSalary());

        // Lambda Expression that takes sum of two integers and return their sum.
        SumOfIntegers sumFunction = Integer::sum;
        int total = sumFunction.sum(2, 3);
        System.out.println("Sum from lambda expression " + total);

        //Sum of all even number's in the list
        int[] listOfint = {1, 2, 3, 4, 5, 6, 7};
        int sumOfEven = Arrays.stream(listOfint).filter(num -> num % 2 == 0).sum();
        System.out.println("Sum Of all even numbers " + sumOfEven);

        //List all the strings starting with P
        List<String> stringList = Arrays.asList("Lokesh", "Mitesh", "Pritesh", "Gitesh", "Gaurav", "Parag");
        List<String> filteredStringList = stringList.stream().filter(str -> str.startsWith("P")).collect(Collectors.toList());
        System.out.println("List of String Starting with P" + filteredStringList.toString());

        //Sort the arraylist alphabetically
        List<String> sortedStringList = stringList.stream().sorted().collect(Collectors.toList());
        System.out.println("Alphabetically sorted list " + sortedStringList.toString());

        //Find Duplicate String in an array
        String[] str = {"wow", "wow", "app"};

        //HashMap Version
        Map<String, Integer> mapOfStrings = new HashMap<>();
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            if (mapOfStrings.containsKey(str[i])) {
                strList.add(str[i]);
                mapOfStrings.put(str[i], mapOfStrings.get(str[i]) + 1);
            } else {
                mapOfStrings.put(str[i], 1);
            }
        }
        System.out.println("Hashmap version duplicate list: " + strList);

        //Java 8 Version
        List<String> arryList = Arrays.stream(str).collect(Collectors.groupingBy(st -> st, Collectors.counting())).entrySet().stream().filter(map -> map.getValue() > 1).map(map -> map.getKey()).collect(Collectors.toList());
        System.out.println("Java8 version duplicate list: " + arryList);
    }
}
