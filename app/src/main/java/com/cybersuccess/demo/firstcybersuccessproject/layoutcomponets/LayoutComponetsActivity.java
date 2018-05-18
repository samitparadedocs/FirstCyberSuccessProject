package com.cybersuccess.demo.firstcybersuccessproject.layoutcomponets;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.cybersuccess.demo.firstcybersuccessproject.R;
import com.cybersuccess.demo.firstcybersuccessproject.layoutcomponets.radiobutton.CustomArrayAdapterDemo;
import com.cybersuccess.demo.firstcybersuccessproject.layoutcomponets.radiobutton.CustomBaseAdapterDemo;
import com.cybersuccess.demo.firstcybersuccessproject.layoutcomponets.radiobutton.RadioButtonDemoActivity;

import java.util.ArrayList;

/**
 * Created by Samit on 5/12/2018.
 */

public class LayoutComponetsActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSimpleToast;
    private Button btnCustomToast;
    private ToggleButton toggleButton;
    private Spinner spinner;
    private AutoCompleteTextView autoCompleteTextView;
    private ListView listView;
    private GridView gridview;

    private ListView arrayAdapterList;
    private ListView customListViewBase;
    CustomArrayAdapter customArrayAdapter;

    String[] coutries = {"India", "USA", "Pakistan"};

    String[] language = {"C", "C++", "Java", ".NET", "iPhone", "Android", "ASP.NET", "PHP"};


    String[] maintitle = {
            "Title 1", "Title 2",
            "Title 3", "Title 4",
            "Title 5",
    };

    String[] subtitle = {
            "Sub Title 1", "Sub Title 2",
            "Sub Title 3", "Sub Title 4",
            "Sub Title 5",
    };

    Integer[] imgid = {
            R.drawable.ic_face_black_24dp, R.drawable.ic_face_black_24dp,
            R.drawable.ic_face_black_24dp, R.drawable.ic_face_black_24dp,
            R.drawable.ic_face_black_24dp,
    };

    ArrayList<Country> countriesList=new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_components);
        btnSimpleToast = findViewById(R.id.btnSimpleTost);
        btnCustomToast = findViewById(R.id.btnCustomToast);
        toggleButton = findViewById(R.id.btnToggle);
        spinner = findViewById(R.id.spinner);
        // gridview = findViewById(R.id.gridLayouts);


        btnSimpleToast.setOnClickListener(this);
        btnCustomToast.setOnClickListener(this);
        toggleButton.setOnClickListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, coutries);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Selected coutry IS:" + coutries[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        listView = findViewById(R.id.listView);
        CustomArrayAdapterDemo customArrayAdapterDemo = new CustomArrayAdapterDemo(this, maintitle, subtitle, imgid);

        listView.setAdapter(customArrayAdapterDemo);
        /*ArrayAdapter adaapterListView=new ArrayAdapter(this,android.R.layout.simple_list_item_1,language);
        listView.setAdapter(adaapterListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Selected Item From Lsit:"+i, Toast.LENGTH_SHORT).show();

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Selected Item forong Lsit:"+i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });*/

        autoCompleteTextView = findViewById(R.id.autocompleteTextView);
        ArrayAdapter arrayAdapterForAutoComplete = new ArrayAdapter(this, android.R.layout.select_dialog_item, language);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setTextColor(Color.RED);
        autoCompleteTextView.setAdapter(arrayAdapterForAutoComplete);

//        gridview.setAdapter(arrayAdapter);
        /*
        displayCustomToast();



       // arrayAdapterList=findViewById(R.id.listViewArrayAdapter);
       /* CustomArrayAdapter customArrayAdapter=new CustomArrayAdapter(this,maintitle,subtitle,imgid);
    arrayAdapterList.setAdapter(customArrayAdapter);
    */
    /*CustomBaseAdapter customBaseAdapter=new CustomBaseAdapter(this,maintitle);
    arrayAdapterList.setAdapter(customBaseAdapter);
    */
        customListViewBase = findViewById(R.id.customListViewBase);

        Country c1=new Country(1,"India","Desc about india",R.drawable.ic_face_black_24dp);
        Country c2=new Country(2,"Pakistan","Desc about Pakistan",R.drawable.ic_face_black_24dp);
        Country c3=new Country(3,"USA","Desc about USA",R.drawable.ic_face_black_24dp);
        Country c4=new Country(4,"China","Desc about China",R.drawable.ic_face_black_24dp);
        countriesList.add(c1);
        countriesList.add(c2);
        countriesList.add(c3);
        countriesList.add(c4);

        CustomBaseAdapterDemo customBaseAdapterDemo = new CustomBaseAdapterDemo(this, countriesList);
        customListViewBase.setAdapter(customBaseAdapterDemo);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSimpleTost:
                displaySimpleToast();
                break;
            case R.id.btnCustomToast:
                displayCustomToast();
                break;

            case R.id.btnToggle:
                StringBuilder result = new StringBuilder();
                result.append("ToggleButton1 : ").append(toggleButton.getText());
                //Displaying the message in toast
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
                break;
        }
    }


    private void displaySimpleToast() {
        Toast.makeText(getApplicationContext(), "Hello Cyber Success", Toast.LENGTH_SHORT).show();
    }

    private void displayCustomToast() {
        //Creating the LayoutInflater instanceLay
        LayoutInflater li = getLayoutInflater();
        //Getting the View object as defined in the customtoast.xml file
        View layout = li.inflate(R.layout.customtoast,
                (ViewGroup) findViewById(R.id.custom_toast_layout));

        TextView textView = layout.findViewById(R.id.custom_toast_message);
        textView.setText("Custom message for textView");
        textView.setTextColor(R.color.colorAccent);
        //Creating the Toast object
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(layout);//setting the view of custom toast layout
        toast.show();
    }

    public void showAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setMessage("You really want to do this Action?").setTitle("Title");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(LayoutComponetsActivity.this, "Positive Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(LayoutComponetsActivity.this, "Negative Button Clicked", Toast.LENGTH_SHORT).show();

            }
        });

        builder.show();
    }

    public void startRadioButtonActivity(View view) {
        startActivity(new Intent(this, RadioButtonDemoActivity.class));
    }
}
