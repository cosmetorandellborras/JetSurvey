package com.example.jetsurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jetsurvey.databinding.ActivitySurvey2Binding;

public class Survey2 extends AppCompatActivity {

    private ActivitySurvey2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySurvey2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
    }
}