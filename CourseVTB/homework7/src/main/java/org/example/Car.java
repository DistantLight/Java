package org.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    final Object lock = new Object();

    static {
        CARS_COUNT = 0;
    }
    private CyclicBarrier cyclicBarrier;

    private Race race;
    private int speed;
    private String name;


    public Car(Race race, int speed, CyclicBarrier cyclicBarrier) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await(); //synchronized with threads from main
            cyclicBarrier.await(); //synchronized with threads from main
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            synchronized (lock){
                if(!race.isWinnerExists()){
                    race.setWinnerExists(true);
                    System.out.println("Участник #" + this.name + " - WIN");
                }
            }
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getCarsCount() {
        return CARS_COUNT;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

}