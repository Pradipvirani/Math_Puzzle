package com.example.math_puzzle.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.math_puzzle.Config;
import com.example.math_puzzle.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class win_puzzle_activity extends AppCompatActivity implements View.OnClickListener {
    TextView win;
    Button con,main,buy,buypro,nothanks;
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_puzzle);
        win=findViewById(R.id.win_solve_nummber);
        con=findViewById(R.id.continue_button);
        main=findViewById(R.id.main_menu_button);
        buypro=findViewById(R.id.buy_button);
        con.setOnClickListener(this);
        main.setOnClickListener(this);
        buypro.setOnClickListener(this);
        n=getIntent().getIntExtra("level",0);
        win.setText("puzzle "+(n+1)+" Solved");
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId()==con.getId())
        {
            if (Config.cnt==0) {
                Intent intent = new Intent(win_puzzle_activity.this, puzzle_play_activity.class);
                intent.putExtra("level", (n + 1));
                startActivity(intent);

            }
            if (Config.cnt==1) {
                Intent intent = new Intent(win_puzzle_activity.this, puzzle_play_activity.class);
                intent.putExtra("level", (n + 21));
                startActivity(intent);

            }
            finish();
        }
        if (view.getId()==main.getId())
        {
            Intent intent = new Intent(win_puzzle_activity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        if (view.getId()==buypro.getId())
        {
            BottomSheetDialog dialog = new BottomSheetDialog(this);
            dialog.setContentView(R.layout.buy_pro_layout);
            buy=findViewById(R.id.buy_button);
            nothanks=findViewById(R.id.nO_thx_button);
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
    }
}