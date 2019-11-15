package com.syedsadman16.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("syed-insta") // should correspond to APP_ID env variable
                .clientKey("syedMasterKey")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("https://syed-insta.herokuapp.com/parse").build());
    }
}