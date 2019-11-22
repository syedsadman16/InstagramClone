package com.syedsadman16.instagramclone.Models;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Post")
public class Post extends ParseObject {

    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "picture";
    public static final String KEY_USER = "author";
    public static final String KEY_CREATED_AT = "createdAt";

    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }
    public void setDescription(String desc){
        put(KEY_DESCRIPTION, desc);
    }

    public ParseFile getPicture() {
        return getParseFile(KEY_IMAGE);
    }

    public void setPicture(ParseFile parseFile) {
        put(KEY_IMAGE, parseFile);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser author){
        put(KEY_USER, author);
    }
}
