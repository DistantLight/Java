package org.example;

import java.util.List;

public class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public static double getAverageSalary(List<Employee> employees){
        return employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum)
                / employees.size();
    }

    public static void showOldestEmployees(List<Employee> employees, int amountOfEmployees){
        System.out.println(amountOfEmployees + "Старших сотрудников зовут: ");
        employees.stream()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(amountOfEmployees)
                .toList()
                .forEach(employee -> System.out.println(employee.getName()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
