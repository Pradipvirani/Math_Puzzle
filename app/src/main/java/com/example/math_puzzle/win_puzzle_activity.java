package com.example.math_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
        buypro=findViewById(R.id.buy_txt);
        con.setOnClickListener(this);
        main.setOnClickListener(this);
        buy.setOnClickListener(this);
        n=getIntent().getIntExtra("level",0);
        win.setText("puzzle"+(n+1)+"Solved");
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId()==con.getId())
        {
            Intent intent = new Intent(win_puzzle_activity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        if (view.getId()==buy.getId())
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