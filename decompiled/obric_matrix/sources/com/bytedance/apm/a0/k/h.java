package com.bytedance.apm.a0.k;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.apm.a0.k.b f1249a;

    static /* synthetic */ class a {
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static h f1250a;

        static {
            f1250a = new h(null);
        }

        static /* synthetic */ h a() {
            return f1250a;
        }
    }

    private h() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        com.bytedance.apm.a0.k.b r0 = new d();
    L6:
        this.f1249a = r0;
        this.f1249a.init();
        return;
    L5:
        r0 = new e();
        goto L6
    }

    /* synthetic */ h(a r1) {
        this();
    }

    public static h e() {
        return b.a();
    }

    public long a() {
        return this.f1249a.a();
    }

    public long b() {
        return this.f1249a.e();
    }

    public long c() {
        return this.f1249a.h();
    }

    public long d() {
        return this.f1249a.j();
    }

    public long f() {
        return this.f1249a.b();
    }

    public long g() {
        return this.f1249a.g();
    }

    public long h() {
        return this.f1249a.c();
    }

    public long i() {
        return this.f1249a.i();
    }

    public long j() {
        return this.f1249a.f();
    }

    void k(boolean r1) {
        this.f1249a.d(r1);
    }
}
