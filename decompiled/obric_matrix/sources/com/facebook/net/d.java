package com.facebook.net;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d f6783b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f6784a;

    private d() {
    }

    public static d a() {
        if (f6783b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6783b != null) goto L9;
        f6783b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f6783b;
    }

    public synchronized boolean b() {
        monitor-enter(this);
        boolean r0 = this.f6784a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
