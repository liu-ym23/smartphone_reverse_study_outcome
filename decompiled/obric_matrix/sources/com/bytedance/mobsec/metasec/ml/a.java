package com.bytedance.mobsec.metasec.ml;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile long f5079a = 131;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile long f5080b = 2000;

    public static long a() {
        return f5079a;
    }

    public static long b() {
        return f5080b;
    }

    public static boolean c() {
        if ((a() & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }
}
