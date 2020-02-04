package com.example.bohataalarider;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class InProgress extends Fragment {

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    List<InProgressRetro> inProgress;
    View v;
    public InProgress(List<InProgressRetro> inProgress) {
        // Required empty public constructor
    this.inProgress=inProgress;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fragment_in_progress, container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList,getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager
                (getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        movieList.clear();
       for (InProgressRetro i:
             inProgress) {
            movieList.add(new Movie(i.getOrderStatus(), i.getDeliveryAddress(), i.getOrderTime(),i.getOrderId(),i.getTaskId()));

        }
        mAdapter.notifyDataSetChanged();


        return v;

    }

}
