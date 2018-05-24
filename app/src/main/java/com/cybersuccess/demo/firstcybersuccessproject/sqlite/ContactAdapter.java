package com.cybersuccess.demo.firstcybersuccessproject.sqlite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.cybersuccess.demo.firstcybersuccessproject.R;

import java.util.ArrayList;

/**
 * Created by Samit on 5/22/2018.
 */

public class ContactAdapter extends BaseAdapter {
    ArrayList<Contact> contacts;
    Activity context;

    public ContactAdapter(ArrayList<Contact> contacts, Activity context) {
        this.contacts = contacts;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int i) {
        return contacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       View view1= context.getLayoutInflater().inflate(R.layout.contact_list,viewGroup,false);
        return view1;
    }
}
