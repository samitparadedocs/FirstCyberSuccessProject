package com.cybersuccess.demo.firstcybersuccessproject.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cybersuccess.demo.firstcybersuccessproject.R;

import org.w3c.dom.Text;

public class ScreenSlidePageFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        TextView textView = rootView.findViewById(R.id.textviewPagerText);
        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.getString("page_number") != null) {
                textView.setText("Page number is" + bundle.getString("page_number"));
            }
        }
        return rootView;
    }
}