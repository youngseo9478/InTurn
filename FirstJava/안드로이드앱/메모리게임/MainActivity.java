package com.example.w663.memorypowergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*지금 뷰를 상속받아 만든게 GameView이기 때문에
        액티비티 컨텐트를 세팅하려면 GameView를 넣어줘야하는 것
        setContentView(int layoutResId), setContentView(View view) 등이 있어서
        레이아웃리소스(xml)을 받을 때도 있고 뷰를 받을 때도 있는 것
        지금의 경우 xml은 사용하지않고 뷰만을 이용해 만들었으므로 실질적으로 뷰를 나타낼 수 있는 GameView를 넘겨주는 것*/
        setContentView(new GameView(this));


    }
}
