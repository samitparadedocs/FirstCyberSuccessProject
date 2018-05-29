package com.cybersuccess.demo.firstcybersuccessproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);

        getSupportFragmentManager().beginTransaction().add(R.id.linearLayout,new BlankFragment() ,"Sam").commit();
    }
}
