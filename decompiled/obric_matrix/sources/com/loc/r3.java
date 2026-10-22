package com.loc;

/* JADX INFO: loaded from: classes2.dex */
public final class r3 {
    public static double a(double r6, double r8, double r10, double r12) {
        double r2 = (((90.0d - r8) * 21412.0d) / 90.0d) + 6356725.0d;
        double r11 = (r10 * 0.01745329238474369d) - (r6 * 0.01745329238474369d);
        double r13 = r11 * (Math.cos((3.1415927410125732d * r8) / 180.0d) * r2);
        double r14 = ((r12 * 0.01745329238474369d) - (r8 * 0.01745329238474369d)) * r2;
        return Math.pow((r13 * r13) + (r14 * r14), 0.5d);
    }
}
