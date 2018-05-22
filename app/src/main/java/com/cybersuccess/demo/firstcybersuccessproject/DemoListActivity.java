package com.cybersuccess.demo.firstcybersuccessproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cybersuccess.demo.firstcybersuccessproject.layoutcomponets.LayoutComponetsActivity;
import com.cybersuccess.demo.firstcybersuccessproject.layoutdata.LinearLayoutDemo;
import com.cybersuccess.demo.firstcybersuccessproject.layoutdata.RelativeLayoutDemoAct;
import com.cybersuccess.demo.firstcybersuccessproject.picker.PickerDemoActivity;
import com.cybersuccess.demo.firstcybersuccessproject.service.ServiceDemoActivity;

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

        /*MyDialogFragment editNameDialog = new MyDialogFragment();
        editNameDialog.show(getFragmentManager(), "fragment_edit_name");
        */
       /* MyAlertDialogFragment alertDialogFragment = new MyAlertDialogFragment();
        alertDialogFragment.show(getFragmentManager(), "fragment_edit_name");
*/


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Toast.makeText(this, "Home menu clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "Item2 menu clicked", Toast.LENGTH_SHORT).show();

                break;
            case R.id.item3:
                Toast.makeText(this, "Item3 menu clicked", Toast.LENGTH_SHORT).show();

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void conextMenuActivity(View view) {

        startActivity(new Intent(this, MenusDemoActivity.class));
    }

    public void startPickerDemoActivity(View view) {
        startActivity(new Intent(this, PickerDemoActivity.class));
    }

    public void startServiceDemoActivity(View view) {
          startActivity(new Intent( this, ServiceDemoActivity.class));

/*    //REFER LINK: https://bhavyanshu.me/tutorials/create-custom-alert-dialog-in-android/08/20/2015
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText edt = (EditText) dialogView.findViewById(R.id.edit1);
        edt.setText("cUSTOM TEXT");
        dialogBuilder.setTitle("Custom dialog");
        dialogBuilder.setMessage("Enter text below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
*/
    }
}
