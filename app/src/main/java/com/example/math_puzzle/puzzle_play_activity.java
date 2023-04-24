package com.example.math_puzzle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class puzzle_play_activity extends AppCompatActivity implements View.OnClickListener {
    Button [] button = new Button[10];
    TextView textView,textView1;
    ImageView imageView;
    String str1,str,temp;
    Button delete,submit,skip;
    ArrayList <String> imgArr = new ArrayList<>();
    List<String> arraylist = new ArrayList<>();

    int level,lastlevel;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    int ansarr []={10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,200,210,220,230,240,250,260,270,280,290,300};
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
        textView1=findViewById(R.id.level_show_txt);

        textView=findViewById(R.id.answer_txt);
        delete=findViewById(R.id.delete_button);
        delete.setOnClickListener(this);
        submit=findViewById(R.id.submit_button);
        imageView=findViewById(R.id.puzzle_imageview);
        submit.setOnClickListener(this);
        preferences=getSharedPreferences("mypre",0);
        editor=preferences.edit();
        skip=findViewById(R.id.skip_button);
        skip.setOnClickListener(this);

        if (getIntent().getExtras() != null) {
            level = getIntent().getIntExtra("level", 0);
        }
        textView1.setText("Puzzle"+(level+1));
            String[] images = new String[0];
        try {
            images = getAssets().list("imges/");
            imgArr = new ArrayList<>(Arrays.asList(images));
        } catch (IOException e) {
            e.printStackTrace();
        }


        InputStream inputStream = null;
        {
            try {
                inputStream =getAssets().open("imges/"+imgArr.get(level));

                Drawable drawable = Drawable.createFromStream(inputStream,null);
                System.out.println("input strram="+drawable);
                imageView.setImageDrawable(drawable);
                inputStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }



        }


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
            if (ansarr[level]==n)
            {
                editor.putInt("lastlevel",level);
                editor.putString("levelstatus"+level,"win");
                editor.commit();
                Intent intent = new Intent(puzzle_play_activity.this,win_puzzle_activity.class);
                intent.putExtra("level",level);
                startActivity(intent);
            }
            else
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("wrong...");
                builder.show();
            }
        }
        if (view.getId()==skip.getId())
        {
            editor.putInt("lastlevel",level);
            editor.putString("levelstatus"+level,"skip");
            System.out.println(level);
            editor.commit();
            Intent intent = new Intent(puzzle_play_activity.this,puzzle_play_activity.class);
            intent.putExtra("level",(level+1));
            startActivity(intent);
            finish();
        }
    }
}