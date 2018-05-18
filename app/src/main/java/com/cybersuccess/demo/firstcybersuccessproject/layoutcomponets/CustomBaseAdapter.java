package com.cybersuccess.demo.firstcybersuccessproject.layoutcomponets;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cybersuccess.demo.firstcybersuccessproject.R;

/**
 * Created by Samit on 5/13/2018.
 */

public class CustomBaseAdapter extends BaseAdapter {
    String[] titles;
    Activity context;

    public CustomBaseAdapter(String[] titles, Activity context) {
        this.titles = titles;
        this.context = context;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int i) {
        return titles[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View childView=layoutInflater.inflate(R.layout.custom_list_demo,viewGroup,false);
     TextView title=childView.findViewById(R.id.title);
     title.setText(titles[i]);
        return childView;
    }
}
