package com.qihoo360.mobilesafe.ui.common.other;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.qihoo360.mobilesafe.common.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public class ImmerseView extends LinearLayout {
    public static final String IMMERSE_TAG = "IMMERSE_TAG";

    public ImmerseView(Context r2) {
        this(r2, null);
    }

    public ImmerseView(Context r1, AttributeSet r2) {
        super(r1, r2);
        init();
    }

    private void init() {
        setOrientation(1);
        setTag(IMMERSE_TAG);
        setBackgroundResource(R.color.inner_common_bg_color_3);
    }
}
