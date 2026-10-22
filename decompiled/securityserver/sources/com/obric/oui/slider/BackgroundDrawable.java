package com.obric.oui.slider;

import a.a;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class BackgroundDrawable extends Drawable {
    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r13) {
        Intrinsics.f(r13, "canvas");
        Rect r12 = getBounds();
        Intrinsics.e(r12, "bounds");
        float r1 = r12.left;
        float r2 = r12.top;
        float r3 = r12.bottom;
        int r4 = r12.width();
        r12.height();
        Resources r5 = Resources.getSystem();
        Intrinsics.e(r5, "Resources.getSystem()");
        MathKt.a(TypedValue.applyDimension(1, 14, r5.getDisplayMetrics()));
        float r6 = r1 + 0;
        RectF r14 = new RectF(r6, r2, r4 + r6, r3);
        Path r7 = new Path();
        float r8 = 16;
        r7.addRoundRect(r14, new float[]{a.d("Resources.getSystem()", 1, r8), a.d("Resources.getSystem()", 1, r8), a.d("Resources.getSystem()", 1, r8), a.d("Resources.getSystem()", 1, r8), a.d("Resources.getSystem()", 1, r8), a.d("Resources.getSystem()", 1, r8), a.d("Resources.getSystem()", 1, r8), a.d("Resources.getSystem()", 1, r8)}, Path.Direction.CW);
        r13.drawPath(r7, null);
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
