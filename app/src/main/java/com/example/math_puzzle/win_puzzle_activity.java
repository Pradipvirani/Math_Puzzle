package com.example.math_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class win_puzzle_activity extends AppCompatActivity implements View.OnClickListener {
    TextView win;
    Button con,main,buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_puzzle);
        win=findViewById(R.id.win_solve_nummber);
        con=findViewById(R.id.continue_button);
        main=findViewById(R.id.main_menu_button);
        buy=findViewById(R.id.buy_button);
        win.setOnClickListener(this);
        con.setOnClickListener(this);
        main.setOnClickListener(this);
        buy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId()==win.getId())
        {

        }
    }
}