package com.metehan.veezyclone.Fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.metehan.veezyclone.MainActivity;
import com.metehan.veezyclone.R;


public class RefrigeratorFragment extends Fragment {


    Activity mActivity;
    FrameLayout fl_intelli_cold_zone;
    TextView tv_freezer, tv_cooler;

    ImageView iv_back_refrigerator;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_refrigerator, container, false);

        mActivity = getActivity();

        fl_intelli_cold_zone = view.findViewById(R.id.fl_intelli_cold_zone);
        tv_freezer= view.findViewById(R.id.tv_freezer);
        tv_cooler = view.findViewById(R.id.tv_cooler);
        iv_back_refrigerator = view.findViewById(R.id.iv_back_refrigerator);

        iv_back_refrigerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)mActivity).removeFragment(MainActivity.REFRIGERATOR_FRAGMENT);
            }
        });



        fl_intelli_cold_zone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Open Intelli Cold Zone fragment
                ((MainActivity) mActivity).addFragment(MainActivity.INTELLI_COLD_ZONE_FRAGMENT);
                ((MainActivity) mActivity).updateStatusBar(R.color.white);
            }
        });

        return view;
    }

    public void updateTemp(int freezer, int cooler){
        tv_freezer.setText(freezer+"");
        tv_cooler.setText(cooler+"");
    }
}