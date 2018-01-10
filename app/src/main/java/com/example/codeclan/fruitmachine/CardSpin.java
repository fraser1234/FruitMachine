package com.example.codeclan.fruitmachine;

/**
 * Created by fraserblack on 10/01/2018.
 */

public class CardSpin extends Thread {

    interface CardSpinLoader {
        void newImage(int image); // dont know why this is wokring, but it does so leave it alone
    }

    //abstract class for spin is not working. throws up major error in the main activty, however needs to be abstract to use the interface??? interface can be contained within the class which means it doesnt have to be abstract

    private  static int[] images = {R.drawable.cardsuit, R.drawable.cardheart, R.drawable.carddiamond, R.drawable.cardclubs };
    public int currentIndex;
    public int spinTime;
    public int startGame;
    public boolean gameStarted;
    public CardSpinLoader spinLoader;



    public CardSpin(CardSpinLoader spinLoader, int spinTime, int startGame){
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
