package com.ss.android.i;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile g f11877b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.b.s.a.l0.j<com.ss.android.i.k.b> f11878a;

    class a extends d.b.s.a.l0.j<com.ss.android.i.k.b> {
        a(g r1) {
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ com.ss.android.i.k.b b() {
            return e();
        }

        @NonNull
        protected com.ss.android.i.k.b e() {
            return f.a();
        }
    }

    private g() {
        this.f11878a = new a(this);
    }

    public static g b() {
        if (f11877b != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11877b != null) goto L9;
        f11877b = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f11877b;
    }

    public com.ss.android.i.k.b a() {
        return this.f11878a.a();
    }

    void c(com.ss.android.i.k.b r1) {
        this.f11878a.c(r1);
    }
}
