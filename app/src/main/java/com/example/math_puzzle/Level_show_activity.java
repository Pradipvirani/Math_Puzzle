package com.example.math_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class Level_show_activity extends AppCompatActivity {
    GridView gridView;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_show);
        gridView=findViewById(R.id.Level_grid_view);
        textView=findViewById(R.id.select_puzzle);
        button=findViewById(R.id.next_button);
        Puzzle_Adapter puzzle_adapter = new Puzzle_Adapter(Level_show_activity.this,Config.lock);
        gridView.setAdapter(puzzle_adapter );
        Typeface typeface = Typeface.createFromAsset(Level_show_activity.this.getAssets(),Config.font);
        textView.setTypeface(typeface);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Level_show_activity.this,Level_show_activity.class);
                startActivity(intent);
            }
        });
    }

}