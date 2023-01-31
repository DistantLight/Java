package org.example.animals;

public class Tiger extends Cat{
    private static int tigerCounter;

    public Tiger(String name) {
        super(name);
        tigerCounter++;
    }

    public static int getTigerCounter() {
        return tigerCounter;
    }
}
