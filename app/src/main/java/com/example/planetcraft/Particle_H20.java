package com.example.planetcraft;

public class Particle_H20 {

    private int h20_x, h20_y;
    private boolean isCollected;

    public Particle_H20(int x, int y, boolean IsCollected) {

        this.h20_x = x;
        this.h20_y = y;
        this.isCollected = IsCollected;
    }



    public int getH20_x() {return h20_x;}
    public void setH20_x (int H20_x) {this.h20_x = H20_x; }

    public int getH20_y() {return h20_y;}
    public void setH20_y (int H20_y) {this.h20_y = H20_y;  }

    public boolean getIsCollected() {return isCollected;}
    public void setIsCollected (boolean IsCollected) {this.isCollected = IsCollected;  }
}
