package com.ciphereck.viralinfectiontracker.reports;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ciphereck.viralinfectiontracker.R;

import java.util.Collection;

public class CountryStatisticAdapter extends RecyclerView.Adapter<CountryStatisticAdapter.ViewHolder> {

    private Collection<CountryStatistics> listItems;
    private Context context;

    public CountryStatisticAdapter(Collection<CountryStatistics> listItems, Context context) {
        this.listItems = listItems;
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
        final CountryStatistics listItem = (CountryStatistics) listItems.toArray()[position];
        holder.countryName.setText(listItem.getCountryName());
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