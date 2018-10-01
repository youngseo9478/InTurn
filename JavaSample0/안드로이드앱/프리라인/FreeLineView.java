package com.example.w663.freelineex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by w663 on 2017-07-19.
 */

public class FreeLineView extends View {
    Paint mPaint;
    int lineColor = Color.BLACK;
    int lineWidth = 3;

    //내부에서 관리하고 초기화할수있게끔 여기에 선언
    ArrayList<EventData> arrData;

    //자바쓸때 일반적으로 쓰는 생성자
    public FreeLineView(Context context){
        super(context);
        init();
    }
    //안드로이드 xml에서 사용할 수 있게되는 생성자가 추가로 하나 더 필요
    public FreeLineView(Context context, AttributeSet att){
        super(context, att);
        init(); //여기서 초기화하는 것
    }

    public void init(){
        arrData = new ArrayList<EventData>();
        //프리라인에서 초기화할 수 있게 빼놓은 것
        mPaint = new Paint();
        //일단 초기 셋팅값으로 들어가짐
        mPaint.setColor(lineColor);
        mPaint.setStrokeWidth(lineWidth);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0x99e0e0e0);
        for(int i=0; i<arrData.size(); i++){
            if(arrData.get(i).bDraw){ //첫번째포인트가 아니면 모두 true값이니까 if문 수행해서 선긋기 가능
                canvas.drawLine(arrData.get(i-1).xPoint, arrData.get(i-1).yPoint,
                                arrData.get(i).xPoint, arrData.get(i).yPoint, mPaint);
            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            arrData.add(new EventData(event.getX(), event.getY(), false));
            return true;
        }else if(event.getAction() == MotionEvent.ACTION_MOVE){
            arrData.add(new EventData(event.getX(), event.getY(), true));
            invalidate();
            return true;
        }
        return false;
    }


    //메인에서 버튼이벤트가 발생함에 따라 해당메소드를 수행해 색/굵기의 변경된값을 초기화가 이루어진다.
    public void lineInit(){
        arrData.clear(); //초기화해서 밑바탕에 다시 그리는
        invalidate(); //다시 온드로우로
    }

    public void setLineColor(int color){
        mPaint.setColor(color);
        invalidate(); //다시 온드로우로
    }

    public void setLineWidth(int width){
        mPaint.setStrokeWidth(width);
        invalidate();//다시 온드로우로
    }
}
