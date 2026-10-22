package com.bytedance.apm.v;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f2082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.apm.g0.c.a f2083b;

    /* JADX INFO: renamed from: com.bytedance.apm.v.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0063a {
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f2084a = null;

        static {
            f2084a = new a(null);
        }

        static /* synthetic */ a a() {
            return f2084a;
        }
    }

    private a() {
    }

    /* synthetic */ a(C0063a r1) {
        this();
    }

    public static a b() {
        return b.a();
    }

    public synchronized c a() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f2082a != null) goto L6;
        this.f2082a = new c.a().a();     // Catch: Throwable -> L9
    L6:
        c r0 = this.f2082a;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized com.bytedance.apm.g0.c.a c() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f2083b != null) goto L6;
        this.f2083b = new com.bytedance.apm.g0.c.a.C0046a().e();     // Catch: Throwable -> L9
    L6:
        com.bytedance.apm.g0.c.a r0 = this.f2083b;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public void d(String r1) {
        if (com.bytedance.apm.d.C() == false) goto L6;
        Log.d("LaunchAnalysis", r1);
        return;
    }

    public void e(String r2) {
        Log.e("LaunchAnalysis", "notice!!!+ " + r2);
    }

    public synchronized void f(c r1) {
        monitor-enter(this);
        this.f2082a = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
