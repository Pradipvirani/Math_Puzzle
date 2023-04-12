package com.example.math_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
TextView textView1,textView2,textView3,textView4;
Button share,email;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1=findViewById(R.id.continue_txt);
        textView2=findViewById(R.id.puzzle_txt);
        textView3=findViewById(R.id.buy_txt);
        textView4=findViewById(R.id.privete_txt);
        share=findViewById(R.id.share_button);
        email=findViewById(R.id.mail_button);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        share.setOnClickListener(this);
        email.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        if (view.getId()==share.getId())
        {

        }
        if (view.getId()==email.getId())

        {

        }
    }
}