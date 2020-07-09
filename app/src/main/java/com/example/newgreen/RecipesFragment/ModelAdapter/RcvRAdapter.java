package com.example.newgreen.RecipesFragment.ModelAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RcvRAdapter extends RecyclerView.Adapter<RcvRAdapter.ItemViewHolder> {
    Context context;
    List<RModel> models;
    onItemClick onItemClick;
    public RcvRAdapter(Context context, List<RModel> models, onItemClick onItemClick){
        this.context=context;
        this.models=models;
        this.onItemClick=onItemClick;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.rcv_vegan_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.txtTitle.setText(models.get(position).getTitle());
        holder.txtDescription.setText(models.get(position).getDescription());
       Picasso.get().load(models.get(position).getImg()).into(holder.img);
        holder.rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.OnClick(models.get(position).getId(),models.get(position).getTitle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle,txtDescription;
        ImageView img;
        RelativeLayout rel;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_veganItem_image);
            txtDescription=itemView.findViewById(R.id.txt_veganITem_dec);
            txtTitle=itemView.findViewById(R.id.txt_veganItem_title);
            rel=itemView.findViewById(R.id.rel_veganItem_rel);
        }
    }

    public interface onItemClick{
        void OnClick(String id,String name);
    }
}
