package com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.R;

import java.util.List;

public class RcvVDetailInAdapter extends RecyclerView.Adapter<RcvVDetailInAdapter.ItemsViewHolder> {
    Context context;
    List<RDItems> items;
    public RcvVDetailInAdapter (Context context, List<RDItems> items){
        this.items=items;
        this.context=context;
    }

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemsViewHolder(LayoutInflater.from(context).inflate(R.layout.rcv_rdetail_information_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {
        holder.txtValue.setText(items.get(position).getValue());
        holder.txtTitle.setText(items.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle,txtValue;
        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle=itemView.findViewById(R.id.txt_VDItem_title);
            txtValue=itemView.findViewById(R.id.txt_VDItem_value);
        }
    }

}
