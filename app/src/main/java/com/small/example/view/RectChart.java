package com.small.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import com.small.example.model.RectData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cao on 2016/4/1.
 */
public class RectChart extends View {
    private List<RectData> datas;
    private List<PointF> points;

    private Scroller mScroller;

    private float spacingOfX; // X间距
    private Paint rectPaint;//矩形画笔
    private float maxHeight;
    private int clickX=0;
    private int moveX=0;
    public RectChart(Context context) {
        super(context);
        init(context);
    }

    public RectChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RectChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        mScroller = new Scroller(context);//平滑滚动的scroller 用于知道自定义view使用

        rectPaint = new Paint();
        rectPaint.setColor(Color.parseColor("#3A5FCD"));
        rectPaint.setStrokeWidth(60);
    }

    public void setData(List<RectData> list){
        if(list!= null){
            this.datas = list;
            maxHeight = findMaxPowers(datas);
//            initPoints();
//            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(list.size() * 60,600);
//            setLayoutParams(lp);

//            invalidate();
        }
    }

    private void initPoints(){
        maxHeight = findMaxPowers(datas);
        points = new ArrayList<PointF>();
        for (int i = 0; i < datas.size(); i++) {
            float f = datas.get(i).height;
            float y = f/(maxHeight/this.getHeight());
            spacingOfX = (float) (this.getWidth() - getPaddingLeft() - getPaddingRight()) / (float) (datas.size() - 1);
            Log.e("spacingOfXandspacingOfY", spacingOfX+"");
            float x = (i * spacingOfX + this.getPaddingLeft());
            PointF point = new PointF(x, y);
            points.add(point);
            Log.e("initPoints", datas.get(i).height + "|point.x:" + x + "|point.y:" + y);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawRect(canvas,rectPaint);
    }

    private void drawRect(Canvas canvas, Paint paint){
        if (datas == null) {
            return;
        }
        for(int i = 0;i<datas.size();i++){
            float f = datas.get(i).height;
            float y = f/(maxHeight/this.getHeight());
            spacingOfX = paint.getStrokeWidth()+20;//(float) (this.getWidth() - getPaddingLeft() - getPaddingRight()) / (float) (datas.size() - 1);
            float maxX = getWidth()/2;
            float x =  maxX-(i * spacingOfX)+moveX;
            canvas.drawLine(x, this.getHeight(), x, this.getHeight()-y, paint);
        }
    }

    /**
     * 找到 数据集合中最大值
     * @return
     */
    private static float findMaxPowers(List<RectData> energys) {
        RectData energy = new RectData();
        energy.height = 0;
        for (int i = 0; i < energys.size(); i++) {
            if (energys.get(i).height > energy.height) {
                energy = energys.get(i);
            }
        }
        return energy.height;
    }

    private int lastX = 0;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                clickX = x;
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = lastX+(x-clickX);
                Log.e("cgq",""+moveX+"==="+(x-clickX));
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                lastX = moveX;
                scroll(x,lastX);
                break;
        }
        return true;
    }

    private void scroll(int startX,int x){
//        mScroller.fling(getWidth(), 0, 10000, 0, 0, Integer.MAX_VALUE,0,0);
        mScroller.startScroll(startX, 0, startX+150, 0,5000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        //先判断mScroller滚动是否完成
        if (mScroller.computeScrollOffset()) {
            //这里调用View的scrollTo()完成实际的滚动

            scrollTo(mScroller.getCurrX(), 0);
//            必须调用该方法，否则不一定能看到滚动效果
            Log.e("cgq", "" + mScroller.getCurrX());
            postInvalidate();
        }

        super.computeScroll();
    }

    public void scroll(){
        mScroller.startScroll(-100, 0, -200, 0, 5000);
        invalidate();
    }

    public void scroll1(){
        mScroller.startScroll(-300, 0, -400, 0,5000);
        invalidate();
    }
}
