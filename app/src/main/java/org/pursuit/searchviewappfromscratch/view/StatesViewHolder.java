package org.pursuit.searchviewappfromscratch.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.searchviewappfromscratch.R;
import org.pursuit.searchviewappfromscratch.model.States;
import org.pursuit.searchviewappfromscratch.model.StatesWrapper;

public class StatesViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewRVname;
    private TextView textViewRVcapital;
    private TextView textViewRVlat;
    private TextView textViewRVlong;

    public StatesViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewRVname = itemView.findViewById(R.id.state_name);
        textViewRVcapital = itemView.findViewById(R.id.state_capital);
        textViewRVlat = itemView.findViewById(R.id.state_lat);
        textViewRVlong = itemView.findViewById(R.id.state_long);
    }

    public void onBind(final States states) {
        setItems(states);
    }

    private void setItems(final States states) {
        textViewRVname.setText(states.getName());
        textViewRVcapital.setText(states.getCapital());
        textViewRVlat.setText(states.getLat());
        textViewRVlong.setText(states.getLong());
    }
}
