package com.example.acm;

import com.example.acm.Models.mlh.Event;
import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface MLHInterface {

    //This is called and "Annotation"
    //Here, our annotation is "GET" for GET request.
    //Inside the parenthesis we want to include the relative URL.
    //na-2019 is our relative URL.
    @GET("na-2019")
    //Call is retrofit Object.
    //We will put our List of Event(s) into this object and name this method "getEvents()"
    //Since this is a interface we do not include the method body.
    Call<List<Event>> getEvents();
    //Retrofit understands this object call and will generate the necessary code to
    //complete our HTTP request.

}
