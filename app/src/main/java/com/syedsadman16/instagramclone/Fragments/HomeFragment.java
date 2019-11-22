package com.syedsadman16.instagramclone.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.syedsadman16.instagramclone.Adapters.RecyclerAdapter;
import com.syedsadman16.instagramclone.Models.Post;
import com.syedsadman16.instagramclone.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    static RecyclerAdapter adapter;
    List<Post> posts;
    private SwipeRefreshLayout swipeContainer;

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
        recyclerView = view.findViewById(R.id.recyView);
        swipeContainer = (SwipeRefreshLayout) view.findViewById(R.id.swipeContainer);
        posts = new ArrayList<Post>();
        adapter = new RecyclerAdapter(getContext(), (ArrayList<Post>) posts);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        queryPost();

        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ParseQuery<Post> query = new ParseQuery<Post>(Post.class);
                query.include(Post.KEY_USER);
                query.setLimit(20);
                query.addDescendingOrder(Post.KEY_CREATED_AT);
                query.findInBackground(new FindCallback<Post>() {
                    @Override
                    public void done(List<Post> objects, ParseException e) {
                        if(e != null){
                            e.printStackTrace();
                            return; //return so it doesn't execute for loop
                        }

                        adapter.clear();
                        posts.addAll(objects);
                        adapter.notifyDataSetChanged();
                        for(int i=0; i<objects.size(); i++){
                            Post post =  objects.get(i);
                            Log.d("Post", "Post: " + post.getDescription()+ ",Username: " + post.getUser().getUsername());
                        }
                    }
                });
                swipeContainer.setRefreshing(false);
            }
        });
    }

    public void queryPost(){
        ParseQuery<Post> query = new ParseQuery<Post>(Post.class);
        query.include(Post.KEY_USER);
        query.setLimit(20);
        query.addDescendingOrder(Post.KEY_CREATED_AT);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> objects, ParseException e) {
                if(e != null){
                    e.printStackTrace();
                    return; //return so it doesn't execute for loop
                }
                posts.addAll(objects);
                adapter.notifyDataSetChanged();
                for(int i=0; i<objects.size(); i++){
                    Post post =  objects.get(i);
                    Log.d("Post", "Post: " + post.getDescription()+ ",Username: " + post.getUser().getUsername());
                }
            }
        });
    }


}
