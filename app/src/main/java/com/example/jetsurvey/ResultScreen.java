package com.example.jetsurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jetsurvey.databinding.ActivityResultScreenBinding;

import java.util.ArrayList;

public class ResultScreen extends AppCompatActivity {

    private ActivityResultScreenBinding binding;
    private ArrayList<CharSequence> options;
    private String film;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        options = new ArrayList<>();
        Intent intent = getIntent();

        options = intent.getCharSequenceArrayListExtra("hobbie");
        film = intent.getStringExtra("film");

        for(int i=0;i<options.size();i++){
            binding.freeTimeOptions.append("-" +options.get(i)+"\n");
        }
        binding.filmResult.setText(film);



    }
}