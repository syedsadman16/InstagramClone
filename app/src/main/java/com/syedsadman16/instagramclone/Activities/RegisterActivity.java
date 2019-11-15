package com.syedsadman16.instagramclone.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.syedsadman16.instagramclone.R;

import java.text.ParseException;

public class RegisterActivity extends AppCompatActivity {

    EditText usernameField, passwordField, emailField, nameTextField;
    Button registerButton;
    TextView signInText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameField = findViewById(R.id.usernameField);
        passwordField = findViewById(R.id.passwordField);
        emailField = findViewById(R.id.emailField);
        registerButton = findViewById(R.id.registerButton);
        signInText = findViewById(R.id.signInText);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameField.getText().toString();
                String password = passwordField.getText().toString();
                String email = emailField.getText().toString();
                register(username,password,email);
            }
        });


    }

    public void register(String username, String password, String email){
        // Create the ParseUser
        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(com.parse.ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                    startActivity(new Intent(RegisterActivity.this, SignIn.class));
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });
    }
}
