package com.syedsadman16.instagramclone.Adapters;

import android.content.Context;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
//import com.bumptech.glide.Glide;
import com.bumptech.glide.Glide;
import com.parse.ParseFile;
import com.syedsadman16.instagramclone.Models.Post;
import com.syedsadman16.instagramclone.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class RecyclerAdapter extends
        RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<Post> posts;

    public RecyclerAdapter(Context context, ArrayList<Post> posts){
        this.context = context;
        this.posts = posts;
    }


    // Clean all elements of the recycler
    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Post> list) {
        posts.addAll(list);
        notifyDataSetChanged();
    }

    //holds references to elements in recyclerview
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView userName;
        public TextView captionText;
        public ImageView postImage;
        public ImageView profileImage;


        public ViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.userName);
            captionText = (TextView) itemView.findViewById(R.id.captionText);
            postImage = (ImageView) itemView.findViewById(R.id.feedImage);
            profileImage = (ImageView) itemView.findViewById(R.id.profileImage);
        }


        public void populateView(final Post post) {
            userName.setText(post.getUser().getUsername());
            captionText.setText(post.getUser().getUsername() + "  " + post.getDescription());
            ParseFile image = post.getPicture();
            if (image != null) {
                Log.i("Recycle", image.getUrl());
                Glide.with(context).load(image.getUrl()).into(postImage);
            }
            Glide.with(context).load(R.drawable.instagram_user_filled_24).into(profileImage);
        }

    }

    // Inflating a layout file and returning it to view holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflate from XML file
        View postView = LayoutInflater.from(context).inflate(R.layout.recycler_layout, parent, false);
        return new ViewHolder(postView);
    }


    // Get data from position and put into view holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.populateView(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


}

