package com.example.newgreen.BasketFragments.CardFragment.ModelAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.AddCardActivity.AddCardActivity;
import com.example.newgreen.R;

import java.util.List;

public class rcvCardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<CardModelItem> models;
    onNewClick onNewClick;
    public rcvCardAdapter (Context context,List<CardModelItem> models,onNewClick onNewClick){
        this.models=models;
        this.onNewClick=onNewClick;
        this.context=context;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==0){
            return new newViewHolder(LayoutInflater.from(context).inflate(R.layout.rcv_addcard_item_one,parent,false));
        }else {
            return new CardViewHolder(LayoutInflater.from(context).inflate(R.layout.rcv_addcard_item_two,parent,false));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position==0){
            ((newViewHolder)holder).relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   onNewClick.OnClick();
                }
            });
        }else {
            ((CardViewHolder)holder).txtName.setText(models.get(position-1).getName());
            ((CardViewHolder)holder).rel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNewClick.OnOk(models.get(position-1).getId());
                }
            });
            ((CardViewHolder)holder).txtDate.setText(models.get(position-1).getDate());
           ((CardViewHolder)holder).txtNumber.setText(models.get(position-1).getNum());
        }
    }

    @Override
    public int getItemCount() {
        return models.size()+1;
    }


    public class CardViewHolder extends RecyclerView.ViewHolder{
        TextView txtName,txtNumber,txtDate;
        RelativeLayout rel;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            rel=itemView.findViewById(R.id.rel_CardItem_two);
            txtName=itemView.findViewById(R.id.txt_cardItem_nameus);
            txtNumber=itemView.findViewById(R.id.txt_cardITem_number);
            txtDate=itemView.findViewById(R.id.txt_cardItem_date);
        }
    }

    public  class newViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout relativeLayout;
        public newViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout=itemView.findViewById(R.id.rel_addCardItem_one);
        }
    }

    public interface onNewClick{
        void OnClick();
        void OnOk(String id);
    }
}
