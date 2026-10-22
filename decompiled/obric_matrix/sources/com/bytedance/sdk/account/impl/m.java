package com.bytedance.sdk.account.impl;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class m implements d.b.s.a.q.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d.b.s.a.q.i f5625b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5626a;

    private m() {
        this.f5626a = com.ss.android.i.j.k().e();
    }

    public static d.b.s.a.q.i c() {
        if (f5625b != null) goto L15;
        monitor-enter(m.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5625b != null) goto L9;
        f5625b = new m();     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
    L15:
        return f5625b;
    }

    @Override // d.b.s.a.q.i
    public void a(String r2, Map<String, String> r3, d.b.s.a.q.j.a<d.b.s.a.q.m.c> r4) {
        b(r2, null, r3, r4);
    }

    @Override // d.b.s.a.q.i
    public void b(String r1, Map<String, String> r2, Map<String, String> r3, d.b.s.a.q.j.a<d.b.s.a.q.m.c> r4) {
        d.b.s.a.y.c.J(this.f5626a, r1, r2, r3, r4).D();
    }
}
