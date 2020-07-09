package com.example.newgreen.BasketFragments.CardFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.AddCardActivity.AddCardActivity;
import com.example.newgreen.BasketActivity.BasketItem;
import com.example.newgreen.BasketFragments.CardFragment.ModelAdapter.CardModelItem;
import com.example.newgreen.BasketFragments.CardFragment.ModelAdapter.rcvCardAdapter;
import com.example.newgreen.R;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CardFragment extends Fragment {
    CardViewModel cardViewModel;
    View view;
    OnCardClick onCardClick;
    RecyclerView rcvCard;
    BasketItem basketItem;
    CompositeDisposable compositeDisposable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=LayoutInflater.from(getContext()).inflate(R.layout.card_fragment,container,false);
        basketItem=getArguments().getParcelable("item");
        SetUpViews();
        basketItem.setIde(cardViewModel.getIde());
        getList();
        return view;
    }

    private void getList() {
        cardViewModel.getCards(cardViewModel.getIde())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<CardModelItem>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<CardModelItem> cardModelItems) {
                        rcvCard.setAdapter(new rcvCardAdapter(getContext(), cardModelItems, new rcvCardAdapter.onNewClick() {
                            @Override
                            public void OnClick() {
                                getActivity().startActivity(new Intent(getContext(), AddCardActivity.class));
                            }

                            @Override
                            public void OnOk(String id) {
                                basketItem.setCardId(id);
                                onCardClick.OnClick(basketItem);
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
        compositeDisposable=new CompositeDisposable();
        cardViewModel=new CardViewModel(getContext());
        rcvCard=view.findViewById(R.id.rcv_CardFm_addCard);
        rcvCard.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

    }

    public void setOnCardClick(OnCardClick onCardClick) {
        this.onCardClick = onCardClick;
    }

    public interface OnCardClick{
        void OnClick(BasketItem basketItem);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
