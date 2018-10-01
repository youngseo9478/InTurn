package com.example.w663.memorypowergame;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;


public class GameView extends View{

    //게임 진행중인 상태인지 끝난상태인지
    final static int BLANK = 0;
    final static int PLAY = 1;

    //게임속도조절
    final static int DELAY = 1000;

    //상태저장변수
    int status;

    //도형을 저장하기위한 배열리스트
    ArrayList<Shape> arShape = new ArrayList<>(100);

    //랜덤하게 숫자를 발생시키기위해
    Random random = new Random();

    /*Context context; 와 같은 개념. 액티비티를 뿌려주기 위함
    * Context 는 크게 두 가지 역할을 수행하는 Abstract 클래스
      -어플리케이션에 관하여 시스템이 관리하고 있는 정보에 접근하기
      -안드로이드 시스템 서비스에서 제공하는 API 를 호출 할 수 있는 기능

      안드로이드 플랫폼상에서의 관점으로 샆펴보면, Context 는
      -자신이 어떤 어플리케이션을 나타내고 있는지 알려주는 ID 역할
      -ActivityManagerService 에 접근할 수 있도록 하는 통로 역할

    */
    Activity mParent;


    //GameView 생성자
    public GameView(Context context)
    {
        super(context); //부모클래스(View) 생성자에게 context를 넘겨주며 호출 =>뷰생성!!!###
        mParent = (Activity)context;
        status = BLANK;
        mHandler.sendEmptyMessageDelayed(0,DELAY); //1.5초있다가 다음단계 그려주기위함
    }

    Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            addNewShape();
            status = PLAY; //게임하는 상태
            invalidate(); //도형을 그릴 수 있게

            String title = "MemoryGame - "+arShape.size()+"단계";
            mParent.setTitle(title);
        }
    };
    //모양 만들어주는 메소드로 모양추가할때 사용
    public void addNewShape()
    {
        Shape shape = new Shape();
        int idx;
        boolean bFindIntersect; //겹치는지확인할때사용
        Rect rect = new Rect();

        //무한루프
        while (true)
        {
            //모든 도형의 범위가 사각형이기때문에 이렇게!
            int size = 64+32*random.nextInt(3); //랜덤값은 0,1,2중에 나오게됨
            rect.left = random.nextInt(getWidth()); //이 뷰에대한 width를 가져옴
            rect.top = random.nextInt(getHeight());
            rect.right = rect.left+size;
            rect.bottom = rect.top+size;

            //Log.i("rectBounds","width:"+rect.width()+", height:"+rect.height());
            if(rect.right>getWidth() || rect.bottom>getHeight()) {
                continue; //영역을 벗어나면 다시 만들라는 것
            }

            bFindIntersect = false;
            for(idx = 0; idx<arShape.size(); idx++)
            {
                if(rect.intersect(arShape.get(idx).shapeRect)==true) {
                    bFindIntersect = true;
                }
            }
            if(bFindIntersect == false)
                break; //안겹치는 거 확인했으면 루프빠져나오는 것
        }
        shape.what = random.nextInt(3);
        switch (random.nextInt(5))
        {
            case 0:
                shape.color = Color.BLUE;
                break;
            case 1:
                shape.color = Color.RED;
                break;
            case 2:
                shape.color = Color.GREEN;
                break;
            case 3:
                shape.color = Color.CYAN;
                break;
            case 4:
                shape.color = Color.YELLOW;
                break;
        }
        shape.shapeRect = rect;
        arShape.add(shape);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        //게임상태에서만 그림을 그릴 것
        if(status==BLANK) {
            return;
        }

        for(int i =0; i<arShape.size();i++)
        {
            Paint pnt = new Paint();
            pnt.setColor(arShape.get(i).color);
            Rect rt = arShape.get(i).shapeRect;
            switch (arShape.get(i).what)
            {
                case Shape.RECT:
                    canvas.drawRect(rt,pnt);
                    break;
                case Shape.CIRCLE:
                    canvas.drawCircle(rt.left+rt.width()/2,rt.top+rt.width()/2,rt.width()/2,pnt);
                    break;
                case Shape.TRIANGLE:
                    //The Path class encapsulates compound (multiple contour) geometric paths consisting of straight line segments,
                    // quadratic curves, and cubic curves. It can be drawn with canvas.drawPath(path, paint), either filled or stroked (based on the paint's Style),
                    // or it can be used for clipping or to draw text on a path.
                    Path path = new Path();
                    //꼭지점
                    path.moveTo(rt.left+rt.width()/2, rt.top);

                    //moveTo의 점으로부터 해당(x,y)좌표로 라인을 긋는것
                    path.lineTo(rt.left,rt.bottom);
                    //위와 동일
                    path.lineTo(rt.right,rt.bottom);
                    //Draw the specified path using the specified paint. The path will be filled or framed based on the Style in the paint.
                    canvas.drawPath(path,pnt);
                    break;
            }
        }
    }

    int findShapeIndex(int x, int y){
        for(int i=0; i<arShape.size();i++)
        {
            //좌표가 도형에 포함되어있는지
            if(arShape.get(i).shapeRect.contains(x,y))
            {
                return i;
            }
        }
        return -1; //빈공간을 눌렀다는 뜻
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        //액션 다운일때만 사용할 것임
        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
            //이벤트가 발생한 (x,y)의 위치가 도형에 포함되는지 아닌지 리턴값을 받은것
            int selectedIndex = findShapeIndex((int) event.getX(),(int)event.getY());
            if(selectedIndex==-1)
                return true; //빈바닥 찍어서 무시하는 것
            //그 좌표가 맨마지막 도형의 범위에 속하느냐를 묻는 것 ->게임룰이 새로추가된(가장나중에생서된) 도형을 클릭하느 것이니깐!
            if(selectedIndex==arShape.size()-1)
            {
                status=BLANK; //잠시 화면이 안보이게 하려고 이렇게 하는 것
                invalidate(); //딜레이 1.5초후에 온드로우 진행시켜서 다시 그림그리는것
                mHandler.sendEmptyMessageDelayed(0,DELAY);
            }
            else
            {
                new AlertDialog.Builder(mParent)
                        .setMessage("틀렸습니다. 게임을 다시 진행하시겠습니까?")
                        .setTitle("GAME OVER")
                        .setPositiveButton("새 게임 시작", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                arShape.clear(); //다시시작하니까 화면 싹 지우는 것
                                status = BLANK;
                                invalidate(); //다시 온드로우
                                mHandler.sendEmptyMessageDelayed(0,DELAY);
                            }
                        })
                        .setNegativeButton("게임 종료", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i){
                                mParent.finish();
                            }
                        })
                        .setCancelable(false) //틀렸으면 더 이상 진행못하게
                        .show();
            }
        }

        return true;
    }
}
