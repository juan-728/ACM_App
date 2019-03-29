package com.example.acm.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acm.R;


public class About extends Fragment{
    public About() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("About Us");
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

}
