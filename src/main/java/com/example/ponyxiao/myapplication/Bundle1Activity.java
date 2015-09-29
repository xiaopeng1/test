package com.example.ponyxiao.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by pony.xiao on 2015/9/1.
 *
 */
public class Bundle1Activity extends Activity{
    private int my_requestCode=1550;
    private RadioButton sexMan;
    private RadioButton sexWoman;
    private EditText heightEdit;
    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bundle1);

        sexMan = (RadioButton) findViewById(R.id.sex_man);
        sexWoman = (RadioButton) findViewById(R.id.sex_woman);
        heightEdit = (EditText) findViewById(R.id.height_edit);
        okButton = (Button) findViewById(R.id.button_ok);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height = Double.parseDouble(heightEdit.getText().toString());
                String sex = "";
                if(sexMan.isChecked()) {
                    sex = "M";
                }
                else{
                    sex = "F";
                }
                Intent intent = new Intent();
                intent.setClass(Bundle1Activity.this,Bundle2Activity.class);
                //
                Bundle bundle = new Bundle();
                bundle.putDouble("height",height);
                bundle.putString("sex",sex);
                intent.putExtras(bundle);
                startActivityForResult(intent,my_requestCode);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case RESULT_OK:
                //
                Bundle bundle = data.getExtras();
                String sex = bundle.getString("sex");
                heightEdit.setText(String.valueOf("height"));
                if (sex.equals("M")){
                    sexMan.setChecked(true);
                }
                else{
                    sexWoman.setChecked(true);
                }
                break;

            default:
                break;
        }
    }

}
