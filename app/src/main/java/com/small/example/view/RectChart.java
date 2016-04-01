package com.small.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.small.example.model.RectData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cao on 2016/4/1.
 */
public class RectChart extends View {
    private Context context ;

    private List<RectData> datas;
    private List<PointF> points;

    private float spacingOfX; // X间距
    private Paint rectPaint;//矩形画笔
    private float maxHeight;
    public RectChart(Context context,List<RectData> list) {
        super(context);
        this.context = context;
        this.datas = list;
        init(context);
    }

    private void init(Context context){
        setLayoutParams(new ViewGroup.LayoutParams(5000, ViewGroup.LayoutParams.MATCH_PARENT));
        rectPaint = new Paint();
        rectPaint.setColor(Color.parseColor("#3A5FCD"));
        rectPaint.setStrokeWidth(10);
    }



    public void setData(List<RectData> list){
        if(list!= null){
            this.datas = list;
            maxHeight = findMaxPowers(datas);
            initPoints();

            invalidate();
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
            spacingOfX = 20;//(float) (this.getWidth() - getPaddingLeft() - getPaddingRight()) / (float) (datas.size() - 1);
            float maxX = getWidth()/2;
            float x = maxX - (i * spacingOfX + this.getPaddingLeft());
            canvas.drawLine(x, this.getHeight(), x, y, paint);
        }
    }

    /**
     * 找到 数据集合中最大值
     *
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

}
