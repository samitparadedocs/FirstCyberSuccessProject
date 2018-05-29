package com.cybersuccess.demo.firstcybersuccessproject.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cybersuccess.demo.firstcybersuccessproject.R;

public class UsefulInfoFragment extends Fragment {

    public UsefulInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);
        return rootView;
    }
}