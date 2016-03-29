package com.small.example;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.small.example.adapter.PersonAdapter;
import com.small.example.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cao on 2016/3/25.
 */
public class RecyclerViewDemoActivity extends Activity {

    private RecyclerView recyclerview ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_recyclerview);

        recyclerview = (RecyclerView) super.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        recyclerview.setHasFixedSize(true);//设置固定个数
        recyclerview.setLayoutManager(lm);

        List<Person> list = new ArrayList<>();
        Person p = new Person();
        p.name = "草国企昂";
        p.sex = "男";
        list.add(p);
        p.name = "哇啦个擦";
        p.sex = "女";
        list.add(p);
        for(int i = 0;i<50;i++){
            Person p2 = new Person();
            p2.name = "名字"+i;
            p2.sex = "性别"+i;
            list.add(p2);
        }

        PersonAdapter pa = new PersonAdapter(list);
        recyclerview.setAdapter(pa);



    }
}
