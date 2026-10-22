package com.obric.oui.oswitch;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f11136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f11141g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11142h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Interpolator f11143i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Drawable f11144j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Drawable f11145k;

    static {
    }

    public a(Drawable r2, Drawable r3) {
        o.f(r2, "startDrawable");
        o.f(r3, "endDrawable");
        this.f11144j = r2;
        this.f11145k = r3;
        this.f11142h = true;
        this.f11143i = new AccelerateInterpolator();
    }

    private final void a(Canvas r3, int r4) {
        this.f11144j.setBounds(getBounds());
        this.f11145k.setBounds(getBounds());
        if (this.f11142h == false) goto L5;
        this.f11144j.setAlpha(255 - r4);
    L5:
        this.f11144j.draw(r3);
        if (this.f11142h == false) goto L8;
        this.f11144j.setAlpha(255);
    L8:
        if (r4 <= 0) goto L11;
        this.f11145k.setAlpha(r4);
        this.f11145k.draw(r3);
        this.f11145k.setAlpha(255);
        return;
    }

    public final void b() {
        this.f11140f = 0;
        this.f11135a = 0;
        invalidateSelf();
    }

    public final void c(int r13) {
        long r0 = SystemClock.uptimeMillis();
        int r3 = 0;
        if (this.f11135a != 2) goto L18;
        long r6 = this.f11136b;
        long r8 = r0 - r6;
        int r2 = this.f11137c;
        if (r8 > r2) goto L18;
        boolean r14 = !this.f11141g;
        this.f11141g = r14;
        this.f11138d = this.f11140f;
        if (r14 == true) goto L11;
        r3 = 255;
    L11:
        this.f11139e = r3;
        long r1 = r0 - r6;
        if (r14 == false) goto L14;
        int r15 = (int) r1;
    L15:
        this.f11137c = r15;
    L16:
        this.f11135a = 1;
        invalidateSelf();
        return;
    L14:
        r15 = r2 - ((int) r1);
    L18:
        this.f11138d = 255;
        this.f11139e = 0;
        this.f11140f = 255;
        this.f11137c = r13;
        this.f11141g = true;
        goto L16
    }

    public final void d() {
        this.f11140f = 255;
        this.f11135a = 0;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r7) {
        o.f(r7, "canvas");
        int r0 = this.f11135a;
        if (r0 == 1) goto L10;
        if (r0 != 2) goto L11;
        long r1 = SystemClock.uptimeMillis() - this.f11136b;
        int r3 = this.f11137c;
        if (r1 < r3) goto L9;
        this.f11140f = this.f11139e;
        this.f11135a = 0;
        goto L11
    L9:
        float r2 = this.f11143i.getInterpolation(r1 / r3);
        int r4 = this.f11138d;
        this.f11140f = r4 + ((int) ((this.f11139e - r4) * r2));
    L11:
        int r5 = this.f11140f;
        if (this.f11135a != 0) goto L21;
        if (r5 != 0) goto L17;
        this.f11144j.setBounds(getBounds());
        Drawable r6 = this.f11144j;
    L15:
        r6.draw(r7);
        return;
    L17:
        if (r5 != 255) goto L19;
        this.f11145k.setBounds(getBounds());
        r6 = this.f11145k;
        goto L15
    L19:
        a(r7, r5);
        return;
    L21:
        a(r7, r5);
        if (this.f11135a != 2) goto L26;
        invalidateSelf();
        return;
    L26:
        return;
    L10:
        this.f11136b = SystemClock.uptimeMillis();
        this.f11135a = 2;
        goto L11
    }

    public final void e(int r3) {
        this.f11138d = 0;
        this.f11139e = 255;
        this.f11140f = 0;
        this.f11137c = r3;
        this.f11141g = false;
        this.f11135a = 1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.f11144j.getIntrinsicHeight(), this.f11145k.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.f11144j.getIntrinsicWidth(), this.f11145k.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.f11144j.setAlpha(r2);
        this.f11145k.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.f11144j.setColorFilter(r2);
        this.f11145k.setColorFilter(r2);
    }
}
