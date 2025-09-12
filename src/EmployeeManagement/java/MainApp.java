package EmployeeManagement.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MainApp {
public static void main(String[] args) {
	List<Employee> employees = Arrays.asList(
			new Employee(121,"Smita",2000000,"HR"),
			new Employee(234,"Sanket",1000000,"IT"),
			new Employee(456,"Balaso",300000,"Finance"),
			new Employee(678,"Alka",500000,"HR"),
			new Employee(126,"Snehal",200000,"IT")
);
	
    System.out.println("Employees with salary > 50,000:");
    
	employees.stream().filter(e->e.salary>50000).forEach(System.out::println);
	
    System.out.println("\n--------------------------------\n");
	
	
	
    System.out.println("Employees sorted by name:");

    employees.stream().sorted(Comparator.comparing(e->e.name)).forEach(System.out::println);
    
    
    System.out.println("\n-----------------------------------------\n");

    
    System.out.println("Employees grouped by department:");
    Map<String, List<Employee>> groupedByDept = 
            employees.stream()
                     .collect(Collectors.groupingBy(e -> e.department));

        groupedByDept.forEach((dept, empList) -> {
            System.out.println("Department: " + dept);
            empList.forEach(e -> System.out.println("  " + e));
        });
    
        
     System.out.println("\n-----------------------------------------\n");

     
     
     System.out.println("Employees sorted by salary (high to low):");
     employees.stream()
     .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary)) 
     .forEach(System.out::println);
     
     System.out.println("\n-----------------------------------------\n");

     
     System.out.println("Printing employee details using Consumer:");
     Consumer<Employee> emp = e -> System.out.println(e.name + "-"+ e.salary);

     employees.forEach(emp);
     
     
     
     
}
}
