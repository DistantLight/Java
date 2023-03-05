package org.example.obstacles;

import org.example.athletes.Athlete;
import org.example.athletes.Cat;
import org.example.athletes.Human;
import org.example.athletes.Robot;

public class Treadmill implements Obstacle {
    private int length;

    public Treadmill(int length){
        this.length = length;
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

        if(length>stagedAthlete.getRunMaxDistance()){
            System.out.println("Слишком большая дистанция для " + stagedAthlete.getName());
        } else {
            System.out.println(stagedAthlete.getName() + " пробежал " + length + " м.");
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
