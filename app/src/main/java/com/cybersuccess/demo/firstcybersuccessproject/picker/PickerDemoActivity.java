package com.cybersuccess.demo.firstcybersuccessproject.picker;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.cybersuccess.demo.firstcybersuccessproject.R;

import java.util.Calendar;

public class PickerDemoActivity extends AppCompatActivity {
    DatePicker picker;
    Button displayDate;
    TextView textview1;

    TextView textView2;
    Button selectTimebtn;
    TimePicker timePicker1;

    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker_demo);

        //demos for the time picker
        textview1 = (TextView) findViewById(R.id.textView1);
        picker = (DatePicker) findViewById(R.id.datePicker1);
        displayDate = (Button) findViewById(R.id.button1);

        textview1.setText(getCurrentDate());

        displayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview1.setText(getCurrentDate());
            }

        });

        //demos for time picker
        textView2 = findViewById(R.id.selectedtime);
        selectTimebtn = findViewById(R.id.selectTimeBtn);
        timePicker1 = findViewById(R.id.timepIcker);
        selectTimebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentTime = "Current Time: " + timePicker1.getCurrentHour() + ":" + timePicker1.getCurrentMinute();
     textView2.setText(currentTime);
            }
        });

        //Use the current date as the default date in the date picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        //Create a new DatePickerDialog instance and return it

        datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(PickerDemoActivity.this,"Date is"+i+"/"+i1+"/"+i2,Toast.LENGTH_SHORT).show();
            }
        }, year, month, day);

        //datePickerDialog.show();

        //Time picker Dialog

        // Get Current Time
        final Calendar cal = Calendar.getInstance();
       int  mHour = cal.get(Calendar.HOUR_OF_DAY);
        int mMinute = cal.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                        Toast.makeText(PickerDemoActivity.this,""+hourOfDay+":"+minute,Toast.LENGTH_SHORT).show();

                    }
                }, mHour, mMinute, false);


        //timePickerDialog.show();
/*refer below link: https://www.journaldev.com/9652/android-progressdialog-example*/

        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Title");
        progressDialog.setMessage("Message");
        progressDialog.setMax(100);

        progressDialog.incrementProgressBy(30);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();

    }

    public String getCurrentDate() {
        StringBuilder builder = new StringBuilder();
        builder.append("Current Date: ");
        builder.append((picker.getMonth() + 1) + "/");//month is 0 based
        builder.append(picker.getDayOfMonth() + "/");
        builder.append(picker.getYear());
        return builder.toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}

