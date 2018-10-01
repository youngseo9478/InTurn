package com.example.w663.animationlistenerex;

import android.animation.AnimatorInflater;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout linear;

    Button btn;

    Animation ani1;
    Animation ani2;
    Animation ani3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linear=(LinearLayout)findViewById(R.id.linear);

        btn = (Button)findViewById(R.id.startBtn);
        btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                btn.startAnimation(ani1);
            }
        });

        ani1 = AnimationUtils.loadAnimation(this,R.anim.rotate2);
        ani2 = AnimationUtils.loadAnimation(this,R.anim.alpha2);
        ani3 = AnimationUtils.loadAnimation(this,R.anim.scale2);

        ani1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                btn.startAnimation(ani2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        ani2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                btn.startAnimation(ani3);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        ani3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                Toast.makeText(MainActivity.this,"Animation End",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


}
