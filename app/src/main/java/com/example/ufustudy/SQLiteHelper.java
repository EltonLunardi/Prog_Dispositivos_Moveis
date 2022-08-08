package com.example.ufustudy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME = "UFUStudy";
    public static final String Aluno = "Aluno";
    public static final String KEY_ID = "ID";
    public static final String KEY_Name = "name";
    public static final String KEY_Sobrenome = "sobrenome";
    public static final String KEY_N_Matricula = "n_matricula";
    public static final String KEY_Subject = "subject";

    private final String Login = "login";
    private final String Usuario = "usuario";
    private final String Senha = "senha";

    public static final String Disciplina = "disciplina";
    public static final String cod_disciplina = "cod";
    public static final String professor_nome = "professor_nome";
    public static final String turma = "turma";
    public static final String ano_semestre = "ano_semestre";

    public static final String Aluno_Disciplina = "Aluno_disciplina";
    public static final String notas = "notas";
    public static final String faltas = "faltas";

    public static final String Matricula_Disciplina_Aluno_Aluno_Disciplina = "Matricula_Disciplina_Aluno_Aluno_Disciplina";

    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String aluno = "CREATE TABLE IF NOT EXISTS " + Aluno + "" +
                "(\" + KEY_N_Matricula + \"VARCHAR PRIMARY KEY," +
                " \" + KEY_ID + \"INTEGER, " +
                " \" + KEY_Name + \"VARCHAR, " +
                "\" + KEY_Sobrenome + \"VARCHAR, " +
                "\" + KEY_Subject + \" VARCHAR)";
        database.execSQL(aluno);

        String login = "CREATE TABLE IF NOT EXISTS " + Login + "" +
                "(" + Usuario + "VARCHAR PRIMARY KEY," +
                " " + Senha + "VARCHAR)";
        database.execSQL(login);

        String disciplina = "CREATE TABLE IF NOT EXISTS " + Disciplina + "" +
                "(\" + cod_disciplina + \"VARCHAR PRIMARY KEY," +
                "\" + professor_nome + \"VARCHAR, " +
                "\" + turma + \"CHAR, " +
                "\" + ano_semestre + \" VARCHAR)";
        database.execSQL(disciplina);

        String aluno_disciplina = "CREATE TABLE IF NOT EXISTS " + Aluno_Disciplina + "" +
                "(\" + notas + \"FLOAT, " +
                "\" + faltas + \"INTEGER)";
        database.execSQL(aluno_disciplina);

        String Matricula_Disciplina_Aluno_Aluno_Disciplina = "CREATE TABLE IF NOT EXISTS Matricula_Disciplina_Aluno_Aluno_Disciplina (\n" +
                "    fk_Disciplina_cod_disciplina varchar,\n" +
                "    fk_Aluno_KEY_N_Matricula varchar,\n" +
                "    fk_Aluno_Disciplina_KEY_N_Matricula varchar,\n" +
                "    fk_Aluno_Disciplina_cod_disciplina varchar,\n" +
                "    FOREIGN KEY (fk_Disciplina_cod_disciplina)\n" +
                "    REFERENCES Disciplina (cod_disciplina),\n" +
                "    FOREIGN KEY (fk_Aluno_KEY_N_Matricula)\n" +
                "    REFERENCES Aluno (KEY_N_Matricula),\n" +
                "    FOREIGN KEY (fk_Aluno_Disciplina_KEY_N_Matricula, fk_Aluno_Disciplina_cod_disciplina)\n" +
                "    REFERENCES Aluno_Disciplina (KEY_N_Matricula, cod_disciplina)\n" +
                ")";
        database.execSQL(Matricula_Disciplina_Aluno_Aluno_Disciplina);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Aluno);
        //db.execSQL("DROP TABLE IF EXISTS " + Disciplina);
        //db.execSQL("DROP TABLE IF EXISTS " + Aluno_Disciplina);
        onCreate(db);
    }

    public Boolean checkUserPassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from login where username=?  and password=?", new String[] {username, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}