package com.cybersuccess.demo.firstcybersuccessproject.layoutcomponets.radiobutton;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cybersuccess.demo.firstcybersuccessproject.R;

/**
 * Created by Samit on 5/17/2018.
 */

public class CustomBaseAdapterDemo extends BaseAdapter {
    Activity context;
    String[] titles;
    public CustomBaseAdapterDemo(Activity context,String[] titles){
        this.context=context;
        this.titles=titles;
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
        TextView titleText = (TextView) childView.findViewById(R.id.title);
        ImageView imageView = (ImageView) childView.findViewById(R.id.icon);
        TextView subtitleText = (TextView) childView.findViewById(R.id.subtitle);

        titleText.setText(titles[i]);
        return childView;
    }
}
