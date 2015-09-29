package com.example.ponyxiao.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by pony.xiao on 2015/9/1.
 */
public class Bundle2Activity extends Activity{
     private TextView result;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.bundle2);
        result = (TextView) findViewById(R.id.result);
        backButton = (Button) findViewById(R.id.button_back);

        final Intent intent = this.getIntent();
        //
        Bundle bundle = intent.getExtras();
        double height = bundle.getDouble("height");
        String sex = bundle.getString("sex");
        String sexStr = "";
        if("F".equals(sex)){
            sexStr="女性";
        }
        else{
            sexStr="男性";
        }
        String weight = this.getWeight(sex,height);
        result.setText("你是一位："+sexStr+"\n身高是："+height+"厘米 \n你的标准体重："+weight+"公斤");
        //
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle2Activity.this.setResult(RESULT_OK,intent);
                Bundle2Activity.this.finish();
            }
        });



    }
    public String getWeight(String sex,Double height){

        String weight = "";
        if("M".endsWith(sex)){
            weight=format((height-80)*0.7);
        }else{
            weight=format((height-75)*0.6);
        }
        return weight;
    }

    public String format(double num){
        NumberFormat numberFormat = new DecimalFormat("0.00");
        String s = numberFormat.format(num);
        return s;

    }
}
