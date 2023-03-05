package org.example.obstacles;

import org.example.athletes.Athlete;
import org.example.athletes.Cat;
import org.example.athletes.Human;
import org.example.athletes.Robot;

public class Wall implements Obstacle{
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void overcome(Athlete athlete) {
        Athlete stagedAthlete;

        if (athlete instanceof Cat){
            stagedAthlete = (Cat)athlete;
        } else if (athlete instanceof Human){
            stagedAthlete = (Human)athlete;
        } else {
            stagedAthlete = (Robot)athlete;
        }

        if(height>stagedAthlete.getRunMaxDistance()){
            System.out.println("Слишком высокая стена для " + stagedAthlete.getName());
        } else {
            System.out.println(stagedAthlete.getName() + " перепрыгнул стену " + height + " м.");
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
