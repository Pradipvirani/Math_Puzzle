package com.example.math_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class puzzle_play_activity extends AppCompatActivity implements View.OnClickListener {
    Button [] button = new Button[10];
    TextView textView;
    String str1,str;
    Button delete,submit;
    ArrayList <String> imgArr = new ArrayList<>();
    String temp;
    int level;

    int ansarr []={10,20,30,40,50,60,70,80,90,100,110,120,130,140,150};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_play);
        for(int i=0;i< button.length;i++)
        {
            int id=getResources().getIdentifier("btn"+i,"id",getPackageName());
            button[i]=findViewById(id);
            button[i].setOnClickListener(this);
        }
        textView=findViewById(R.id.answer_txt);
        delete=findViewById(R.id.delete_button);
        delete.setOnClickListener(this);
        submit=findViewById(R.id.submit_button);
        submit.setOnClickListener(this);
        level=findViewById(R.id.l)
    }

    @Override
    public void onClick(View view) {
        for (int i=0;i< button.length;i++)
        {
            if(button[i].getId()==view.getId()) {
                str1 = String.valueOf(textView.getText());
                textView.setText(str1+i);
            }

        }

        if (view.getId()==delete.getId())
        {
            str1=String.valueOf(textView.getText());
            int n=str1.length()-1;
            if (n>=0)
            {
                String s = str1.substring(0,n);
                textView.setText(""+s);
            }

        }
        if (view.getId()==submit.getId())
        {
            str=String.valueOf(textView.getText());
            int n=Integer.parseInt(str);
            if (ansarr)
        }
    }
}