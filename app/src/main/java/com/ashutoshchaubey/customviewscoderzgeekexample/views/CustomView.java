package com.ashutoshchaubey.customviewscoderzgeekexample.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
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
    private Paint mPaint;
    private int mSquareColor;
    private int mSquareSize;

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
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);


        if(attrs==null){
            return;
        }

        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.CustomView);

        mSquareColor = ta.getColor(R.styleable.CustomView_square_color,Color.BLUE);
        mSquareSize = ta.getDimensionPixelSize(R.styleable.CustomView_square_dimension , SQUARE_SIZE_DEF);
        mPaint.setColor(mSquareColor);
        ta.recycle();

    }

    public void swapColor(){
        mPaint.setColor(mPaint.getColor()==Color.GREEN ? mSquareColor : Color.GREEN);
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

        canvas.drawRect(mRect,mPaint);

    }
}
