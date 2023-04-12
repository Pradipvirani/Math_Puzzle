package com.example.math_puzzle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class Puzzle_Adapter extends BaseAdapter {
    Context context;
    int lock;
    ImageView imageView;
    public Puzzle_Adapter(Level_show_activity level_show_activity, int lock) {
        this.context=level_show_activity;
        this.lock=lock;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.level_item,viewGroup,false);

        imageView=view.findViewById(R.id.item_txt_view);
        imageView.setImageResource(lock);
        return view;
    }
}
