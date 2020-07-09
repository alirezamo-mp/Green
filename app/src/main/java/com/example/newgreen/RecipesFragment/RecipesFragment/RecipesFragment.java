package com.example.newgreen.RecipesFragment.RecipesFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.newgreen.R;
import com.example.newgreen.RecipesFragment.AllFragment.AllFragment;
import com.example.newgreen.RecipesFragment.RecipesDetailFragment.RecipesDetailFragment;
import com.example.newgreen.RecipesFragment.VeganFragment.VeganFragment;

public class RecipesFragment extends Fragment {

    RelativeLayout relAll, relVegan, relPaleo, relKeto;
    TextView txtAll, txtVegan, txtPaleo, txtKeto;
    FrameLayout fm,fmIn;
    FragmentManager fragmentManager;
    View view;
    CardView cardView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.recipes_fragment, container, false);

        SetUpViews();
        SetFirstFragment();
        ChageList();
        OnBack();

        return view;
    }

    private void SetFirstFragment() {


        AllFragment allFragment=new AllFragment();
        allFragment.setOnItemClick(new AllFragment.OnItemClickAll() {
            @Override
            public void OnClick(String id, String name) {
                fmIn.setVisibility(View.VISIBLE);
                RecipesDetailFragment RDetail=new RecipesDetailFragment();
                RDetail.setOnClickBtn(new RecipesDetailFragment.OnClickBtn() {
                    @Override
                    public void OnBackClick() {
                        getFragmentManager().beginTransaction().remove(RDetail).commit();
                        fmIn.setVisibility(View.GONE);
                    }
                });
                Bundle bundle=new Bundle();
                bundle.putString("id",id);
                bundle.putString("name",name);
                RDetail.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fm_recipes_information,RDetail).addToBackStack(null).commit();

            }
        });

        fragmentManager.beginTransaction().add(R.id.fm_recipes_view,allFragment).commit();
    }

    private void OnBack() {

    }

    private void ChageList() {


        txtAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relAll.setVisibility(View.VISIBLE);
                txtAll.setVisibility(View.GONE);
                txtVegan.setVisibility(View.VISIBLE);
                txtKeto.setVisibility(View.VISIBLE);
                txtPaleo.setVisibility(View.VISIBLE);
                relKeto.setVisibility(View.GONE);
                relPaleo.setVisibility(View.GONE);
                relVegan.setVisibility(View.GONE);

                getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.fm_recipes_view)).commit();

                AllFragment allFragment=new AllFragment();
                allFragment.setOnItemClick(new AllFragment.OnItemClickAll() {
                    @Override
                    public void OnClick(String id, String name) {
                        fmIn.setVisibility(View.VISIBLE);
                        RecipesDetailFragment RDetail=new RecipesDetailFragment();
                        RDetail.setOnClickBtn(new RecipesDetailFragment.OnClickBtn() {
                            @Override
                            public void OnBackClick() {
                                getFragmentManager().beginTransaction().remove(RDetail).commit();
                                fmIn.setVisibility(View.GONE);
                            }
                        });
                        Bundle bundle=new Bundle();
                        bundle.putString("id",id);
                        bundle.putString("name",name);
                        RDetail.setArguments(bundle);

                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fm_recipes_information,RDetail).addToBackStack(null).commit();

                    }
                });



                fragmentManager.beginTransaction().add(R.id.fm_recipes_view,allFragment).commit();

            }
        });

        txtVegan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relVegan.setVisibility(View.VISIBLE);
                txtVegan.setVisibility(View.GONE);
                txtAll.setVisibility(View.VISIBLE);
                txtKeto.setVisibility(View.VISIBLE);
                txtPaleo.setVisibility(View.VISIBLE);
                relKeto.setVisibility(View.GONE);
                relPaleo.setVisibility(View.GONE);
                relAll.setVisibility(View.GONE);

                getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.fm_recipes_view)).commit();

                VeganFragment veganFragment=new VeganFragment();
                veganFragment.setOnItemClicked(new VeganFragment.OnItemClicked() {
                    @Override
                    public void OnCliched(String id,String title) {
                        fmIn.setVisibility(View.VISIBLE);
                        RecipesDetailFragment RDetail=new RecipesDetailFragment();
                        RDetail.setOnClickBtn(new RecipesDetailFragment.OnClickBtn() {
                            @Override
                            public void OnBackClick() {
                                getFragmentManager().beginTransaction().remove(RDetail).commit();
                                fmIn.setVisibility(View.GONE);
                            }
                        });
                        Bundle bundle=new Bundle();
                        bundle.putString("id",id);
                        bundle.putString("name",title);
                        RDetail.setArguments(bundle);

                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fm_recipes_information,RDetail).addToBackStack(null).commit();
                    }
                });

                fragmentManager.beginTransaction().add(R.id.fm_recipes_view,veganFragment).commit();

            }
        });

        txtPaleo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relPaleo.setVisibility(View.VISIBLE);
                txtPaleo.setVisibility(View.GONE);
                txtVegan.setVisibility(View.VISIBLE);
                txtKeto.setVisibility(View.VISIBLE);
                txtAll.setVisibility(View.VISIBLE);
                relKeto.setVisibility(View.GONE);
                relAll.setVisibility(View.GONE);
                relVegan.setVisibility(View.GONE);

                getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.fm_recipes_view)).commit();

                fragmentManager.beginTransaction().add(R.id.fm_recipes_view,new AllFragment()).commit();
            }
        });

        txtKeto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relKeto.setVisibility(View.VISIBLE);
                txtKeto.setVisibility(View.GONE);
                txtVegan.setVisibility(View.VISIBLE);
                txtPaleo.setVisibility(View.VISIBLE);
                txtAll.setVisibility(View.VISIBLE);
                relPaleo.setVisibility(View.GONE);
                relAll.setVisibility(View.GONE);
                relVegan.setVisibility(View.GONE);

                getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.fm_recipes_view)).commit();

                fragmentManager.beginTransaction().add(R.id.fm_recipes_view,new VeganFragment()).commit();

            }
        });


    }

    private void SetUpViews() {
        relAll = view.findViewById(R.id.rel_recipes_all);
        relKeto = view.findViewById(R.id.rel_recipes_keto);
        relPaleo = view.findViewById(R.id.rel_recipes_paleo);
        relVegan = view.findViewById(R.id.rel_recipes_vegan);
        cardView = view.findViewById(R.id.card_recipes_title);
        txtAll = view.findViewById(R.id.txt_recipes_all);
        txtPaleo = view.findViewById(R.id.txt_recipes_paleo);
        txtVegan = view.findViewById(R.id.txt_recipes_vegan);
        txtKeto = view.findViewById(R.id.txt_recipes_keto);
        fm=view.findViewById(R.id.fm_recipes_view);
        fmIn=view.findViewById(R.id.fm_recipes_information);
        fragmentManager=getActivity().getSupportFragmentManager();
        cardView.setBackgroundResource(R.drawable.card_radius_style);
    }


}
