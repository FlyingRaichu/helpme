package com.example.planetcraft;

public class Particle_tempdown {

    private int tempdown_x, tempdown_y;
    private boolean isCollected;

    public Particle_tempdown(int x, int y, boolean IsCollected) {

        this.tempdown_x = x;
        this.tempdown_y = y;
        this.isCollected = IsCollected;
    }



    public int getTempdown_x() {return tempdown_x;}
    public void setTempdown_x (int tempdown_x) {this.tempdown_x = tempdown_x; }

    public int getTempdown_y() {return tempdown_y;}
    public void setTempdown_y (int tempdown_y) {this.tempdown_y = tempdown_y;  }

    public boolean getIsCollected() {return isCollected;}
    public void setIsCollected (boolean IsCollected) {this.isCollected = IsCollected;  }
}
