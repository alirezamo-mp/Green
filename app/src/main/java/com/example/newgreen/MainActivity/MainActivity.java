package com.example.newgreen.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.newgreen.CartFm.CartFragment;
import com.example.newgreen.RecipesFragment.RecipesFragment.RecipesFragment;
import com.example.newgreen.SettingFm.SettingFragment;
import com.example.newgreen.StoreFm.StoreFragment.StoreFragment;
import com.example.newgreen.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ImageView viewGray, viewGreen;
    ViewPagerAdapter adapter;
    List<Fragment> fragments;
    ViewPager viewPager;
    MainViewModel mainViewModel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetUpViews();
        setViewPager();
        SetTablayout();
    }


    private void setViewPager() {
        RecipesFragment recipesFragment = new RecipesFragment();
        fragments.add(new StoreFragment());
        fragments.add(recipesFragment);
        fragments.add(new SettingFragment());
        fragments.add(new CartFragment());
        fragments.add(new SettingFragment());
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
    }

    private void SetTablayout() {
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < 5; i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            switch (i) {
                case 0:
                    tab.setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_icon_store_green));

                    break;
                case 1:
                    tab.setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_icon_recipes));
                    break;
                case 2:
                    tab.setCustomView(viewGray);
                    break;
                case 3:

                    tab.setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_icon_cart));
                    break;
                case 4:
                    tab.setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_icon_settings));
                    break;


            }

        }



        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                switch (tab.getPosition()) {
                    case 0:
                        tab.setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_icon_store_green));

                        break;
                    case 1:
                        tab.setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_icon_recipes_green));
                        break;
                    case 2:
                        tab.setCustomView(viewGreen);
                        break;
                    case 3:

                        tab.setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_icon_cart_green));
                        break;
                    case 4:
                        tab.setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_icon_settings_green));
                        break;


                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                switch (tab.getPosition()) {
                    case 0:
                        tab.setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_icon_store));
                        break;
                    case 1:
                        tab.setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_icon_recipes));
                        break;
                    case 2:
                        tab.setCustomView(viewGray);

                        break;
                    case 3:

                        tab.setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_icon_cart));
                        break;
                    case 4:
                        tab.setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_icon_settings));
                        break;


                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void SetUpViews() {
        fragments = new ArrayList<>();
        mainViewModel = new MainViewModel(this);
        viewPager = findViewById(R.id.view_pager);
        viewGray = new ImageView(this);
        viewGreen = new ImageView(this);
        viewGray.setImageResource(R.drawable.tab_gray_style);
        viewGreen.setImageResource(R.drawable.tab_green_style);
    }


}
