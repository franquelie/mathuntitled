package com.example.mathuntitled;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
        setContentView(R.layout.activity_main);

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

    }

    void loadQuestion() {
        questionTextView.setText(Questions.question[currentQuestion]);
        ansA.setText(Questions.choices[currentQuestion][0]);
        ansB.setText(Questions.choices[currentQuestion][1]);
        ansC.setText(Questions.choices[currentQuestion][2]);
        ansD.setText(Questions.choices[currentQuestion][3]);

    }
}
