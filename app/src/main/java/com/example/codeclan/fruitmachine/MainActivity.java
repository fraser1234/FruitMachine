package com.example.codeclan.fruitmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private ImageView images1, images2, images3, images4, images5;
    private Spin spin1, spin2, spin3, spin4, spin5;
    private Button button;
    private boolean gameStarted;

    public static final Random RANDOM = new Random();

    public static long randomLong(int lower, int upper) {
        return lower + (long) (RANDOM.nextDouble() * (upper - lower));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images1 = (ImageView) findViewById(R.id.image1);
        images2 = (ImageView) findViewById(R.id.image2);
        images3 = (ImageView) findViewById(R.id.image3);
        images4 = (ImageView) findViewById(R.id.image4);
        images5 = (ImageView) findViewById(R.id.image5);
        result = (TextView)findViewById(R.id.result);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameStarted){
                    spin1.stopSpin();
                    spin2.stopSpin();
                    spin3.stopSpin();
                    spin4.stopSpin();
                    spin5.stopSpin();

                    if(spin1.currentIndex == spin2.currentIndex && spin2.currentIndex == spin3.currentIndex && spin3.currentIndex == spin4.currentIndex && spin4.currentIndex == spin5.currentIndex){
                        result.setText("Congratulations! you have won 5 of the Queens finest British Pounds!!!"); // enter the counter here so that it can tally the amount mamde in each game
                    } else if (spin1.currentIndex == spin2.currentIndex && spin2.currentIndex == spin3.currentIndex
                            || spin2.currentIndex == spin3.currentIndex && spin3.currentIndex == spin4.currentIndex
                            || spin3.currentIndex == spin4.currentIndex && spin4.currentIndex == spin5.currentIndex
                            || spin1.currentIndex == spin3.currentIndex && spin3.currentIndex == spin5.currentIndex
                            || spin1.currentIndex == spin4.currentIndex && spin4.currentIndex == spin5.currentIndex
                            || spin2.currentIndex == spin3.currentIndex && spin3.currentIndex == spin5.currentIndex
                            || spin2.currentIndex == spin4.currentIndex && spin4.currentIndex == spin5.currentIndex){
                        result.setText("So Close! Three Correct! for that effort you collect 3 of the Queens British Pounds"); // enter counter here to tally 3 onto the score
                    }else{
                        result.setText("You didnt manage to match three fruits, try again!!!");
                    }

                    button.setText("Go!");
                    gameStarted = false;
            }   else {

                spin1 = new Spin(new Spin.SpinLoader(){
                    @Override
                    public void newImage(final int img) {
                        runOnUiThread(new Runnable(){
                            @Override
                            public void run(){
                                images1.setImageResource(image);
                            }
                        });
                    }
                },50, randomLong(0, 100));// random section figure this out



        };
    }

    // oncreate menu option to contain rules, how to play etc.

}
    }
