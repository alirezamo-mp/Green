package com.example.newgreen.RecipesFragment.VeganFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.R;
import com.example.newgreen.RecipesFragment.ModelAdapter.RcvRAdapter;
import com.example.newgreen.RecipesFragment.ModelAdapter.RModel;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VeganFragment extends Fragment {
    CompositeDisposable compositeDisposable;
    FrameLayout fmProgress;
    View view;
    RecyclerView rcv;
    VeganViewModel veganViewModel;
    OnItemClicked onItemClicked;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=LayoutInflater.from(getContext()).inflate(R.layout.vegan_fragment,container,false);
        SetUpViews();
        getList();


        return view;
    }

    private void getList() {
        veganViewModel.getVeganList().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<RModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<RModel> rModels) {
                        fmProgress.setVisibility(View.GONE);
                        rcv.setVisibility(View.VISIBLE);
                        rcv.setAdapter(new RcvRAdapter(getContext(), rModels, new RcvRAdapter.onItemClick() {
                            @Override
                            public void OnClick(String id,String title) {
                                onItemClicked.OnCliched(id,title);
                            }
                        }));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("LOG", "onError: "+e);
                    }
                });


    }

    private void SetUpViews() {
        rcv=view.findViewById(R.id.rcv_veganFM_list);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        veganViewModel=new VeganViewModel();
        compositeDisposable=new CompositeDisposable();
        fmProgress=view.findViewById(R.id.fm_veganFm_progress);






    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }

    public void setOnItemClicked(OnItemClicked onItemClicked) {
        this.onItemClicked = onItemClicked;
    }

    public interface OnItemClicked{
        void OnCliched(String id,String name);
    }
}
