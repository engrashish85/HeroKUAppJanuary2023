package dataTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMain {
    public static void main(String[] args) {
        Employee employee2 = new Employee("Ashish", "One", 33);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Ashish", "One", 33));
        employeeList.add(new Employee("Ashish", "Two", 31));
        employeeList.add(new Employee("Ashish", "Three", 31));
        employeeList.add(new Employee("Ashish", "Four", 32));

        employeeList.forEach(employee -> System.out.println(employee));
        System.out.println("\n\n");

        employeeList.set(1, new Employee("Ashish","Fie", 1));
        employeeList.add(1, new Employee("Ashi", "Test", 23));
        employeeList.forEach(employee -> System.out.println(employee));
        System.out.println("\n\n");
        System.out.println(employeeList.get(1).getLastName().contains("Test"));
        System.out.println(employeeList.indexOf(new Employee("Ashish", "Four", 32)));
        System.out.println("\n\n");
        System.out.println(employeeList.get(3));
        System.out.println("\n\n removing list");
        System.out.println(employeeList.remove(2).getLastName());


        Employee[] employees = employeeList.toArray(new Employee[employeeList.size()]);
        Arrays.stream(employees).forEach(employee -> System.out.println(employee));


    }
}
