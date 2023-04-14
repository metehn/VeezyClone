package com.metehan.veezyclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.metehan.veezyclone.Fragment.DemoFragment;
import com.metehan.veezyclone.Fragment.IntelliColdZoneFragment;
import com.metehan.veezyclone.Fragment.LogInFragment;
import com.metehan.veezyclone.Fragment.RefrigeratorFragment;

public class MainActivity extends AppCompatActivity {

    public static final String DEMO_FRAGMENT = "DEMO_FRAGMENT";
    public static final String LOGIN_FRAGMENT = "LOGIN_FRAGMENT";
    public static final String REFRIGERATOR_FRAGMENT = "REFRIGERATOR_FRAGMENT";
    public static final String INTELLI_COLD_ZONE_FRAGMENT = "INTELLI_COLD_ZONE_FRAGMENT";

    public static final String SUPERCOOL_CHILLING = "Supercool Chilling";
    public static final String SOFT_FREEZE = "Soft Freeze";
    public static final String FREEZER = "Freezer";
    public static final String COOLER = "Cooler";
    public static final String CUSTOM_MODE = "Custom Mode";


    FragmentManager fragmentManager;

    Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        window = getWindow();

        updateStatusBar(R.color.custom_gray_4);

        //Initialize fragment manager
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_mainActivity, new LogInFragment(), LOGIN_FRAGMENT).commit();

    }

    public void addFragment(String tag) {

        Fragment fragment = fragmentManager.findFragmentByTag(tag);

        //That means there is no fragment created yet, so create and add one
        if (fragment == null) {

            switch (tag) {
                case LOGIN_FRAGMENT:
                    fragmentManager.beginTransaction().add(R.id.fl_mainActivity, new LogInFragment(), LOGIN_FRAGMENT).commit();
                    updateStatusBar(R.color.custom_gray_4);
                    return;

                case DEMO_FRAGMENT:
                    fragmentManager.beginTransaction().add(R.id.fl_mainActivity, new DemoFragment(), DEMO_FRAGMENT).commit();
                    updateStatusBar(R.color.white);
                    return;

                case REFRIGERATOR_FRAGMENT:
                    fragmentManager.beginTransaction().add(R.id.fl_mainActivity, new RefrigeratorFragment(), REFRIGERATOR_FRAGMENT).commit();
                    updateStatusBar(R.color.white);
                    return;

                case INTELLI_COLD_ZONE_FRAGMENT:
                    fragmentManager.beginTransaction().add(R.id.fl_mainActivity, new IntelliColdZoneFragment(), INTELLI_COLD_ZONE_FRAGMENT).commit();
                    updateStatusBar(R.color.white);
                    return;
            }
        }
        //Detach all
        detachAllRemaining(fragment);

        fragmentManager.beginTransaction().attach(fragment).commit();


        /*
        //Attach fragment
        if (!fragment.isVisible()) {
            fragmentManager.beginTransaction().attach(fragment).commit();
        }
        */


    }

    public Fragment findFragment(String tag) {
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        return fragment;
    }

    public void removeFragment(String tag) {

        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager.beginTransaction().remove(fragment).commit();
        }
    }


    public void detachAllRemaining(Fragment fragment) {
        Fragment login = fragmentManager.findFragmentByTag(LOGIN_FRAGMENT);
        Fragment Demo = fragmentManager.findFragmentByTag(DEMO_FRAGMENT);


        if (login != null && login != fragment) {
            fragmentManager.beginTransaction().detach(login).commit();
        }
        if (Demo != null && Demo != fragment) {
            fragmentManager.beginTransaction().detach(Demo).commit();
        }


    }

    public void updateStatusBar(int color) {
        // window = getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, color));

    }



}