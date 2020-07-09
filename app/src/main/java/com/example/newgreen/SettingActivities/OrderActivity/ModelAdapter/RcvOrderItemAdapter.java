package com.example.newgreen.SettingActivities.OrderActivity.ModelAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.R;

import java.util.List;

public class RcvOrderItemAdapter extends RecyclerView.Adapter<RcvOrderItemAdapter.ItemViewHolder> {
    Context context;
    List<OrderItem> items;
    public RcvOrderItemAdapter (Context context, List<OrderItem> items){
        this.items=items;
        this.context=context;
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.rcv_order_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.txtTitle.setText(items.get(position).getName());
        holder.txtPrice.setText("£"+items.get(position).getPrice());
        holder.txtValue.setText(items.get(position).getValue());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle,txtValue,txtPrice;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPrice=itemView.findViewById(R.id.txt_rcvOrderItem_gh);
            txtTitle=itemView.findViewById(R.id.txt_rcvOrderItem_title);
            txtValue=itemView.findViewById(R.id.txt_rcvOrderITem_value);
        }
    }
}
