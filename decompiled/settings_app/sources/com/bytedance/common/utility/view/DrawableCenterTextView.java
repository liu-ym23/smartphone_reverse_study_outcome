package com.bytedance.common.utility.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes3.dex */
public class DrawableCenterTextView extends TextView {
    public DrawableCenterTextView(Context r1) {
        super(r1);
    }

    public DrawableCenterTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public DrawableCenterTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public DrawableCenterTextView(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas r5) {
        Drawable[] r0 = getCompoundDrawables();
        if (r0 != null) goto L5;
    L17:
        super.onDraw(r5);
        return;
    L5:
        if (r0.length != 4) goto L17;
        Drawable r1 = r0[0];
        Drawable r2 = r0[2];
        if (r1 != null) goto L9;
        if (r2 == null) goto L17;
    L9:
        float r3 = getPaint().measureText(getText().toString());
        int r4 = getCompoundDrawablePadding();
        if (r1 == null) goto L12;
        int r6 = r1.getIntrinsicWidth();
    L13:
        float r7 = (r3 + r6) + r4;
        if (r1 == null) goto L16;
        setGravity(19);
        r5.translate((getWidth() - r7) / 2.0f, 0.0f);
        goto L17
    L16:
        setGravity(21);
        r5.translate((r7 - getWidth()) / 2.0f, 0.0f);
        goto L17
    L12:
        r6 = r2.getIntrinsicWidth();
        goto L13
    }
}
