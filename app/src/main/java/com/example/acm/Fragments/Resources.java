package com.example.acm.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acm.MLHInterface;
import com.example.acm.Models.mlh.Event;
import com.example.acm.R;
import com.example.acm.RecyclerHackathons;
import com.example.acm.Retrofit.APIClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.

public class Resources extends Fragment {

    //List of Hackathons, this is where our response from our JSON will be held.
    private List<Event> Hackathons;

    //Instace of TextView for our results. This will be displayed in the fragment_resources.xml
    private TextView results;

    public Resources() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Understanding this completely is out of the scope of the workshop
        //Just know that we are getting our root view since we are using a fragment instead of an activity.
        //We must know what activity we are on.
        View rootView = inflater.inflate(R.layout.fragment_resources, container, false);

        //Find the results TextView in our XML through Id
        results = rootView.findViewById(R.id.nav_resources);

        //LoadJSON is a custom method, we take in the parameter container since this is a fragment.
        LoadJson(container);

        return rootView;
    }

    public void LoadJson(final ViewGroup container){
        MLHInterface apiInterface = APIClient.getApiClient().create(MLHInterface.class);

        Call<List<Event>> call;
        call = apiInterface.getEvents();

        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                Hackathons = filterEvents(response.body());
                for (Event event : Hackathons) {
                    String content = "";
                    content += "Name: " + event.getName() + "\n";
                    content += "Location: " + event.getLocation() + "\n";
                    content += "Start Date: " + event.getStartDate() + "\n";
                    content += "End Date: " + event.getEndDate() + "\n";
                    content += "URL: " + event.getUrl() + "\n\n";

                    results.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {

            }
        });
    }

    public List<Event> filterEvents(final List<Event> allEvents){
        List<Event> caEvents = new ArrayList<>();
        for(int i = allEvents.size() - 1; i > 0; i--){
            //Filter California Events
            if(allEvents.get(i).getLocation().contains("CA")){
                caEvents.add(allEvents.get(i));
            }
        }
        return caEvents;

    }

}

 */
public class Resources extends Fragment {

    //List of Hackathons, this is where our response from our JSON will be held.
    private List<Event> hackathons;

    //Instace of TextView for our results. This will be displayed in the fragment_resources.xml
    private RecyclerView recyclerView;
    private RecyclerHackathons recyclerAdapter;

    public Resources() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Understanding this completely is out of the scope of the workshop
        //Just know that we are getting our root view since we are using a fragment instead of an activity.
        //We must know what activity we are on.
        View rootView = inflater.inflate(R.layout.fragment_resources, container, false);

        getActivity().setTitle("Resources");

        recyclerView = rootView.findViewById(R.id.hackathons_recycler);

        //LoadJSON is a custom method, we take in the parameter container since this is a fragment.
        LoadJson(container);

        return rootView;
    }

    public void LoadJson(final ViewGroup container){
        MLHInterface apiInterface = APIClient.getApiClient().create(MLHInterface.class);

        Call<List<Event>> call;
        call = apiInterface.getEvents();

        //We will be changing our response for the enqueue.
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                hackathons = filterEvents(response.body());
                //Instead of the Text View we appended to, we're going to replace it with the RecyclerView.
                //Here, create the instance of the RecyclerAdapter.
                recyclerAdapter = new RecyclerHackathons(hackathons, container.getContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {

            }
        });
    }

    public List<Event> filterEvents(final List<Event> allEvents){
        List<Event> caEvents = new ArrayList<>();
        for(int i = allEvents.size() - 1; i > 0; i--){
            //Filter California Events
            if(allEvents.get(i).getLocation().contains("CA")){
                caEvents.add(allEvents.get(i));
            }
        }
        return caEvents;

    }


}
