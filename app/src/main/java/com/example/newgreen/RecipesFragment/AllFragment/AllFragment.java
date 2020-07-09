package com.example.newgreen.RecipesFragment.AllFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.R;
import com.example.newgreen.RecipesFragment.ModelAdapter.RModel;
import com.example.newgreen.RecipesFragment.ModelAdapter.RcvRAdapter;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AllFragment extends Fragment {
    View view;
    AllViewModel allViewModel;
    RecyclerView rcv;
    CompositeDisposable compositeDisposable;
    OnItemClickAll onItemClickall;
    FrameLayout fmProgress;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=LayoutInflater.from(getContext()).inflate(R.layout.all_fragment,container,false);
        SetUpViews();
        getList();
        return view;
    }

    private void getList() {
        allViewModel.getRecipesList().subscribeOn(Schedulers.newThread())
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
                            public void OnClick(String id, String name) {
                                onItemClickall.OnClick(id,name);
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
        fmProgress=view.findViewById(R.id.fm_allFm_progress);
        compositeDisposable=new CompositeDisposable();
        rcv=view.findViewById(R.id.rcv_allFm_list);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        allViewModel=new AllViewModel();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }

    public void setOnItemClick(OnItemClickAll onItemClickall) {
        this.onItemClickall = onItemClickall;
    }

    public interface OnItemClickAll{
        void OnClick(String id,String name);
    }
}
