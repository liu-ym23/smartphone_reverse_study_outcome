package com.obric.oui.oswitch;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CustomTransitionDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f237a;
    public long b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f238d;
    public int e;
    public int f;
    public boolean g;
    public final boolean h;
    public final AccelerateInterpolator i;
    public final Drawable j;
    public final Drawable k;

    @Metadata
    public static final class Companion {
    }

    public CustomTransitionDrawable(Drawable r2, Drawable r3) {
        Intrinsics.f(r2, "startDrawable");
        Intrinsics.f(r3, "endDrawable");
        this.j = r2;
        this.k = r3;
        this.h = true;
        this.i = new AccelerateInterpolator();
    }

    public final void a(Canvas r4, int r5) {
        Rect r0 = getBounds();
        Drawable r1 = this.j;
        r1.setBounds(r0);
        Rect r2 = getBounds();
        Drawable r3 = this.k;
        r3.setBounds(r2);
        boolean r6 = this.h;
        if (r6 == false) goto L5;
        r1.setAlpha(255 - r5);
    L5:
        r1.draw(r4);
        if (r6 == false) goto L8;
        r1.setAlpha(255);
    L8:
        if (r5 <= 0) goto L11;
        r3.setAlpha(r5);
        r3.draw(r4);
        r3.setAlpha(255);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r7) {
        Intrinsics.f(r7, "canvas");
        int r0 = this.f237a;
        if (r0 == 1) goto L10;
        if (r0 != 2) goto L11;
        long r1 = SystemClock.uptimeMillis() - this.b;
        int r3 = this.c;
        if (r1 < r3) goto L9;
        this.f = this.e;
        this.f237a = 0;
        goto L11
    L9:
        float r2 = this.i.getInterpolation(r1 / r3);
        int r4 = this.f238d;
        this.f = r4 + ((int) ((this.e - r4) * r2));
    L11:
        int r5 = this.f;
        if (this.f237a != 0) goto L20;
        if (r5 != 0) goto L16;
        Rect r6 = getBounds();
        Drawable r8 = this.j;
        r8.setBounds(r6);
        r8.draw(r7);
        return;
    L16:
        if (r5 != 255) goto L18;
        Rect r9 = getBounds();
        Drawable r10 = this.k;
        r10.setBounds(r9);
        r10.draw(r7);
        return;
    L18:
        a(r7, r5);
        return;
    L20:
        a(r7, r5);
        if (this.f237a != 2) goto L26;
        invalidateSelf();
        return;
    L26:
        return;
    L10:
        this.b = SystemClock.uptimeMillis();
        this.f237a = 2;
        goto L11
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.j.getIntrinsicHeight(), this.k.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.j.getIntrinsicWidth(), this.k.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.j.setAlpha(r2);
        this.k.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.j.setColorFilter(r2);
        this.k.setColorFilter(r2);
    }
}
