package com.example.planetcraft;

public class Particle_Rock {

    private int rock_x, rock_y;
    private boolean isCollected;

    public Particle_Rock(int x, int y, boolean IsCollected) {

        this.rock_x = x;
        this.rock_y = y;
        this.isCollected = IsCollected;
    }



    public int getRock_x() {return rock_x;}
    public void setRock_x (int rock_x) {this.rock_x = rock_x; }

    public int getRock_y() {return rock_y;}
    public void setRock_y (int rock_y) {this.rock_y = rock_y;  }

    public boolean getIsCollected() {return isCollected;}
    public void setIsCollected (boolean IsCollected) {this.isCollected = IsCollected;  }
}
