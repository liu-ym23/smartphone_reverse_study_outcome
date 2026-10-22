package com.bytedance.feedbackerlib.matisse.internal.ui.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* JADX INFO: loaded from: classes.dex */
public class b extends ImageSpan {
    public b(Drawable r1, int r2) {
        super(r1, r2);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Drawable r10 = getDrawable();
        r1.save();
        Paint.FontMetricsInt r11 = r9.getFontMetricsInt();
        int r12 = r8 - r10.getBounds().bottom;
        int r0 = ((ImageSpan) this).mVerticalAlignment;
        if (r0 != 1) goto L6;
        r12 = r12 - r11.descent;
    L8:
        r1.translate(r5, r12);
        r10.draw(r1);
        r1.restore();
        return;
    L6:
        if (r0 != 2) goto L8;
        r12 = (((r11.descent + r7) + (r7 + r11.ascent)) / 2) - (r10.getBounds().bottom / 2);
        goto L8
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Rect r0 = getDrawable().getBounds();
        if (r5 == null) goto L6;
        Paint.FontMetricsInt r6 = r1.getFontMetricsInt();
        int r7 = r6.bottom - r6.top;
        int r8 = (r0.bottom - r0.top) / 2;
        int r9 = r7 / 4;
        int r10 = r8 - r9;
        int r11 = -(r8 + r9);
        r5.ascent = r11;
        r5.top = r11;
        r5.bottom = r10;
        r5.descent = r10;
    L6:
        return r0.right;
    }
}
