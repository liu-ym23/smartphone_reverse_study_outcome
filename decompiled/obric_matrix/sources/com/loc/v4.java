package com.loc;

import android.content.Context;
import com.amap.api.location.DPoint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class v4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static double f7906a = 3.141592653589793d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<DPoint> f7907b = null;

    static {
        f7907b = new ArrayList(Arrays.asList(new DPoint[]{new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)}));
    }

    private static double a(double r4) {
        return Math.sin((r4 * 3000.0d) * (f7906a / 180.0d)) * 2.0E-5d;
    }

    private static double b(double r6, double r8) {
        return (Math.cos(r8 / 100000.0d) * (r6 / 18000.0d)) + (Math.sin(r6 / 100000.0d) * (r8 / 9000.0d));
    }

    private static DPoint c(double r2, double r4, double r6, double r8) {
        DPoint r0 = new DPoint();
        double r7 = r2 - r6;
        double r9 = r4 - r8;
        DPoint r1 = m(r7, r9);
        r0.f(j((r2 + r7) - r1.d()));
        r0.e(j((r4 + r9) - r1.b()));
        return r0;
    }

    public static DPoint d(Context r0, DPoint r1) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return i(r1);
    }

    public static DPoint e(DPoint r5) {
        if (r5 != null) goto L14;
    L13:
        return r5;
    L14:
    L11:
        th = move-exception;
        s4.h(th, "OffsetUtil", "b2G");
        goto L13
    L4:
        if (s4.i(r5.b(), r5.d()) == false) goto L8;
        return l(r5);
    L8:
        if (n(r5.b(), r5.d()) == false) goto L15;
        DPoint r0 = l(r5);     // Catch: Throwable -> L11
        return o(r0.b(), r0.d());
    L15:
        return r5;
    }

    private static double f(double r4) {
        return Math.cos((r4 * 3000.0d) * (f7906a / 180.0d)) * 3.0E-6d;
    }

    private static double g(double r6, double r8) {
        return (Math.sin(r8 / 100000.0d) * (r6 / 18000.0d)) + (Math.cos(r6 / 100000.0d) * (r8 / 9000.0d));
    }

    public static DPoint h(Context r4, DPoint r5) {
    L7:
        th = move-exception;
        s4.h(th, "OffsetUtil", "marbar2G");
        return r5;
    L3:
        if (s4.i(r5.b(), r5.d()) == true) goto L5;
        return r5;
    L5:
        return d(r4, k(r5.d(), r5.b()));
    }

    private static DPoint i(DPoint r6) {
    L7:
        th = move-exception;
        s4.h(th, "OffsetUtil", "cover part2");
        return r6;
    L3:
        if (s4.i(r6.b(), r6.d()) == false) goto L6;
        double[] r0 = c5.b(r6.d(), r6.b());     // Catch: Throwable -> L7
        return new DPoint(r0[1], r0[0]);
    L6:
        return r6;
    }

    private static double j(double r1) {
        return new BigDecimal(r1).setScale(8, 4).doubleValue();
    }

    private static DPoint k(double r11, double r13) {
        double r12 = ((long) (r11 * 100000.0d)) % 36000000;
        double r14 = ((long) (r13 * 100000.0d)) % 36000000;
        double r4 = (int) ((-b(r12, r14)) + r12);
        double r2 = (int) ((-g(r12, r14)) + r14);
        double r5 = (-b(r4, r2)) + r12;
        int r15 = 1;
        if (r12 <= 0.0d) goto L5;
        int r16 = 1;
    L6:
        double r6 = (int) (r5 + ((double) r16));
        double r3 = (-g(r6, r2)) + r14;
        if (r14 > 0.0d) goto L11;
        r15 = -1;
    L11:
        return new DPoint(((double) ((int) (r3 + ((double) r15)))) / 100000.0d, r6 / 100000.0d);
    L5:
        r16 = -1;
        goto L6
    }

    private static DPoint l(DPoint r14) {
        DPoint r4 = null;
        int r5 = 0;
        double r10 = 0.006401062d;
        double r12 = 0.0060424805d;
    L4:
        if (r5 >= 2) goto L6;
        r4 = c(r14.d(), r14.b(), r10, r12);
        r10 = r14.d() - r4.d();
        r12 = r14.b() - r4.b();
        r5 = r5 + 1;
        goto L4
    L6:
        return r4;
    }

    private static DPoint m(double r9, double r11) {
        DPoint r0 = new DPoint();
        double r5 = (r9 * r9) + (r11 * r11);
        double r1 = (Math.cos(f(r9) + Math.atan2(r11, r9)) * (a(r11) + Math.sqrt(r5))) + 0.0065d;
        double r10 = (Math.sin(f(r9) + Math.atan2(r11, r9)) * (a(r11) + Math.sqrt(r5))) + 0.006d;
        r0.f(j(r1));
        r0.e(j(r10));
        return r0;
    }

    private static boolean n(double r1, double r3) {
        if (s4.l(new DPoint(r1, r3), f7907b) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private static DPoint o(double r5, double r7) {
        DPoint r0 = p(r5, r7);
        double r8 = (r7 * 2.0d) - r0.d();
        return new DPoint((r5 * 2.0d) - r0.b(), r8);
    }

    private static DPoint p(double r14, double r16) {
        double r0 = r16 - 105.0d;
        double r2 = r14 - 35.0d;
        double r4 = q(r0, r2);
        double r1 = r(r0, r2);
        double r6 = (r14 / 180.0d) * f7906a;
        double r8 = Math.sin(r6);
        double r9 = 1.0d - ((0.006693421622965943d * r8) * r8);
        double r10 = Math.sqrt(r9);
        double r5 = (r4 * 180.0d) / ((6335552.717000426d / (r9 * r10)) * f7906a);
        double r3 = (r1 * 180.0d) / (((6378245.0d / r10) * Math.cos(r6)) * f7906a);
        return new DPoint(r14 + r5, r16 + r3);
    }

    private static double q(double r12, double r14) {
        double r2 = r12 * 2.0d;
        return ((((((((-100.0d) + r2) + (r14 * 3.0d)) + ((r14 * 0.2d) * r14)) + ((0.1d * r12) * r14)) + (Math.sqrt(Math.abs(r12)) * 0.2d)) + ((((Math.sin((r12 * 6.0d) * f7906a) * 20.0d) + (Math.sin(r2 * f7906a) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(f7906a * r14) * 20.0d) + (Math.sin((r14 / 3.0d) * f7906a) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r14 / 12.0d) * f7906a) * 160.0d) + (Math.sin((r14 * f7906a) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double r(double r12, double r14) {
        double r8 = r12 * 0.1d;
        return (((((((r12 + 300.0d) + (r14 * 2.0d)) + (r8 * r12)) + (r8 * r14)) + (Math.sqrt(Math.abs(r12)) * 0.1d)) + ((((Math.sin((6.0d * r12) * f7906a) * 20.0d) + (Math.sin((r12 * 2.0d) * f7906a) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(f7906a * r12) * 20.0d) + (Math.sin((r12 / 3.0d) * f7906a) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r12 / 12.0d) * f7906a) * 150.0d) + (Math.sin((r12 / 30.0d) * f7906a) * 300.0d)) * 2.0d) / 3.0d);
    }
}
