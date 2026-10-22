package com.bytedance.sdk.account.impl;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile h f5547a;

    private h() {
    }

    public static h b() {
        if (f5547a != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5547a != null) goto L9;
        f5547a = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f5547a;
    }

    public void a() {
        c("account_sdk_info", d.b.s.a.s.a.f14899a);
        d.b.s.a.v.a.b.e(new d.b.s.a.v.a.a[]{new d.b.s.a.v.a.d.a()});
    }

    public void c(String r1, d.b.s.a.s.c r2) {
        d.b.s.a.s.b.f14901b.a(r1, r2);
    }
}
