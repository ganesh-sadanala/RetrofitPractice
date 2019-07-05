package com.ganesh.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text);
        /*The Retrofit class generates an implementation of the JsonPlaceholder interface.*/
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceholderApi jsonPlaceholderApi=retrofit.create(JsonPlaceholderApi.class);
        Call<List<Post>> call=jsonPlaceholderApi.getPosts();
        /*There is another methode call execute() because this method
        will run synchronously with main thread causing to freeze it.
        There is an another method called ennqueue by retrofit
        that creates another thread in the background.
         */
        //Asynchronously sends request
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                /*If this method gets executed that doesn't mean
                everything is going good because the server may respond with 404 message
                 */
                if(!response.isSuccessful())
                {
                    textView.setText("Code: "+response.code());
                    return;
                }
                List<Post>posts=response.body();
                String content="";
                for(Post post:posts)
                {
                    content+=post.getUserId()+" "+post.getUserId()+" "+post.getText()+" "+post.getText();
                            content+="\n\n";
                            textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
               textView.setText(t.getMessage());
            }
        });
    }
}
