package com.example.planetcraft;

public class Particle_Gas {

    private int gas_x, gas_y;
    private boolean isCollected;

    public Particle_Gas(int x, int y, boolean IsCollected) {

        this.gas_x = x;
        this.gas_y = y;
        this.isCollected = IsCollected;
    }



    public int getGas_x() {return gas_x;}
    public void setGas_x (int gas_x) {this.gas_x = gas_x; }

    public int getGas_y() {return gas_y;}
    public void setGas_y (int gas_y) {this.gas_y = gas_y;  }

    public boolean getIsCollected() {return isCollected;}
    public void setIsCollected (boolean IsCollected) {this.isCollected = IsCollected;  }
}
