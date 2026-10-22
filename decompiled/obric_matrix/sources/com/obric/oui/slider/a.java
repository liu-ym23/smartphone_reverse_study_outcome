package com.obric.oui.slider;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f11414c;

    public final void a(int r1) {
        this.f11413b = r1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r19) {
        o.f(r19, "canvas");
        Rect r2 = getBounds();
        o.e(r2, "bounds");
        float r3 = r2.left;
        float r4 = r2.top;
        int r5 = r2.right;
        float r6 = r2.bottom;
        int r7 = r2.width();
        r2.height();
        Resources r8 = Resources.getSystem();
        o.e(r8, "Resources.getSystem()");
        int r9 = kotlin.o0.a.a(TypedValue.applyDimension(1, 14, r8.getDisplayMetrics()));
        int r10 = this.f11413b;
        int r11 = (r7 - (r10 * r9)) / (r10 + 1);
        if (r10 < 0) goto L8;
        int r12 = 0;
    L5:
        float r13 = ((r11 + r9) * r12) + r3;
        RectF r14 = new RectF(r13, r4, r11 + r13, r6);
        Path r15 = new Path();
        float r16 = 16;
        Resources r17 = Resources.getSystem();
        o.e(r17, "Resources.getSystem()");
        Resources r18 = Resources.getSystem();
        o.e(r18, "Resources.getSystem()");
        Resources r110 = Resources.getSystem();
        o.e(r110, "Resources.getSystem()");
        Resources r111 = Resources.getSystem();
        o.e(r111, "Resources.getSystem()");
        Resources r112 = Resources.getSystem();
        o.e(r112, "Resources.getSystem()");
        Resources r113 = Resources.getSystem();
        o.e(r113, "Resources.getSystem()");
        Resources r114 = Resources.getSystem();
        o.e(r114, "Resources.getSystem()");
        Resources r115 = Resources.getSystem();
        o.e(r115, "Resources.getSystem()");
        r15.addRoundRect(r14, new float[]{kotlin.o0.a.a(TypedValue.applyDimension(1, r16, r17.getDisplayMetrics())), kotlin.o0.a.a(TypedValue.applyDimension(1, r16, r18.getDisplayMetrics())), kotlin.o0.a.a(TypedValue.applyDimension(1, r16, r110.getDisplayMetrics())), kotlin.o0.a.a(TypedValue.applyDimension(1, r16, r111.getDisplayMetrics())), kotlin.o0.a.a(TypedValue.applyDimension(1, r16, r112.getDisplayMetrics())), kotlin.o0.a.a(TypedValue.applyDimension(1, r16, r113.getDisplayMetrics())), kotlin.o0.a.a(TypedValue.applyDimension(1, r16, r114.getDisplayMetrics())), kotlin.o0.a.a(TypedValue.applyDimension(1, r16, r115.getDisplayMetrics()))}, Path.Direction.CW);
        r19.drawPath(r15, this.f11414c);
        if (r12 == r10) goto L10;
        r12 = r12 + 1;
        goto L5
    L10:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f11412a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r1) {
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }
}
