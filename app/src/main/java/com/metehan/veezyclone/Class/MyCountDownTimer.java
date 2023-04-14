package com.metehan.veezyclone.Class;

import android.app.Activity;
import android.os.CountDownTimer;
import android.widget.Toast;

public class MyCountDownTimer extends CountDownTimer {

//TODO singleton yapısı ile arka arkaya alarm kurma engellenecek
    Activity activity;
    ColdZoneTypes coldZoneTypes;

    public MyCountDownTimer(Activity activity, long millisInFuture, long countDownInterval, ColdZoneTypes coldZoneTypes) {
        super(millisInFuture, countDownInterval);
        this.activity = activity;
        this.coldZoneTypes = coldZoneTypes;
    }

    @Override
    public void onTick(long l) {

    }

    @Override
    public void onFinish() {
        Toast.makeText(activity, "DONE", Toast.LENGTH_LONG).show();
    }


}
