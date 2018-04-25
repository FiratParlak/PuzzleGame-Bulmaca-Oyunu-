package com.example.frtpa.puzzlegame;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by frtpa on 13.04.2018.
 */

public class MyGridView2 extends GridView {

    public MyGridView2(Context context) {
        super(context);

    }

    public MyGridView2(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public MyGridView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP) // API 21
    public MyGridView2(Context context, AttributeSet attrs, int defStyleAttr,
                      int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }
}
