package com.cybersuccess.demo.firstcybersuccessproject.layoutcomponets.radiobutton;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cybersuccess.demo.firstcybersuccessproject.R;
import com.cybersuccess.demo.firstcybersuccessproject.layoutcomponets.Country;

import java.util.ArrayList;

/**
 * Created by Samit on 5/17/2018.
 */

public class CustomBaseAdapterDemo extends BaseAdapter {
    Activity context;
    ArrayList coutriesList;
    public CustomBaseAdapterDemo(Activity context,ArrayList coutriessList){
        this.context=context;
        this.coutriesList =coutriessList;
    }

    @Override
    public int getCount() {
        return coutriesList.size();
    }

    @Override
    public Object getItem(int i) {
        return coutriesList.get(i);

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

        Country country= (Country) coutriesList.get(i);
        titleText.setText(country.getCountryName());
        subtitleText.setText(country.getDetails());
        imageView.setImageResource(country.getImageId());
        return childView;
    }
}
