package com.example.planetcraft;

public class Particle_Lmatter {

    private int lmatter_x, lmatter_y;
    private boolean isCollected;

    public Particle_Lmatter(int x, int y, boolean IsCollected) {

        this.lmatter_x = x;
        this.lmatter_y = y;
        this.isCollected = IsCollected;
    }



    public int getLmatter_x() {return lmatter_x;}
    public void setLmatter_x (int lmatter_x) {this.lmatter_x = lmatter_x; }

    public int getLmatter_y() {return lmatter_y;}
    public void setLmatter_y (int lmatter_y) {this.lmatter_y = lmatter_y;  }

    public boolean getIsCollected() {return isCollected;}
    public void setIsCollected (boolean IsCollected) {this.isCollected = IsCollected;  }
}
