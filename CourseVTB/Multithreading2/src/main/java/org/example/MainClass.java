package org.example;

import java.util.concurrent.*;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        var barrier = new CyclicBarrier(CARS_COUNT + 1); //+1 for thread main
        Car[] cars = new Car[CARS_COUNT];
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT), new Road(40));

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), barrier);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            barrier.await(); //preparation of cars
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            barrier.await(); //does not allow other threads to go on until the last message is printed
            barrier.await(); //race finish
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}