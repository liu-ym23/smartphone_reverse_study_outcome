package com.bytedance.apm;

import android.util.Log;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f1642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashSet<String> f1643b;

    class a implements d.b.l.a.h.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f1644a;

        a(k r1) {
            this.f1644a = r1;
        }

        @Override // d.b.l.a.h.d.a
        public void a(Throwable r2, String r3) {
            if (k.a(this.f1644a) == null) goto L6;
            k.a(this.f1644a).a(r2, r3);
            return;
        }
    }

    public interface b {
        void a(Throwable r1, String r2);

        void ensureNotReachHere(String r1);

        void ensureNotReachHere(Throwable r1, String r2);
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final k f1645a = null;

        static {
            f1645a = new k(null);
        }

        static /* synthetic */ k a() {
            return f1645a;
        }
    }

    private k() {
        this.f1643b = new HashSet();
    }

    /* synthetic */ k(a r1) {
        this();
    }

    static /* synthetic */ b a(k r0) {
        return r0.f1642a;
    }

    public static k e() {
        return c.a();
    }

    private void g() {
        d.b.l.a.h.c.a().b(new a(this));
    }

    public void b(Throwable r1, String r2) {
        b r0 = this.f1642a;     // Catch: Throwable -> L12
        if (r0 == null) goto L6;
        r0.a(r1, r2);     // Catch: Throwable -> L12
    L6:
        if (d.C() == true) goto L11;
        if (d.F() == true) goto L11;
        return;
    L11:
        throw new RuntimeException(r1);
    }

    public void c(String r3) {
        if (this.f1642a == null) goto L8;
        if (this.f1643b.contains(r3) == true) goto L8;
        this.f1643b.add(r3);
        this.f1642a.ensureNotReachHere("apm_" + r3);
    L8:
        if (d.C() == false) goto L11;
        Log.e("apm_", "ensureNotReachHere", new RuntimeException(r3));
        System.exit(1);
        return;
    }

    public void d(Throwable r3, String r4) {
        if (this.f1642a == null) goto L8;
        if (this.f1643b.contains(r4) == true) goto L8;
        this.f1643b.add(r4);
        this.f1642a.ensureNotReachHere(r3, "apm_" + r4);
    L8:
        if (d.C() == false) goto L11;
        r3.printStackTrace();
        return;
    }

    public void f(b r1) {
        this.f1642a = r1;
        g();
    }
}
