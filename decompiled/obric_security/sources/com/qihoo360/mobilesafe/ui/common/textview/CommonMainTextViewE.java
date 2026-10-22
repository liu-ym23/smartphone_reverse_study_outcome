package com.qihoo360.mobilesafe.ui.common.textview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public class CommonMainTextViewE extends TextView {
    public CommonMainTextViewE(Context r2) {
        this(r2, null);
    }

    public CommonMainTextViewE(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public CommonMainTextViewE(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init();
    }

    private void init() {
        setTextColor(getResources().getColor(R.color.inner_common_text_color_1));
        setTextSize(0, getResources().getDimensionPixelSize(R.dimen.inner_common_font_size_e));
    }
}
