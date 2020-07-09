package com.example.newgreen.SettingActivities.OrderActivity.ModelAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.R;

import java.util.List;

public class RcvOrderAdapter extends RecyclerView.Adapter<RcvOrderAdapter.OrderViewHolder> {
    List<OrderList> lists;
    Context context;
    int startHeight;

    public RcvOrderAdapter(Context context, List<OrderList> lists) {
        this.lists = lists;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderViewHolder(LayoutInflater.from(context).inflate(R.layout.rcv_order_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        holder.txtNumber.setText("#" + lists.get(position).getId() + "497");
        holder.rcv.setLayoutManager(new LinearLayoutManager(context));
        holder.rcv.setAdapter(new RcvOrderItemAdapter(context, lists.get(position).getItemList().getOrderItem()));
        holder.txtPrice.setText("£"+lists.get(position).getItemList().getPrice());
        if(lists.get(position).getItemList().getPprice().equals("ok")){
            holder.txtPprice.setText("£"+"4.99");
        }else {
            holder.txtPprice.setText("(free)");
        }

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.rcv.getVisibility()!=View.VISIBLE){
                    holder.img.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_icon_top_smal));
                    holder.rcv.setVisibility(View.VISIBLE);
                    holder.txtPrice.setVisibility(View.VISIBLE);
                    holder.txtSub.setVisibility(View.VISIBLE);
                    holder.txtPprice.setVisibility(View.VISIBLE);
                    holder.txtTotal.setVisibility(View.VISIBLE);
                    holder.txtShip.setVisibility(View.VISIBLE);
                    holder.imgShip.setVisibility(View.VISIBLE);


                    startHeight = holder.card.getHeight();
                    int widthSpec = View.MeasureSpec.makeMeasureSpec(holder.card.getWidth(), View.MeasureSpec.EXACTLY);
                    int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    holder.card.measure(widthSpec, heightSpec);
                    int targetHeight = holder.card.getMeasuredHeight();
                    final int heightSpan = targetHeight - startHeight;
                    holder.card.getLayoutParams().height = startHeight;
                    holder.card.setLayoutParams(holder.card.getLayoutParams());
                    Animation animation = new Animation() {
                        @Override
                        protected void applyTransformation(float interpolatedTime, Transformation t) {
                            holder.card.getLayoutParams().height = (int) (startHeight+ + heightSpan * interpolatedTime);
                            holder.card.setLayoutParams(holder.card.getLayoutParams());
                        }
                    };
                    animation.setDuration(300);

                    holder.card.startAnimation(animation);

                }else {
                    holder.img.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_icon_botom_smal));
                    holder.rcv.setVisibility(View.GONE);
                    holder.txtPrice.setVisibility(View.GONE);
                    holder.txtSub.setVisibility(View.GONE);
                    holder.txtPprice.setVisibility(View.GONE);
                    holder.txtShip.setVisibility(View.GONE);
                    holder.txtTotal.setVisibility(View.GONE);
                    holder.imgShip.setVisibility(View.GONE);

                    startHeight = holder.card.getHeight();
                    int widthSpec = View.MeasureSpec.makeMeasureSpec(holder.card.getWidth(), View.MeasureSpec.EXACTLY);
                    int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    holder.card.measure(widthSpec, heightSpec);
                    int targetHeight = holder.card.getMeasuredHeight();
                    final int heightSpan = targetHeight - startHeight;
                    holder.card.getLayoutParams().height = startHeight;
                    holder.card.setLayoutParams(holder.card.getLayoutParams());
                    Animation animation = new Animation() {
                        @Override
                        protected void applyTransformation(float interpolatedTime, Transformation t) {
                            holder.card.getLayoutParams().height = (int) (startHeight + heightSpan * interpolatedTime);
                            holder.card.setLayoutParams(holder.card.getLayoutParams());
                        }
                    };
                    animation.setDuration(300);
                    holder.card.startAnimation(animation);



                }
            }
        });



    }



    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        ImageView img,imgShip;
        TextView txtNumber,txtShip, txtTotal, txtPrice, txtPprice, txtSub;
        CardView card;
        RecyclerView rcv;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_rcvOrderITem_show);
            imgShip=itemView.findViewById(R.id.img_OrderItem_img);
            txtPprice = itemView.findViewById(R.id.txt_OrderItem_subGh);
            txtShip = itemView.findViewById(R.id.txt_ship);
            txtSub = itemView.findViewById(R.id.txt_OrderItem_subTotal);
            txtTotal = itemView.findViewById(R.id.xt_OrderITem_total);
            txtPrice = itemView.findViewById(R.id.txt_OrderItem_gh);
            rcv = itemView.findViewById(R.id.rcv_OrderItemList_show);
            txtNumber = itemView.findViewById(R.id.txt_orderItemList_number);
            card=itemView.findViewById(R.id.card_OrderItem_card);
        }
    }
}
