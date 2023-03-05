package org.example.animals;

public abstract class Animal {
    String name;
    private int runMaxDistance;
    private int swimMaxDistance;
    private static int animalCounter;
    Animal(String name, int runMaxDistance, int swimMaxDistance){
        this.runMaxDistance = runMaxDistance;
        this.swimMaxDistance = swimMaxDistance;
        this.name = name;
        animalCounter++;
    }

    public void run(int length) {
        if(length>runMaxDistance){
            System.out.println("Слишком длинная дистанция для " + this.getName());
        } else {
            System.out.println(this.getName() + " пробежал " + length + " м.");
        }
    }

    public void swim(int length) {
        if(length>swimMaxDistance){
            System.out.println("Слишком длинная дистанция для " + this.getName());
        } else {
            System.out.println(this.getName() + " проплыл " + length + " м.");
        }
    }

    public static int getAnimalCounter() {
        return animalCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
