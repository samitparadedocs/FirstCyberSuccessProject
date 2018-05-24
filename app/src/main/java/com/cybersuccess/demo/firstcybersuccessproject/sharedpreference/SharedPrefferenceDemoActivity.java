package com.cybersuccess.demo.firstcybersuccessproject.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cybersuccess.demo.firstcybersuccessproject.R;

public class SharedPrefferenceDemoActivity extends AppCompatActivity {
    EditText firstName, lastName;
    Button add, clear, retive, removeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefference_demo);
        firstName = findViewById(R.id.userName);
        lastName = findViewById(R.id.lastName);
        add = findViewById(R.id.addBtn);
        clear = findViewById(R.id.clearBtn);
        retive = findViewById(R.id.retriveBtn);
        removeBtn = findViewById(R.id.removeBtn);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDataInSharedPreference();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName.setText("");
                lastName.setText("");
            }
        });
        retive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveDataFromSharedPreference();
            }
        });
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeSharedPreferences();
            }
        });

    }

    private void removeSharedPreferences() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MY_PREF_Cyber", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("first_name");
        editor.remove("last_name");
        editor.commit();

    }

    private void addDataInSharedPreference() {
        Toast.makeText(this, "Add clicked", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MY_PREF_Cyber", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("first_name", firstName.getText().toString());
        editor.putString("last_name", lastName.getText().toString());
        editor.putBoolean("key_name1", true); // Storing boolean - true/false
        editor.putInt("key_name3", 10); // Storing integer
        editor.putFloat("key_name4", (float) 11.55); // Storing float
        editor.putLong("key_name5", 100000111); // Storing long

        editor.commit();

    }

    private void retriveDataFromSharedPreference() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MY_PREF_Cyber", MODE_PRIVATE);
        String firstName = sharedPreferences.getString("first_name", "default string");
        String lastName = sharedPreferences.getString("last_name", "default string");

        this.firstName.setText(firstName);
        this.lastName.setText(lastName);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("key1" + sharedPreferences.getBoolean("key_name1", false));
        stringBuilder.append("key2" + sharedPreferences.getString("key_name2", "dummy"));
        stringBuilder.append("key3" + sharedPreferences.getInt("key_name3", 1));
        stringBuilder.append("key4" + sharedPreferences.getFloat("key_name4", (float) 1.001));
        stringBuilder.append("key5" + sharedPreferences.getLong("key_name5", 10001));
        Log.d("pref values", stringBuilder.toString());

    }


}
