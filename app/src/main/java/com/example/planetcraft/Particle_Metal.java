package com.example.planetcraft;

public class Particle_Metal {

    private int metal_x, metal_y;
    private boolean isCollected;

    public Particle_Metal(int x, int y, boolean IsCollected) {

        this.metal_x = x;
        this.metal_y = y;
        this.isCollected = IsCollected;
    }



    public int getMetal_x() {return metal_x;}
    public void setMetal_x (int metal_x) {this.metal_x = metal_x; }

    public int getMetal_y() {return metal_y;}
    public void setMetal_y (int metal_y) {this.metal_y = metal_y;  }

    public boolean getIsCollected() {return isCollected;}
    public void setIsCollected (boolean IsCollected) {this.isCollected = IsCollected;  }
}
