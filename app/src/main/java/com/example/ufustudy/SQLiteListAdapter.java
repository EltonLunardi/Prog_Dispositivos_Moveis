package com.example.ufustudy;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SQLiteListAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> userID;
    ArrayList<String> UserName;
    ArrayList<String> UserSobrenome;
    ArrayList<String> User_N_Matricula;
    ArrayList<String> UserSubject;

    public SQLiteListAdapter(
            Context context2,
            ArrayList<String> id,
            ArrayList<String> name,
            ArrayList<String> sobrenome,
            ArrayList<String> n_matricula,
            ArrayList<String> subject) {

        this.context = context2;
        this.userID = id;
        this.UserName = name;
        this.UserSobrenome = sobrenome;
        this.User_N_Matricula = n_matricula;
        this.UserSubject = subject;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return userID.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public View getView(int position, View child, ViewGroup parent) {

        Holder holder;
        LayoutInflater layoutInflater;
        if (child == null) {

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.listviewdatalayout, null);
            holder = new Holder();
            holder.textviewid = (TextView) child.findViewById(R.id.textViewID);
            holder.textviewname = (TextView) child.findViewById(R.id.textViewNAME);
            holder.textviewsobrenome = (TextView) child.findViewById(R.id.textViewSOBRENOME);
            holder.textviewN_Matricula = (TextView) child.findViewById(R.id.textViewN_MATRICULA);
            holder.textviewsubject = (TextView) child.findViewById(R.id.textViewSUBJECT);
            child.setTag(holder);
        } else {
            holder = (Holder) child.getTag();
        }
        holder.textviewid.setText(userID.get(position));
        holder.textviewname.setText(UserName.get(position));
        holder.textviewsobrenome.setText(UserSobrenome.get(position));
        holder.textviewN_Matricula.setText(User_N_Matricula.get(position));
        holder.textviewsubject.setText(UserSubject.get(position));
        return child;
    }

    public class Holder {
        TextView textviewid;
        TextView textviewname;
        TextView textviewsobrenome;
        TextView textviewN_Matricula;
        TextView textviewsubject;
    }

}