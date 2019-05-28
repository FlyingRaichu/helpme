package com.example.planetcraft;

public class Particle_tempup {

    private int tempup_x, tempup_y;
    private boolean isCollected;

    public Particle_tempup(int x, int y, boolean IsCollected) {

        this.tempup_x = x;
        this.tempup_y = y;
        this.isCollected = IsCollected;
    }



    public int getTempup_x() {return tempup_x;}
    public void setTempup_x (int tempup_x) {this.tempup_x = tempup_x; }

    public int getTempup_y() {return tempup_y;}
    public void setTempup_y (int tempup_y) {this.tempup_y = tempup_y;  }

    public boolean getIsCollected() {return isCollected;}
    public void setIsCollected (boolean IsCollected) {this.isCollected = IsCollected;  }
}
