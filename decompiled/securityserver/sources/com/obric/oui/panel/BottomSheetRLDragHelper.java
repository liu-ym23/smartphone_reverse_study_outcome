package com.obric.oui.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetRLDragHelper {
    public static final Interpolator n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OverScroller f248a;
    public final ViewDragHelper.Callback b;
    public final float c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f249d;
    public final float e;
    public final ViewGroup f;
    public int g;
    public int h;
    public int i;
    public boolean j;
    public int k;
    public boolean l;
    public final Runnable m;

    /* JADX INFO: renamed from: com.obric.oui.panel.BottomSheetRLDragHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r2) {
            float r3 = r2 - 1.0f;
            return ((((r3 * r3) * r3) * r3) * r3) + 1.0f;
        }
    }

    static {
        n = new AnonymousClass1();
    }

    public BottomSheetRLDragHelper(Context r3, ViewGroup r4, ViewDragHelper.Callback r5) {
        this.l = false;
        this.m = new AnonymousClass2(this);
        this.f248a = new OverScroller(r3, n);
        this.f = r4;
        this.b = r5;
        ViewConfiguration r6 = ViewConfiguration.get(r3);
        this.e = r6.getScaledTouchSlop();
        this.c = r6.getScaledMaximumFlingVelocity();
        this.f249d = r6.getScaledMinimumFlingVelocity();
    }

    public final int a(int r4, int r5, int r6) {
        if (r4 != 0) goto L5;
        return 0;
    L5:
        int r3 = this.f.getWidth();
        float r0 = r3 / 2;
        float r1 = (((float) Math.sin((Math.min(1.0f, Math.abs(r4) / r3) - 0.5f) * 0.47123894f)) * r0) + r0;
        int r7 = Math.abs(r5);
        if (r7 <= 0) goto L8;
        int r8 = Math.round(Math.abs(r1 / r7) * 1000.0f) * 4;
    L10:
        return Math.min(r8, 600);
    L8:
        r8 = (int) (((Math.abs(r4) / r6) + 1.0f) * 256.0f);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View b(View r5) {
        if (r5 != 0) goto L6;
        return null;
    L6:
        if (r5.canScrollHorizontally(-this.k) == false) goto L8;
    L21:
        return r5;
    L8:
        if ((r5 instanceof IRLSlideView) == false) goto L13;
        if (((IRLSlideView) r5).a() == true) goto L21;
    L13:
        if ((r5 instanceof ViewGroup) == false) goto L20;
        ViewGroup r6 = (ViewGroup) r5;
        int r1 = r6.getChildCount();
        int r2 = 0;
    L15:
        if (r2 >= r1) goto L20;
        View r3 = b(r6.getChildAt(r2));
        if (r3 != null) goto L18;
        r2 = r2 + 1;
        goto L15
    L18:
        return r3;
    L20:
        return null;
    }
}
