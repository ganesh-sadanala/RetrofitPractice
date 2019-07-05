package com.ganesh.retrofitpractice;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int userId;
    private int id;
    private String title;
    @SerializedName("body")
    private String text;
    //If we name it different from Json names, we can annotate using @SerializedName(textIn Json)

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    //Next step is to create an interface that represents the web service api
}
