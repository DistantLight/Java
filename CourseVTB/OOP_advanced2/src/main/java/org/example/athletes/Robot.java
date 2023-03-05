package org.example.athletes;

public class Robot implements Athlete{
    String name;
    private int runMaxDistance;
    private int jumpMaxDistance;

    public Robot(String name, int runMaxDistance, int jumpMaxDistance) {
        this.name = name;
        this.runMaxDistance = runMaxDistance;
        this.jumpMaxDistance = jumpMaxDistance;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int getRunMaxDistance() {
        return runMaxDistance;
    }
    @Override
    public void setRunMaxDistance(int runMaxDistance) {
        this.runMaxDistance = runMaxDistance;
    }
    @Override
    public int getJumpMaxDistance() {
        return jumpMaxDistance;
    }
    @Override
    public void setJumpMaxDistance(int jumpMaxDistance) {
        this.jumpMaxDistance = jumpMaxDistance;
    }
}
