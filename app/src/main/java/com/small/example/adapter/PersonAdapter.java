package com.small.example.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.small.example.R;
import com.small.example.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cao on 2016/3/25.
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.MyViewHolder>  {

    private List<Person> list = new ArrayList<>();
    public PersonAdapter(List<Person> list){
        if(list != null){
            this.list = list;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, null);
        return new MyViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Person ps = list.get(position);
        holder.mTvName.setText(ps.name);
        holder.mSex.setText(ps.sex);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView mTvName;
        public TextView mSex;


        public MyViewHolder(View itemView) {
            super(itemView);
            mTvName = (TextView) itemView.findViewById(R.id.tv_name);
            mSex = (TextView) itemView.findViewById(R.id.tv_sex);
        }
    }
}
