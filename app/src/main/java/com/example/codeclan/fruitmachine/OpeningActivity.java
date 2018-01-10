package com.example.codeclan.fruitmachine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OpeningActivity extends AppCompatActivity {

    private TextView selectGame;
    private Button fruitMachineButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        selectGame = (TextView) findViewById(R.id.selectGame);
        fruitMachineButton = (Button) findViewById(R.id.fruitMachineButton);
    }

    public void onFruitMachineButtonClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }




}
