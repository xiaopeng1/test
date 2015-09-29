package com.example.ponyxiao.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    private Button bundle;
    private Button frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bundle = (Button) findViewById(R.id.bundle);
        frameLayout = (Button) findViewById(R.id.frameLayout);


        //Activity值传递
        bundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Bundle1Activity.class);
                startActivity(intent);
            }
        });
        //frameLayout 跳转，事件通过button跳转
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, FrameLayoutActivity.class);
                startActivity(intent);
            }
        });

    }

}
