package com.example.codeclan.fruitmachine;

/**
 * Created by fraserblack on 07/01/2018.
 */

public class Spin extends Thread {

    // nested interface or normal interface?
    interface SpinLoader{
        void newImage(int images);
    }

    private  static int[] images = {};
    public int currentIndex;
    public int spinTime;
    public int startGame;
    public boolean gameStarted;
    public SpinLoader spinLoader;


    public Spin(int currentIndex, int spinTime, int startGame, SpinLoader spinLoader){
        this.currentIndex = 0;
        this.gameStarted = true;
        this.spinTime = spinTime;
        this.startGame = startGame;
        this.spinLoader = spinLoader;
    }

    //play method look up what a try loop does
    public void run() {
        try {
            Thread.sleep(startGame);
        } catch (InterruptedException e) {
        }

        while(gameStarted) {
            try {
                Thread.sleep(spinTime);
            } catch (InterruptedException e) {
            }

            nextImage();

            if (spinLoader != null) {
                spinLoader.newImage(images[currentIndex]); // need to decide about interface, should really move it to make it look like my own work
            }
        }
    }

    //stop method
    public void stopSpin() {
        gameStarted = false;
    }

    // next image in reel method
    public void nextImage(){
        currentIndex++;

        if(currentIndex == images.length){
            currentIndex = 0;
        }

    }

}
