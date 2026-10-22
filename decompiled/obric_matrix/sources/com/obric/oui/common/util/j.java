package com.obric.oui.common.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.Objects;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    static final class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f10947f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f10948g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f10949h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f10950i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ ViewGroup f10951j;

        a(View r1, int r2, int r3, boolean r4, ViewGroup r5) {
            this.f10947f = r1;
            this.f10948g = r2;
            this.f10949h = r3;
            this.f10950i = r4;
            this.f10951j = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Rect r0 = new Rect();
            this.f10947f.getHitRect(r0);
            int r1 = (this.f10948g - r0.width()) / 2;
            int r2 = (this.f10949h - r0.height()) / 2;
            if (r1 < 0) goto L5;
        L7:
            if (r2 < 0) goto L9;
        L11:
            r0.left -= r1;
            r0.top -= r2;
            r0.right += r1;
            r0.bottom += r2;
            this.f10951j.setTouchDelegate(new TouchDelegate(r0, this.f10947f));
            return;
        L9:
            if (this.f10950i == true) goto L11;
            r2 = 0;
            goto L11
        L5:
            if (this.f10950i == true) goto L7;
            r1 = 0;
            goto L7
        }
    }

    static final class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f10952f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ View[] f10953g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f10954h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f10955i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ i f10956j;

        b(View r1, View[] r2, int r3, int r4, i r5) {
            this.f10952f = r1;
            this.f10953g = r2;
            this.f10954h = r3;
            this.f10955i = r4;
            this.f10956j = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View[] r0 = this.f10953g;
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L10;
            View r4 = r0[r3];
            r3 = r3 + 1;
            Rect r5 = new Rect();
            r4.getHitRect(r5);
            int r6 = (this.f10954h - r5.width()) / 2;
            int r7 = (this.f10955i - r5.height()) / 2;
            if (r6 >= 0) goto L7;
            r6 = 0;
        L7:
            if (r7 >= 0) goto L9;
            r7 = 0;
        L9:
            r5.left -= r6;
            r5.top -= r7;
            r5.right += r6;
            r5.bottom += r7;
            this.f10956j.a(new TouchDelegate(r5, r4));
            goto L3
        L10:
            this.f10952f.setTouchDelegate(this.f10956j);
        }
    }

    public static final void a(View r7, int r8) {
        o.f(r7, "$this$expandTouchArea");
        c(r7, r8, r8, false, 4, null);
    }

    public static final void b(View r8, int r9, int r10, boolean r11) {
        o.f(r8, "$this$expandTouchArea");
        if (r8.getParent() == null) goto L5;
        ViewParent r0 = r8.getParent();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L9;
        r1.post(new a(r8, r9, r10, r11, r1));
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static /* synthetic */ void c(View r0, int r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        b(r0, r1, r2, r3);
    }

    public static final void d(View r7, int r8, int r9, View... r10) {
        o.f(r7, "$this$increaseHitAreaForViews");
        o.f(r10, "views");
        r7.post(new b(r7, r10, r8, r9, new i(r7, null, 2, null)));
    }

    public static final void e(View r1) {
        o.f(r1, "$this$makeGone");
        r1.setVisibility(8);
    }

    public static final void f(View r1) {
        o.f(r1, "$this$makeInvisible");
        r1.setVisibility(4);
    }

    public static final void g(View r1) {
        o.f(r1, "$this$makeVisible");
        r1.setVisibility(0);
    }

    public static final void h(View r2) {
        o.f(r2, "$this$removeFromParent");
        if (r2.getParent() != null) goto L5;
        return;
    L5:
        if ((r2.getParent() instanceof ViewGroup) == false) goto L9;
        ViewParent r0 = r2.getParent();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r0).removeView(r2);
        return;
    }

    public static final void i(ViewGroup r1, View r2) {
        o.f(r1, "$this$removeFromParentAndAdd");
        if (r2 == null) goto L5;
        ViewParent r0 = r2.getParent();
    L6:
        if (r0 != null) goto L8;
    L10:
        r1.addView(r2);
        return;
    L8:
        if ((r2.getParent() instanceof ViewGroup) == false) goto L10;
        h(r2);
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    public static final void j(View r1, boolean r2) {
        o.f(r1, "$this$setVisibility");
        if (r2 == false) goto L5;
        g(r1);
        return;
    L5:
        e(r1);
    }
}
