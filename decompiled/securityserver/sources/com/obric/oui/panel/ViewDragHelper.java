package com.obric.oui.panel;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class ViewDragHelper {
    public static final Interpolator w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f252a;
    public final int b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f253d;
    public float[] e;
    public float[] f;
    public float[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public int k;
    public VelocityTracker l;
    public final float m;
    public final float n;
    public final int o;
    public final OverScroller p;
    public final Callback q;
    public View r;
    public boolean s;
    public final ViewGroup t;
    public int u;
    public final Runnable v;

    /* JADX INFO: renamed from: com.obric.oui.panel.ViewDragHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r2) {
            float r3 = r2 - 1.0f;
            return ((((r3 * r3) * r3) * r3) * r3) + 1.0f;
        }
    }

    public static abstract class Callback {
        public int a(View r1, int r2, int r3) {
            return 0;
        }

        public int b(View r1, int r2, int r3) {
            return 0;
        }

        public int c(View r1) {
            return 0;
        }

        public void d(int r1) {
        }

        public void e(View r1, int r2, int r3, int r4, int r5) {
        }

        public void f(View r1, float r2, float r3) {
        }

        public abstract boolean g(View r1, int r2);
    }

    static {
        w = new AnonymousClass1();
    }

    public ViewDragHelper(Context r2, ViewGroup r3, Callback r4) {
        this.c = -1;
        this.u = 600;
        this.v = new AnonymousClass2(this);
        if (r3 == null) goto L10;
        if (r4 == null) goto L8;
        this.t = r3;
        this.q = r4;
        ViewConfiguration r5 = ViewConfiguration.get(r2);
        this.o = (int) ((r2.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.b = r5.getScaledTouchSlop();
        this.m = r5.getScaledMaximumFlingVelocity();
        this.n = r5.getScaledMinimumFlingVelocity();
        this.p = new OverScroller(r2, w);
        return;
    L8:
        throw new IllegalArgumentException("Callback may not be null");
    L10:
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public final void a() {
        this.c = -1;
        float[] r0 = this.f253d;
        if (r0 == null) goto L6;
        Arrays.fill(r0, 0.0f);
        Arrays.fill(this.e, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    L6:
        VelocityTracker r1 = this.l;
        if (r1 == null) goto L10;
        r1.recycle();
        this.l = null;
        return;
    }

    public final void b(View r3, int r4) {
        ViewParent r0 = r3.getParent();
        ViewGroup r1 = this.t;
        if (r0 != r1) goto L7;
        this.r = r3;
        this.c = r4;
        this.q.getClass();
        k(1);
        return;
    L7:
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + r1 + ")");
    }

    public final void c(int r5) {
        float[] r0 = this.f253d;
        if (r0 == null) goto L8;
        int r1 = this.k;
        int r2 = 1 << r5;
        if ((r1 & r2) == 0) goto L9;
        r0[r5] = 0.0f;
        this.e[r5] = 0.0f;
        this.f[r5] = 0.0f;
        this.g[r5] = 0.0f;
        this.h[r5] = 0;
        this.i[r5] = 0;
        this.j[r5] = 0;
        this.k = (~r2) & r1;
        return;
    L9:
        return;
    }

    public final int d(int r5, int r6, int r7) {
        if (r5 != 0) goto L5;
        return 0;
    L5:
        int r0 = this.t.getWidth();
        float r1 = r0 / 2;
        float r2 = (((float) Math.sin((Math.min(1.0f, Math.abs(r5) / r0) - 0.5f) * 0.47123894f)) * r1) + r1;
        int r8 = Math.abs(r6);
        if (r8 <= 0) goto L8;
        int r9 = Math.round(Math.abs(r2 / r8) * 1000.0f) * 4;
    L10:
        return Math.min(r9, this.u);
    L8:
        r9 = (int) (((Math.abs(r5) / r7) + 1.0f) * 256.0f);
        goto L10
    }

    public final View e(int r5, int r6) {
        ViewGroup r0 = this.t;
        int r1 = r0.getChildCount() - 1;
    L3:
        if (r1 < 0) goto L14;
        this.q.getClass();
        View r2 = r0.getChildAt(r1);
        if (r5 < r2.getLeft()) goto L13;
        if (r5 >= r2.getRight()) goto L13;
        if (r6 < r2.getTop()) goto L13;
        if (r6 >= r2.getBottom()) goto L13;
        return r2;
    L13:
        r1 = r1 - 1;
        goto L3
    L14:
        return null;
    }

    public final boolean f(int r12, int r13, int r14, int r15) {
        int r2 = this.r.getLeft();
        int r3 = this.r.getTop();
        int r4 = r12 - r2;
        int r5 = r13 - r3;
        OverScroller r1 = this.p;
        if (r4 != 0) goto L7;
        if (r5 != 0) goto L7;
        r1.abortAnimation();
        k(0);
        return false;
    L7:
        View r16 = this.r;
        int r0 = (int) this.n;
        int r6 = (int) this.m;
        int r7 = Math.abs(r14);
        if (r7 >= r0) goto L10;
        r14 = 0;
    L14:
        int r8 = Math.abs(r15);
        if (r8 >= r0) goto L17;
        r15 = 0;
    L21:
        int r9 = Math.abs(r4);
        int r10 = Math.abs(r5);
        int r11 = Math.abs(r14);
        int r17 = Math.abs(r15);
        int r18 = r11 + r17;
        int r19 = r9 + r10;
        if (r14 == 0) goto L25;
        float r20 = r11;
        float r21 = r18;
    L24:
        float r22 = r20 / r21;
        if (r15 == 0) goto L29;
        float r23 = r17;
        float r24 = r18;
    L28:
        float r25 = r23 / r24;
        Callback r26 = this.q;
        r26.getClass();
        int r110 = d(r4, r14, 0);
        r1.startScroll(r2, r3, r4, r5, (int) ((d(r5, r15, r26.c(r16)) * r25) + (r110 * r22)));
        k(2);
        return true;
    L29:
        r23 = r10;
        r24 = r19;
        goto L28
    L25:
        r20 = r9;
        r21 = r19;
        goto L24
    L17:
        if (r8 <= r6) goto L21;
        if (r15 <= 0) goto L20;
        r15 = r6;
        goto L21
    L20:
        r15 = -r6;
        goto L21
    L10:
        if (r7 <= r6) goto L14;
        if (r14 <= 0) goto L13;
        r14 = r6;
        goto L14
    L13:
        r14 = -r6;
        goto L14
    }

    public final boolean g(int r3) {
        if ((this.k & (1 << r3)) == 0) goto L5;
        return true;
    L5:
        Log.e("ViewDragHelper", "Ignoring pointerId=" + r3 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void h() {
        VelocityTracker r0 = this.l;
        float r1 = this.m;
        r0.computeCurrentVelocity(1000, r1);
        float r2 = this.l.getXVelocity(this.c);
        float r3 = this.n;
        float r4 = Math.abs(r2);
        float r5 = 0.0f;
        if (r4 >= r3) goto L6;
        r2 = 0.0f;
    L11:
        float r6 = this.l.getYVelocity(this.c);
        float r7 = Math.abs(r6);
        if (r7 >= r3) goto L15;
    L22:
        this.s = true;
        this.q.f(this.r, r2, r5);
        this.s = false;
        if (this.f252a != 1) goto L26;
        k(0);
        return;
    L26:
        return;
    L15:
        if (r7 > r1) goto L17;
        r5 = r6;
        goto L22
    L17:
        if (r6 > 0.0f) goto L20;
        r1 = -r1;
    L20:
        r5 = r1;
        goto L22
    L6:
        if (r4 <= r1) goto L11;
        if (r2 <= 0.0f) goto L10;
        r2 = r1;
        goto L11
    L10:
        r2 = -r1;
        goto L11
    }

    public final void i(float r11, float r12, int r13) {
        float[] r0 = this.f253d;
        int r1 = 0;
        if (r0 != null) goto L5;
    L6:
        int r2 = r13 + 1;
        float[] r3 = new float[r2];
        float[] r4 = new float[r2];
        float[] r5 = new float[r2];
        float[] r6 = new float[r2];
        int[] r7 = new int[r2];
        int[] r8 = new int[r2];
        int[] r9 = new int[r2];
        if (r0 == null) goto L9;
        System.arraycopy(r0, 0, r3, 0, r0.length);
        float[] r10 = this.e;
        System.arraycopy(r10, 0, r4, 0, r10.length);
        float[] r14 = this.f;
        System.arraycopy(r14, 0, r5, 0, r14.length);
        float[] r15 = this.g;
        System.arraycopy(r15, 0, r6, 0, r15.length);
        int[] r16 = this.h;
        System.arraycopy(r16, 0, r7, 0, r16.length);
        int[] r17 = this.i;
        System.arraycopy(r17, 0, r8, 0, r17.length);
        int[] r18 = this.j;
        System.arraycopy(r18, 0, r9, 0, r18.length);
    L9:
        this.f253d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
    L10:
        float[] r19 = this.f253d;
        this.f[r13] = r11;
        r19[r13] = r11;
        float[] r20 = this.e;
        this.g[r13] = r12;
        r20[r13] = r12;
        int[] r21 = this.h;
        int r110 = (int) r11;
        int r111 = (int) r12;
        ViewGroup r22 = this.t;
        int r23 = r22.getLeft();
        int r24 = this.o;
        if (r110 >= (r23 + r24)) goto L14;
        r1 = 1;
    L14:
        if (r111 >= (r22.getTop() + r24)) goto L17;
        r1 = r1 | 4;
    L17:
        if (r110 <= (r22.getRight() - r24)) goto L20;
        r1 = r1 | 2;
    L20:
        if (r111 <= (r22.getBottom() - r24)) goto L22;
        r1 = r1 | 8;
    L22:
        r21[r13] = r1;
        this.k |= 1 << r13;
        return;
    L5:
        if (r0.length > r13) goto L10;
        goto L6
    }

    public final void j(MotionEvent r7) {
        int r0 = r7.getPointerCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        int r2 = r7.getPointerId(r1);
        if (g(r2) == false) goto L8;
        float r3 = r7.getX(r1);
        float r4 = r7.getY(r1);
        this.f[r2] = r3;
        this.g[r2] = r4;
    L8:
        r1 = r1 + 1;
        goto L3
    }

    public final void k(int r3) {
        Runnable r0 = this.v;
        this.t.removeCallbacks(r0);
        if (this.f252a == r3) goto L8;
        this.f252a = r3;
        this.q.d(r3);
        if (this.f252a != 0) goto L9;
        this.r = null;
        return;
    L9:
        return;
    }

    public final boolean l(View r3, int r4) {
        if (r3 == this.r) goto L5;
    L7:
        if (r3 != null) goto L9;
        return false;
    L9:
        if (this.q.g(r3, r4) == false) goto L14;
        this.c = r4;
        b(r3, r4);
        return true;
    L14:
        return false;
    L5:
        if (this.c != r4) goto L7;
        return true;
    }
}
