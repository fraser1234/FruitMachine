package com.example.codeclan.fruitmachine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class CardGameActivity extends AppCompatActivity {

    private Counter counter;
    private Button button;
    private boolean gameStarted;
    private CardSpin spin1, spin2, spin3, spin4;
    private ImageView cardimage1, cardimage2, cardimage3, cardimage4;
    private TextView cardResult;
    private TextView scoreCounter;

    public static final Random RANDOM = new Random();

    public static long randomInt(int lower, int upper) {
        return lower + (long) (RANDOM.nextDouble() * (upper - lower));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_game);
        cardimage1 = (ImageView) findViewById(R.id.cardimage1);
        cardimage2 = (ImageView) findViewById(R.id.cardimage2);
        cardimage3 = (ImageView) findViewById(R.id.cardimage3);
        cardimage4 = (ImageView) findViewById(R.id.cardimage4);
        counter = new Counter();
        button = (Button) findViewById(R.id.cardGoButton);
        cardResult = (TextView) findViewById(R.id.cardResult);
        scoreCounter = (TextView) findViewById(R.id.scoreCounter);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameStarted) {
                    spin1.stopSpin();
                    spin2.stopSpin();
                    spin3.stopSpin();
                    spin4.stopSpin();

                    if (spin1.currentIndex == spin2.currentIndex && spin2.currentIndex == spin3.currentIndex && spin3.currentIndex == spin4.currentIndex) {
                        cardResult.setText("Congratulations! you matched all 4! You Win £4!");
                        counter.increaseByFour();
                        scoreCounter.setText(counter.getWinnings().toString());
                        // enter the counter here so that it can tally the amount mamde in each game
                    } else if (spin1.currentIndex == spin2.currentIndex && spin2.currentIndex == spin3.currentIndex
                            || spin2.currentIndex == spin3.currentIndex && spin3.currentIndex == spin4.currentIndex
                            || spin1.currentIndex == spin3.currentIndex && spin3.currentIndex == spin4.currentIndex
                            || spin1.currentIndex == spin2.currentIndex && spin2.currentIndex == spin4.currentIndex) {
                        cardResult.setText("So Close! Three Correct! You Win £3");
                        counter.increaseByThree();
                        scoreCounter.setText(counter.getWinnings().toString());
                        // enter counter here to tally 3 onto the score
                    } else if (spin1.currentIndex == spin2.currentIndex
                            || spin3.currentIndex == spin4.currentIndex
                            || spin1.currentIndex == spin4.currentIndex
                            || spin2.currentIndex == spin3.currentIndex
                            || spin1.currentIndex == spin3.currentIndex
                            || spin2.currentIndex == spin4.currentIndex){
                        cardResult.setText("So Close! Two Correct! You Win £2");
                        counter.increaseByTwo();
                        scoreCounter.setText(counter.getWinnings().toString());
                    }
                    else {
                        cardResult.setText("You didnt manage to match three suits, try again!");
                    }

                    button.setText("DEAL");

                    gameStarted = false;


                } else {

                    spin1 = new CardSpin(new CardSpin.CardSpinLoader() {
                        @Override
                        public void newImage(final int image) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run(){
                                    cardimage1.setImageResource(image);
                                }
                            });
                        }
                    }, 47, (int) randomInt(0, 100));

                    spin1.start();

                    spin2 = new CardSpin(new CardSpin.CardSpinLoader() {
                        @Override
                        public void newImage(final int image) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run(){
                                    cardimage2.setImageResource(image);
                                }
                            });
                        }
                    }, 48, (int) randomInt(0, 100));

                    spin2.start();

                    spin3 = new CardSpin(new CardSpin.CardSpinLoader() {
                        @Override
                        public void newImage(final int image) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run(){
                                    cardimage3.setImageResource(image);
                                }
                            });
                        }
                    }, 49, (int) randomInt(0, 100));

                    spin3.start();

                    spin4 = new CardSpin(new CardSpin.CardSpinLoader() {
                        @Override
                        public void newImage(final int image) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run(){
                                    cardimage4.setImageResource(image);
                                }
                            });
                        }
                    }, 50, (int) randomInt(0, 100));

                    spin4.start();


                    button.setText("Show Hand");
                    gameStarted = true;

                }
            }

        });
    }



}

