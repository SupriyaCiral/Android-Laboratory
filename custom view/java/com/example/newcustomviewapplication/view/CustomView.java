package com.example.newcustomviewapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.Random;

public class CustomView extends View {
    private static  final int SQUARE_SIZE=200;
    private Rect mRectSquare;
    private Paint mPaintSquare;



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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }
    public void SwapColor()
    {
        //mPaintSquare.setColor(mPaintSquare.getColor()==Color.GREEN?Color.RED:Color.GREEN);

        Random random = new Random();
        int color = Color.argb(255, random.nextInt(256), random.nextInt(256),random.nextInt(256));
        mPaintSquare.setColor(color);
        postInvalidate();
    }

    private void init(@Nullable AttributeSet set) {
        mRectSquare=new Rect();
        mPaintSquare=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintSquare.setColor(Color.GREEN);
    }

    @Override
    protected  void onDraw(Canvas canvas)
    {

        Rect rect=new Rect();
        mRectSquare.left=50;
        mRectSquare.top=50;
        mRectSquare.right=mRectSquare.left+SQUARE_SIZE;
        mRectSquare.bottom=mRectSquare.top+SQUARE_SIZE;
        canvas.drawRect(mRectSquare,mPaintSquare);

    }

}
