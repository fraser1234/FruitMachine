package com.example.codeclan.fruitmachine;

/**
 * Created by fraserblack on 07/01/2018.
 */
// thread is a thread of execution within a program, uses the run method
public class Spin extends Thread {

    interface SpinLoader {
        void newImage(int image); // dont know why this is wokring, but it does so leave it alone
    }

    //abstract class for spin is not working. throws up major error in the main activty, however needs to be abstract to use the interface??? interface can be contained within the class which means it doesnt have to be abstract

    private  static int[] images = {R.drawable.fruitgrape, R.drawable.fruitcherry, R.drawable.fruitseven, R.drawable.fruitbell, R.drawable.fruitbar, R.drawable.fruitbanana };
    public int currentIndex;
    public int spinTime;
    public int startGame;
    public boolean gameStarted;
    public SpinLoader spinLoader;



    public Spin(SpinLoader spinLoader, int spinTime, int startGame){
        this.currentIndex = 0;
        this.gameStarted = true;
        this.spinTime = spinTime;
        this.startGame = startGame;
        this.spinLoader = spinLoader;
    }

    //thread.sleep acts as a delay method in java
    public void run() {
        try {
            Thread.sleep(startGame);
        } catch (InterruptedException a) {
        }

        while(gameStarted) {
            try {
                Thread.sleep(spinTime);
            } catch (InterruptedException a) {
            }

            nextImage();

            if(spinLoader != null){
            spinLoader.newImage(images[currentIndex]);
            }
    }
    }


    //stop method
    public void stopSpin() {
        gameStarted = false;
    }

    public void newImage(int image){

    }

    // next image in reel method
    public void nextImage(){
        currentIndex++;

        if(currentIndex == images.length){
            currentIndex = 0;
        }

    }

}
