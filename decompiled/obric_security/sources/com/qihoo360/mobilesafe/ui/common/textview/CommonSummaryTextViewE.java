package com.qihoo360.mobilesafe.ui.common.textview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public class CommonSummaryTextViewE extends TextView {
    public CommonSummaryTextViewE(Context r2) {
        this(r2, null);
    }

    public CommonSummaryTextViewE(Context r1, AttributeSet r2) {
        super(r1, r2);
        init();
    }

    private void init() {
        setTextColor(getResources().getColor(R.color.inner_common_text_color_2));
        setTextSize(0, getResources().getDimensionPixelSize(R.dimen.inner_common_font_size_g));
    }
}
