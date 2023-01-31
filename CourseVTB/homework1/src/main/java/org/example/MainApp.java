package org.example;

import org.example.animals.*;


public class MainApp {
    public static final int runDistance = 100;
    public static final int swimDistance = 40;
    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("Бобик"),
                new HomeCat("Федя"),
                new Dog("Шарик"),
                new Tiger("Толик"),
                new HomeCat("Рыжий"),
        };


        for (Animal animal: animals) {
            animal.run(runDistance);
            animal.swim(swimDistance);
        }

        System.out.println(
                "Животных: " +Animal.getAnimalCounter() + "\n" +
                "Собак: " + Dog.getDogCounter() + "\n" +
                "Котов: " + Cat.getCatCounter() + "\n" +
                "Домашних котов: " + HomeCat.getHomeCatCounter()+ "\n" +
                "Тигров: " + Tiger.getTigerCounter()
        );
    }
}
