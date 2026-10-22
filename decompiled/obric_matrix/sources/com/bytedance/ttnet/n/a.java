package com.bytedance.ttnet.n;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f6485b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, b> f6486a;

    public a() {
        this.f6486a = new ConcurrentHashMap();
    }

    public static synchronized a c() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f6485b != null) goto L7;
        f6485b = new a();     // Catch: Throwable -> L10
    L7:
        a r1 = f6485b;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r1;
    }

    public void a(String r8, String r9, int r10, int r11, int r12, List<String> r13, String r14) {
        b r15 = this.f6486a.get(r8);
        if (r15 == null) goto L6;
        r15.e(new c(r10, r11, r12, r13, r14));
        r15.d();
        this.f6486a.remove(r8);
        return;
    }

    public c b(String r2, int r3, Map<String, String> r4) {
        b r0 = new b(r2, r3, r4);
        this.f6486a.put(r0.f(), r0);
        r0.b();
        r0.a();
        this.f6486a.remove(r0.f());
        return r0.c();
    }
}
