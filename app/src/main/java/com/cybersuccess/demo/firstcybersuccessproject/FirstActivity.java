package com.cybersuccess.demo.firstcybersuccessproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Samit on 5/5/2018.
 */

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    Button button2;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_ativity);
        button = findViewById(R.id.btn);
        button2 = findViewById(R.id.btn2);
        editText = (EditText) findViewById(R.id.et);
        textView = (TextView) findViewById(R.id.tv);
        button.setOnClickListener(this);
        Log.d("Main activity ", "Oncrete Activity");
        button2.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Main activity ", "onStart Activity");
    }

    public void displayData(View view) {
        EditText editText = (EditText) findViewById(R.id.et);
        TextView textView = (TextView) findViewById(R.id.tv);
        textView.setText(editText.getText());
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn) {
            textView.setText(editText.getText());
        } else if (view.getId() == R.id.btn2) {
            //start the next activity
            Intent intent = new Intent(this, ActivitySecond.class);
            intent.putExtra("activity_first_data", editText.getText().toString());
            intent.putExtra("user_id", "10");
            startActivityForResult(intent, 100);
            Toast.makeText(this, "Start Next Activity Clicked", Toast.LENGTH_SHORT).show();
            //   textView.setText(editText.getText()+":Pune");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {

            if(resultCode==10){
                Toast.makeText(this,  data.getExtras().getString("second_act_data"), Toast.LENGTH_SHORT).show();
               textView.setText( data.getExtras().getString("second_act_data"));

            }


        }
    }
}
