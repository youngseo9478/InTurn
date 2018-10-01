package com.example.w663.memorypowergame;

import android.graphics.Rect;


//도형 하나에 대한 정보
public class Shape {
    final static int RECT = 0;
    final static int CIRCLE = 1;
    final static int TRIANGLE = 2;

    int what;
    int color;
    Rect shapeRect;
}
