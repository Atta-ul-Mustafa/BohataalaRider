package com.example.bohataalarider;


import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppleFragment extends Fragment {

    List<NewRetro> _new=new ArrayList<>();
    public AppleFragment(List<NewRetro> _new) {
        // Required empty public constructor
    this._new=_new;
    }

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_apple, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager
                (getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        movieList.clear();


        for (NewRetro n:
             _new) {
            movieList.add(new Movie(n.getTaskStatus(), n.getDeliveryAddress(), n.getOrderTime(),n.getOrderId(),n.getTaskId()));


        }
        mAdapter.notifyDataSetChanged();

       // Toast.makeText(getContext(), ""+_new.size(), Toast.LENGTH_SHORT).show();
        // prepareMovieData();

        // Log.d("value", "onCreateView: "+idea);
        return v;
    }


    /*private void prepareMovieData() {

        ClientApi clientApi = Base.getClient().create(ClientApi.class);
        final itemFile login = new itemFile(idea);
        Call<List<itemFile>> call = clientApi.getNew(login);
call.enqueue(new Callback<List<itemFile>>() {
    @Override
    public void onResponse(Call<List<itemFile>> call, Response<List<itemFile>> response) {
        if(response.isSuccessful()){
          List<itemFile> list=response.body();
            for (itemFile i :list
                    ) {
                Log.d("ddd", "onResponse: "+i.getFileName());
            }

        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                movieList.clear();
                prepareMovieData();
            }
        }, 5000);
    }

    @Override
    public void onFailure(Call<List<itemFile>> call, Throwable t) {

    }
});



    }*/
}
