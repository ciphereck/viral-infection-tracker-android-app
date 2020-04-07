package com.ciphereck.viralinfectiontracker.reports;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ciphereck.viralinfectiontracker.R;

import java.util.Collections;
import java.util.List;

public class CountryStatisticAdapter extends RecyclerView.Adapter<CountryStatisticAdapter.ViewHolder> {

    private List<CountryStatistics> listItems;
    private Context context;

    public CountryStatisticAdapter(List<CountryStatistics> listItems, Context context) {
        this.listItems = Collections.synchronizedList(listItems);
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.country_statistic_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CountryStatisticAdapter.ViewHolder holder, int position) {
        final CountryStatistics listItem = (CountryStatistics) listItems.get(position);
        holder.countryName.setText(listItem.getCountryName() + " " + listItem.getTotalCases());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView countryName;

        public ViewHolder(View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.text);
        }
    }
}