package org.example.obstacles;

import org.example.athletes.Athlete;

public class Wall implements Obstacle{
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void overcome(Athlete athlete) {
        if(height>athlete.getJumpMaxDistance()){
            System.out.println("Слишком высокая стена для " + athlete.getName());
        } else {
            System.out.println(athlete.getName() + " перепрыгнул " + height + " м.");
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
