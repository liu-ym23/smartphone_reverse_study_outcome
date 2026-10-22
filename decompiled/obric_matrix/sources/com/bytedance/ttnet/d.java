package com.bytedance.ttnet;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.e.j;
import d.b.h.a.a.h.o.b.s;
import java.net.MalformedURLException;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f6302a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final C0197d f6303b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final b f6304c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static boolean f6305d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static volatile boolean f6306e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static String f6307f;

    static /* synthetic */ class a {
    }

    private static class b extends C0197d {
        private b() {
            super(null);
        }

        /* synthetic */ b(a r1) {
            this();
        }

        @Override // com.bytedance.ttnet.d.C0197d
        public d.b.h.a.a.h.d a() {
            return e.b(j.w(TTNetInit.getTTNetDepend().getContext()));
        }
    }

    public interface c {
        boolean i();
    }

    /* JADX INFO: renamed from: com.bytedance.ttnet.d$d, reason: collision with other inner class name */
    private static class C0197d {
        private C0197d() {
        }

        /* synthetic */ C0197d(a r1) {
            this();
        }

        public d.b.h.a.a.h.d a() {
            Context r1 = TTNetInit.getTTNetDepend().getContext();
            s r0 = s.t(r1);
            if (d.b.h.a.a.h.s.h.h(r1) == false) goto L5;
            r0.w(com.bytedance.ttnet.r.c.l());
        L5:
            return r0;
        }
    }

    private static class e implements d.b.h.a.a.h.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static volatile e f6308c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private j f6309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile int f6310b;

        private e(j r1) {
            this.f6309a = r1;
        }

        public static e b(j r2) {
            if (f6308c != null) goto L15;
            monitor-enter(e.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (f6308c != null) goto L9;
            f6308c = new e(r2);     // Catch: Throwable -> L11
        L9:
            monitor-exit(e.class);     // Catch: Throwable -> L11
        L15:
            return f6308c;
        }

        private void c(Throwable r3) {
            if ((r3 instanceof MalformedURLException) == false) goto L6;
            return;
        L6:
            if (r3.getMessage() != null) goto L8;
        L10:
            Logger.debug();
            if (d.b.h.a.a.c.k().m() == false) goto L21;
            int r0 = this.f6310b + 1;
            this.f6310b = r0;
            if (r0 > 3) goto L15;
            return;
        L15:
            if (com.bytedance.ttnet.j.c.b() == true) goto L17;
            Logger.debug();
            d.f6305d = true;
        L17:
            String r2 = com.bytedance.ttnet.s.e.f(r3);
            d.f6307f = r2;
            if (r2.length() <= 256) goto L23;
            d.f6307f = d.f6307f.substring(0, 256);
            return;
        L23:
            return;
        L21:
            return;
        L8:
            if (r3.getMessage().contains("MalformedURLException") == false) goto L10;
        }

        @Override // d.b.r.h0.a
        public d.b.r.h0.e a(d.b.r.h0.c r3) {
            return this.f6309a.a(r3);
        L4:
            th = move-exception;
            c(th);
            TTNetInit.notifyColdStartFinish();
            if (r3.z() == null) goto L12;
            String r2 = com.bytedance.ttnet.s.e.f(th);
            if (r2.length() <= 1024) goto L10;
            r2 = r2.substring(0, 1024);
        L10:
            r3.z().f14622i = r2;
            r3.z().f14621h = 10;
            Logger.debug();
        L12:
            return d.f6303b.a().a(r3);
        }
    }

    static {
        a r1 = null;
        f6303b = new C0197d(r1);
        f6304c = new b(r1);
    }

    public static String a() {
        return f6307f;
    }

    public static d.b.h.a.a.h.d b(String r0, boolean r1) {
        if (c() == false) goto L8;
        if (r1 == true) goto L8;
        return f6304c.a();
    L8:
        return f6303b.a();
    }

    public static boolean c() {
        if (f6302a == null) goto L8;
        if (s.l() != 9) goto L8;
        Logger.debug();
        s.v(-1);
    L8:
        if (f6302a != null) goto L14;
        if (com.bytedance.ttnet.j.c.c() == true) goto L14;
        Logger.debug();
        com.bytedance.ttnet.r.c.l().o();
        s.v(9);
        return false;
    L14:
        if (f6302a == null) goto L19;
        if (f6302a.i() == true) goto L19;
        return false;
    L19:
        if (f6305d == true) goto L21;
        return true;
    L21:
        if (f6306e == true) goto L26;
        s.v(7);
        s.u(f6307f);
        return false;
    L26:
        return true;
    }

    public static void d(boolean r0) {
        f6306e = r0;
    }

    public static void e(c r0) {
        f6302a = r0;
    }
}
