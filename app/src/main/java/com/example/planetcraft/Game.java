package com.example.planetcraft;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private Context context;

    private Bitmap asteroidBitmap;
    private Bitmap gasgiantBitmap;
    private Bitmap habitableBitmap;
    private Bitmap icyplanetBitmap;
    private Bitmap lavaplanetBitmap;
    private Bitmap rockyplanetBitmap;
    private Bitmap starmBitmap;
    private Bitmap watergiantBitmap;

    private Bitmap h20ParticleBitmap;
    private Bitmap metalParticleBitmap;
    private Bitmap gasParticleBitmap;
    private Bitmap rockParticleBitmap;
    private Bitmap tempupParticleBitmap;
    private Bitmap tempdownParticleBitmap;
    private Bitmap matterParticleBitmap;


    private GameView gameView;
    private int h,w;
    private int h20points = 0;
    private int metalpoints = 0;
    private int gaspoints = 0;
    private int rockpoints = 0;
    private int temperature = 0;
    private int pixels = 2;
    boolean executed = false;

    //variables for the evolution shop for the inhabitable planet play style
    private int matterpoints;
    private int proteins = 0;
    private int dna = 0;
    Random rnd = new Random();
    int rintw = rnd.nextInt(1000);
    int rinth = rnd.nextInt(1900);
    private int prokaryote = 0;
    private int bacteria = 0;
    private int eukaryote = 0;
    private int colony = 0;
    private int fungi = 0;
    private int plants = 0;
    private int animals = 0;

    Dialog habtutDialog;





    public ArrayList<Particle_H20> particles_h20 = new ArrayList<>();
    public ArrayList<Particle_Metal> particles_metal = new ArrayList<>();
    public ArrayList<Particle_Gas> particles_gas = new ArrayList<>();
    public ArrayList<Particle_Rock> particles_rock = new ArrayList<>();
    public ArrayList<Particle_tempup> particles_tempup = new ArrayList<>();
    public ArrayList<Particle_tempdown> particles_tempdown = new ArrayList<>();
    public ArrayList<Particle_Lmatter> particles_lmatter = new ArrayList<>();

    private boolean running;



    public Game(Context context, Dialog habtutDialog) {
        this.context = context;
        this.habtutDialog = habtutDialog;
        asteroidBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.asteroid);
        gasgiantBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.gasgiant);
        habitableBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.habitable);
        icyplanetBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.icyplanet);
        lavaplanetBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.lavaplanet);
        rockyplanetBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.rockyplanet);
        starmBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.starm);
        watergiantBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.watergiant);


        h20ParticleBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.h20particle);
        matterParticleBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.matterparticle);
        metalParticleBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.metalparticle);
        gasParticleBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.gasparticle);
        rockParticleBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.rockparticle);
        tempupParticleBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.tempupparticle);
        tempdownParticleBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.tempdownparticle);
    }



    public void setGameView(GameView view)
    {
        this.gameView = view;
    }

    public void setSize(int h, int w)
    {
        this.h = h;
        this.w = w;
    }


    public void newGame() {
        h20points = 0;
        executed = false;
        metalpoints = 0;
        gaspoints = 0;
        rockpoints = 0;
        temperature = 0;
        particles_h20.clear();
        particles_gas.clear();
        particles_metal.clear();
        particles_rock.clear();
        particles_tempup.clear();
        particles_tempdown.clear();
        particles_lmatter.clear();

        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);
        particles_h20.add(new Particle_H20(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);
        particles_h20.add(new Particle_H20(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);
        particles_h20.add(new Particle_H20(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);
        particles_gas.add(new Particle_Gas(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);
        particles_gas.add(new Particle_Gas(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);
        particles_gas.add(new Particle_Gas(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);
        particles_metal.add(new Particle_Metal(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);
        particles_metal.add(new Particle_Metal(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);
        particles_metal.add(new Particle_Metal(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);
        particles_metal.add(new Particle_Metal(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);


        particles_tempup.add (new Particle_tempup(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);
        particles_tempup.add (new Particle_tempup(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);
        particles_tempup.add (new Particle_tempup(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);


        particles_tempdown.add (new Particle_tempdown(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);
        particles_tempdown.add (new Particle_tempdown(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);
        particles_tempdown.add (new Particle_tempdown(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);


        particles_rock.add (new Particle_Rock(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);
        particles_rock.add (new Particle_Rock(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);
        particles_rock.add (new Particle_Rock(rintw, rinth, false));
        rintw = rnd.nextInt(1000);
        rinth = rnd.nextInt(1900);

        gameView.invalidate();
    }


    public void moveParticle_h20(Particle_H20 h20) {

        if (h20.getH20_x() + pixels > w + 60) {
            h20.setH20_x(h20.getH20_x() - w);
        }


        else {
            h20.setH20_x(h20.getH20_x() + pixels);
        }

        if (h20.getH20_y() + pixels + h20ParticleBitmap.getHeight() > h + 60) {
            h20.setH20_y(h20.getH20_y() - h);
            gameView.invalidate();
        }

        else {
            h20.setH20_y(h20.getH20_y() + pixels);
            gameView.invalidate();
        }
    }

    public void moveParticle_matter(Particle_Lmatter matter) {

        if (matter.getLmatter_x() + pixels > w + 60) {
            matter.setLmatter_x(matter.getLmatter_x() - w);
        }


        else {
            matter.setLmatter_x(matter.getLmatter_x() + pixels);
        }

        if (matter.getLmatter_y() + pixels + matterParticleBitmap.getHeight() > h + 60) {
            matter.setLmatter_y(matter.getLmatter_y() - h);
            gameView.invalidate();
        }

        else {
            matter.setLmatter_y(matter.getLmatter_y() + pixels);
            gameView.invalidate();
        }
    }

    public void moveParticle_metal(Particle_Metal metal) {

        if (metal.getMetal_x() + pixels + metalParticleBitmap.getWidth() < 0) {
            metal.setMetal_x( metal.getMetal_x() + w);
            gameView.invalidate();
        }


        else {
            metal.setMetal_x(metal.getMetal_x() - pixels - 1);
            gameView.invalidate();
        }
    }

    public void moveParticle_gas(Particle_Gas gas) {

        if (gas.getGas_x() + pixels + gasParticleBitmap.getWidth() > w + 60) {
            gas.setGas_x( gas.getGas_x() - w);
            gameView.invalidate();
        }

        else {
            gas.setGas_x(gas.getGas_x() + pixels);
            gameView.invalidate();
        }
    }

    public void moveParticle_rock(Particle_Rock rock) {

        if (rock.getRock_x() + pixels + rockParticleBitmap.getWidth() > w + 60) {
            rock.setRock_x(rock.getRock_x() - w );
            gameView.invalidate();
        }

        else {
            rock.setRock_x(rock.getRock_x() + pixels);
            gameView.invalidate();
        }
    }

    public void moveParticle_tempup(Particle_tempup tempup) {

        if (tempup.getTempup_x() + pixels + tempupParticleBitmap.getWidth() > w + 60) {
            tempup.setTempup_x(tempup.getTempup_x() - w);
            gameView.invalidate();
        }

        else {
            tempup.setTempup_x(tempup.getTempup_x() + pixels);
            gameView.invalidate();
        }
    }

    public void moveParticle_tempdown(Particle_tempdown tempdown) {

        if (tempdown.getTempdown_x() + pixels + tempdownParticleBitmap.getWidth() > w + 60) {
            tempdown.setTempdown_x(tempdown.getTempdown_x() - w);
            gameView.invalidate();
        }

        else {
            tempdown.setTempdown_x(tempdown.getTempdown_x() + pixels);
            gameView.invalidate();
        }

        if (tempdown.getTempdown_y() + pixels + tempdownParticleBitmap.getHeight() < 0) {
            tempdown.setTempdown_y(tempdown.getTempdown_y() + h);
            gameView.invalidate();
        }

        else {
            tempdown.setTempdown_y(tempdown.getTempdown_y() - pixels);
            gameView.invalidate();
        }

    }



    public void moveParticlesforeach() {

                for (Particle_H20 h20 : particles_h20) {
                    moveParticle_h20(h20);
                }

                for (Particle_Metal metal : particles_metal) {
                    moveParticle_metal(metal);
                }

                for (Particle_Gas gas : particles_gas) {
                    moveParticle_gas(gas);
                }

                for (Particle_Rock rock : particles_rock) {
                    moveParticle_rock(rock);
                }

                for (Particle_tempup tempup : particles_tempup) {
                    moveParticle_tempup(tempup);
                }

                for (Particle_tempdown tempdown : particles_tempdown) {
                    moveParticle_tempdown(tempdown);
                }

        for (Particle_Lmatter matter: particles_lmatter) {
            moveParticle_matter(matter);
        }

        }

        public void Movematter() {
        for (Particle_Lmatter matter: particles_lmatter) {
            moveParticle_matter(matter);
        }

        }


    //booleans for switching planet and star types
    public boolean Asteroidswitch() {

        if (h20points <=20 && rockpoints <= 50 && gaspoints <= 50 && temperature <= 50) {
            return true;
        }

        return false;
    }


    public boolean Rockyswitch() {

        if (h20points <= 20 && rockpoints >= 4 && gaspoints <= 30 && temperature >= 2 && temperature <= 50) {
            return true;
        }

        return false;
    }

    public boolean Icerockyswitch() {

        if (h20points >= 20 && rockpoints >= 30 && gaspoints <= 30 && temperature <= 2) {
            return true;
        }

        return false;
    }


    public boolean HighMetalswitch() {

        if (h20points <= 20 && rockpoints >= 30 && gaspoints <= 30 && metalpoints >= 40 && temperature >= 10 && temperature <= 50) {
            return true;
        }

        return false;
    }

    public boolean Lavaswitch() {

        if (h20points <= 1 && rockpoints >= 30 && gaspoints >= 10 && temperature >= 15 && temperature <= 50) {
            return true;
        }

        return false;
    }

    public boolean Habitableswitchbit() {

        if (h20points >= 2 && metalpoints >= 2) {
            return true;
        }

        return false;
    }

    public boolean Habitableswitch() {

        if (h20points >= 2 && metalpoints >= 2 && executed == false) {
                particles_h20.clear();
                particles_gas.clear();
                particles_metal.clear();
                particles_rock.clear();
                particles_tempup.clear();
                particles_tempdown.clear();
                habtutDialog.show();

            rintw = rnd.nextInt(1000);
            rinth = rnd.nextInt(1900);
                particles_lmatter.add(new Particle_Lmatter(rintw, rinth, false));
                executed = true;
                gameView.invalidate();

            return true;
        }

        return false;
    }





    public boolean Gasgiantswitch() {

        if (gaspoints >= 30 && temperature <= 50) {
            return true;
        }

        return false;
    }



    public boolean Watergiantswitch() {

        if (gaspoints >= 30 && h20points >= 30 && temperature <= 50 ) {
            return true;
        }

        return false;
    }

    public boolean Starmswitch() {

        if (gaspoints >= 50 && temperature >= 50) {
            return true;
        }

        return false;
    }

    public boolean Starkswitch() {

        if (gaspoints >= 70 && temperature >= 60) {
            return true;
        }

        return false;
    }

    public boolean Starfswitch() {

        if (gaspoints >= 75 && temperature >= 65) {
            return true;
        }

        return false;
    }

    public boolean Staroswitch() {

        if (gaspoints >= 80 && temperature >= 80) {
            return true;
        }

        return false;
    }


    public boolean Starwswitch() {

        if (gaspoints >= 85 && temperature >= 100) {
            return true;
        }

        return false;
    }


    public void ShoplogicProt() {
        if (matterpoints >= 10) {
            matterpoints = matterpoints - 10;
            proteins++;
        }
        else {
            Toast.makeText(context, "Not enough matter", Toast.LENGTH_SHORT).show();
        }
    }

    public void ShoplogicDNA() {
        if (proteins >= 10) {
            proteins = proteins - 10;
            dna++;
        }
        else {
            Toast.makeText(context, "Not enough Protein", Toast.LENGTH_SHORT).show();
        }
    }

    public void ShoplogicPro() {
        if (dna >= 10) {
            dna = dna - 10;
            prokaryote++;
        }
        else {
            Toast.makeText(context, "Not enough DNA", Toast.LENGTH_SHORT).show();
        }
    }

    public void ShoplogicBac() {
        if (prokaryote >= 10) {
            prokaryote = prokaryote - 10;
            bacteria++;
        }
        else {
            Toast.makeText(context, "Not enough Prokaryotes", Toast.LENGTH_SHORT).show();
        }
    }

    public void ShoplogicEuk() {
        if (bacteria >= 10) {
            bacteria = bacteria - 10;
            eukaryote++;
        }
        else {
            Toast.makeText(context, "Not enough Bacteria", Toast.LENGTH_SHORT).show();
        }
    }

    public void ShoplogicCol() {
        if (eukaryote >= 10) {
            eukaryote = eukaryote - 10;
            colony++;
        }
        else {
            Toast.makeText(context, "Not enough Eukaryotes", Toast.LENGTH_SHORT).show();
        }
    }

    public void ShoplogicFun() {
        if (colony >= 10) {
            colony = colony - 10;
            fungi++;
        }
        else {
            Toast.makeText(context, "Not enough Colonies", Toast.LENGTH_SHORT).show();
        }
    }

    public void ShoplogicPla() {
        if (fungi >= 10) {
            fungi = fungi - 10;
            plants++;
        }
        else {
            Toast.makeText(context, "Not enough Fungi", Toast.LENGTH_SHORT).show();
        }
    }

    public void ShoplogicAni() {
        if (plants >= 10) {
            plants = plants - 10;
            animals++;
        }
        else {
            Toast.makeText(context, "Not enough Plants", Toast.LENGTH_SHORT).show();
        }
    }

    public void ShopLogicReset() {
        if (animals == 10) {
            animals = 0;
            particles_lmatter.add(new Particle_Lmatter(320, 320, false));
        }
    }

    public ArrayList<Particle_H20> getParticles_h20() {return particles_h20; }
    public ArrayList<Particle_Metal> getParticles_metal() {return particles_metal; }
    public ArrayList<Particle_Gas> getParticles_gas() {return particles_gas; }

    Bitmap getAsteroidBitmap() {return asteroidBitmap; }
    Bitmap getGasgiantBitmap() {return gasgiantBitmap; }
    Bitmap getHabitableBitmap() {return habitableBitmap; }
    Bitmap getIcyplanetBitmap() {return icyplanetBitmap; }
    Bitmap getLavaplanetBitmap() {return lavaplanetBitmap; }
    Bitmap getRockyplanetBitmap() {return rockyplanetBitmap; }
    Bitmap getStarmBitmap() {return starmBitmap; }
    Bitmap getWatergiantBitmap() {return watergiantBitmap; }

    Bitmap getH20ParticleBitmap() {return h20ParticleBitmap; }
    Bitmap getMetalParticleBitmap() {return metalParticleBitmap; }
    Bitmap getMatterParticleBitmap() {return matterParticleBitmap; }
    Bitmap getGasParticleBitmap() {return gasParticleBitmap; }
    Bitmap getRockParticleBitmap() {return rockParticleBitmap; }
    Bitmap getTempupParticleBitmap() {return tempupParticleBitmap; }
    Bitmap getTempdownParticleBitmap() {return tempdownParticleBitmap; }

    public boolean GetRunning(){return running; }

    public void SetRunning(boolean running) {this.running=running; }

    public int getH20Points() {return h20points; }
    public void setH20Points (int h20Points) {this.h20points = h20Points; }

    public int getMetalpoints() {return metalpoints; }
    public void setMetalpoints (int Metalpoints) {this.metalpoints = Metalpoints; }

    public int getRockpoints() {return rockpoints; }
    public void setRockpoints (int Rockpoints) {this.rockpoints = Rockpoints; }

    public int getGaspoints() {return gaspoints; }
    public void setGaspoints (int Gaspoints) {this.gaspoints = Gaspoints; }

    public int getMatterpoints() {return matterpoints; }
    public void setMatterpoints(int Matterpoints) {this.matterpoints = Matterpoints; }

    public int getTemperature() {return temperature; }
    public void setTemperature(int Temperature) {this.temperature = Temperature; }

    public int getProteins() {return proteins; }
    public void setProteins(int proteins) { this.proteins = proteins; }

    public int getDna() {return dna; }
    public void setDna(int dna) { this.dna = dna; }

    public int getProkaryote() {return prokaryote; }
    public void setProkaryote(int prokaryote) { this.prokaryote = prokaryote; }

    public int getBacteria() {return bacteria; }
    public void setBacteria(int bacteria) { this.bacteria = bacteria; }

    public int getEukaryote() {return eukaryote; }
    public void setEukaryote(int eukaryote) { this.eukaryote = eukaryote; }

    public int getColony() {return colony; }
    public void setColony(int colony) {this.colony = colony; }

    public int getFungi() {return fungi; }
    public void setFungae(int fungi) {this.fungi = fungi; }

    public int getPlants() {return plants; }
    public void setPlants(int plants) {this.plants = plants; }

    public int getAnimals() {return animals; }
    public void setAnimals(int animals) {this.animals = animals; }
}
