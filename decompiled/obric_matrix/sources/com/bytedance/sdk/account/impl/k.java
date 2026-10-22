package com.bytedance.sdk.account.impl;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile k f5617a;

    private k() {
        com.ss.android.i.j.k().e();
    }

    public static k a() {
        if (f5617a != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5617a != null) goto L9;
        f5617a = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return f5617a;
    }
}
