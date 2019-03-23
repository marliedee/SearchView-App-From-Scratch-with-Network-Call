package org.pursuit.searchviewappfromscratch.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.searchviewappfromscratch.R;
import org.pursuit.searchviewappfromscratch.model.States;
import org.pursuit.searchviewappfromscratch.model.StatesWrapper;
import org.pursuit.searchviewappfromscratch.view.StatesViewHolder;

import java.util.List;

public class StatesAdapter extends RecyclerView.Adapter<StatesViewHolder> {
    private List<States> stateList;

    public StatesAdapter(List<States> stateList) {
        this.stateList = stateList;
    }

    public List<States> getStateList() {
        return stateList;
    }

    @NonNull
    @Override
    public StatesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.state_listview, viewGroup, false);
        return new StatesViewHolder(childView);     }

    @Override
    public void onBindViewHolder(@NonNull StatesViewHolder statesViewHolder, int i) {
        statesViewHolder.onBind(stateList.get(i));

    }

    @Override
    public int getItemCount() {
        return stateList.size();
    }

    public void setData(List<States>newNameList) {
        this.stateList = newNameList;
        notifyDataSetChanged();
    }
}
