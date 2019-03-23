package org.pursuit.searchviewappfromscratch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;

import org.pursuit.searchviewappfromscratch.controller.StatesAdapter;
import org.pursuit.searchviewappfromscratch.model.States;
import org.pursuit.searchviewappfromscratch.model.StatesWrapper;
import org.pursuit.searchviewappfromscratch.network.StatesRetrofitSingleton;
import org.pursuit.searchviewappfromscratch.network.StatesService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private Retrofit retro;
    private String TAG = "MAIN_ACTIVITY";
    private String TAG2 = "MAIN_ACTIVITY_FAIL";
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private StatesAdapter adapter;
    private SearchView searchView;
    private List<States>stateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.stateRV);
        searchView = findViewById(R.id.state_searchview);

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        searchView.setOnQueryTextListener(this);

        stateList = new ArrayList<>();

        retro = StatesRetrofitSingleton.getInstance();
        StatesService service = retro.create(StatesService.class);
        Call<StatesWrapper> statesWrapperCall = service.getStates();
        statesWrapperCall.enqueue(new Callback<StatesWrapper>() {
            @Override
            public void onResponse(Call<StatesWrapper> call, Response<StatesWrapper> response) {
                adapter = new StatesAdapter(response.body().states());
                stateList.addAll(response.body().states());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<StatesWrapper> call, Throwable t) {
                Log.d(TAG2, "onResponse: " + t.getMessage());
            }
        });

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        List<States> newStateList = new ArrayList<>();
        for(States states : stateList) {
            if(states.getName().toLowerCase().startsWith(s.toLowerCase())) {
                newStateList.add(states);
            }
        }
        adapter.setData(newStateList);
        return false;
    }
}
