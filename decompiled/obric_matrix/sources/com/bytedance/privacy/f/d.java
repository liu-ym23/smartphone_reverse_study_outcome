package com.bytedance.privacy.f;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f5369a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f5370b = false;

    static {
    }

    public static boolean a() {
        return false;
    }

    public static boolean b(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return false;
    L9:
        return f5370b;
    L11:
        return f5369a;
    }
}
