package com.example.ufustudy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText GetName, GetSobrenome, GetN_Matricula, GetSubject;
    Button Submit, EditData, DisplayData;
    SQLiteDatabase SQLITEDATABASE;
    String Name, Sobrenome, N_Matricula, Subject;
    Boolean CheckEditTextEmpty;
    String SQLiteQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetName = (EditText) findViewById(R.id.editText1);
        GetSobrenome = (EditText) findViewById(R.id.editText4);
        GetN_Matricula = (EditText) findViewById(R.id.editText2);
        GetSubject = (EditText) findViewById(R.id.editText3);
        Submit = (Button) findViewById(R.id.button1);
        EditData = (Button) findViewById(R.id.button2);
        DisplayData = (Button) findViewById(R.id.update_data);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DBCreate();
                SubmitData2SQLiteDB();
            }
        });

        EditData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(MainActivity.this, EditDataActivity.class);
                startActivity(intent);

            }
        });
        DisplayData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });
    }

    public void DBCreate() {

        SQLITEDATABASE = openOrCreateDatabase("UFUStudy", Context.MODE_PRIVATE, null);
        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS Aluno(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR, sobrenome VARCHAR, n_matricula VARCHAR, subject VARCHAR);");
    }


    public void SubmitData2SQLiteDB() {

        Name = GetName.getText().toString();
        Sobrenome = GetSobrenome.getText().toString();
        N_Matricula = GetN_Matricula.getText().toString();
        Subject = GetSubject.getText().toString();
        CheckEditTextIsEmptyOrNot(Name, Sobrenome, N_Matricula, Subject);

        if (CheckEditTextEmpty == true) {

            SQLiteQuery = "INSERT INTO Aluno(name,sobrenome,n_matricula,subject) VALUES('" + Name + "', '" + Sobrenome + "', '" + N_Matricula + "', '" + Subject + "');";
            SQLITEDATABASE. execSQL(SQLiteQuery);
            Toast.makeText(MainActivity.this, "Dados enviados com sucesso!", Toast.LENGTH_LONG).show();
            ClearEditTextAfterDoneTask();
        } else {
            Toast.makeText(MainActivity.this, "Por favor, complete todos os campos!", Toast.LENGTH_LONG).show();
        }
    }

    public void CheckEditTextIsEmptyOrNot(String Name, String Sobrenome, String N_Matricula, String subject) {

        if (TextUtils.isEmpty(Name) || TextUtils.isEmpty(Sobrenome) || TextUtils.isEmpty(N_Matricula) || TextUtils.isEmpty(Subject)) {
            CheckEditTextEmpty = false;
        } else {
            CheckEditTextEmpty = true;
        }
    }

    public void ClearEditTextAfterDoneTask() {

        GetName.getText().clear();
        GetSobrenome.getText().clear();
        GetN_Matricula.getText().clear();
        GetSubject.getText().clear();

    }

}
