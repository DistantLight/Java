package org.example.athletes;

public abstract class Athlete {
    String name;
    private int runMaxDistance;
    private int jumpMaxDistance;

    public Athlete(String name, int runMaxDistance, int jumpMaxDistance) {
        this.name = name;
        this.runMaxDistance = runMaxDistance;
        this.jumpMaxDistance = jumpMaxDistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunMaxDistance() {
        return runMaxDistance;
    }

    public void setRunMaxDistance(int runMaxDistance) {
        this.runMaxDistance = runMaxDistance;
    }

    public int getJumpMaxDistance() {
        return jumpMaxDistance;
    }

    public void setJumpMaxDistance(int jumpMaxDistance) {
        this.jumpMaxDistance = jumpMaxDistance;
    }
}
