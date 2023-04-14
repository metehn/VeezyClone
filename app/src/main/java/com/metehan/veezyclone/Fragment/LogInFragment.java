package com.metehan.veezyclone.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.metehan.veezyclone.MainActivity;
import com.metehan.veezyclone.R;

public class LogInFragment extends Fragment {

    Activity mActivity;
    AppCompatButton button_demoMode;

    public LogInFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_log_in, container, false);


        button_demoMode = view.findViewById(R.id.button_demoMode);
        button_demoMode.setSoundEffectsEnabled(false);

        button_demoMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainActivity) mActivity).addFragment(MainActivity.DEMO_FRAGMENT);
                ((MainActivity)mActivity).updateStatusBar(R.color.white);

            }
        });



        return view;
    }



}