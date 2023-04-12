package com.example.math_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
TextView textView1,textView2,textView3,textView4;
Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1=findViewById(R.id.continue_txt);
        textView2=findViewById(R.id.puzzle_txt);
        textView3=findViewById(R.id.buy_txt);
        textView4=findViewById(R.id.privete_txt);
        button1=findViewById(R.id.share_button);
        button2=findViewById(R.id.mail_button);

    }
}