package com.obric.oui.picker.reels.views;

import android.widget.OverScroller;
import java.lang.reflect.Method;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class<?> f11276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f11277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f11278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f11279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f11280e = null;

    static {
        f11280e = new c();
    }

    private c() {
    }

    private final int a(OverScroller r18, int r19, int r20, int r21) {
        if (f11279d == true) goto L6;
        d.g.d.f.f.b.b("ScrollerExt", "calculateSnapVelocity, reflect failed, use original velocityY: " + r19);
        return r19;
    L6:
        if (r19 == 0) goto L49;
        float r1 = r20;
        float r3 = r21;
        float r4 = c(r18, r19) + r1;
        double r5 = r4 / r3;
        float r7 = ((float) Math.floor(r5)) * r3;
        float r6 = ((float) Math.ceil(r5)) * r3;
        if (Math.abs(r4 - r7) < Math.abs(r6 - r4)) goto L11;
        r7 = r6;
    L11:
        if (r19 <= 0) goto L13;
        byte r8 = 1;
    L15:
        if (r19 <= 0) goto L17;
        int r9 = 40000;
        int r10 = 0;
    L18:
        float r11 = Float.MAX_VALUE;
        int r12 = 20;
        int r13 = r19;
        int r14 = 0;
    L19:
        if (r14 >= r12) goto L54;
        int r15 = (r10 + r9) / 2;
        float r16 = c(r18, r15) + r1;
        float r17 = r16 - r7;
        if (Math.abs(r17) >= r11) goto L23;
        r11 = Math.abs(r17);
        r13 = r15;
    L23:
        d.g.d.f.f.b.i("ScrollerExt", "calculateSnapVelocity, iteration: " + r14 + ", mid: " + r15 + ", low: " + r10 + ", high: " + r9 + ", diff: " + r17 + ", dist: " + r16 + ", targetDistance: " + r7 + ", bestDiff: " + r11 + ", bestVelocity: " + r13 + ", velocityY: " + r19 + ", currentOffset: " + r1);
        if (r8 <= 0) goto L32;
        if (r17 < 0) goto L36;
        if (Math.abs(r17) > 0.3f) goto L36;
        return r13;
    L36:
        float r22 = 0;
        if (r8 <= 0) goto L42;
        if (r17 > r22) goto L44;
    L43:
        r10 = r15 + 1;
    L45:
        if (r10 > r9) goto L57;
        r14 = r14 + 1;
        r12 = 20;
        goto L19
    L57:
        return r13;
    L44:
        r9 = r15 - 1;
        goto L45
    L42:
        if (r17 >= r22) goto L44;
    L32:
        if (r17 > 0) goto L36;
        if (Math.abs(r17) > 0.3f) goto L36;
        return r13;
    L54:
        return r13;
    L17:
        r10 = -40000;
        r9 = 0;
        goto L18
    L13:
        r8 = -1;
        goto L15
    L49:
        return r19;
    }

    private final void b(OverScroller r4) {
    L11:
        e = move-exception;
        d.g.d.f.f.b.k("ScrollerExt", "disableDynamicScroll, failed", e);
        return;
    L3:
        if (f11278c != null) goto L7;
        Method r3 = OverScroller.class.getDeclaredMethod("disableDynamicScroll", new Class[0]);     // Catch: Exception -> L11
        f11278c = r3;     // Catch: Exception -> L11
        if (r3 == null) goto L7;
        r3.setAccessible(true);     // Catch: Exception -> L11
    L7:
        Method r5 = f11278c;     // Catch: Exception -> L11
        if (r5 == null) goto L16;
        r5.invoke(r4, new Object[0]);     // Catch: Exception -> L11
        return;
    }

    private final int c(OverScroller r1, int r2) {
        double r0 = e(r1, r2);
        if (r2 != 0) goto L5;
        Number r3 = 0;
    L10:
        return r3.intValue();
    L5:
        if (r2 > 0) goto L8;
        r0 = -r0;
    L8:
        r3 = Double.valueOf(r0);
        goto L10
    }

    public static final double e(OverScroller r4, int r5) {
        o.f(r4, "overScroller");
        f11280e.b(r4);     // Catch: Exception -> L11
        Method r1 = f11277b;     // Catch: Exception -> L11
        if (r1 == null) goto L6;
        Object r6 = r1.invoke(r4, new Object[]{Integer.valueOf(r5)});     // Catch: Exception -> L11
    L7:
        if (r6 == null) goto L10;
        return ((Double) r6).doubleValue();
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");     // Catch: Exception -> L11
    L6:
        r6 = null;
    L11:
        e = move-exception;
        d.g.d.f.f.b.c("ScrollerExt", "reflectGetSplineFlingDistance, velocity: " + r5 + ", error", e);
        f11279d = false;
        return 0.0d;
    }

    public final void d() {
    L13:
        e = move-exception;
        d.g.d.f.f.b.c("ScrollerExt", "init reflect error", e);
        f11279d = false;
        return;
    L4:
        if (f11276a != null) goto L7;
        f11276a = Class.forName("android.widget.OverScroller");     // Catch: Exception -> L13
    L7:
        if (f11277b != null) goto L11;
        Class<?> r0 = f11276a;     // Catch: Exception -> L13
        o.c(r0);     // Catch: Exception -> L13
        Method r1 = r0.getDeclaredMethod("getSplineFlingDistance", new Class[]{Integer.TYPE});     // Catch: Exception -> L13
        f11277b = r1;     // Catch: Exception -> L13
        if (r1 == null) goto L11;
        r1.setAccessible(true);     // Catch: Exception -> L13
    L11:
        f11279d = true;     // Catch: Exception -> L13
    }

    public final void f(OverScroller r12, int r13, int r14, int r15, int r16, int r17, int r18) {
        o.f(r12, "$this$snapFlingVertically");
        r12.fling(0, r14, 0, a(r12, r15, r14, r13), 0, 0, r16, r17, 0, r18);
    }
}
