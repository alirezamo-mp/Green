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

public class RcvDateAdapter extends RecyclerView.Adapter<RcvDateAdapter.DateViewHolder> {
    Context context;
    List<DateModel> models;
    String[] colors;
    String time;
    public RcvDateAdapter(Context context, List<DateModel> models){
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
    public DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DateViewHolder(LayoutInflater.from(context).inflate(R.layout.rcv_date_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DateViewHolder holder, int position) {
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

    public class DateViewHolder extends RecyclerView.ViewHolder{
        TextView txt;
        public DateViewHolder(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.txt_rcvDate_item);
        }
    }

    public String getDate(){
        return time;
    }
}
