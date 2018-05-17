package com.cybersuccess.demo.firstcybersuccessproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cybersuccess.demo.firstcybersuccessproject.layoutcomponets.LayoutComponetsActivity;
import com.cybersuccess.demo.firstcybersuccessproject.layoutdata.LinearLayoutDemo;
import com.cybersuccess.demo.firstcybersuccessproject.layoutdata.RelativeLayoutDemoAct;

public class DemoListActivity extends AppCompatActivity implements View.OnClickListener {
    Button activityCommunication;
    Button btnLayoutComponets;
    Button btnLinearLayoutDemo;
    Button btnRelativerLayoutDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_list);
        activityCommunication = findViewById(R.id.btnActCommunication);
        btnLayoutComponets = findViewById(R.id.btnLayoutComponets);
        btnLinearLayoutDemo = findViewById(R.id.btnLinearLayoutDemo);
        btnRelativerLayoutDemo = findViewById(R.id.btnRelativerLayoutDemo);

        activityCommunication.setOnClickListener(this);
        btnLayoutComponets.setOnClickListener(this);
        btnLinearLayoutDemo.setOnClickListener(this);
        btnRelativerLayoutDemo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnActCommunication:
                startActivity(new Intent(this, FirstActivity.class));
                break;

            case R.id.btnLayoutComponets:
                startActivity(new Intent(this, LayoutComponetsActivity.class
                ));
                break;

            case R.id.btnLinearLayoutDemo:
                startActivity(new Intent(this, LinearLayoutDemo.class));
                break;
                case R.id.btnRelativerLayoutDemo:
                startActivity(new Intent(this, RelativeLayoutDemoAct.class));
                break;
        }
    }
}
