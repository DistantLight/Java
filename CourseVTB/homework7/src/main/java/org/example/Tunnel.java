package org.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private static Semaphore semaphore;

    public Tunnel(int carsCount) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        semaphore = new Semaphore(carsCount / 2);
    }

    @Override
    public void go(Car car) {
        try {
            if (!semaphore.tryAcquire()){ //get semaphore if .tryAcquire returned true; go to if-block if .tryAcquire() returned false
                System.out.println(car.getName() + " готовится к этапу(ждет): " +
                        description);
                semaphore.acquire(); //waiting for semaphore
            }
            System.out.println(car.getName() + " начал этап: " + description);
            Thread.sleep(length / car.getSpeed() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(car.getName() + " закончил этап: " +
                    description);
            semaphore.release();
        }
    }
}