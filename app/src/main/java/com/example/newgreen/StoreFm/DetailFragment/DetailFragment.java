package com.example.newgreen.StoreFm.DetailFragment;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.R;
import com.example.newgreen.StoreFm.DetailFragment.ModelAdapter.DetailModel;
import com.example.newgreen.StoreFm.DetailFragment.ModelAdapter.RcvDetailAdapter;
import com.example.newgreen.StoreFm.DetailFragment.ModelAdapter.RcvDetailShowAdapter;
import com.squareup.picasso.Picasso;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailFragment extends Fragment {
    DetailViewModel detailViewModel;
    TextView txtDesc, txtOrigin, txtStorage, txtPre, txtTitle, txtShowTL, txtShowGh, txtShowMS;
    ScrollView scrollView;
    View view;
    String id, name;
    ImageView imgBack, imgShow,imgTitle;
    OnBackClick onBackClick;
    RcvDetailAdapter adapter;
    RecyclerView rcv, rcvShow;
    CardView cardShow;
    Button btnAdd;
    int startHeight, check = 1;
    Handler handler;
    CompositeDisposable compositeDisposable;
    String img;
    String pre = "2";
    String namesh = "heads";
    String ghe = "2";
    String position = "2";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.detail_fragment, container, false);

        SetUpViews();
        getInformationList();

        MyOnClick();


        return view;
    }

    private void getInformationList() {
        detailViewModel.getInformationList(id)
                .subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new SingleObserver<DetailModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(DetailModel detailModel) {
                        setModels(detailModel);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("LOG", "onError: " + e);
                    }
                });

    }

    private void setModels(DetailModel model) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Picasso.get().load(img).into(imgTitle);
                txtTitle.setText(name);
                txtShowGh.setText(""+model.getDetailGhiList().get(2));
                txtShowMS.setText("heads");
                txtShowTL.setText(name);
                txtStorage.setText(model.getStorage());
                txtPre.setText(model.getPre());
                txtDesc.setText(model.getDesc());
                txtOrigin.setText(model.getOrigin());
                adapter = new RcvDetailAdapter(getContext(), model.getDetailRcvModel());
                rcv.setAdapter(adapter);
                RcvDetailShowAdapter showAdapter = new RcvDetailShowAdapter(getContext(), model.getDetailGhiList());
                showAdapter.setOnShowItemClick(new RcvDetailShowAdapter.OnShowItemClick() {
                    @Override
                    public void onClick(String id, String gh, String value) {
                        pre = id;
                        namesh = value;
                        ghe = gh;
                    }
                });
                rcvShow.setAdapter(showAdapter);

            }
        });

    }

    private void MyOnClick() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackClick.OnClick();
            }
        });

        imgShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeShow();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnAdd.getText().equals("Select")) {
                    ChangeShow();
                    txtShowMS.setText(namesh);
                    txtShowGh.setText("£" + ghe);
                    position = pre;
                } else {
                    Toast.makeText(getContext(), "Added to cart", Toast.LENGTH_SHORT).show();
                    detailViewModel.addBasket(detailViewModel.getUserIde(), id, position)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new SingleObserver<String>() {
                                @Override
                                public void onSubscribe(Disposable d) {
                                    compositeDisposable.add(d);
                                }

                                @Override
                                public void onSuccess(String s) {

                                }

                                @Override
                                public void onError(Throwable e) {
                                    Log.i("LOG", "onError: " + e);
                                }
                            });
                }
            }
        });


    }

    private void ChangeShow() {

        if (check == 1) {
            check = 2;
            rcvShow.setVisibility(View.VISIBLE);
            startHeight = cardShow.getHeight();
            int widthSpec = View.MeasureSpec.makeMeasureSpec(cardShow.getWidth(), View.MeasureSpec.EXACTLY);
            int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            cardShow.measure(widthSpec, heightSpec);
            int targetHeight = cardShow.getMeasuredHeight();
            final int heightSpan = targetHeight - startHeight;
            cardShow.getLayoutParams().height = startHeight;
            cardShow.setLayoutParams(cardShow.getLayoutParams());
            Animation animation = new Animation() {
                @Override
                protected void applyTransformation(float interpolatedTime, Transformation t) {
                    cardShow.getLayoutParams().height = (int) (startHeight + +heightSpan * interpolatedTime);
                    cardShow.setLayoutParams(cardShow.getLayoutParams());
                }
            };
            animation.setDuration(300);

            cardShow.startAnimation(animation);
            scrollView.setScrollY(245);
            btnAdd.setText("Select");
            imgShow.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_icon_chevron_top));
            txtShowMS.setVisibility(View.GONE);
            txtShowGh.setVisibility(View.GONE);

        } else {
            check = 1;
            startHeight = cardShow.getHeight();
            rcvShow.setVisibility(View.GONE);
            int widthSpec = View.MeasureSpec.makeMeasureSpec(cardShow.getWidth(), View.MeasureSpec.EXACTLY);
            int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            cardShow.measure(widthSpec, heightSpec);
            int targetHeight = cardShow.getMeasuredHeight();
            final int heightSpan = targetHeight - startHeight;
            cardShow.getLayoutParams().height = startHeight;
            cardShow.setLayoutParams(cardShow.getLayoutParams());
            Animation animation = new Animation() {
                @Override
                protected void applyTransformation(float interpolatedTime, Transformation t) {
                    cardShow.getLayoutParams().height = (int) (startHeight + heightSpan * interpolatedTime);
                    cardShow.setLayoutParams(cardShow.getLayoutParams());
                }
            };
            animation.setDuration(300);
            cardShow.startAnimation(animation);

            imgShow.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_icon_chevron));

            btnAdd.setText("ADD TO CART");
            txtShowMS.setVisibility(View.VISIBLE);
            txtShowGh.setVisibility(View.VISIBLE);
        }


    }

    private void SetUpViews() {
        compositeDisposable = new CompositeDisposable();
        handler = new Handler();
        detailViewModel = new DetailViewModel(getContext());
        btnAdd = view.findViewById(R.id.btn_detail_add);
        scrollView = view.findViewById(R.id.scrollView_detailFM);
        rcvShow = view.findViewById(R.id.rcv_detailFm_show);
        rcvShow.setLayoutManager(new LinearLayoutManager(getContext()));
        imgTitle=view.findViewById(R.id.img_detail_imageTitle);
        txtShowTL = view.findViewById(R.id.txt_detailFM_showTL);
        txtShowGh = view.findViewById(R.id.txt_detailFm_showGh);
        txtShowMS = view.findViewById(R.id.txt_detailFm_showMS);
        cardShow = view.findViewById(R.id.card_detailFM_show);
        imgShow = view.findViewById(R.id.img_detailFM_show);
        imgBack = view.findViewById(R.id.img_detailFm_back);
        txtTitle = view.findViewById(R.id.txt_detail_title);
        txtDesc = view.findViewById(R.id.txt_detail_description);
        txtOrigin = view.findViewById(R.id.txt_detail_origin);
        txtPre = view.findViewById(R.id.txt_detail_usage);
        txtStorage = view.findViewById(R.id.txt_detail_storage);
        rcv = view.findViewById(R.id.rcv_detailFm_list);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));


    }

    public void setId(String id, String name,String img) {
        this.id = id;
        this.name = name;
        this.img=img;

    }


    public void setOnBackClick(OnBackClick onBackClick) {
        this.onBackClick = onBackClick;
    }

    public interface OnBackClick {
        void OnClick();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
