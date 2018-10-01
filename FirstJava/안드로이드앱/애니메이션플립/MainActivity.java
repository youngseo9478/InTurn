package com.example.w663.animationflip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper mFlip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFlip = (ViewFlipper)findViewById(R.id.flip);
    }

    public void mOnClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnprev:
                mFlip.showPrevious();
                break;
            case  R.id.btnnext:
                mFlip.showNext();
                break;
            case R.id.chkflip:
                //플리핑이 이미 되어있으면??
                if(mFlip.isFlipping())
                {
                    mFlip.stopFlipping();
                }
                else
                {
                    mFlip.startFlipping();
                }
                break;
            case R.id.chkanim:
                //애니메이션 체크안되어있으면??
                if(mFlip.getInAnimation()==null)
                {
                    mFlip.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.viewin));
                    mFlip.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.viewout));
                }
                //애니메이션이미 체크되어있었으면??
                else
                {
                    mFlip.setInAnimation(null);
                    mFlip.setOutAnimation(null);
                }
        }

    }
}
