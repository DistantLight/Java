package org.example.animals;

public class HomeCat extends Cat {
    private static int homeCatCounter;

    public HomeCat(String name) {
        super(name);
        homeCatCounter++;
    }

    public static int getHomeCatCounter() {
        return homeCatCounter;
    }

}
