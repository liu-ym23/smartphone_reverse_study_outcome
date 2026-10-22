package com.android.settings;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class ImageSpanAlignCenter extends ImageSpan {
    private static final char[] ELLIPSIS_NORMAL = null;
    private static final char[] ELLIPSIS_TWO_DOTS = null;
    private WeakReference<Drawable> mDrawableRef;

    static {
        ELLIPSIS_NORMAL = new char[]{8230};
        ELLIPSIS_TWO_DOTS = new char[]{8229};
    }

    public ImageSpanAlignCenter(Context r1, int r2) {
        super(r1, r2);
    }

    public ImageSpanAlignCenter(Drawable r1) {
        super(r1);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Rect r0 = getCachedDrawable(r1).getBounds();
        if (r5 == null) goto L6;
        Paint.FontMetricsInt r6 = new Paint.FontMetricsInt();
        r1.getFontMetricsInt(r6);
        r5.ascent = r6.ascent;
        r5.descent = r6.descent;
        r5.top = r6.top;
        r5.bottom = r6.bottom;
    L6:
        return r0.right;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        String r10 = r2.toString().substring(r3, r4);
        if (ELLIPSIS_NORMAL[0] != r10.charAt(0)) goto L5;
    L8:
        r1.save();
        r1.drawText(r10, r5, r7, r9);
        r1.restore();
        return;
    L5:
        if (ELLIPSIS_TWO_DOTS[0] == r10.charAt(0)) goto L8;
        Drawable r0 = getCachedDrawable(r9);
        r1.save();
        Paint.FontMetricsInt r11 = new Paint.FontMetricsInt();
        r9.getFontMetricsInt(r11);
        r0.getBounds();
        r1.translate(r5, r7 + r11.ascent);
        r0.draw(r1);
        r1.restore();
    }

    private Drawable getCachedDrawable(Paint r7) {
        WeakReference<Drawable> r0 = this.mDrawableRef;
        if (r0 == null) goto L5;
        Drawable r1 = r0.get();
    L6:
        if (r1 != null) goto L14;
        r1 = getDrawable();
        if (r1 == null) goto L14;
        int r8 = r7.getFontMetricsInt(null);
        int r2 = r1.getIntrinsicWidth();
        int r3 = r1.getIntrinsicHeight();
        if (r8 <= r3) goto L12;
        int r4 = (r8 - r3) / 2;
    L13:
        r1.setBounds(new Rect(0, r4, r2, Math.min(r8, r3) + r4));
        this.mDrawableRef = new WeakReference(r1);
        goto L14
    L12:
        r4 = 0;
    L14:
        return r1;
    L5:
        r1 = null;
        goto L6
    }
}
