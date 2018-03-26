package com.ashutoshchaubey.customviewscoderzgeekexample.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.ashutoshchaubey.customviewscoderzgeekexample.R;

/**
 * Created by ashutoshchaubey on 25/03/18.
 */

public class CustomView extends View {

    private static final int SQUARE_SIZE_DEF = 200;
    //The rect object specifies the dimensions of rectangle
    private Rect mRect;
    //Paint object specifies background of the rectangle
    private Paint mPaintSquare;
    private Paint mPaintCircle;
    private int mSquareColor;
    private int mSquareSize;

    private float mCircleX,mCircleY;
    private float mCircleRadius=100f;

    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs){
        mRect = new Rect();
        mPaintSquare = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaintCircle=new Paint();
        mPaintCircle.setAntiAlias(true);
        mPaintCircle.setColor(Color.parseColor("#00ccff"));

        if(attrs==null){
            return;
        }

        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.CustomView);

        mSquareColor = ta.getColor(R.styleable.CustomView_square_color,Color.BLUE);
        mSquareSize = ta.getDimensionPixelSize(R.styleable.CustomView_square_dimension , SQUARE_SIZE_DEF);
        mPaintSquare.setColor(mSquareColor);
        ta.recycle();

    }

    public void swapColor(){
        mPaintSquare.setColor(mPaintSquare.getColor()==Color.GREEN ? mSquareColor : Color.GREEN);
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //Code for making background of canvas red
//        canvas.drawColor(Color.RED);

        //Code for making a rectangle in canvas

        mRect.top = 50;
        mRect.left = 50;
        mRect.bottom=mRect.top+mSquareSize;
        mRect.right=mRect.left+mSquareSize;
        canvas.drawRect(mRect,mPaintSquare);

        //Code for making a circle in canvas
        if(mCircleX==0f || mCircleY==0f){

            mCircleX=canvas.getWidth()/2;
            mCircleY=canvas.getHeight()/2;

        }
        canvas.drawCircle(mCircleX,mCircleY,mCircleRadius,mPaintCircle);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                float x1 = event.getX();
                float y2 =event.getY();

                if(mRect.left<x1 && mRect.right>x1 && mRect.top<y2 && mRect.bottom>y2){

                    mCircleRadius+=10f;
                    postInvalidate();

                }

                return true;
            case MotionEvent.ACTION_MOVE:
                float x = event.getX();
                float y=event.getY();
                double dx = Math.pow(x-mCircleX,2);
                double dy = Math.pow(y-mCircleY,2);
                if(dx+dy < Math.pow(mCircleRadius,2)){
                    //Circle is touched
                    mCircleY=y;
                    mCircleX=x;

                    postInvalidate();
                    return true;
                }


        }

        return value;
    }
}
