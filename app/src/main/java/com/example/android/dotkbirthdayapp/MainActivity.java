package com.example.android.dotkbirthdayapp;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mySound;

    AnimationDrawable run_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySound = MediaPlayer.create(this, R.raw.happy_birthday);
        mySound.setLooping(true);
        mySound.start();

        ImageView runImage = (ImageView) findViewById(R.id.run_img);
        runImage.setBackgroundResource(R.drawable.run_animation);
        run_animation = (AnimationDrawable) runImage.getBackground();
    }

    @Override
    protected void onPause(){
        super.onPause();
        mySound.release();
        finish();
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            run_animation.start();
            return true;
        }

        return super.onTouchEvent(event);
    }
}
