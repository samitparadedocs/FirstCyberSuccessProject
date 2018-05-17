package com.cybersuccess.demo.firstcybersuccessproject.layoutcomponets.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.cybersuccess.demo.firstcybersuccessproject.R;

public class RadioButtonDemoActivity extends AppCompatActivity {
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private Button button;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_demo);
        radioButton1 = findViewById(R.id.radio1);
        radioButton2 = findViewById(R.id.radio2);

        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        radioGroup = findViewById(R.id.radioGroup);

        button = findViewById(R.id.buttonResult);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int radioId=radioGroup.getCheckedRadioButtonId();
                StringBuilder displaytext = new StringBuilder("Slected buttons are");

                if(radioId==-1){
                    Toast.makeText(RadioButtonDemoActivity.this, "please select something", Toast.LENGTH_LONG).show();

                }else{
                  RadioButton radioButton=  findViewById(radioId);
                    displaytext.append(" :" + radioButton.getText());
                    Toast.makeText(RadioButtonDemoActivity.this, displaytext, Toast.LENGTH_LONG).show();

                }
               /* if (radioButton1.isChecked()) {
                    displaytext.append(" :" + radioButton1.getText());
                    if (radioButton2.isChecked()) {
                        displaytext.append(" :" + radioButton2.getText());
                    }
                }*/

            }
        });
        radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    radioButton2.setChecked(false);
                } else {
                    radioButton2.setChecked(true);

                }
            }
        });

        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    radioButton1.setChecked(false);
                } else {
                    radioButton1.setChecked(true);

                }
            }
        });
    }

    public void placeOrder(View view) {
        StringBuilder userOrder = new StringBuilder("Your place Order Is");
        if (checkBox1.isChecked()) {
            userOrder.append(checkBox1.getText());
        }
        if (checkBox2.isChecked()) {
            userOrder.append(checkBox2.getText());
        }
        if (checkBox3.isChecked()) {
            userOrder.append(checkBox3.getText());
        }
        if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked())
            Toast.makeText(RadioButtonDemoActivity.this, userOrder, Toast.LENGTH_LONG).show();
        else {
            Toast.makeText(RadioButtonDemoActivity.this, "please select Any option", Toast.LENGTH_LONG).show();

        }
    }
}
