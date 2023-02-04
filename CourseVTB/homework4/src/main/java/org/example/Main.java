package org.example;

import org.example.boxes.Box;
import org.example.fruits.Apple;
import org.example.fruits.Orange;

public class Main {
    public static void main(String[] args) {
        var box1 = new Box<Apple>();
        var box2 = new Box<Orange>();
        var box3 = new Box<Apple>();

        box1.add(new Apple());
        box1.add(new Apple());
        box1.add(new Apple());

        box2.add(new Orange());
        box2.add(new Orange());
        box2.add(new Orange());

        box3.add(new Apple());
        box3.add(new Apple());

        System.out.println(box2.compare(box3));

        box1.transfer(box3);

        System.out.println(box1.getWeight());
        System.out.println(box3.getWeight());
    }
}