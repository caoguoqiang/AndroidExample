package com.small.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.small.example.R;
import com.small.example.model.RectData;
import com.small.example.view.RectChart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cao on 2016/4/1.
 */
public class RectChartActivity extends Activity {

    private LinearLayout mChartLL;
    private RectChart mRc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_rect_chart);
        mRc = (RectChart) super.findViewById(R.id.rc_view);
        List<RectData> list = new ArrayList<>();
        for(int i = 0;i<5;i++){
            Random random = new Random();
            int count = random.nextInt(9999);
            RectData rcs = new RectData();
            rcs.height = i+1;
            list.add(rcs);
        }
        mRc.setData(list);
    }

    public void setWidth(){

    }

    public void scroll(View view ){
        mRc.scroll();
    }

    public void scroll1(View view){
        mRc.scroll1();
    }
}
