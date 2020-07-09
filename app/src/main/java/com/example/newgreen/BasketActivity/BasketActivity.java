package com.example.newgreen.BasketActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.newgreen.BasketFragments.CarFragment.CarFragment;
import com.example.newgreen.BasketFragments.CardFragment.CardFragment;
import com.example.newgreen.BasketFragments.LocationFragment.LocationFragment;
import com.example.newgreen.BasketFragments.MoreFragment.MoreFragment;
import com.example.newgreen.R;

public class BasketActivity extends AppCompatActivity {
    CardView cardView;
    FrameLayout frameLayout;
    CardFragment cardFragment;
    CarFragment carFragment;
    LocationFragment locationFragment;
    MoreFragment moreFragment;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    RelativeLayout relCard, relCar, relLocation, relMore;
    ImageView imgCar, imgCard, imgMore, imgLocation, imgBack;
    int opp = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        SetUpViews();
        onLocationFragment();


    }

    private void onLocationFragment() {
        fragmentTransaction.replace(R.id.fm_basket_view, locationFragment).commit();
        locationFragment.setOnBtnClick(new LocationFragment.OnBtnClick() {
            @Override
            public void OnClick(BasketItem basketItem) {

                carFragment = new CarFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("item", basketItem);
                carFragment.setArguments(bundle);
                relCar.setVisibility(View.VISIBLE);
                relLocation.setVisibility(View.GONE);
                imgLocation.setVisibility(View.VISIBLE);
                imgCar.setVisibility(View.GONE);

                carFragment.setOnCarClick(new CarFragment.onCarClick() {
                    @Override
                    public void OnClick(BasketItem basketItem1) {

                        cardFragment = new CardFragment();
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("item", basketItem1);
                        cardFragment.setArguments(bundle);
                        relCar.setVisibility(View.GONE);
                        imgCar.setVisibility(View.VISIBLE);
                        imgCar.setImageDrawable(ContextCompat.getDrawable(BasketActivity.this, R.drawable.ic_icon_car_green));
                        imgCard.setVisibility(View.GONE);
                        relCard.setVisibility(View.VISIBLE);
                        cardFragment.setOnCardClick(new CardFragment.OnCardClick() {
                            @Override
                            public void OnClick(BasketItem basketItem2) {

                                moreFragment = new MoreFragment();
                                moreFragment.setOnBtnClick(new MoreFragment.onBtnClick() {
                                    @Override
                                    public void click() {
                                        removeAllFragments(fragmentManager);
                                        opp = 0;
                                        onBackPressed();
                                        Toast.makeText(BasketActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("item", basketItem2);
                                moreFragment.setArguments(bundle);
                                relCard.setVisibility(View.GONE);
                                relMore.setVisibility(View.VISIBLE);
                                imgCard.setVisibility(View.VISIBLE);
                                imgCard.setImageDrawable(ContextCompat.getDrawable(BasketActivity.this, R.drawable.ic_icon_card_green));
                                imgMore.setVisibility(View.GONE);


                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.fm_basket_view, moreFragment);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                                opp = opp + 1;


                            }
                        });

                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fm_basket_view, cardFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        opp = opp + 1;

                    }
                });


                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fm_basket_view, carFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                opp = opp + 1;


            }
        });
    }

    private void SetUpViews() {

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        frameLayout = findViewById(R.id.fm_basket_view);
        locationFragment = new LocationFragment();
        cardView = findViewById(R.id.card_basket_title);
        cardView.setBackgroundResource(R.drawable.card_radius_style);

        imgLocation = findViewById(R.id.img_basket_locationStep);
        imgCard = findViewById(R.id.img_basket_cardStep);
        imgMore = findViewById(R.id.img_basket_moreStep);
        imgCar = findViewById(R.id.img_basket_carStep);

        relLocation = findViewById(R.id.rel_basket_location);
        relCard = findViewById(R.id.rel_basket_card);
        relMore = findViewById(R.id.rel_basket_more);
        relCar = findViewById(R.id.rel_basket_car);

        imgBack = findViewById(R.id.img_basket_imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }

        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        opp = opp - 1;
        switch (opp) {
            case 1:
                relCar.setVisibility(View.GONE);
                relLocation.setVisibility(View.VISIBLE);
                imgCar.setVisibility(View.VISIBLE);
                imgCar.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_icon_car_gray));
                imgLocation.setVisibility(View.GONE);
                break;
            case 2:
                relCard.setVisibility(View.GONE);
                relCar.setVisibility(View.VISIBLE);
                imgCard.setVisibility(View.VISIBLE);
                imgCard.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_icon_card_gray));
                imgCar.setVisibility(View.GONE);
                break;
            case 3:
                relMore.setVisibility(View.GONE);
                relCard.setVisibility(View.VISIBLE);
                imgMore.setVisibility(View.VISIBLE);
                imgMore.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_icon_more_gray));
                imgCard.setVisibility(View.GONE);
                break;

        }
    }


    private void removeAllFragments(FragmentManager fragmentManager) {
        while (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStackImmediate();
        }
    }


}