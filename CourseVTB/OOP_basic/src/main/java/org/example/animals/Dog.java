package org.example.animals;

public class Dog extends Animal {
    private static final int RUN_MAX_DISTANCE = 500;
    private static final int SWIM_MAX_DISTANCE = 10;
    private static int dogCounter;

    public Dog(String name) {
        super(name, RUN_MAX_DISTANCE, SWIM_MAX_DISTANCE);
        dogCounter++;
    }

    public static int getDogCounter() {
        return dogCounter;
    }
}
