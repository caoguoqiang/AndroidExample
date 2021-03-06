package com.small.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.small.example.activity.LoadingActivity;
import com.small.example.activity.RectChartActivity;
import com.small.example.activity.SwitchButtonActivity;
import com.small.example.meituan.Activity01;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void linechart(View view){
        Intent intent = new Intent(this, com.small.example.energycurve.MainActivity.class);
        startActivity(intent);
    }

    public void recy(View view){
        Intent intent = new Intent(this,RecyclerViewDemoActivity.class);
        startActivity(intent);
    }

    public void switchButton(View view){
        Intent intent = new Intent(this, SwitchButtonActivity.class);
        startActivity(intent);
    }

    public void cityChoose(View view){
        Intent intent = new Intent(this, Activity01.class);
        startActivity(intent);
    }

    public void loading(View view){
        Intent intent = new Intent(this,LoadingActivity.class);
        startActivity(intent);
    }

    public void rect(View view){
        Intent intent = new Intent(this, RectChartActivity.class);
        startActivity(intent);
    }

    public void wireframet(View view){
        Intent intent = new Intent(this, com.small.example.linechart.MainActivity.class);
        startActivity(intent);
    }

}
