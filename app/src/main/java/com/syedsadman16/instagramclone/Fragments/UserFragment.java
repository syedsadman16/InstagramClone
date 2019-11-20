package com.syedsadman16.instagramclone.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.parse.ParseUser;
import com.syedsadman16.instagramclone.Activities.SignIn;
import com.syedsadman16.instagramclone.Activities.UserActivity;
import com.syedsadman16.instagramclone.R;

public class UserFragment extends Fragment {
    Button logOut;

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    // Method that gets called when the view is actually created
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        logOut = view.findViewById(R.id.signOutButton);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser();
                startActivity(new Intent(getContext(), SignIn.class));
            }
        });
    }


}
