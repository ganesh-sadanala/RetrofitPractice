package com.ganesh.retrofitpractice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceholderApi {
    /*Retrofit generates all the lower level code like doGet doPost ...
    All we have to do is tell the retrofit to do what we want it to do
    by annotating
     */
    //we provide the relative part inside a base url
    @GET("posts")
    Call<List<Post>> getPosts();
}
