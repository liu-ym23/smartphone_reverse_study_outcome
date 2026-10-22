package com.obric.oui.slider;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.e;
import kotlin.f0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f11415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f11419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f11420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f11421g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f11422h;

    public b(Context r5) {
        o.f(r5, "context");
        Resources r1 = Resources.getSystem();
        o.e(r1, "Resources.getSystem()");
        this.f11417c = kotlin.o0.a.a(TypedValue.applyDimension(1, 8, r1.getDisplayMetrics()));
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        this.f11418d = kotlin.o0.a.a(TypedValue.applyDimension(1, 6, r2.getDisplayMetrics()));
        Resources r3 = Resources.getSystem();
        o.e(r3, "Resources.getSystem()");
        this.f11419e = kotlin.o0.a.a(TypedValue.applyDimension(1, 16, r3.getDisplayMetrics()));
        Resources r4 = Resources.getSystem();
        o.e(r4, "Resources.getSystem()");
        this.f11420f = kotlin.o0.a.a(TypedValue.applyDimension(1, 1, r4.getDisplayMetrics()));
        this.f11415a = ContextCompat.getDrawable(r5, e.H);
        Paint r0 = new Paint();
        r0.setColor(ContextCompat.getColor(r5, com.obric.common.oui.c.v));
        r0.setStyle(Paint.Style.FILL);
        f0 r6 = f0.f18324a;
        this.f11421g = r0;
        Paint r7 = new Paint();
        r7.setColor(ContextCompat.getColor(r5, com.obric.common.oui.c.f8201J));
        r7.setStyle(Paint.Style.FILL);
        this.f11422h = r7;
    }

    private final void a(Canvas r11) {
        if (this.f11415a != null) goto L5;
        return;
    L5:
        if (this.f11416b == false) goto L14;
        Rect r0 = getBounds();
        o.e(r0, "bounds");
        int r1 = r0.left;
        int r2 = r0.top;
        int r3 = r0.right;
        int r4 = r0.bottom;
        float r5 = 8;
        Resources r6 = Resources.getSystem();
        o.e(r6, "Resources.getSystem()");
        int r7 = kotlin.o0.a.a(TypedValue.applyDimension(1, r5, r6.getDisplayMetrics())) + r1;
        Resources r8 = Resources.getSystem();
        o.e(r8, "Resources.getSystem()");
        int r9 = r2 + kotlin.o0.a.a(TypedValue.applyDimension(1, r5, r8.getDisplayMetrics()));
        Resources r10 = Resources.getSystem();
        o.e(r10, "Resources.getSystem()");
        int r12 = r1 + kotlin.o0.a.a(TypedValue.applyDimension(1, 32, r10.getDisplayMetrics()));
        Resources r13 = Resources.getSystem();
        o.e(r13, "Resources.getSystem()");
        Rect r14 = new Rect(r7, r9, r12, r4 - kotlin.o0.a.a(TypedValue.applyDimension(1, r5, r13.getDisplayMetrics())));
        Drawable r15 = this.f11415a;
        if (r15 == null) goto L9;
        r15.setBounds(r14);
    L9:
        Drawable r16 = this.f11415a;
        if (r16 == null) goto L15;
        r16.draw(r11);
        return;
    L15:
        return;
    }

    public final void b() {
        this.f11416b = false;
        invalidateSelf();
    }

    public final void c(int r1) {
        this.f11418d = r1;
        invalidateSelf();
    }

    public final void d(Drawable r2) {
        o.f(r2, "imageIcon");
        this.f11415a = r2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r21) {
        o.f(r21, "canvas");
        Rect r2 = getBounds();
        o.e(r2, "bounds");
        float r3 = r2.left;
        float r4 = r2.top;
        float r5 = r2.right;
        float r6 = r2.bottom;
        int r7 = r2.width();
        r2.height();
        r21.drawColor(0);
        float r8 = (getLevel() * r7) / 10000.0f;
        int r9 = this.f11418d;
        if ((r8 - r9) >= 0) goto L5;
        float r10 = 0.0f;
    L7:
        if ((r9 + r8) <= r5) goto L9;
        float r11 = r7;
    L10:
        RectF r12 = new RectF(r3, r4, r10 + r3, r6);
        Path r13 = new Path();
        float r14 = this.f11419e;
        float r15 = this.f11420f;
        r13.addRoundRect(r12, new float[]{r14, r14, r15, r15, r15, r15, r14, r14}, Path.Direction.CW);
        r21.drawPath(r13, this.f11421g);
        RectF r16 = new RectF(r3 + r11, r4, r5, r6);
        Path r17 = new Path();
        float r18 = this.f11420f;
        float r19 = this.f11419e;
        r17.addRoundRect(r16, new float[]{r18, r18, r19, r19, r19, r19, r18, r18}, Path.Direction.CW);
        r21.drawPath(r17, this.f11422h);
        a(r21);
        return;
    L9:
        r11 = r9 + r8;
        goto L10
    L5:
        r10 = r8 - r9;
        goto L7
    }

    public final void e() {
        this.f11416b = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f11417c;
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
