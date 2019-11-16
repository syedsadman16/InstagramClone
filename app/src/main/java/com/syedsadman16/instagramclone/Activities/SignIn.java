package com.syedsadman16.instagramclone.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseUser;
import com.syedsadman16.instagramclone.R;

public class SignIn extends AppCompatActivity {

    EditText usernameField, passwordField;
    Button signIn;
    TextView registerText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameField = findViewById(R.id.usernameField);
        passwordField = findViewById(R.id.passwordField);
        signIn = findViewById(R.id.signInButton);
        registerText = findViewById(R.id.registerText);

        //Before anything, if user is already signed in, skip login page
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            startActivity(new Intent(this, HomeActivity.class));
        }

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameField.getText().toString();
                String password = passwordField.getText().toString();
                Log.i("SignIn", username + password);
                login(username, password);
            }
        });

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this, RegisterActivity.class));
            }
        });

    }

    public void login(String username, String password){
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, com.parse.ParseException e) {
                if (e != null) {
                    Log.i("SignIn", "Error");
                    e.printStackTrace();
                    return;
                }
                startActivity(new Intent(SignIn.this, HomeActivity.class));
                finish();
            }

        });
    }
}
