package com.android.settingslib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* JADX INFO: loaded from: classes.dex */
public class RestrictedLockImageSpan extends ImageSpan {
    private Context mContext;
    private final float mExtraPadding;
    private final Drawable mRestrictedPadlock;

    public RestrictedLockImageSpan(Context r3) {
        Drawable r1 = (Drawable) null;
        super(null);
        this.mContext = r3;
        this.mExtraPadding = r3.getResources().getDimensionPixelSize(R.dimen.restricted_icon_padding);
        this.mRestrictedPadlock = RestrictedLockUtilsInternal.getRestrictedPadlock(this.mContext);
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        return this.mRestrictedPadlock;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Drawable r10 = getDrawable();
        r1.save();
        r1.translate(r5 + this.mExtraPadding, (r8 - r10.getBounds().bottom) / 2.0f);
        r10.draw(r1);
        r1.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        return (int) (super.getSize(r1, r2, r3, r4, r5) + (this.mExtraPadding * 2.0f));
    }
}
