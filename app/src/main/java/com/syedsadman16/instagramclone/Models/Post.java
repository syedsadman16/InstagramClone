package com.syedsadman16.instagramclone.Models;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Post")
public class Post extends ParseObject {


    public String getDescription(){
        return getString("description");
    }
    public void setDescription(String desc){
        put("description", desc);
    }

    public ParseFile getPicture() {
        return getParseFile("picture");
    }

    public void setPicture(ParseFile parseFile) {
        put("picture", parseFile);
    }

    public ParseUser getUser(){
        return getParseUser("author");
    }

    public void setUser(ParseUser author){
        put("author", author);
    }
}
