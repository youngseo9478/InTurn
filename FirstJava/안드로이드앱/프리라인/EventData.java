package com.example.w663.freelineex;

/**
 * 이벤트 처리는 여기에 따로 클래스를 만들어 사용해줌
 * ->실무에서는 이렇게 분리해서 클래스를 작성함
 *
 * Created by w663 on 2017-07-19.
 */


public class EventData {
    float xPoint;
    float yPoint;
    boolean bDraw; //첫번째 포인트이면 점하나만 있으면 선을 그을 수 없기때문에 false값을 가지게 됨, 나머지는 true

    public EventData(float xPoint, float yPoint, boolean bDraw){
        this.xPoint = xPoint;
        this.yPoint = yPoint;
        this.bDraw = bDraw;
    }
}
