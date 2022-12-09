package com.example.jetsurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.jetsurvey.databinding.ActivitySurvey2Binding;

import java.util.ArrayList;

public class Survey2 extends AppCompatActivity {

    private ActivitySurvey2Binding binding;
    private String film;
    private ArrayList<CharSequence> options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySurvey2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        options = new ArrayList<>();

        Intent intent = getIntent();
        options = intent.getCharSequenceArrayListExtra("check");

        binding.previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(),Survey1.class);
               startActivity(intent);
            }
        });

        binding.nextButtonSurvey2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ResultScreen.class);
                intent.putExtra("film",film);
                intent.putCharSequenceArrayListExtra("hobbie",options);
                startActivity(intent);
            }
        });

        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioButton1:
                        film = binding.radioButton1.getText().toString();
                        binding.nextButtonSurvey2.setEnabled(true); break;
                    case R.id.radioButton2:
                        film = binding.radioButton2.getText().toString();
                        binding.nextButtonSurvey2.setEnabled(true); break;
                    case R.id.radioButton3:
                        film = binding.radioButton3.getText().toString();
                        binding.nextButtonSurvey2.setEnabled(true); break;
                    case R.id.radioButton4:
                        film = binding.radioButton4.getText().toString();
                        binding.nextButtonSurvey2.setEnabled(true); break;
                }
            }
        });
    }
}