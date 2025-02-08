package com.example.mathuntitled;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.math.untitled.R;

public class MainActivity_Archived extends AppCompatActivity implements View.OnClickListener {

    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score = 0;
    int totalQuestions = Questions.question.length;
    int currentQuestion = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old);

        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.answer_A);
        ansB = findViewById(R.id.answer_B);
        ansC = findViewById(R.id.answer_C);
        ansD = findViewById(R.id.answer_D);
        submitBtn = findViewById(R.id.submit_button);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        loadQuestion();

    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId() == R.id.submit_button) {
            if(selectedAnswer.equals(Questions.correctAnswer[currentQuestion])) {
                score++;
            }

            currentQuestion++;
            loadQuestion();


        } else {
            // choices button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);

        }
    }

    void loadQuestion() {

        if(currentQuestion == totalQuestions) {
            finishQuiz();
            return;
        }

        questionTextView.setText(Questions.question[currentQuestion]);
        ansA.setText(Questions.choices[currentQuestion][0]);
        ansB.setText(Questions.choices[currentQuestion][1]);
        ansC.setText(Questions.choices[currentQuestion][2]);
        ansD.setText(Questions.choices[currentQuestion][3]);

    }

    void finishQuiz() {
        new AlertDialog.Builder(this)
                .setTitle("Quiz Finished")
                .setMessage("Your score is " + score + " out of " + totalQuestions)
                .setPositiveButton("Close", null)
                .setCancelable(false)
                .show();


    }

}
