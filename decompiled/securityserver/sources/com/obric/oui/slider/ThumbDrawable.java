package com.obric.oui.slider;

import a.a;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ThumbDrawable extends Drawable {
    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        Intrinsics.f(r5, "canvas");
        Rect r4 = getBounds();
        Intrinsics.e(r4, "bounds");
        int r0 = r4.height() / 2;
        RectF r1 = new RectF(r4.left, r0, r4.right, r0);
        float r6 = 8;
        r5.drawRoundRect(r1, a.d("Resources.getSystem()", 1, r6), a.d("Resources.getSystem()", 1, r6), null);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
        throw null;
    }
}
