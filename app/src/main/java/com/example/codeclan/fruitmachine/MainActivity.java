package com.example.codeclan.fruitmachine;

import android.content.Intent;
import android.media.MediaPlayer;
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

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private ImageView images1, images2, images3, images4, images5;
    private Spin spin1, spin2, spin3, spin4, spin5;
    private Button button;
    private boolean gameStarted;
    private TextView scoreCounter;
    private Counter counter;

    public static final Random RANDOM = new Random();

    public static long randomInt(int lower, int upper) {
        return lower + (long) (RANDOM.nextDouble() * (upper - lower));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
        button = (Button) findViewById(R.id.button);
        scoreCounter = (TextView)findViewById(R.id.scoreCounter);
        images1 = (ImageView) findViewById(R.id.images1);
        images2 = (ImageView) findViewById(R.id.images2);
        images3 = (ImageView) findViewById(R.id.images3);
        images4 = (ImageView) findViewById(R.id.images4);
        images5 = (ImageView) findViewById(R.id.images5);
        counter = new Counter();
        final MediaPlayer moneySound = MediaPlayer.create(this, R.raw.moneysound);
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
                    spin5.stopSpin();

                    if (spin1.currentIndex == spin2.currentIndex && spin2.currentIndex == spin3.currentIndex && spin3.currentIndex == spin4.currentIndex && spin4.currentIndex == spin5.currentIndex) {
                        result.setText("Congratulations! you matched all 5! You Win £5!");
                        counter.increaseByFive();
                        scoreCounter.setText(counter.getWinnings().toString());
                        // enter the counter here so that it can tally the amount mamde in each game
                    } else if (spin1.currentIndex == spin2.currentIndex && spin2.currentIndex == spin3.currentIndex
                            || spin2.currentIndex == spin3.currentIndex && spin3.currentIndex == spin4.currentIndex
                            || spin3.currentIndex == spin4.currentIndex && spin4.currentIndex == spin5.currentIndex
                            || spin1.currentIndex == spin3.currentIndex && spin3.currentIndex == spin5.currentIndex
                            || spin1.currentIndex == spin4.currentIndex && spin4.currentIndex == spin5.currentIndex
                            || spin2.currentIndex == spin3.currentIndex && spin3.currentIndex == spin5.currentIndex
                            || spin2.currentIndex == spin4.currentIndex && spin4.currentIndex == spin5.currentIndex
                            || spin1.currentIndex == spin2.currentIndex && spin2.currentIndex == spin5.currentIndex
                            || spin1.currentIndex == spin3.currentIndex && spin3.currentIndex == spin4.currentIndex
                            || spin1.currentIndex == spin2.currentIndex && spin2.currentIndex == spin4.currentIndex) {
                        result.setText("So Close! Three Correct! You Win £3");
                        counter.increaseByThree();
                        scoreCounter.setText(counter.getWinnings().toString());// enter counter here to tally 3 onto the score
                    } else {
                        result.setText("You didnt manage to match three fruits, try again!");
                    }

                    button.setText("Go!");

                    gameStarted = false;


                } else {

                    spin1 = new Spin(new Spin.SpinLoader() {
                        @Override
                        public void newImage(final int image) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run(){
                                    images1.setImageResource(image);
                        }
                    });
                        }
                    }, 50, (int) randomInt(0, 100));

                    spin1.start();

                    spin2 = new Spin(new Spin.SpinLoader() {
                        @Override
                        public void newImage(final int image) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run(){
                                    images2.setImageResource(image);
                                }
                            });
                        }
                    }, 50, (int) randomInt(0, 100));

                    spin2.start();

                    spin3 = new Spin(new Spin.SpinLoader() {
                        @Override
                        public void newImage(final int image) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run(){
                                    images3.setImageResource(image);
                                }
                            });
                        }
                    }, 50, (int) randomInt(0, 100));

                    spin3.start();

                    spin4 = new Spin(new Spin.SpinLoader() {
                        @Override
                        public void newImage(final int image) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run(){
                                    images4.setImageResource(image);
                                }
                            });
                        }
                    }, 50, (int) randomInt(0, 100));

                    spin4.start();

                    spin5 = new Spin(new Spin.SpinLoader() {
                        @Override
                        public void newImage(final int image) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run(){
                                    images5.setImageResource(image);
                                }
                            });
                        }
                    }, 50, (int) randomInt(0, 100));

                    spin5.start();

                    button.setText("Stop");
                    moneySound.start();
                    gameStarted = true;

                }
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.tell_rules){
            for (int i=0; i < 2; i++){
            Toast.makeText(MainActivity.this, "So Simple! All you have to do is click go and then after your desired length of time, press STOP and see how much money you have won!!!" , Toast.LENGTH_LONG).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
