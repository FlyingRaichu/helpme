package com.example.planetcraft;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class GameView extends View {
    Game game;

    int h,w; //used for storing our height and width of the view

    public void setGame(Game game)
    {
        this.game = game;
    }


    /* The next 3 constructors are needed for the Android view system,
    when we have a custom view.
     */
    public GameView(Context context) {
        super(context);

    }

    public GameView(Context context, AttributeSet attrs) {
        super(context,attrs);
    }


    public GameView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context,attrs,defStyleAttr);
    }

    //In the onDraw we put all our code that should be
    //drawn whenever we update the screen.
    @Override
    protected void onDraw(Canvas canvas) {
        //Here we get the height and weight
        h = canvas.getHeight();
        w = canvas.getWidth();
        //update the size for the canvas to the game.
        game.setSize(h,w);
        Log.d("GAMEVIEW","h = "+h+", w = "+w);
        //Making a new paint object
        Paint paint = new Paint();
        canvas.drawColor(Color.rgb(0, 8, 28)); //background colour
        int centerPlanetBitX = game.getAsteroidBitmap().getWidth()/2;
        int centerPlanetBitY = game.getAsteroidBitmap().getHeight()/2;


        //bitmap rendering
            canvas.drawBitmap(game.getAsteroidBitmap(), getPivotX() - centerPlanetBitX, getPivotY() - centerPlanetBitY, paint);


        if (game.Gasgiantswitch()) {
            canvas.drawColor(Color.rgb(0, 8, 28)); //hides the previous planet's bitmap
            canvas.drawBitmap(game.getGasgiantBitmap(),getPivotX() - centerPlanetBitX, getPivotY() - centerPlanetBitY, paint);
        }

        if (game.Habitableswitchbit()) {
            canvas.drawColor(Color.rgb(0, 8, 28)); //hides the previous planet's bitmap
            canvas.drawBitmap(game.getHabitableBitmap(),getPivotX() - centerPlanetBitX, getPivotY() - centerPlanetBitY, paint);
        }

        if (game.Icerockyswitch()) {
            canvas.drawColor(Color.rgb(0, 8, 28)); //hides the previous planet's bitmap
            canvas.drawBitmap(game.getIcyplanetBitmap(),getPivotX() - centerPlanetBitX, getPivotY() - centerPlanetBitY, paint);
        }

        if (game.Lavaswitch()) {
            canvas.drawColor(Color.rgb(0, 8, 28)); //hides the previous planet's bitmap
            canvas.drawBitmap(game.getLavaplanetBitmap(),getPivotX() - centerPlanetBitX, getPivotY() - centerPlanetBitY, paint);
        }

        if (game.Rockyswitch()) {
            canvas.drawColor(Color.rgb(0, 8, 28)); //hides the previous planet's bitmap
            canvas.drawBitmap(game.getRockyplanetBitmap(),getPivotX() - centerPlanetBitX, getPivotY() - centerPlanetBitY, paint);
        }

        if (game.Starmswitch()) {
            canvas.drawColor(Color.rgb(0, 8, 28)); //hides the previous planet's bitmap
            canvas.drawBitmap(game.getStarmBitmap(),getPivotX() - centerPlanetBitX, getPivotY() - centerPlanetBitY, paint);
        }

        if (game.Watergiantswitch()) {
            canvas.drawColor(Color.rgb(0, 8, 28)); //hides the previous planet's bitmap
            canvas.drawBitmap(game.getWatergiantBitmap(),getPivotX() - centerPlanetBitX, getPivotY() - centerPlanetBitY, paint);
        }

        for(Particle_H20 h20 : game.particles_h20) {
            if (!h20.getIsCollected()) {
                canvas.drawBitmap(game.getH20ParticleBitmap(), h20.getH20_x(), h20.getH20_y(), paint);

            }
        }

        for(Particle_Metal metal : game.particles_metal) {
            if (!metal.getIsCollected()) {
                canvas.drawBitmap(game.getMetalParticleBitmap(), metal.getMetal_x(), metal.getMetal_y(), paint);

            }
        }

        for(Particle_Gas gas : game.particles_gas) {
            if (!gas.getIsCollected()) {
                canvas.drawBitmap(game.getGasParticleBitmap(), gas.getGas_x(), gas.getGas_y(), paint);

            }
        }

        for(Particle_Rock rock : game.particles_rock) {
            if (!rock.getIsCollected()) {
                canvas.drawBitmap(game.getRockParticleBitmap(), rock.getRock_x(), rock.getRock_y(), paint);

            }
        }

        for(Particle_tempup tempup : game.particles_tempup) {
            if (!tempup.getIsCollected()) {
                canvas.drawBitmap(game.getTempupParticleBitmap(), tempup.getTempup_x(), tempup.getTempup_y(), paint);

            }
        }

        for(Particle_tempdown tempdown : game.particles_tempdown) {
            if (!tempdown.getIsCollected()) {
                canvas.drawBitmap(game.getTempdownParticleBitmap(), tempdown.getTempdown_x(), tempdown.getTempdown_y(), paint);

            }
        }

        for(Particle_Lmatter matter : game.particles_lmatter) {
            if (!matter.getIsCollected()) {
                canvas.drawBitmap(game.getMatterParticleBitmap(), matter.getLmatter_x(), matter.getLmatter_y(), paint);

            }
        }

        super.onDraw(canvas);
    }

}
