package com.small.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.small.example.R;
import com.small.example.model.RectData;
import com.small.example.view.RectChart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cao on 2016/4/1.
 */
public class RectChartActivity extends Activity {

    private LinearLayout mChartLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_rect_chart);

        mChartLL = (LinearLayout) super.findViewById(R.id.ll_chart);
        List<RectData> list = new ArrayList<>();
        for(int i = 0;i<5000;i++){
            RectData rcs = new RectData();
            rcs.height = i+10;

            list.add(rcs);
        }

        mChartLL.addView(new RectChart(this,list));
    }
}
