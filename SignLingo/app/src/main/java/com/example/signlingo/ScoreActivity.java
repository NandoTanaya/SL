package com.example.signlingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

public class ScoreActivity extends AppCompatActivity {

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        btnBack = (Button) findViewById(R.id.whoop);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent BukaStrClick = new Intent(getApplicationContext(),Option.class);
                startActivity(BukaStrClick);
            }
        });

        int score = getIntent().getIntExtra("score", 0);

        TextView scoreTextView = findViewById(R.id.Score);
        scoreTextView.setText(String.valueOf(score));


    }
}