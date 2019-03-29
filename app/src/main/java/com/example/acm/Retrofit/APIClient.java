package com.example.acm.Retrofit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.acm.R;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIClient {
    //Our base URL
    public static final String BASE_URL = "https://mlh-events.now.sh/";
    //Instance of Retrofit, this allows us to use the methods in the Retrofit class
    public static Retrofit retrofit;

    //We use the singleton pattern to insure that only one Retrofit instance is made at a time.
    //This helps data from getting messy
    public static Retrofit getApiClient() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}