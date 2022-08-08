package com.example.ufustudy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Intent intent = getIntent();
        getSupportActionBar().hide();
    }

    public void inserir_aluno (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void back_button (View view){
        super.onBackPressed();
    }
}