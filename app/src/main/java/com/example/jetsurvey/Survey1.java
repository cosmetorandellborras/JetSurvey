package com.example.jetsurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.example.jetsurvey.databinding.ActivitySurvey1Binding;

public class Survey1 extends AppCompatActivity {

    private ActivitySurvey1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySurvey1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.readcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    binding.readchecklayout.setBackgroundResource(R.drawable.layoutchecked);
                    binding.nextButton.setEnabled(true);
                }
                else{
                    binding.readchecklayout.setBackgroundResource(R.drawable.layoutunchecked);
                }
            }
        });
        binding.workoutcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    binding.workoutlayout.setBackgroundResource(R.drawable.layoutchecked);
                    binding.nextButton.setEnabled(true);
                }else{
                    binding.workoutlayout.setBackgroundResource(R.drawable.layoutunchecked);
                }
            }
        });
        binding.drawcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    binding.drawlayout.setBackgroundResource(R.drawable.layoutchecked);
                    binding.nextButton.setEnabled(true);
                }else{
                    binding.drawlayout.setBackgroundResource(R.drawable.layoutunchecked);
                }
            }
        });
        binding.playvidogamescheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    binding.playvideogameslayout.setBackgroundResource(R.drawable.layoutchecked);
                    binding.nextButton.setEnabled(true);
                }else{
                    binding.playvideogameslayout.setBackgroundResource(R.drawable.layoutunchecked);
                }
            }
        });

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Survey2.class);
                //intent.putExtra();
                startActivity(intent);
            }
        });

    }
}