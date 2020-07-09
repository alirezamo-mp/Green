package com.example.newgreen.StoreFm.DetailFragment.ModelAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.R;

import java.util.List;

public class RcvDetailAdapter extends RecyclerView.Adapter<RcvDetailAdapter.DetailViewHolder> {
    Context context;
    List<DetailRcvModel> models;
    public RcvDetailAdapter(Context context, List<DetailRcvModel> models){

        this.models=models;
        this.context=context;
    }
    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DetailViewHolder(LayoutInflater.from(context).inflate(R.layout.detail_rcv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {
    DetailRcvModel model=models.get(position);
    holder.txtTitle.setText(model.getTitle());
    holder.txtValue.setText(model.getValue());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle,txtValue;
        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle=itemView.findViewById(R.id.txt_detailRcv_title);
            txtValue=itemView.findViewById(R.id.txt_detailRcv_value);
        }
    }
}
