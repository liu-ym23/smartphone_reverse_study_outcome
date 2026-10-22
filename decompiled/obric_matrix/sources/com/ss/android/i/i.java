package com.ss.android.i;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile i f11894b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.b.s.a.l0.j<com.ss.android.i.m.a> f11895a;

    class a extends d.b.s.a.l0.j<com.ss.android.i.m.a> {
        a(i r1) {
        }

        @Override // d.b.s.a.l0.j
        @NonNull
        protected /* bridge */ /* synthetic */ com.ss.android.i.m.a b() {
            return e();
        }

        @NonNull
        protected com.ss.android.i.m.a e() {
            return d.a();
        }
    }

    private i() {
        this.f11895a = new a(this);
    }

    public static i a() {
        if (f11894b != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11894b != null) goto L9;
        f11894b = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return f11894b;
    }

    void b(com.ss.android.i.m.a r1) {
        this.f11895a.c(r1);
    }
}
