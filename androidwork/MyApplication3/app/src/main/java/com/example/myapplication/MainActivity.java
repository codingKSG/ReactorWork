package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import info.androidhive.fontawesome.FontDrawable;

public class MainActivity extends AppCompatActivity {

    private boolean isLike = false;
    private ImageView ivHeart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivHeart = findViewById(R.id.iv_heart);
        FontDrawable fontDrawable = new FontDrawable(this, R.string.fa_heart, true, false);
        fontDrawable.setTextColor(android.R.color.darker_gray);
        ivHeart.setImageDrawable(fontDrawable);

        ivHeart.setOnClickListener(v -> {
            isLike = !isLike;
            FontDrawable drawable = new FontDrawable(this, R.string.fa_heart, true, false);
            if(isLike == true) {
                drawable.setTextColor(android.R.color.holo_red_dark);
            } else {
                drawable.setTextColor(android.R.color.darker_gray);
            }
            ivHeart.setImageDrawable(drawable);
        });

    }
}