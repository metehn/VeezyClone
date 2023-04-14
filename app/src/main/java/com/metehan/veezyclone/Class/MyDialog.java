package com.metehan.veezyclone.Class;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyDialog extends Dialog {

    Enum myEnum;

    public MyDialog(@NonNull Context context, Enum myEnum) {
        super(context);
        this.myEnum = myEnum;
    }

    public MyDialog(@NonNull Context context, int themeResId,Enum myEnum) {
        super(context, themeResId);
        this.myEnum = myEnum;
    }

    protected MyDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener, Enum myEnum) {
        super(context, cancelable, cancelListener);
        this.myEnum = myEnum;
    }

    public Enum getMyEnum() {
        return myEnum;
    }

    public void setMyEnum(Enum myEnum) {
        this.myEnum = myEnum;
    }
}
