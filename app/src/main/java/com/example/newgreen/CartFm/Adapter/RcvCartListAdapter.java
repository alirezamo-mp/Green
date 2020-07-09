package com.example.newgreen.CartFm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RcvCartListAdapter extends RecyclerView.Adapter<RcvCartListAdapter.ListViewHolder> {
    Context context;
    List<CartItemList> itemLists;
    onItemClick onItemClick;
    boolean setting;


    public RcvCartListAdapter(Context context, List<CartItemList> itemLists,boolean setting) {
        this.itemLists = itemLists;
        this.context = context;
        this.setting=setting;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(context).inflate(R.layout.rcv_cart_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.txtName.setText(itemLists.get(position).getName());
        holder.txtName.setVisibility(View.VISIBLE);
        holder.txtGh.setText("£" + itemLists.get(position).getPrice());
        holder.txtGh.setVisibility(View.VISIBLE);
        holder.txtValue.setText(itemLists.get(position).getValue());
        holder.txtValue.setVisibility(View.VISIBLE);
        Picasso.get().load(itemLists.get(position).getImg()).into(holder.img);

        if (setting){

        holder.relItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (holder.relDelete.getVisibility()==View.VISIBLE){
                    holder.txtValue.setVisibility(View.VISIBLE);
                    holder.txtGh.setVisibility(View.VISIBLE);
                    holder.relEdit.setVisibility(View.GONE);
                    holder.relDelete.setVisibility(View.GONE);
                }else {
                    holder.txtValue.setVisibility(View.GONE);
                    holder.txtGh.setVisibility(View.GONE);
                    holder.relEdit.setVisibility(View.VISIBLE);
                    holder.relDelete.setVisibility(View.VISIBLE);
                }

                return true;
            }

        });

        holder.relItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.relDelete.getVisibility()==View.VISIBLE){
                    holder.txtValue.setVisibility(View.VISIBLE);
                    holder.txtGh.setVisibility(View.VISIBLE);
                    holder.relEdit.setVisibility(View.GONE);
                    holder.relDelete.setVisibility(View.GONE);
                }
            }
        });

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onDelete(itemLists.get(position).getId(),itemLists.get(position).getIde());
                itemLists.remove(itemLists.get(position));
                notifyDataSetChanged();
                holder.relDelete.setVisibility(View.GONE);
                holder.relEdit.setVisibility(View.GONE);
            }
        });

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "edit", Toast.LENGTH_SHORT).show();
            }
        });

        }

    }

    @Override
    public int getItemCount() {
        return itemLists.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView txtGh, txtName, txtValue;
        ImageView img,imgEdit,imgDelete;
        RelativeLayout relDelete,relEdit, relItem;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtGh = itemView.findViewById(R.id.txt_cartItem_Gh);
            txtName = itemView.findViewById(R.id.txt_cardItem_name);
            txtValue = itemView.findViewById(R.id.txt_cartItem_value);
            img = itemView.findViewById(R.id.img_cardItem_image);
            imgDelete=itemView.findViewById(R.id.img_cartItem_delete);
            imgEdit=itemView.findViewById(R.id.img_cartITem_edit);
            relDelete=itemView.findViewById(R.id.rel_cartItem_delete);
            relEdit=itemView.findViewById(R.id.rel_cartItem_edit);
            relItem =itemView.findViewById(R.id.rel_cartItem_item);
        }
    }

    public void setOnItemClick(RcvCartListAdapter.onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public  interface onItemClick{
        void onDelete(String id,String ide);
        void onEdit();
    }

}
