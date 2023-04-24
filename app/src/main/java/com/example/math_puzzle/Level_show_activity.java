package com.example.math_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class Level_show_activity extends AppCompatActivity {
    GridView gridView;
    Button button ,pbutton;
    TextView textView;


    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_show);
        gridView=findViewById(R.id.Level_grid_view);
        textView=findViewById(R.id.select_puzzle);
        button=findViewById(R.id.next_button);
        pbutton=findViewById(R.id.previus_button);
        preferences=getSharedPreferences("mypre",MODE_PRIVATE);

        Puzzle_Adapter puzzle_adapter = new Puzzle_Adapter(Level_show_activity.this,Config.lock,preferences);
        gridView.setAdapter(puzzle_adapter );
        Typeface typeface = Typeface.createFromAsset(Level_show_activity.this.getAssets(),Config.font);
        textView.setTypeface(typeface);
        if (Config.cnt == 1) {
            pbutton.setVisibility(View.VISIBLE);
            pbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Config.cnt--;
                    Intent intent = new Intent(Level_show_activity.this, Level_show_activity.class);

                    startActivity(intent);
                    finish();
                }
            });


        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Config.cnt++;
                Intent intent = new Intent(Level_show_activity.this, Level_show_activity.class);

                startActivity(intent);
                finish();
            }
        });
    }

}