package com.cybersuccess.demo.firstcybersuccessproject.layoutcomponets;

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
    Context context;
    public CustomBaseAdapter(Context context,String[] titles) {
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
        View view1;
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view1=layoutInflater.inflate(R.layout.custom_list,viewGroup,false);
TextView txt=view1.findViewById(R.id.title);
txt.setText(titles[i]);
        return view1;
    }
}
