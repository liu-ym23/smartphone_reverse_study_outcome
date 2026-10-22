package com.obric.oui.slider;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ProgressDrawable extends Drawable {
    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r11) {
        float r1 = 0.0f;
        Intrinsics.f(r11, "canvas");
        Rect r2 = getBounds();
        Intrinsics.e(r2, "bounds");
        float r3 = r2.left;
        float r4 = r2.top;
        float r5 = r2.right;
        float r6 = r2.bottom;
        int r7 = r2.width();
        r2.height();
        r11.drawColor(0);
        float r10 = (getLevel() * r7) / 10000.0f;
        float r8 = 0;
        float r9 = r10 - r8;
        if (r9 < r8) goto L6;
        r1 = r9;
    L6:
        float r12 = r10 + r8;
        if (r12 <= r5) goto L9;
        r12 = r7;
    L9:
        RectF r13 = new RectF(r3, r4, r1 + r3, r6);
        Path r14 = new Path();
        Path.Direction r15 = Path.Direction.CW;
        r14.addRoundRect(r13, new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, r15);
        r11.drawPath(r14, null);
        RectF r16 = new RectF(r3 + r12, r4, r5, r6);
        Path r17 = new Path();
        r17.addRoundRect(r16, new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, r15);
        r11.drawPath(r17, null);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int r1) {
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }
}
