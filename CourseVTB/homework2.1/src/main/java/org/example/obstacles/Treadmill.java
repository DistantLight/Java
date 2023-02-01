package org.example.obstacles;

import org.example.athletes.Athlete;

public class Treadmill implements Obstacle {
    private int length;

    public Treadmill(int length){
        this.length = length;
    }

    @Override
    public void overcome(Athlete athlete) {
        if(length>athlete.getJumpMaxDistance()){
            System.out.println("Слишком длинная дистанция для " + athlete.getName());
        } else {
            System.out.println(athlete.getName() + " перепрыгнул " + length + " м.");
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
