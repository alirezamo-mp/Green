package com.example.newgreen.StoreFm.DetailFragment.ModelAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.R;

import java.util.List;

public class RcvDetailShowAdapter extends RecyclerView.Adapter<RcvDetailShowAdapter.ShowViewHolder> {
    Context context;
    OnShowItemClick onShowItemClick;
    List<String> models;

    public RcvDetailShowAdapter(Context context,List<String> models) {
        this.context = context;
        this.models=models;
    }

    @SuppressLint("Range")
    @NonNull
    @Override
    public ShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShowViewHolder(LayoutInflater.from(context).inflate(R.layout.rcv_item,parent,false));

    }



    private String[] name= new String[]{
            "grams","lbs","heads","packs"
    };

    private String[] vis= new String[]{
            "0","0","1","0"
    };

    private float[] alpha= new float[]{
            0.2f,0.2f,1f,0.2f
    };


    @Override
    public void onBindViewHolder(@NonNull ShowViewHolder holder, int position) {

        holder.txtGh.setText("£"+models.get(position));
        holder.txtMs.setAlpha(alpha[position]);
        holder.txtP.setAlpha(alpha[position]);
        holder.txtMs.setText(name[position]);
        holder.txtP.setText(position+"");
        if (vis[position].equals("1")){
            holder.txtGh.setVisibility(View.VISIBLE);
        }else {
            holder.txtGh.setVisibility(View.GONE);
        }

        holder.rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha[position]=1f;
                vis[position]="1";
                for (int i = 0; i <4 ; i++) {
                    if (i!=position){
                       alpha[i]=0.2f;
                       vis[i]="0";
                    }
                }
                notifyDataSetChanged();
                onShowItemClick.onClick(position+"",models.get(position),name[position]);
            }
        });




    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class ShowViewHolder extends RecyclerView.ViewHolder {
        TextView txtP,txtGh,txtMs;
        RelativeLayout rel;
        public ShowViewHolder(@NonNull View itemView) {
            super(itemView);
            txtP=itemView.findViewById(R.id.t1);
            txtMs=itemView.findViewById(R.id.t2);
            txtGh=itemView.findViewById(R.id.t3);
            rel=itemView.findViewById(R.id.rel_detailFM_item);
        }
    }

    public void setOnShowItemClick(OnShowItemClick onShowItemClick) {
        this.onShowItemClick = onShowItemClick;
    }

    public interface OnShowItemClick{
        void onClick(String id,String gh,String value);
    }

}
