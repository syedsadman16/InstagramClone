package com.syedsadman16.instagramclone.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.syedsadman16.instagramclone.R;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().hide();
    }
}
