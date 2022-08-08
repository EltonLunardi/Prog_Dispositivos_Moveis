package com.example.ufustudy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText loginEm, loginPass;
    private ImageButton loginBtn;
    private SQLiteDatabase SQLITEDATABASE;
    private SQLiteHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginEm = findViewById(R.id.et_user);
        loginPass = findViewById(R.id.et_pass);
        loginBtn = findViewById(R.id.enter_button);
        DB = new SQLiteHelper(this);
        Intent intent = getIntent();
        getSupportActionBar().hide();
        DB.onCreate(SQLITEDATABASE);

        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String email = loginEm.getText().toString().trim();
                String password = loginPass.getText().toString().trim();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(Login.this, "Todos os campos devem ser preenchidos!!!",Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    Boolean checkUserPass = DB.checkUserPassword(email, password);
                    if(checkUserPass==false){
                        Toast.makeText(Login.this, "NÃ£o foi possivel realizxar o Login. Email ou Senha errados", Toast.LENGTH_LONG).show();
                        return;
                    }
                    else {
                        Toast.makeText(Login.this, "Sucesso no Login", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

    }




    /*
    public void enter_button (View view){
        Intent intent = new Intent(this, index.class);
        startActivity(intent);

    }



    /*
    public void DBCreate(){
        SQLITEDATABASE = openOrCreateDatabase("UFUStudy", Context.MODE_PRIVATE, null);

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS Aluno (\n" +
                "    n_Matricula varchar PRIMARY KEY,\n" +
                "    Nome varchar,\n" +
                "    Sobrenome varchar,\n" +
                "    Curso varchar\n" +
                ");");

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS Disciplina (\n" +
                "    cod varchar PRIMARY KEY,\n" +
                "    Professor varchar,\n" +
                "    Nome varchar,\n" +
                "    Turma char,\n" +
                "    ano_semestre varchar\n" +
                ");");

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS Aluno_Disciplina (\n" +
                "    n_Matricula varchar,\n" +
                "    cod varchar,\n" +
                "\tnotas float,\n" +
                "\tfaltas int,\n" +
                "    PRIMARY KEY (n_Matricula, cod)\n" +
                ");");

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS Matricula_Disciplina_Aluno_Aluno_Disciplina (\n" +
                "    fk_Disciplina_cod varchar,\n" +
                "    fk_Aluno_n_Matricula varchar,\n" +
                "    fk_Aluno_Disciplina_n_Matricula varchar,\n" +
                "    fk_Aluno_Disciplina_cod varchar,\n" +
                "    FOREIGN KEY (fk_Disciplina_cod)\n" +
                "    REFERENCES Disciplina (cod),\n" +
                "    FOREIGN KEY (fk_Aluno_n_Matricula)\n" +
                "    REFERENCES Aluno (n_Matricula),\n" +
                "    FOREIGN KEY (fk_Aluno_Disciplina_n_Matricula, fk_Aluno_Disciplina_cod)\n" +
                "    REFERENCES Aluno_Disciplina (n_Matricula, cod)\n" +
                ");");
    }
     */
}