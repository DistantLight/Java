package org.example;

import org.example.athletes.Athlete;
import org.example.athletes.Cat;
import org.example.athletes.Human;
import org.example.athletes.Robot;
import org.example.obstacles.Obstacle;
import org.example.obstacles.Treadmill;
import org.example.obstacles.Wall;

public class Main {
    public static void main(String[] args) {
        Athlete[] athletes = {
                new Cat("Егор", 30, 5),
                new Robot("Бендер",400, 4),
                new Human("Саня", 300, 8)
        };

        Obstacle[] obstacles = {
                new Wall(5),
                new Treadmill(350),
                new Wall(7)
        };

        for (Athlete athlete: athletes) {
            for (Obstacle obstacle: obstacles) {
                obstacle.overcome(athlete);
            }
        }
    }
}