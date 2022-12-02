package com.example.jetsurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.example.jetsurvey.databinding.ActivitySingIn1Binding;

public class SingIn_1 extends AppCompatActivity {

    private ActivitySingIn1Binding binding;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySingIn1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        getSupportActionBar().hide();

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        binding.secondLayoutEmailEditText.setText(email);

        if(binding.secondLayoutEmailEditText.getText().toString().length()>0){
            binding.secondContinueButton.setEnabled(true);
            binding.secondSingInButton.setEnabled(true);
        }

        binding.secondLayoutEmailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.secondContinueButton.setEnabled(true);
                binding.secondSingInButton.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.secondContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAndpassword = preferences.getString("emailAndPassword",binding.secondLayoutEmailEditText.getText().toString());
                String[] email2AndPaswword = emailAndpassword.split(",");
                Log.i("EMAIL",email2AndPaswword[0]);
                Log.i("EMAIL",email2AndPaswword[1]);
                if(email2AndPaswword[0].equals(binding.secondLayoutEmailEditText.getText().toString())){
                    Intent intent = new Intent(getApplicationContext(),SingInAct3.class);
                    intent.putExtra("email",binding.secondLayoutEmailEditText.getText().toString());
                    intent.putExtra("value","continue");
                    startActivity(intent);
                }
                else{
                    binding.secondLayoutEmailEditText.setText("");
                }

            }
        });
        binding.secondSingInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SingInAct3.class);
                intent.putExtra("email",binding.secondLayoutEmailEditText.getText().toString());
                intent.putExtra("value","singin");
                startActivity(intent);
            }
        });

    }
}