package com.example.ufustudy;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Base64;
/*
public class ExpandableTextViewAdapter extends BaseExpandableListAdapter {

    Context context;

    String[]faqs={
            "Question number1",
            "Question number2",
            "Question number3"
    };

    String[][]answer={{
            "Answer number 1, Answer number 1, Answer number 1, Answer number 1, Answer number 1,\n\n"+
                    "Answer number 1, Answer number 1,Answer number 1,Answer number 1\n"+
                    "Answer number 1,Answer number 1,Answer number 1,Answer number 1,"},
            {"Answer number 2, Answer number 1,Answer number 1,Answer number 1,Answer number 1,Answer number 1,Answer number 1,Answer number 1\n"+
                    "Answer number 1,Answer number 1,Answer number 1,Answer number 1,Answer number 1\n"},
            {"Answer number 2, Answer number 1,Answer number 1,Answer number 1,Answer number 1,Answer number 1,Answer number 1,Answer number 1\n"+
                    "Answer number 1,Answer number 1,Answer number 1,Answer number 1,Answer number 1\n"}
    };

    public ExpandableTextViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return faqs.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return answer[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return faqs[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return answer[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String questionFaq = (String)getGroup(groupPosition);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.faqs_title,null);
        }
        TextView questionFaq2=convertView.findViewById(R.id.faqsTitleView);
        questionFaq2.setTypeface(null, Typeface.BOLD);
        questionFaq2.setText(questionFaq);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String answerFaq = (String)getChild(groupPosition,childPosition);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.faq_answer,null);
        }
        TextView answerFaq2=convertView.findViewById(R.id.descriptionFaqView);
        answerFaq2.setText(answerFaq);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
 */
