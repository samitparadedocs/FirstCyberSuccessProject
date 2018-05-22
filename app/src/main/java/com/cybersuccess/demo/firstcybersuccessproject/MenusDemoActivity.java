package com.cybersuccess.demo.firstcybersuccessproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MenusDemoActivity extends AppCompatActivity {
     ListView listView1;
     String contacts[]={"Ajay","Sachin","Sumit","Tarun","Yogesh"};

     Button popUpmenuExampleBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conext_menu);
        listView1=(ListView)findViewById(R.id.listView1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        listView1.setAdapter(adapter);

        registerForContextMenu(listView1);



        popUpmenuExampleBtn=findViewById(R.id.popUpmenuExample);
        popUpmenuExampleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popup=new PopupMenu(MenusDemoActivity.this,popUpmenuExampleBtn);

                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MenusDemoActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();

                        return true;
                    }
                });

               /* popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MenusDemoActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });*/

                popup.show();//showing popup menu
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Set the context menu Action");
        menu.add("Call");
        menu.add("SMS");
     /*   menu.setHeaderTitle("Set The Action");
        menu.add(1, v.getId(), 1, "Call");//groupId, itemId, order, title
        menu.add(2, v.getId(), 2, "SMS"); */
    }
    /*

    */
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Call"){
            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle()=="SMS"){
            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo_activity, menu);
        return true;
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.save:
                Toast.makeText(this, "Saved option Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.reset:
                Toast.makeText(this, "Reset option Clicked", Toast.LENGTH_SHORT).show();

                break;
            case R.id.logout:
                Toast.makeText(this, "Logout option Clicked", Toast.LENGTH_SHORT).show();

                break;
        }

        return super.onOptionsItemSelected(item);
    }


}

