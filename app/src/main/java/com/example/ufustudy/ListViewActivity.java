package com.example.ufustudy;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

public class ListViewActivity extends Activity {

    SQLiteHelper SQLITEHELPER;
    SQLiteDatabase SQLITEDATABASE;
    Cursor cursor;
    SQLiteListAdapter ListAdapter;
    ArrayList<String> ID_ArrayList = new ArrayList<String>();
    ArrayList<String> NAME_ArrayList = new ArrayList<String>();
    ArrayList<String> SOBRENOME_ArrayList = new ArrayList<String>();
    ArrayList<String> N_MATRICULA_NUMBER_ArrayList = new ArrayList<String>();
    ArrayList<String> SUBJECT_ArrayList = new ArrayList<String>();
    ListView LISTVIEW;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        LISTVIEW = (ListView) findViewById(R.id.listView1);
        SQLITEHELPER = new SQLiteHelper(this);
    }

    @Override
    protected void onResume() {

        ShowSQLiteDBdata();
        super.onResume();
    }

    private void ShowSQLiteDBdata() {

        SQLITEDATABASE = SQLITEHELPER.getWritableDatabase();
        cursor = SQLITEDATABASE.rawQuery("SELECT * FROM Aluno", null);
        ID_ArrayList.clear();
        NAME_ArrayList.clear();
        SOBRENOME_ArrayList.clear();
        N_MATRICULA_NUMBER_ArrayList.clear();
        SUBJECT_ArrayList.clear();

        if (cursor.moveToFirst()) {
            do {

                ID_ArrayList.add(cursor.getString(cursor.getColumnIndexOrThrow(SQLiteHelper.KEY_ID)));
                NAME_ArrayList.add(cursor.getString(cursor.getColumnIndexOrThrow(SQLiteHelper.KEY_Name)));
                SOBRENOME_ArrayList.add(cursor.getString(cursor.getColumnIndexOrThrow(SQLiteHelper.KEY_Sobrenome)));
                N_MATRICULA_NUMBER_ArrayList.add(cursor.getString(cursor.getColumnIndexOrThrow(SQLiteHelper.KEY_N_Matricula)));
                SUBJECT_ArrayList.add(cursor.getString(cursor.getColumnIndexOrThrow(SQLiteHelper.KEY_Subject)));
            } while (cursor.moveToNext());
        }

        ListAdapter = new SQLiteListAdapter(ListViewActivity.this,

                ID_ArrayList,
                NAME_ArrayList,
                SOBRENOME_ArrayList,
                N_MATRICULA_NUMBER_ArrayList,
                SUBJECT_ArrayList
        );

        LISTVIEW.setAdapter(ListAdapter);
        cursor.close();
    }
}