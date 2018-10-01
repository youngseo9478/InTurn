package com.example.w663.animationex1;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    AnimationDrawable mAni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img = (ImageView)findViewById(R.id.aniImage);
        //이미지를 가져오는 것
        mAni = (AnimationDrawable) img.getBackground();

        //포스트는 스레드처럼...
        img.post(new Runnable() {
            @Override
            public void run() {
                mAni.start();
            }
        });
    }

    public void mOnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.startBtn:
                mAni.start();
                break;
            case R.id.stopBtn:
                mAni.stop();
                break;
        }
    }
}
