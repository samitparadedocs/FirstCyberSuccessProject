package com.cybersuccess.demo.firstcybersuccessproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivitySecond extends AppCompatActivity implements View.OnClickListener {
TextView textView;
EditText editText;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView=findViewById(R.id.tv1);
        editText=findViewById(R.id.et1);
        button=findViewById(R.id.button1);
        button.setOnClickListener(this);
        if(getIntent()!=null ){
            Intent intent=getIntent();
            String s=intent.getExtras().getString("activity_first_data");
            String userId=intent.getExtras().getString("user_id");
            textView.setText(s);
            textView.append(""+userId);
        }
    }
int RESULT_COMPLETE=10;
int RESULT_FAILED=0;
int RESULT_PARTIALLY_COMPLETE=5
        ;
    @Override
    public void onClick(View view) {
    String editTextString=    editText.getText().toString();
    Intent intent=new Intent();
    intent.putExtra("second_act_data",editTextString);
    setResult(RESULT_COMPLETE,intent);
    finish();

    }
}
