package com.loc;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static h f7346c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f7347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7348b;

    private h(Context r1) {
        this.f7347a = r1.getApplicationContext();
        this.f7348b = o.d(u5.u("RYW1hcF9kZXZpY2VfYWRpdQ"));
    }

    public static h a(Context r2) {
        if (f7346c != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7346c != null) goto L9;
        f7346c = new h(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f7346c;
    }

    public final synchronized void b() {
        monitor-enter(this);
        if (l5.z() != null) goto L6;
        l5.r(l.a());     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    }

    public final void c(String r3) {
        i.c(this.f7347a).e(this.f7348b);
        i.c(this.f7347a).h(r3);
    }
}
