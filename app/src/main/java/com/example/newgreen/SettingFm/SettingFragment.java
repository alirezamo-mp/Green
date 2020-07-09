package com.example.newgreen.SettingFm;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.R;
import com.example.newgreen.SettingActivities.AccountActivity.AccountActivity;
import com.example.newgreen.SettingActivities.OrderActivity.OrderActivity;

public class SettingFragment extends Fragment {
    View view;
    CardView cardView;
    RelativeLayout relAccount,relOrder;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=LayoutInflater.from(getContext()).inflate(R.layout.setting_fragment,container,false);

        SetUpViews();
        MyOnClick();

        return view;
    }

    private void MyOnClick() {
        relAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getContext(), AccountActivity.class));
            }
        });

        relOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getContext(), OrderActivity.class));
            }
        });

    }

    private void SetUpViews() {
        cardView=view.findViewById(R.id.card_settingFM_title);
        cardView.setBackgroundResource(R.drawable.card_radius_style);
        relAccount=view.findViewById(R.id.rel_settingFM_account);
        relOrder=view.findViewById(R.id.rel_settingFM_orders);

    }
}
