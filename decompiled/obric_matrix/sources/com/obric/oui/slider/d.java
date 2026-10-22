package com.obric.oui.slider;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import kotlin.f0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f11427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11431f;

    public d(Context r3, int r4) {
        o.f(r3, "context");
        this.f11431f = r4;
        this.f11426a = r3;
        Paint r5 = new Paint();
        r5.setColor(ContextCompat.getColor(r3, com.obric.common.oui.c.v));
        r5.setStyle(Paint.Style.FILL);
        r5.setAntiAlias(true);
        f0 r0 = f0.f18324a;
        this.f11427b = r5;
        Resources r1 = Resources.getSystem();
        o.e(r1, "Resources.getSystem()");
        this.f11428c = kotlin.o0.a.a(TypedValue.applyDimension(1, 16, r1.getDisplayMetrics()));
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        kotlin.o0.a.a(TypedValue.applyDimension(1, 24, r2.getDisplayMetrics()));
        this.f11429d = this.f11428c;
        Resources r6 = Resources.getSystem();
        o.e(r6, "Resources.getSystem()");
        this.f11430e = kotlin.o0.a.a(TypedValue.applyDimension(1, 4, r6.getDisplayMetrics()));
    }

    public final void a(int r1) {
        this.f11430e = r1;
        invalidateSelf();
    }

    public final void b(int r3) {
        this.f11427b.setColor(ContextCompat.getColor(this.f11426a, r3));
        invalidateSelf();
    }

    public final void c(int r1) {
        this.f11431f = r1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r7) {
        o.f(r7, "canvas");
        Rect r0 = getBounds();
        o.e(r0, "bounds");
        int r1 = (r0.height() - this.f11429d) / 2;
        RectF r2 = new RectF(r0.left, r1, r0.right, r1 + this.f11429d);
        float r3 = 8;
        Resources r4 = Resources.getSystem();
        o.e(r4, "Resources.getSystem()");
        float r5 = kotlin.o0.a.a(TypedValue.applyDimension(1, r3, r4.getDisplayMetrics()));
        Resources r6 = Resources.getSystem();
        o.e(r6, "Resources.getSystem()");
        r7.drawRoundRect(r2, r5, kotlin.o0.a.a(TypedValue.applyDimension(1, r3, r6.getDisplayMetrics())), this.f11427b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f11431f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f11430e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.f11427b.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.f11427b.setColorFilter(r2);
        invalidateSelf();
    }
}
