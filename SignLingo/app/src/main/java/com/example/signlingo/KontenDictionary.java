package com.example.signlingo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class KontenDictionary extends AppCompatActivity {

    private EditText alphabetInput;
    private ImageView handSignImage;
    private TextView explanationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konten_dictionary);

        alphabetInput = findViewById(R.id.Alphabet);
        handSignImage = findViewById(R.id.Handsign);
        explanationText = findViewById(R.id.Explain);

        alphabetInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    char input = Character.toLowerCase(s.charAt(0));
                    updateDictionary(input);
                }
            }
        });
    }

    private void updateDictionary(char input) {
        int imageResource;
        String explanation;

        switch (input) {
            case 'a':
                imageResource = R.drawable.a;
                explanation = "Place the palm facing forward, fingers together with the thumb touching the side of the palm";
                break;
            case 'b':
                imageResource = R.drawable.b;
                explanation = "Hold the hand up, palm facing forward. Keep your thumb tucked against your palm and your fingers straight up";
                break;
            case 'c':
                imageResource = R.drawable.c;
                explanation = "Form the palm into a 'C' shape with fingers and thumb curved";
                break;
            case 'd':
                imageResource = R.drawable.d;
                explanation = "Raise the index finger straight up, with the other fingers and thumb touching the palm";
                break;
            case 'e':
                imageResource = R.drawable.e;
                explanation = "Fold all fingers to touch the palm, with the thumb bent over the fingers";
                break;
            case 'f':
                imageResource = R.drawable.f;
                explanation = "Touch the tip of the thumb with the tip of the index finger to form a circle, while the other fingers are open";
                break;
            case 'g':
                imageResource = R.drawable.g;
                explanation = "Point the index finger and thumb straight to the side, with the other fingers folded into the palm";
                break;
            case 'h':
                imageResource = R.drawable.h;
                explanation = "Raise the index and middle fingers straight forward, with the other fingers folded into the palm";
                break;
            case 'i':
                imageResource = R.drawable.i;
                explanation = "Raise the pinky finger straight up, with the other fingers folded into the palm";
                break;
            case 'j':
                imageResource = R.drawable.j;
                explanation = "Make a downward and sideways curved motion with the pinky finger to outline the letter 'J'";
                break;
            case 'k':
                imageResource = R.drawable.k;
                explanation = " Raise the index and middle fingers straight up, with the thumb touching the middle between them";
                break;
            case 'l':
                imageResource = R.drawable.l;
                explanation = "Raise the index finger straight up and the thumb straight to the side, forming a 90-degree angle";
                break;
            case 'm':
                imageResource = R.drawable.m;
                explanation = "Fold the three middle fingers into the palm, with the thumb pressing over them";
                break;
            case 'n':
                imageResource = R.drawable.n;
                explanation = "Fold the two middle fingers into the palm, with the thumb pressing over them";
                break;
            case 'o':
                imageResource = R.drawable.o;
                explanation = "Form the palm into an 'O' shape with the fingertips and thumb touching";
                break;
            case 'p':
                imageResource = R.drawable.p;
                explanation = "Point the index and middle fingers straight down, with the thumb touching the middle between them";
                break;
            case 'q':
                imageResource = R.drawable.q;
                explanation = "Point the index finger and thumb straight down, with the other fingers folded into the palm";
                break;
            case 'r':
                imageResource = R.drawable.r;
                explanation = "Cross the index and middle fingers in front, with the other fingers folded into the palm";
                break;
            case 's':
                imageResource = R.drawable.s;
                explanation = "Make a fist with the thumb curled in front of the other fingers";
                break;
            case 't':
                imageResource = R.drawable.t;
                explanation = "Make a fist with the thumb tucked between the index and middle fingers";
                break;
            case 'u':
                imageResource = R.drawable.u;
                explanation = "Raise the index and middle fingers straight up, with the other fingers folded into the palm";
                break;
            case 'v':
                imageResource = R.drawable.v;
                explanation = "Raise the index and middle fingers forming a 'V', with the other fingers folded into the palm";
                break;
            case 'w':
                imageResource = R.drawable.w;
                explanation = "Raise the index, middle, and ring fingers straight up, with the other fingers folded into the palm";
                break;
            case 'x':
                imageResource = R.drawable.x;
                explanation = "Bend the index finger forward, with the other fingers folded into the palm";
                break;
            case 'y':
                imageResource = R.drawable.y;
                explanation = "Raise the thumb and pinky finger straight to the side, with the other fingers folded into the palm";
                break;
            case 'z':
                imageResource = R.drawable.z;
                explanation = "Draw the letter 'Z' in the air with the index finger straight forward, with the other fingers folded into the palm";
                break;

            default:
                imageResource = R.drawable.default_sign;
                explanation = "Pagi-pagi pasang keramik, malam- malam adu MEKANIKKK";
                break;
        }

        handSignImage.setImageResource(imageResource);
        explanationText.setText(explanation);
    }
}