package com.bytedance.apm.r;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile g f1834b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1835a;

    class a implements com.bytedance.apm.y.a.InterfaceC0065a {
        a(g r1) {
        }
    }

    private g() {
        this.f1835a = 0;
    }

    public static g a() {
        if (f1834b != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1834b != null) goto L9;
        f1834b = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f1834b;
    }

    public static int b(int r1) {
        if (r1 != 11) goto L5;
        return 2;
    L5:
        if (r1 != 101) goto L7;
        return 3;
    L7:
        if (r1 == 1001) goto L10;
        return 1;
    L10:
        return 0;
    }

    public static int c(JSONObject r3) {
        int r4 = com.bytedance.apm.util.h.e(r3, "performance_modules", "smooth", "block_monitor_mode");
        if (r4 != 11) goto L5;
        return 2;
    L5:
        if (r4 != 101) goto L7;
        return 3;
    L7:
        if (r4 == 1001) goto L10;
        return 1;
    L10:
        return 0;
    }

    public void d() {
        com.bytedance.apm.y.a.a(new a(this));
    }

    public void e() {
        com.bytedance.monitor.collector.k.n().v();
    }

    public void f(int r1, boolean r2) {
        this.f1835a = b(r1);
        com.bytedance.monitor.collector.k.n().w(this.f1835a);
    }
}
