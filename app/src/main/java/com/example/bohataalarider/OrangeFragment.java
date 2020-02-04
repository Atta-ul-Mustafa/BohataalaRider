package com.example.bohataalarider;


import android.os.Bundle;
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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.bohataalarider.MainActivity.rloginB;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrangeFragment extends Fragment {


    public OrangeFragment() {
        // Required empty public constructor
    }

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       v= inflater.inflate(R.layout.fragment_orange, container, false);
        recyclerView = (RecyclerView)v.findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager
                (getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        movieList.clear();


        ClientApi clientApi = Base.getClient().create(ClientApi.class);
        FRider fSubCat = new FRider(rloginB.getRiderId());
        Call<RriderHistory> call = clientApi. geHistory(fSubCat);

call.enqueue(new Callback<RriderHistory>() {
    @Override
    public void onResponse(Call<RriderHistory> call, Response<RriderHistory> response) {
        RriderHistory rriderHistory=response.body();
    //    Toast.makeText(getContext(), ""+rriderHistory.getMessage(), Toast.LENGTH_SHORT).show();


        List<RriderHistoryB> list=rriderHistory.getData();
        for (RriderHistoryB r:
             list) {


            movieList.add(new Movie(r.getTaskStatus(), r.getDeliveryAddress(), r.getOrderTime(),r.getOrderId(),"1"));


        }

        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFailure(Call<RriderHistory> call, Throwable t) {

    }

});





       /* movieList.add(new Movie("Delivered", "Model Town Lahore", "4/7/2015"));
        movieList.add(new Movie("Delivered", "Sabzazar Lahore ", "4/7/2015"));
        movieList.add(new Movie("Delivered", "Model Town Lahore", "4/7/2015"));
        movieList.add(new Movie("Delivered", "Township Lahore", "4/7/2015"));
        movieList.add(new Movie("Delivered", "Sabzazar Lahore ", "4/7/2015"));
        movieList.add(new Movie("Delivered", "Model Town Lahore", "4/7/2015"));
        movieList.add(new Movie("Delivered", "Sabzazar Lahore ", "4/7/2015"));
        movieList.add(new Movie("Delivered", "Model Town Lahore", "4/7/2015"));
        movieList.add(new Movie("Delivered", "Township Lahore", "4/7/2015"));
        movieList.add(new Movie("Delivered", "Sabzazar Lahore ", "4/7/2015"));
        movieList.add(new Movie("Delivered", "Model Town Lahore", "4/7/2015"));
        movieList.add(new Movie("Delivered", "Sabzazar Lahore ", "4/7/2015"));
        movieList.add(new Movie("Delivered", "Model Town Lahore", "4/7/2015"));
        movieList.add(new Movie("Delivered", "Township Lahore", "4/7/2015"));
        movieList.add(new Movie("Delivered", "Sabzazar Lahore ", "4/7/2015"));
*/


        // prepareMovieData();
        return v;
    }
    /*private void prepareMovieData() {
        ClientApi clientApi = Base.getClient().create(ClientApi.class);
        final itemFile login = new itemFile(idea);
        Call<List<itemFile>> call = clientApi.getHistory(login);
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
            }

            @Override
            public void onFailure(Call<List<itemFile>> call, Throwable t) {

            }
        });

    }*/
}
