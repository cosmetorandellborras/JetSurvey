package com.example.jetsurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.jetsurvey.databinding.ActivitySingInAct3Binding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SingInAct3 extends AppCompatActivity {

    private ActivitySingInAct3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySingInAct3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        getSupportActionBar().hide();
        Intent intent = getIntent();
        if(intent.getStringExtra("value").equals("continue")){
            binding.singIn3.setText("Continue");
            binding.thirdActsingInButt.setText("Continue");
        }else if(intent.getStringExtra("value").equals("singin")){
            binding.singIn3.setText("Sing in");
            binding.thirdActsingInButt.setText("Sing in");
        }
        binding.thirdEmailEditText.setText(intent.getStringExtra("email"));

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.thirdPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String password = charSequence.toString();
                if(binding.singIn3.getText().equals("Sing in")){
                    if(password.length()>=8){
                        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
                        Matcher matcher = pattern.matcher(password);
                        boolean isPwdContainsSpeChar = matcher.find();
                        if(isPwdContainsSpeChar){
                            binding.layoutThirdPassword.setHelperText("Strong Password");
                            binding.thirdActsingInButt.setEnabled(true);
                        }
                        else{
                            binding.layoutThirdPassword.setHelperText("");
                            binding.layoutThirdPassword.setError("Weak Password. Include minimun 1 special char");
                            binding.thirdActsingInButt.setEnabled(false);
                        }
                    }else{
                        binding.layoutThirdPassword.setHelperText("Enter minimum 8 characters");
                        binding.layoutThirdPassword.setError("");
                        binding.thirdActsingInButt.setEnabled(false);
                    }
                }
                else{
                    String emailAndpassword = preferences.getString("emailAndPassword",binding.thirdEmailEditText.getText().toString());
                    String[] email2AndPaswword = emailAndpassword.split(",");
                    if(password.equals(email2AndPaswword[1])){
                        binding.layoutThirdPassword.setHelperText("Correct Password");
                        binding.thirdActsingInButt.setEnabled(true);
                    }
                    else{
                        binding.layoutThirdPassword.setError("Invalid password");
                        binding.thirdActsingInButt.setEnabled(false);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.thirdActsingInButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.thirdActsingInButt.equals("Continue")){
                    Intent intent = new Intent(getApplicationContext(),Survey1.class);
                    startActivity(intent);
                }else{
                    editor.putString("emailAndPassword",binding.thirdEmailEditText.getText().toString()+","+binding.thirdPasswordEditText.getText().toString());
                    editor.commit();
                    Intent intent = new Intent(getApplicationContext(),Survey1.class);
                    startActivity(intent);
                }

            }
        });
    }
}