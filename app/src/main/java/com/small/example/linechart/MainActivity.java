package com.small.example.linechart;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.small.example.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

	LinearLayout arc;
    RelativeLayout pillars,linear;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wire_framet);

		arc = (LinearLayout) findViewById(R.id.arc);//圆弧计分
		arc.addView(new HomeArc(this, 90)); 
		
		List<Score> list = new ArrayList<Score>();;//柱状图  范围10-100
		for (int i = 0; i < 28; i++) {
			Score s = new Score();
			s.date = "2013-10-" + i;
			s.score = getRandom(10,100);
			list.add(s);
		}
		pillars= (RelativeLayout) findViewById(R.id.pillars);
		pillars.addView(new HomeColumnar(this,list));
		
		List<Integer> lists = new ArrayList<Integer>();//线性图  范围10-100
		for (int i = 0; i < 48; i++) {
			if (i < 8 || i == 28 || i == 12 || i == 18 || i == 20 || i == 30
					|| i == 34) {
				lists.add(0);
			} else {
				lists.add(getRandom(0, 50000));
			}
		}
		linear= (RelativeLayout) findViewById(R.id.linear);
		HomeDiagram view = new HomeDiagram(this,lists);
		linear.addView(view);
		
		
		view.setOnDownActionListener(new HomeDiagram.OnDownActionListener() {
			 
            @Override
            public void OnDown(int x, int y) {
                // TODO Auto-generated method stub
                System.out.println("down x = " + x + " y = " + y);
            }
        });
 
        view.setOnMoveActionListener(new HomeDiagram.OnMoveActionListener() {
 
            @Override
            public void OnMove(int x, int y) {
                // TODO Auto-generated method stub
                System.out.println("move x = " + x + " y = " + y);
            }
        });
 
        view.setOnUpActionListener(new HomeDiagram.OnUpActionListener() {
 
            @Override
            public void OnUp(int x, int y) {
                // TODO Auto-generated method stub
                System.out.println("up x = " + x + " y = " + y);
            }
        });
	}
	
	public int getRandom(int min,int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}

}
