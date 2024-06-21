package com.example.signlingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Option extends AppCompatActivity {

    ImageButton ButtonOne, ButtonTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        ButtonOne = (ImageButton) findViewById(R.id.Quiz);

        ButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent BukaStrClick = new Intent(getApplicationContext(), KontenQuiz.class);
                startActivity(BukaStrClick);
            }
        });

        ButtonTwo = (ImageButton) findViewById(R.id.Dictionary);

        ButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent BukaStrClick = new Intent(getApplicationContext(), KontenDictionary.class);
                startActivity(BukaStrClick);
            }
        });
    }
}