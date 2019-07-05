package com.ganesh.retrofitpractice;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceholderApi {
    /*Retrofit generates all the lower level code like doGet doPost ...
    All we have to do is tell the retrofit to do what we want it to do
    by annotating
     */
    //we provide the relative part inside a base url
    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId") int userId); //retrofit automatically adds ? before @Query
                                                            //and = before userId

//    @GET("posts/2/comments")
//    Call<List<Comment>> getComments();
    //Instead of hard coding like in the above case, we can do like below
    @GET("posts/{id}/comments")  //id as in json
    Call<List<Comment>> getComments(@Path("id") int pathId,@Query("postId") int postId,@Query("_sort")
                                    String sort,@Query("_order")String order); //Path is to tell the retrofit to put the pathId in the placeholder id



}
