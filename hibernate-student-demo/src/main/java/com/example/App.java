package com.example;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepositoryImpl;

import java.util.List;

public class App {
    public static void main(String[] args) {

        EmployeeRepositoryImpl repo = new EmployeeRepositoryImpl();

        Employee emp1 = new Employee();
        emp1.setEmpName("John Doe");
        emp1.setEmail("john@example.com");
        emp1.setPassword("12345");

        Employee emp2 = new Employee();
        emp2.setEmpName("Jane Smith");
        emp2.setEmail("jane@example.com");
        emp2.setPassword("abcde");

        repo.addEmployee(emp1);
        repo.addEmployee(emp2);

        System.out.println("✅ Employees Added Successfully!");

        List<Employee> employees = repo.getAllEmployees();
        System.out.println("All Employees:");
        for (Employee e : employees) {
            System.out.println(e);
        }

        int deleteId = 1; 
        repo.deleteEmployeeById(deleteId);
        System.out.println("Deleted Employee with ID = " + deleteId);

        employees = repo.getAllEmployees();
        System.out.println("Employees after delete:");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
