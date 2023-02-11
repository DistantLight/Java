package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] words = {
                "car",
                "phone",
                "window",
                "car",
                "car",
                "window",
                "building",
                "phone",
                "road",
                "phone"
        };
        var stringsList = Arrays.stream(words).toList();
        System.out.println(ListHandler.findMostFrequentlyRepeatedStrings(stringsList, 2));

        var employees = Arrays.asList(new Employee("Alexander", 23, 43),
                new Employee("Sergey", 25, 65),
                new Employee("Alexey", 26, 30),
                new Employee("Danil", 30, 90));

        System.out.println(Employee.getAverageSalary(employees));
        Employee.showOldestEmployees(employees, 2);
    }
}