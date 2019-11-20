package com.syedsadman16.instagramclone.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.syedsadman16.instagramclone.Fragments.HomeFragment;
import com.syedsadman16.instagramclone.Fragments.PhotoFragment;
import com.syedsadman16.instagramclone.Fragments.UserFragment;
import com.syedsadman16.instagramclone.Models.Post;
import com.syedsadman16.instagramclone.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    //RecyclerAdapter adapter;
    //List<Post> instafeedList;
    RecyclerView instaRecyclerView;
    //SwipeRefreshLayout swipeRefreshLayout;
    Button homeButton, pictureButton, userButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle("Instagram");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#110011")));

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        // define your fragments here
        final Fragment fragment1 = new HomeFragment();
        final Fragment fragment2 = new PhotoFragment();
        final Fragment fragment3 = new UserFragment();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        fragment = fragment1;
                        break;
                    case R.id.action_capture:
                        fragment = fragment2;
                        break;
                    case R.id.action_profile:
                        fragment = fragment3;
                        break;
                    default: return true;
                }
                fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit();
                return true;
            }
        });
        // Set default selection to be launched
        bottomNavigationView.setSelectedItemId(R.id.action_home);

        ParseQuery<Post> query = new ParseQuery<Post>(Post.class);
        query.include("author");
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> objects, ParseException e) {
                if(e != null){
                    e.printStackTrace();
                    return; //return so it doesn't execute for loop
                }
                for(int i=0; i<objects.size(); i++){
                    Post post =  objects.get(i);
                    Log.d("Post", "Post: " + post.getDescription()+ ",Username: " + post.getUser().getUsername());
                }
            }
        });



        //pull to refresh
/*      swipeRefreshLayout = findViewById(R.id.swipeContainer);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                restClient.getTweetList(new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Headers headers, JSON json) {
                        JSONArray jsonArray = json.jsonArray;
                        try {
                            adapter.clear();
                            adapter.addAll(Tweet.jsonDataArray(jsonArray));
                            swipeRefreshLayout.setRefreshing(false);
                        } catch (JSONException e) { e.printStackTrace(); }
                    }

                    @Override
                    public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                        Log.e(TAG, throwable + "");
                    }
                });
            }
        });
*/
/*
        instaRecyclerView = findViewById(R.id.twitterFeedRV);
       // tweetsList = new ArrayList<>();
        //adapter = new RecyclerAdapter(this, (ArrayList<Tweet>) tweetsList);
        twitterFeedRV.setLayoutManager(new LinearLayoutManager(this));
        twitterFeedRV.setAdapter(adapter);
        twitterFeedRV.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        //Return the tweet list as json
        restClient = TwitterApplication.getRestClient(this);
        restClient.getTweetList(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                JSONArray jsonArray = json.jsonArray;
                Log.i(TAG,jsonArray+"");
                try {
                    adapter.clear();
                    adapter.addAll(Tweet.jsonDataArray(jsonArray));
                    swipeRefreshLayout.setRefreshing(false);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.e("StreamActivity", throwable + "");
            }
        });


        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.miCompose);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showEditDialog();
            }
        });
*/
    }


/*
    private void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        TweetDialogFragment editNameDialogFragment = TweetDialogFragment.newInstance("Tweet something");
        editNameDialogFragment.show(fm, "tweet_dialog_fragment");
        ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }
    */

}
