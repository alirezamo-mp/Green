package com.example.newgreen.BasketFragments.LocationFragment.ModelAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.R;

import java.util.List;

public class RcvCityAdapter extends RecyclerView.Adapter<RcvCityAdapter.CityViewHolder> {
    List<CityModel> models;
    Context context;
    onCityClick onCityClick;
    public RcvCityAdapter(Context context, List<CityModel> models,onCityClick onCityClick){
        this.context=context;
        this.onCityClick=onCityClick;
        this.models=models;
    }
    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CityViewHolder(LayoutInflater.from(context).inflate(R.layout.rcv_location_city_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        holder.textView.setText((position+1)+" "+models.get(position).getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCityClick.onClick(models.get(position).getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class CityViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.txt_cityItem_location);
        }
    }
    public interface onCityClick{
        void onClick(String name);

    }
}
