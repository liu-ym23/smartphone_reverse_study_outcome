package com.qihoo360.mobilesafe.common.ui.textview;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CommonRoundTextView extends TextView {
    public CommonRoundTextView(Context r1) {
        super(r1);
    }

    public CommonRoundTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public CommonRoundTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public void setUIBgColorAndCorner(int r4, int r5) {
        int r0 = CommonUtils.dip2px(getContext(), 5.0f);
        int r1 = CommonUtils.dip2px(getContext(), 2.0f);
        setPadding(r0, r1, r0, r1);
        float r6 = r5;
        ShapeDrawable r2 = new ShapeDrawable(new RoundRectShape(new float[]{r6, r6, r6, r6, r6, r6, r6, r6}, null, null));
        r2.getPaint().setColor(getResources().getColor(r4));
        setBackgroundDrawable(r2);
    }
}
