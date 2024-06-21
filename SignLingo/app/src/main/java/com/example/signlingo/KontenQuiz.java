package com.example.signlingo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class KontenQuiz extends AppCompatActivity implements View.OnClickListener {

    private TextView questionTextView;
    private ImageView imageView;
    private Button choiceOneButton, choiceTwoButton;
    private List<Question> questionList;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konten_quiz);

        questionTextView = findViewById(R.id.Question);
        imageView = findViewById(R.id.Image_view);
        choiceOneButton = findViewById(R.id.ChoiceOne);
        choiceTwoButton = findViewById(R.id.ChoiceTwo);

        choiceOneButton.setOnClickListener(this);
        choiceTwoButton.setOnClickListener(this);

        questionList = new ArrayList<>();
        // Tambahkan pertanyaan, gambar, pilihan jawaban, dan kunci jawaban
        questionList.add(new Question(R.drawable.first, "Which sign is this?", new String[]{"A", "O"}, "A"));
        questionList.add(new Question(R.drawable.botak, "What bout thiss?", new String[]{"Good", "Bad"}, "Good"));
        questionList.add(new Question(R.drawable.thanku, "What is it?", new String[]{"Thank you", "Well played"}, "Thank you"));
        questionList.add(new Question(R.drawable.ok, "Which sign is this?", new String[]{"NOPE", "OK"}, "OK"));
        // Tambahkan pertanyaan lainnya di sini

        displayQuestion();
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questionList.size()) {
            Question currentQuestion = questionList.get(currentQuestionIndex);
            questionTextView.setText(currentQuestion.getQuestionText());
            imageView.setImageResource(currentQuestion.getImageResId());
            choiceOneButton.setText(currentQuestion.getChoices()[0]);
            choiceTwoButton.setText(currentQuestion.getChoices()[1]);
        } else {
            // Jika sudah tidak ada pertanyaan lagi, tampilkan skor
            showScoreActivity();
        }
    }

    @Override
    public void onClick(View view) {
        Question currentQuestion = questionList.get(currentQuestionIndex);
        String selectedChoice = "";

        if (view == choiceOneButton) {
            selectedChoice = choiceOneButton.getText().toString();
        } else if (view == choiceTwoButton) {
            selectedChoice = choiceTwoButton.getText().toString();
        }

        if (selectedChoice.equals(currentQuestion.getCorrectAnswer())) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            score++;
            currentQuestionIndex++;
            displayQuestion();
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showScoreActivity() {
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }

    private class Question {
        private int imageResId;
        private String questionText;
        private String[] choices;
        private String correctAnswer;

        public Question(int imageResId, String questionText, String[] choices, String correctAnswer) {
            this.imageResId = imageResId;
            this.questionText = questionText;
            this.choices = choices;
            this.correctAnswer = correctAnswer;
        }

        public int getImageResId() {
            return imageResId;
        }

        public String getQuestionText() {
            return questionText;
        }

        public String[] getChoices() {
            return choices;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }
    }
}