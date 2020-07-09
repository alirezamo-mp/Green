package com.example.newgreen.BasketFragments.CarFragment.ModelAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.R;

import java.util.List;

public class RcvTimeAdapter extends RecyclerView.Adapter<RcvTimeAdapter.TimeViewHolder> {
    Context context;
    List<TimeModel> models;
    String time;
    String[] colors;
    public RcvTimeAdapter(Context context,List<TimeModel> models){
        this.context=context;
        this.models=models;
        colors=new String[models.size()];
        for (int i = 0; i <models.size() ; i++) {
            if (i==0){
                colors[i]="1";
            }else {
                colors[i]="0";
            }
        }
    }

    @NonNull
    @Override
    public TimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TimeViewHolder(LayoutInflater.from(context).inflate(R.layout.rcv_date_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TimeViewHolder holder, int position) {
        if (colors[position].equals("1")){
            holder.txt.setTextColor(ContextCompat.getColor(context,R.color.green));
            time=models.get(position).getValue();
        }else {
            holder.txt.setTextColor(ContextCompat.getColor(context,R.color.medium_gray_dark));
        }
        holder.txt.setText(models.get(position).getValue());
        holder.txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i <models.size() ; i++) {
                    if (i==position){
                        colors[i]="1";
                    }else {
                        colors[i]="0";
                    }
                }
                time=holder.txt.getText().toString();
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class TimeViewHolder extends RecyclerView.ViewHolder{
        TextView txt;
        public TimeViewHolder(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.txt_rcvDate_item);
        }
    }

    public String getTime(){
        return time;
    }
}
