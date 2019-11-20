package com.syedsadman16.instagramclone.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.syedsadman16.instagramclone.R;

public class HomeFragment extends Fragment {

    TextView textView;


    public HomeFragment() {
        // Required empty public constructor
    }

    // Inflate the view
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    // Method that gets called when the view is actually created
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        textView = view.findViewById(R.id.testing);
    }
}
