package org.example;

public class MainApp {
    public static void main(String[] args) {
        var phoneBook = new PhoneBook();

        phoneBook.addRecord("Иванов", "89208347439");
        phoneBook.addRecord("Смирнов", "89208343245");
        phoneBook.addRecord("Иванов", "89902139876");
        phoneBook.addRecord("Петров", "89223453221");
        phoneBook.addRecord("Сидоров", "89873214957");
        phoneBook.addRecord("Петров", "89208342339");
        phoneBook.addRecord("Иванов", "89208347431");

        System.out.println(phoneBook.getNumber("Иванов"));
        System.out.println(phoneBook.getNumber("Петров"));
    }
}
