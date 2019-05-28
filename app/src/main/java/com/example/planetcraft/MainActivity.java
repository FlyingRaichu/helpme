package com.example.planetcraft;
import android.app.Dialog;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Dialog shopDialog;
    Dialog particleDialog;
    Dialog mainmenuDialog;
    Dialog inittutDialog;
    Dialog habtutDialog;
    GameView gameView;

    Game game;
    Random rnd = new Random();
    int rintw = rnd.nextInt(1000);
    int rinth = rnd.nextInt(1900);
    private int counter;
    private Timer particleTimer;
    private int h, w;

    private void TimerMethod()
    {
        //This method is called directly by the timer
        //and runs in the same thread as the timer.

        //We call the method that will work with the UI
        //through the runOnUiThread method.
        this.runOnUiThread(Timer_Tick);

    }

    private Runnable Timer_Tick = new Runnable() {
        public void run() {


            if (game.GetRunning()) {
                counter++;
                game.moveParticlesforeach(); //move all the particles

            }



        }
    };



    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:


                for(int i=0;i<game.particles_h20.size();i++){

                    double getcenterparticleX = game.particles_h20.get(i).getH20_x() + game.getH20ParticleBitmap().getWidth() / 2;
                    double getcenterparticleY = game.particles_h20.get(i).getH20_y() + game.getH20ParticleBitmap().getHeight() / 2;

                    double distance = Math.sqrt((x - getcenterparticleX) * (x - getcenterparticleX) + (y - getcenterparticleY) * (y - getcenterparticleY));
                    if (distance < 80 && !game.particles_h20.get(i).getIsCollected()) {

                        game.particles_h20.get(i).setIsCollected(true);
                        game.setH20Points(game.getH20Points() + 1);




                        Log.d("h20points","h20 points:"+ " " + game.getH20Points());
                        Log.d("Itworks_h20", "It works h20");
                        rintw = rnd.nextInt(1000);
                        rinth = rnd.nextInt(1900);
                        game.particles_h20.add(new Particle_H20(rintw, rinth, false));
                        gameView.invalidate();

                    }


                }


                for (int i=0;i<game.particles_metal.size();i++) {

                    int getcenterparticleX = game.particles_metal.get(i).getMetal_x() + game.getMetalParticleBitmap().getWidth() / 2;
                    int getcenterparticleY = game.particles_metal.get(i).getMetal_y() + game.getMetalParticleBitmap().getHeight() / 2;

                    double distance = Math.sqrt((x - getcenterparticleX) * (x - getcenterparticleX) + (y - getcenterparticleY) * (y - getcenterparticleY));
                    if (distance < 80 && !game.particles_metal.get(i).getIsCollected()) {

                        game.particles_metal.get(i).setIsCollected(true);
                        game.setMetalpoints(game.getMetalpoints() + 1);
                        rintw = rnd.nextInt(1000);
                        rinth = rnd.nextInt(1900);
                        game.particles_metal.add(new Particle_Metal(rintw, rinth, false));
                        gameView.invalidate();
                        Log.d("Itworks_metal", "It works metal");
                    }


                }


                for (int i=0;i<game.particles_gas.size();i++) {

                    int getcenterparticleX = game.particles_gas.get(i).getGas_x() + game.getGasParticleBitmap().getWidth() / 2;
                    int getcenterparticleY = game.particles_gas.get(i).getGas_y() + game.getGasParticleBitmap().getHeight() / 2;

                    double distance = Math.sqrt((x - getcenterparticleX) * (x - getcenterparticleX) + (y - getcenterparticleY) * (y - getcenterparticleY));
                    if (distance < 80 && !game.particles_gas.get(i).getIsCollected()) {

                        game.particles_gas.get(i).setIsCollected(true);
                        game.setGaspoints(game.getGaspoints() + 1);
                        rintw = rnd.nextInt(1000);
                        rinth = rnd.nextInt(1900);
                        game.particles_gas.add(new Particle_Gas(rintw, rinth, false));

                        gameView.invalidate();

                        Log.d("Itworks_gas", "It works gas");


                    }



                }


                for (int i=0;i<game.particles_rock.size();i++) {

                    int getcenterparticleX = game.particles_rock.get(i).getRock_x() + game.getRockParticleBitmap().getWidth() / 2;
                    int getcenterparticleY = game.particles_rock.get(i).getRock_y() + game.getRockParticleBitmap().getHeight() / 2;

                    double distance = Math.sqrt((x - getcenterparticleX) * (x - getcenterparticleX) + (y - getcenterparticleY) * (y - getcenterparticleY));
                    if (distance < 80 && !game.particles_rock.get(i).getIsCollected()) {

                        game.particles_rock.get(i).setIsCollected(true);
                        game.setRockpoints(game.getRockpoints() +1);
                        rintw = rnd.nextInt(1000);
                        rinth = rnd.nextInt(1900);
                        game.particles_rock.add(new Particle_Rock(rintw, rinth, false));
                        gameView.invalidate();

                        Log.d("Itworks_rock", "It works rock");


                    }
                }


                for (int i=0;i<game.particles_tempup.size();i++) {

                    int getcenterparticleX = game.particles_tempup.get(i).getTempup_x() + game.getTempupParticleBitmap().getWidth() / 2;
                    int getcenterparticleY = game.particles_tempup.get(i).getTempup_y() + game.getTempupParticleBitmap().getHeight() / 2;

                    double distance = Math.sqrt((x - getcenterparticleX) * (x - getcenterparticleX) + (y - getcenterparticleY) * (y - getcenterparticleY));
                    if (distance < 80 && !game.particles_tempup.get(i).getIsCollected()) {

                        game.particles_tempup.get(i).setIsCollected(true);
                        game.setTemperature(game.getTemperature() +1);
                        rintw = rnd.nextInt(1000);
                        rinth = rnd.nextInt(1900);
                        game.particles_tempup.add(new Particle_tempup(rintw, rinth, false));
                        gameView.invalidate();

                        Log.d("Itworks_tup", "It works tup");


                    }
                }


                for (int i=0;i<game.particles_tempdown.size();i++) {

                    int getcenterparticleX = game.particles_tempdown.get(i).getTempdown_x() + game.getTempdownParticleBitmap().getWidth() / 2;
                    int getcenterparticleY = game.particles_tempdown.get(i).getTempdown_y() + game.getTempdownParticleBitmap().getHeight() / 2;

                    double distance = Math.sqrt((x - getcenterparticleX) * (x - getcenterparticleX) + (y - getcenterparticleY) * (y - getcenterparticleY));
                    if (distance < 80 && !game.particles_tempdown.get(i).getIsCollected()) {

                        game.particles_tempdown.get(i).setIsCollected(true);
                        game.setTemperature(game.getTemperature() -1);
                        rintw = rnd.nextInt(1000);
                        rinth = rnd.nextInt(1900);
                        game.particles_tempdown.add(new Particle_tempdown(rintw, rinth, false));
                        gameView.invalidate();

                        Log.d("Itworks_tup", "It works tup");


                    }
                }

                for (int i=0;i<game.particles_lmatter.size();i++) {

                    int getcenterparticleX = game.particles_lmatter.get(i).getLmatter_x() + game.getMatterParticleBitmap().getWidth() / 2;
                    int getcenterparticleY = game.particles_lmatter.get(i).getLmatter_y() + game.getMatterParticleBitmap().getHeight() / 2;

                    double distance = Math.sqrt((x - getcenterparticleX) * (x - getcenterparticleX) + (y - getcenterparticleY) * (y - getcenterparticleY));
                    if (distance < 80 && !game.particles_lmatter.get(i).getIsCollected()) {

                        game.particles_lmatter.get(i).setIsCollected(true);
                        game.setMatterpoints(game.getMatterpoints() +1);
                        rintw = rnd.nextInt(1000);
                        rinth = rnd.nextInt(1900);
                        game.particles_lmatter.add(new Particle_Lmatter(rintw, rinth, false));
                        gameView.invalidate();

                        Log.d("Itworks_lmatter", "It works matter");


                    }
                }

        }
        game.Habitableswitch();
        return true;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        Button gotit;
        gameView = findViewById(R.id.gameView);
        habtutDialog = new Dialog(this);
        habtutDialog.setContentView(R.layout.tutorial_habitable);
        gotit = (Button) habtutDialog.findViewById(R.id.gotit);
        gotit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                habtutDialog.dismiss();
            }
        });



        game = new Game(this, habtutDialog);
        game.setGameView(gameView);
        gameView.setGame(game);
        shopDialog = new Dialog(this);
        particleDialog = new Dialog(this);
        mainmenuDialog = new Dialog(this);
        inittutDialog = new Dialog(this);



        particleTimer = new Timer();
        game.SetRunning(true);
        particleTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                TimerMethod();
            }

        }, 0, 10);
        game.newGame();
        InitTutPopup();




    }

    public void InitTutPopup() {
        Button gotit;

        inittutDialog.setContentView(R.layout.initial_tutorial);

        gotit = (Button) inittutDialog.findViewById(R.id.gotit);
        gotit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inittutDialog.dismiss();
            }
        });
        inittutDialog.show();
    }


    public void ShowShopPopup(View v) {
        TextView txtclose;
        TextView butProt;
        TextView butDNA;
        TextView butPro;
        TextView butBac;
        TextView butEuk;
        TextView butCol;
        TextView butFun;
        TextView butPla;
        TextView butAni;

        TextView txtProt;
        TextView txtDNA;
        TextView txtPro;
        TextView txtBac;
        TextView txtEuk;
        TextView txtCol;
        TextView txtFun;
        TextView txtPla;
        TextView txtAni;

        shopDialog.setContentView(R.layout.popup_shop);
        txtclose = (TextView) shopDialog.findViewById(R.id.closebtn);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopDialog.dismiss();
            }
        });
        butProt = (TextView) shopDialog.findViewById(R.id.Protbtn);
        butDNA = (TextView) shopDialog.findViewById(R.id.DNAbtn);
        butPro = (TextView) shopDialog.findViewById(R.id.Probtn);
        butBac =  (TextView) shopDialog.findViewById(R.id.Bacbtn);
        butEuk = (TextView) shopDialog.findViewById(R.id.Eukbtn);
        butCol =  (TextView) shopDialog.findViewById(R.id.Colbtn);
        butFun =  (TextView) shopDialog.findViewById(R.id.Funbtn);
        butPla =  (TextView) shopDialog.findViewById(R.id.Plabtn);
        butAni =  (TextView) shopDialog.findViewById(R.id.Anibtn);

        butProt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.ShoplogicProt();
            }
        });

        butDNA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.ShoplogicDNA();
            }
        });

        butPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.ShoplogicPro();
            }
        });

        butBac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.ShoplogicBac();
            }
        });

        butEuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.ShoplogicEuk();
            }
        });

        butCol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.ShoplogicCol();
            }
        });

        butFun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.ShoplogicFun();
            }
        });

        butPla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.ShoplogicPla();
            }
        });

        butAni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.ShoplogicAni();
                game.ShopLogicReset();
                shopDialog.dismiss();
                mainmenuDialog.dismiss();
            }
        });

         txtProt = (TextView) shopDialog.findViewById(R.id.Prottxt);
         txtDNA = (TextView) shopDialog.findViewById(R.id.DNAtxt);
         txtPro = (TextView) shopDialog.findViewById(R.id.Protxt);
         txtBac = (TextView) shopDialog.findViewById(R.id.Bactxt);
         txtEuk = (TextView) shopDialog.findViewById(R.id.Euktxt);
         txtCol = (TextView) shopDialog.findViewById(R.id.Coltxt);
         txtFun = (TextView) shopDialog.findViewById(R.id.Funtxt);
         txtPla = (TextView) shopDialog.findViewById(R.id.Platxt);
         txtAni = (TextView) shopDialog.findViewById(R.id.Anitxt);

        txtProt.setText("Proteins: " + game.getProteins());
        txtDNA.setText("DNA: " + game.getDna());
        txtPro.setText("Prokaryotes: " + game.getProkaryote());
        txtBac.setText("Bacteria: " + game.getBacteria());
        txtEuk.setText("Eukaryotes: " + game.getEukaryote());
        txtCol.setText("Colonies: " + game.getColony());
        txtFun.setText("Fungi: " + game.getFungi());
        txtPla.setText("Plants: " + game.getPlants());
        txtAni.setText("Animals: " + game.getAnimals());
        gameView.invalidate();
        shopDialog.show();
    }


    public void ShowMainMenuPopup (View v) {
        TextView txtclose;
        final TextView newgame;
        TextView particles;
        TextView save;

        mainmenuDialog.setContentView(R.layout.menu);

        newgame = (TextView) mainmenuDialog.findViewById(R.id.newGame);
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.newGame();
                mainmenuDialog.dismiss();
        }
        });

        txtclose = (TextView) mainmenuDialog.findViewById(R.id.closebtn);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainmenuDialog.dismiss();
            }
        });

        mainmenuDialog.show();
    }



    public void ShowParticlePopup(View v) {
        TextView txtclose;
        TextView h20text;
        TextView gastext;
        TextView mattertext;
        TextView metaltext;
        TextView rocktext;
        TextView temptext;
        particleDialog.setContentView(R.layout.particles_count);
        txtclose = (TextView) particleDialog.findViewById(R.id.closebtn);
        h20text = (TextView) particleDialog.findViewById(R.id.h20counter);
        gastext = (TextView) particleDialog.findViewById(R.id.gascounter);
        mattertext = (TextView) particleDialog.findViewById(R.id.mattercounter);
        metaltext = (TextView) particleDialog.findViewById(R.id.metalcounter);
        rocktext = (TextView) particleDialog.findViewById(R.id.rockcounter);
        temptext = (TextView) particleDialog.findViewById(R.id.tempcounter);
        h20text.setText("H2O: " + game.getH20Points());
        gastext.setText("Gas: "+ game.getGaspoints());
        mattertext.setText("Matter: "+ game.getMatterpoints());
        metaltext.setText("Metal: "+ game.getMetalpoints());
        rocktext.setText("Rock: "+ game.getRockpoints());
        temptext.setText("Temp: "+ game.getTemperature());
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                particleDialog.dismiss();
            }
        });

        particleDialog.show();
    }
}
