package com.example.math_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.logging.Level;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
TextView textView1,textView2,textView3,textView4;
Button share,email,buy,nothanks;

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
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT,textView1.getText());
            intent.putExtra(Intent.EXTRA_SUBJECT,"Puzzle");
            startActivity(Intent.createChooser(intent,"share"));

        }
        if (view.getId()==email.getId())

        {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("messgae/rfc822");
            intent.putExtra(Intent.EXTRA_TEXT,textView1.getText());
            intent.putExtra(Intent.EXTRA_SUBJECT,"Puzzle Game");
            startActivity(Intent.createChooser(intent,"share"));
        }
        if (view.getId()==textView1.getId())
        {
            Intent intent = new Intent(MainActivity.this,puzzle_play_activity.class);
            startActivity(intent);

        }
        if (view.getId()==textView2.getId())
        {
            Intent intent = new Intent(MainActivity.this,Level_show_activity.class);
            startActivity(intent);

        }
        if (view.getId()==textView3.getId())
        {
            BottomSheetDialog dialog = new BottomSheetDialog(this);
            dialog.setContentView(R.layout.buy_pro_layout);
            buy=dialog.findViewById(R.id.buy_button);
            nothanks=dialog.findViewById(R.id.nO_thx_button);
            dialog.show();
            buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.cancel();
                }
            });
            nothanks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.cancel();
                }
            });

        }
        if (view.getId()==textView2.getId())
        {

        }
    }
}