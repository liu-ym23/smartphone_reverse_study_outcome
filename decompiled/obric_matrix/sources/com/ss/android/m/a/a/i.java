package com.ss.android.m.a.a;

import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j f12166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f12167b;

    static /* synthetic */ class a {
    }

    public interface b {
        ExecutorService a(h r1);
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final i f12168a = null;

        static {
            f12168a = new i(null);
        }

        static /* synthetic */ i a() {
            return f12168a;
        }
    }

    private i() {
        this.f12166a = new j();
        this.f12167b = new d();
    }

    /* synthetic */ i(a r1) {
        this();
    }

    static i b() {
        return c.a();
    }

    ExecutorService a(h r3, boolean r4) {
        ExecutorService r0 = this.f12167b.a(r3);
        if (f.c().f() == false) goto L5;
        this.f12166a.a(r3.f12152a, r0, r4);
    L5:
        return r0;
    }
}
