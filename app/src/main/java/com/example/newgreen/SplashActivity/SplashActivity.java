package com.example.newgreen.SplashActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.newgreen.LoginFragments.SignIn.SignInFragment;
import com.example.newgreen.LoginFragments.SignUpFragmnet.SignUpFragment;
import com.example.newgreen.SplashActivity.IntroLogoFragment.IntroLogoFragment;
import com.example.newgreen.R;
import com.example.newgreen.SplashActivity.IntroFragments.IntroFragment_One;
import com.example.newgreen.SplashActivity.IntroFragments.IntroFragment_Settings;
import com.example.newgreen.SplashActivity.IntroFragments.IntroFragment_Two;
import com.example.newgreen.MainActivity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    SplashViewModel splashViewModel;
    RelativeLayout rel8;
    ConstraintLayout con;
    Button btnSkip, btnGo;
    FrameLayout fmLogo, fmSign;
    int myPosition;
    ViewPager viewPager;
    LinearLayout linearLayout;
    IntroFragment_Settings introFragment_settings;
    IntroFragment_One introFragment_one;
    IntroFragment_Two introFragment_two;
    TextView[] mDouct;
    FragmentManager fragmentManager;
    boolean fa = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        rel8=findViewById(R.id.relativeLayout8);
        splashViewModel = new SplashViewModel(this);
        con = findViewById(R.id.con_splash);
        fmLogo = findViewById(R.id.fm_splashA_logo);
        fmSign = findViewById(R.id.fm_splash_sign);
        setSplash();


    }

    private void setSplash() {
        IntroLogoFragment introLogoFragment = new IntroLogoFragment();

        introLogoFragment.setOnIntro(new IntroLogoFragment.OnIntro() {
            @Override
            public void OnOk() {
                getSupportFragmentManager().beginTransaction().remove(introLogoFragment);
                fmLogo.setVisibility(View.GONE);
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onLogin() {

                SignUpFragment signUpFragment = new SignUpFragment();
                SignInFragment signInFragment = new SignInFragment();

                signUpFragment.setOnChangeUp(new SignUpFragment.OnChangeUp() {
                    @Override
                    public void OnClickUp() {
                        fmLogo.setVisibility(View.VISIBLE);
                        fmSign.setVisibility(View.GONE);
                    }

                    @Override
                    public void OnOkUp() {
                        getSupportFragmentManager().beginTransaction().remove(signInFragment);
                        getSupportFragmentManager().beginTransaction().remove(signUpFragment);
                        if (splashViewModel.CheckIntro().equals("no")) {
                            see();
                        } else {
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        }
                    }
                });


                signInFragment.setOnChange(new SignInFragment.OnChange() {
                    @Override
                    public void OnClick() {
                        fmLogo.setVisibility(View.GONE);
                        if (fa) {
                            getSupportFragmentManager().beginTransaction().add(R.id.fm_splash_sign, signUpFragment).commit();
                            fa = false;
                        }
                        fmSign.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void OnOk() {
                        getSupportFragmentManager().beginTransaction().remove(signInFragment);
                        getSupportFragmentManager().beginTransaction().remove(signUpFragment);
                        if (splashViewModel.CheckIntro().equals("no")) {
                            see();
                        } else {
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        }


                    }
                });

                getSupportFragmentManager().beginTransaction().remove(introLogoFragment).commit();
                getSupportFragmentManager().beginTransaction().add(R.id.fm_splashA_logo, signInFragment).commit();


            }
        });

        getSupportFragmentManager().beginTransaction().add(R.id.fm_splashA_logo, introLogoFragment).commit();
    }

    private void see() {
        rel8.setBackgroundResource(R.drawable.card_radius_style);
        fmLogo.setVisibility(View.GONE);
        con.setVisibility(View.VISIBLE);
        fmSign.setVisibility(View.GONE);
        SetupViews();
        SetAdapter();
        setMdouct(0);
        viewPager.addOnPageChangeListener(listener);
        btnClick();


    }


    private void SetupViews() {

        fragmentManager = getSupportFragmentManager();
        introFragment_one = new IntroFragment_One();
        introFragment_settings = new IntroFragment_Settings();
        introFragment_two = new IntroFragment_Two();
        linearLayout = findViewById(R.id.lin_Splash_list);
        btnGo = findViewById(R.id.btn_Slash_go);
        btnSkip = findViewById(R.id.btn_Splash_skip);
        viewPager = findViewById(R.id.viewpager_start_intro);

    }

    private void SetAdapter() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(introFragment_one);
        fragments.add(introFragment_two);
        fragments.add(introFragment_settings);
        Splash_Adapter adapter = new Splash_Adapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
    }

    ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            // Log.i("LOG", "onPageScrolled: "+position+"/"+positionOffset+"/"+positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            myPosition = position;
            setMdouct(position);
            if (position == 0) {
                btnGo.setVisibility(View.GONE);
                btnSkip.setVisibility(View.VISIBLE);

            } else if (position == 1) {
                btnGo.setVisibility(View.GONE);
                btnSkip.setVisibility(View.VISIBLE);

            } else if (position == 2) {
                btnGo.setVisibility(View.VISIBLE);
                btnSkip.setVisibility(View.INVISIBLE);
            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

            //Log.i("LOG", "onPageScrollStateChanged: "+state);
        }
    };

    public void setMdouct(int position) {
        mDouct = new TextView[3];
        linearLayout.removeAllViews();

        for (int i = 0; i < mDouct.length; i++) {

            mDouct[i] = new TextView(SplashActivity.this);
            mDouct[i].setText(Html.fromHtml("&#8226;"));
            mDouct[i].setTextSize(40);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 0, 10, 0);
            mDouct[i].setLayoutParams(params);
            mDouct[i].setTextColor(ContextCompat.getColor(SplashActivity.this, R.color.light_gray));
            linearLayout.addView(mDouct[i]);

        }

        if (mDouct.length > 0) {
            mDouct[position].setTextColor(ContextCompat.getColor(SplashActivity.this, R.color.medium_gray));
        }

    }

    private void btnClick() {
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (myPosition == 0) {
                    viewPager.setCurrentItem(myPosition + 2);
                } else if (myPosition == 1) {
                    viewPager.setCurrentItem(myPosition + 1);
                }

            }
        });
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                intent.putExtra("ok", "ok");
                startActivity(intent);
                splashViewModel.saveIntro();
                finish();
            }
        });


    }

}
