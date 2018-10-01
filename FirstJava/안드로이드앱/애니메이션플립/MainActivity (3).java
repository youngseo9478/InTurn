package com.example.w663.animationex2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linearlayout통째로 받아옴
        linear=(LinearLayout)findViewById(R.id.linear);

    }

    public void mOnClick(View view)
    {
        Animation ani = null;
        switch (view.getId())
        {
            case R.id.transBtn:
                ani = AnimationUtils.loadAnimation(this, R.anim.translate);
                break;
            case R.id.rotateBtn:
                ani = AnimationUtils.loadAnimation(this, R.anim.rotate);
                break;
            case R.id.scaleBtn:
                ani = AnimationUtils.loadAnimation(this,R.anim.scale);
                break;
            case R.id.alphaBtn:
                ani=AnimationUtils.loadAnimation(this,R.anim.alpha);
                break;

            //set은 한번에 모든 애니메이션이 같이 적용된다.
            case R.id.setBtn:
                ani=AnimationUtils.loadAnimation(this,R.anim.set_ani);
                break;
        }

        linear.startAnimation(ani);
    }

}
