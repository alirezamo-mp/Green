package com.example.newgreen.StoreFm.StoreFragment.ModelAdapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RcvStoreAdapter extends RecyclerView.Adapter<RcvStoreAdapter.StoreViewHolder> {
    Context context;
    List<ProductsStoreModel> models;
    OnClickItem onClickItem;
    public RcvStoreAdapter(Context context, List<ProductsStoreModel> models, OnClickItem onClickItem){
        this.models=models;
        this.context=context;
        this.onClickItem=onClickItem;
    }
    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StoreViewHolder(LayoutInflater.from(context).inflate(R.layout.store_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder holder, int position) {
        ProductsStoreModel model=models.get(position);
        holder.title.setText(model.getTitle());


        Picasso.get().load(model.getImg()).into(holder.img);
        holder.card.setCardBackgroundColor(Color.parseColor(model.getColor()));
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem.OnClick(model.getTitle(),model.getId(),model.getImg());
        }
        });


    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class StoreViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView img;
        CardView card;
        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);
            img =itemView.findViewById(R.id.img_storeItem_image);
            title =itemView.findViewById(R.id.txt_storeItem_title);
            card=itemView.findViewById(R.id.card_storeItem_color);
        }
    }
    public interface OnClickItem {
        void OnClick(String id,String name,String img);
    }
}
