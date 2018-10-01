package com.example.w663.freelineex;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    FreeLineView flv; //xml에서 생성한 객체 인스턴스를 참조하기위함
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //FreeLineView flv = new FreeLineView(this);
        setContentView(R.layout.activity_main); //액티비티를 화면에 뿌려주기위함

        //findViewById->아이디를 통해서 해당하는 뷰 xml에 있는 객체의 주소값을 넘겨줌=>xml에있는거참조하기위함
        flv = (FreeLineView)findViewById(R.id.freeLine);
        findViewById(R.id.redBtn).setOnClickListener(colorEvent);
        findViewById(R.id.greenBtn).setOnClickListener(colorEvent);
        findViewById(R.id.blueBtn).setOnClickListener(colorEvent);
        findViewById(R.id.withd1).setOnClickListener(lineEvent);
        findViewById(R.id.width5).setOnClickListener(lineEvent);
        findViewById(R.id.width10).setOnClickListener(lineEvent);
        findViewById(R.id.initBtn).setOnClickListener(new Button.OnClickListener() {
            //초기화버튼에 관련된 리스너처리는 어나니머스 내부 클래스로 여기서 오버라이딩
            @Override
            public void onClick(View view) {
                flv.lineInit(); //초기화버튼
            }
        });

    }

    //컬러,라인을 구분해줬을 뿐 하나의 리스너로 받아서 case별로 나눠서 처리해저도 같은 결과 =>가독성높이기위해이렇게!
    Button.OnClickListener colorEvent = new Button.OnClickListener(){
        //이렇게 하면 나중에 메소드명이 바뀌어도 한번만 수정해주면 되서 더 좋은 코드!
        public void onClick(View view) {
            int colorV = Color.BLACK;
            switch (view.getId()){
                case R.id.redBtn:
                    colorV = Color.RED;
                    break;
                case R.id.greenBtn:
                    colorV = Color.GREEN;
                    break;
                case R.id.blueBtn:
                    colorV = Color.BLUE;
                    break;
            }
            flv.setLineColor(colorV);
        }

        /* 다같이 쓰는 경우(전역)의 경우에는 한번만 써주는 게 더 좋음
       public void onClick(View view) {
            switch (view.getId()){
                case R.id.redBtn:
                    flv.setLineColor(Color.RED);
                    break;
                case R.id.greenBtn:
                    flv.setLineColor(Color.GREEN);
                    break;
                case R.id.blueBtn:
                    flv.setLineColor(Color.BLUE);
                    break;
            }
        }*/
    };

    Button.OnClickListener lineEvent = new Button.OnClickListener(){
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.withd1:
                    flv.setLineWidth(1);
                    break;
                case R.id.width5:
                    flv.setLineWidth(5);
                    break;
                case R.id.width10:
                    flv.setLineWidth(10);
                    break;
            }
        }
    };
}
