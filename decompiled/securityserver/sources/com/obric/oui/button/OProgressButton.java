package com.obric.oui.button;

import android.R;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextPaint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OProgressButton extends OButton {
    public boolean t;

    public final void i() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        float r6 = getWidth();
        float r1 = RangesKt.a(0 / 100.0f, 0.0f, 1.0f);
        if (r1 > 0.0f) goto L9;
        TextPaint r2 = getPaint();
        Intrinsics.e(r2, "paint");
        r2.setShader(null);
        setTextColor(0);
    L12:
        invalidate();
        return;
    L9:
        if (r1 < 1.0f) goto L11;
        TextPaint r3 = getPaint();
        Intrinsics.e(r3, "paint");
        r3.setShader(null);
        setTextColor(0);
        goto L12
    L11:
        LinearGradient r12 = new LinearGradient(0.0f, 0.0f, r6, 0.0f, new int[]{0, 0, 0, 0}, new float[]{0.0f, r1, r1, 1.0f}, Shader.TileMode.CLAMP);
        TextPaint r4 = getPaint();
        Intrinsics.e(r4, "paint");
        r4.setShader(r12);
        setTextColor(0);
        goto L12
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.t == false) goto L6;
        i();
        return;
    }

    public final void setProgressMode(boolean r2) {
        if (this.t == r2) goto L12;
        this.t = r2;
        if (r2 == false) goto L10;
        setBackgroundResource(0);
        Drawable r3 = getBackground();
        if ((r3 instanceof LayerDrawable) == false) goto L9;
        boolean r4 = ((LayerDrawable) r3).findDrawableByLayerId(R.id.progress) instanceof ClipDrawable;
    L9:
        i();
        return;
    L10:
        TextPaint r5 = getPaint();
        Intrinsics.e(r5, "paint");
        r5.setShader(null);
        i();
        return;
    }
}
