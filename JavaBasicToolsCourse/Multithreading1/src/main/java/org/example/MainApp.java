package org.example;

import java.util.Arrays;

public class MainApp {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] arr = new float[SIZE];


    public void measureOneTread(){
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        long start = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Measurement for one thread " + (System.currentTimeMillis() - start));
    }

    public void measureTwoTread(){
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        long start = System.currentTimeMillis();
        var arr1 = new float[HALF];
        var arr2 = new float[HALF];
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        var thread1 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                arr1[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        var thread2 = new Thread(() -> {
            for (int i = HALF; i < SIZE; i++) {
                arr2[i - HALF] = (float) (arr[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
        System.out.println("Measurement for two threads " + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) {
        var mainApp = new MainApp();

        mainApp.measureOneTread();
        mainApp.measureTwoTread();
    }
}