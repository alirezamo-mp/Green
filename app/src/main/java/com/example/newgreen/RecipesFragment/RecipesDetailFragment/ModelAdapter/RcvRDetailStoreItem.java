package com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.R;

import java.util.List;

public class RcvRDetailStoreItem extends RecyclerView.Adapter<RcvRDetailStoreItem.StoreItemViewHolder>{
    Context context;
    List<RDStoreItem> items;
    public RcvRDetailStoreItem (Context context,List<RDStoreItem> items){
        this.items=items;
        this.context=context;
    }

    @NonNull
    @Override
    public StoreItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StoreItemViewHolder(LayoutInflater.from(context).inflate(R.layout.rcv_rdetail_store_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StoreItemViewHolder holder, int position) {
        holder.txtTitle.setText(items.get(position).getTitle());
        if (items.get(position).getChecked().equals("1")){
            holder.checkBox.setChecked(true);
        }else {
            holder.checkBox.setChecked(false);
        }
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    items.get(position).setChecked("1");
                }else {
                    items.get(position).setChecked("0");
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class StoreItemViewHolder extends RecyclerView.ViewHolder{
        CheckBox checkBox;
        TextView txtTitle;
        public StoreItemViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox=itemView.findViewById(R.id.ch_RDetailStore_item);
            txtTitle=itemView.findViewById(R.id.txt_RDetail_title);
        }
    }


    public AddRecipesStoreModel getStoreModel(){
        AddRecipesStoreModel addRecipesStoreModel=new AddRecipesStoreModel();
        addRecipesStoreModel.setItems(items);
        addRecipesStoreModel.setSize(items.size()+"");
        addRecipesStoreModel.setIde("#404");
        return addRecipesStoreModel;
    }
}
