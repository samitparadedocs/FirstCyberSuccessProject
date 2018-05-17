package com.cybersuccess.demo.firstcybersuccessproject.layoutcomponets.radiobutton;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cybersuccess.demo.firstcybersuccessproject.R;

import java.util.List;

/**
 * Created by Samit on 5/17/2018.
 */

public class CustomArrayAdapterDemo extends ArrayAdapter {

    private Activity context;
    private String[] maintitle;
    private String[] subtitle;
    private Integer[] imgid;

    public CustomArrayAdapterDemo(Activity context, String[] maintitle, String[] subtitle, Integer[] imgid) {
        super(context, R.layout.custom_list_demo, maintitle);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.maintitle = maintitle;
        this.subtitle = subtitle;
        this.imgid = imgid;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view;
        if (convertView != null) {
            view = convertView;
        } else {
            view = layoutInflater.inflate(R.layout.custom_list_demo, parent, false);

        }
        TextView title = view.findViewById(R.id.title);
        TextView SubTitle = view.findViewById(R.id.subtitle);
        ImageView imageView = view.findViewById(R.id.icon);
        title.setText(maintitle[position]);
        SubTitle.setText(subtitle[position]);
        imageView.setImageResource(imgid[position]);

        return view;
    }
}
