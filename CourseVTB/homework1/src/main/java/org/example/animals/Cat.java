package org.example.animals;

public abstract class Cat extends Animal {
    private static final int RUN_MAX_DISTANCE = 200;
    private static final int SWIM_MAX_DISTANCE = 0;
    private static int catCounter;

    public Cat(String name) {
        super(name,RUN_MAX_DISTANCE,SWIM_MAX_DISTANCE);
        catCounter++;
    }
    @Override
    public void swim(int length) {
        System.out.println(this.getName() + " не умеет плавать!");
    }

    public static int getCatCounter() {
        return catCounter;
    }

}
