package org.example.boxes;

import org.example.fruits.Fruit;
import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit> {
    private ArrayList<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public Box(T... fruits) {
        this.fruits = new ArrayList<T>(Arrays.asList((fruits)));
    }

    public float getWeight(){
        float sum = 0f;
        for (Fruit fruit: fruits) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    public boolean compare(Box<? extends Fruit> another){
        return Math.abs(this.getWeight() - another.getWeight()) < 0.01;
    }

    public void transfer(Box<T> another) {
        if (this == another){
            return;
        }
        this.getFruits().addAll(another.getFruits());
        another.getFruits().clear();
    }

    public void add(T fruit){
        this.getFruits().add(fruit);
    }

    public void add(T... fruits){
        this.getFruits().addAll(Arrays.asList(fruits));
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<T> fruits) {
        this.fruits = fruits;
    }
}


