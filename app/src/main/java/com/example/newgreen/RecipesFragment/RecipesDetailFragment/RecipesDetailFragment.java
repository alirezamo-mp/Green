package com.example.newgreen.RecipesFragment.RecipesDetailFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.R;
import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.AddRecipesStoreModel;
import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.RcvRDetailStoreItem;
import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.RcvVDetailInAdapter;
import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.RDModel;
import com.squareup.picasso.Picasso;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RecipesDetailFragment extends Fragment {
    ConstraintLayout con;
    FrameLayout fmProgress;
    ImageView img, imgBack, imgShare;
    RDetailViewModel rDViewModel;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    RecyclerView rcvStore, rcvInformation;
    Button btnAdd;
    TextView txtType, txtTime, txtDate, txtInformation, txtTitle;
    View view;
    OnClickBtn onClickBtn;
    RcvRDetailStoreItem rcvRDetailStoreItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.vegan_detail_fragment, container, false);


        SetUpViews();
        getList();
        OnCkicked();

        return view;
    }

    private void OnCkicked() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBtn.OnBackClick();
            }
        });

        imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Green");
                    String shareMessage = "\nHello you can see the " + getArguments().getString("name") + " recipe and thousands of other" +
                            " delicious recipes in the quick green app\n\n";
                    shareMessage = shareMessage + "Download for Android :\n\n" + "http://www.digimoplus.ir" + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch (Exception e) {
                    //e.toString();
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean a = false;
                AddRecipesStoreModel storeModel = rcvRDetailStoreItem.getStoreModel();
                for (int i = 0; i < storeModel.getItems().size(); i++) {
                    if (storeModel.getItems().get(i).getChecked().equals("1")) {
                        a = true;
                    }
                }
                if (a != true) {
                    Toast.makeText(getContext(), "alll pro", Toast.LENGTH_SHORT).show();
                } else {
                    AddInStore(storeModel);
                }

            }
        });

    }

    private void AddInStore(AddRecipesStoreModel storeModel) {
        storeModel.setIde(rDViewModel.getIde());
        rDViewModel.addRecipesStore(storeModel).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(String s) {
                        //Toast.makeText(getContext(), ""+s, Toast.LENGTH_SHORT).show();
                        //Log.i("LOG", "onSuccess: "+s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        //Log.i("LOG", "onError: " + e);
                    }
                });
        Toast.makeText(getContext(), "Added to cart", Toast.LENGTH_SHORT).show();
        onClickBtn.OnBackClick();
    }

    private void getList() {
        rDViewModel.getVDModel(getArguments().getString("id"))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<RDModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(RDModel RDModel) {
                        Picasso.get().load(RDModel.getImg()).into(img);
                        txtInformation.setText(RDModel.getDescription());
                        txtTime.setText(RDModel.getTime());
                        txtDate.setText(RDModel.getDate());
                        txtType.setText(RDModel.getType());
                        rcvInformation.setAdapter(new RcvVDetailInAdapter(getContext(), RDModel.getRDItems()));
                        rcvRDetailStoreItem = new RcvRDetailStoreItem(getContext(), RDModel.getRDStoreItems());
                        rcvStore.setAdapter(rcvRDetailStoreItem);

                        fmProgress.setVisibility(View.GONE);
                        con.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("LOG", "onError: " + e);
                    }
                });
    }

    private void SetUpViews() {
        fmProgress = view.findViewById(R.id.fm_RDetailFm_progress);
        con = view.findViewById(R.id.con_RDetail_con);
        rDViewModel = new RDetailViewModel(getContext());
        compositeDisposable = new CompositeDisposable();
        txtDate = view.findViewById(R.id.txt_VDetail_date);
        txtTime = view.findViewById(R.id.txt_VDetail_time);
        txtType = view.findViewById(R.id.txt_VDetail_type);
        txtInformation = view.findViewById(R.id.txt_VDetail_dec);
        txtTitle = view.findViewById(R.id.txt_VDetail_title);
        txtTitle.setText(getArguments().getString("name"));
        rcvInformation = view.findViewById(R.id.rcv_VDetail_information);
        rcvStore = view.findViewById(R.id.rcv_VDetail_store);
        rcvInformation.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvStore.setLayoutManager(new LinearLayoutManager(getContext()));
        btnAdd = view.findViewById(R.id.btn_VDetail_add);
        img = view.findViewById(R.id.img_VDetail_image);
        imgBack = view.findViewById(R.id.img_VDetail_back);
        imgShare = view.findViewById(R.id.img_DetailR_share);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }

    public void setOnClickBtn(OnClickBtn onClickBtn) {
        this.onClickBtn = onClickBtn;
    }

    public interface OnClickBtn {
        void OnBackClick();
    }
}
