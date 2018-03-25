package com.ashutoshchaubey.customviewscoderzgeekexample.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ashutoshchaubey on 25/03/18.
 */

public class CustomView extends View {

    private static final int SQUARE_SIZE = 100;
    private Rect mRect;
    private Paint mPaint;

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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //Code for making background of canvas red
//        canvas.drawColor(Color.RED);

        //Code for making a rectangle in canvas

        mRect.top = SQUARE_SIZE;
        mRect.left = SQUARE_SIZE;
        mRect.bottom=mRect.top+SQUARE_SIZE;
        mRect.right=mRect.left+SQUARE_SIZE;


        mPaint.setColor(Color.BLUE);

        canvas.drawRect(mRect,mPaint);

    }
}
