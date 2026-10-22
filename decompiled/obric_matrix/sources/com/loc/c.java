package com.loc;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f7209b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f7210c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f7211d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7212a;

    final class a extends s1 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f7213g;

        a(c r1) {
            this.f7213g = r1;
        }

        @Override // com.loc.s1
        public final void b() {
            c.c(this.f7213g);
        }
    }

    final class b extends s1 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f7214g;

        b(c r1) {
            this.f7214g = r1;
        }

        @Override // com.loc.s1
        public final void b() {
            c.e(this.f7214g);
        }
    }

    static {
    }

    private c(Context r1) {
        this.f7212a = r1;
    }

    public static c a(Context r2) {
        if (f7209b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7209b != null) goto L9;
        f7209b = new c(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f7209b;
    }

    static /* synthetic */ void c(c r0) {
        r0.d();
    }

    private void d() {
    L23:
        f7210c = false;
        return;
    L4:
        if (f7210c == false) goto L8;
        f7210c = false;
        return;
    L8:
        f7210c = true;     // Catch: Throwable -> L23
        com.loc.a r2 = new com.loc.a(this.f7212a);     // Catch: Throwable -> L23
        new o0();     // Catch: Throwable -> L23
        u0 r3 = o0.c(r2);     // Catch: Throwable -> L23
        if (r3 == null) goto L21;
        byte[] r4 = r3.f7856a;     // Catch: Throwable -> L23
        com.loc.b.d(r4, u5.u("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());     // Catch: Throwable -> L23
        JSONObject r5 = new JSONObject(u5.g(r4));     // Catch: Throwable -> L23
        if (r5.optBoolean("suc") == false) goto L21;
        v5.m(this.f7212a, r2.m);     // Catch: Throwable -> L23
        v5.o(this.f7212a, r2.n);     // Catch: Throwable -> L23
        v5.q(this.f7212a, r2.o);     // Catch: Throwable -> L23
        v5.s(this.f7212a, r2.p);     // Catch: Throwable -> L23
        v5.u(this.f7212a, r2.q);     // Catch: Throwable -> L23
        v5.w(this.f7212a, r2.r);     // Catch: Throwable -> L23
        v5.y(this.f7212a, r2.s);     // Catch: Throwable -> L23
        v5.e(this.f7212a, r2.u);     // Catch: Throwable -> L23
        v5.A(this.f7212a, r2.t);     // Catch: Throwable -> L23
        v5.b(this.f7212a, SystemClock.elapsedRealtime());     // Catch: Throwable -> L23
        String r6 = r5.optString("aaid", "");     // Catch: Throwable -> L23
        String r7 = r5.optString("resetToken", "");     // Catch: Throwable -> L23
        String r0 = r5.optString("uabc", "");     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r6) == true) goto L16;
        v5.g(this.f7212a, r6);     // Catch: Throwable -> L23
    L16:
        if (TextUtils.isEmpty(r7) == true) goto L19;
        v5.k(this.f7212a, r7);     // Catch: Throwable -> L23
    L19:
        if (TextUtils.isEmpty(r0) == true) goto L21;
        v5.i(this.f7212a, r0);     // Catch: Throwable -> L23
    L21:
        f7210c = false;
    }

    static /* synthetic */ void e(c r0) {
        r0.f();
    }

    private void f() {
    L23:
        f7211d = false;
        return;
    L4:
        if (f7211d == false) goto L8;
        f7211d = false;
        return;
    L8:
        f7211d = true;     // Catch: Throwable -> L23
        d r2 = new d(this.f7212a);     // Catch: Throwable -> L23
        new o0();     // Catch: Throwable -> L23
        u0 r3 = o0.c(r2);     // Catch: Throwable -> L23
        if (r3 == null) goto L21;
        byte[] r4 = r3.f7856a;     // Catch: Throwable -> L23
        com.loc.b.d(r4, u5.u("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());     // Catch: Throwable -> L23
        JSONObject r5 = new JSONObject(u5.g(r4));     // Catch: Throwable -> L23
        if (r5.optBoolean("suc") == false) goto L21;
        v5.m(this.f7212a, r2.m);     // Catch: Throwable -> L23
        v5.o(this.f7212a, r2.n);     // Catch: Throwable -> L23
        v5.q(this.f7212a, r2.o);     // Catch: Throwable -> L23
        v5.s(this.f7212a, r2.p);     // Catch: Throwable -> L23
        v5.u(this.f7212a, r2.q);     // Catch: Throwable -> L23
        v5.w(this.f7212a, r2.r);     // Catch: Throwable -> L23
        v5.y(this.f7212a, r2.s);     // Catch: Throwable -> L23
        v5.e(this.f7212a, r2.u);     // Catch: Throwable -> L23
        v5.A(this.f7212a, r2.t);     // Catch: Throwable -> L23
        v5.b(this.f7212a, SystemClock.elapsedRealtime());     // Catch: Throwable -> L23
        String r6 = r5.optString("aaid", "");     // Catch: Throwable -> L23
        String r7 = r5.optString("resetToken", "");     // Catch: Throwable -> L23
        String r0 = r5.optString("uabc", "");     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r6) == true) goto L16;
        v5.g(this.f7212a, r6);     // Catch: Throwable -> L23
    L16:
        if (TextUtils.isEmpty(r7) == true) goto L19;
        v5.k(this.f7212a, r7);     // Catch: Throwable -> L23
    L19:
        if (TextUtils.isEmpty(r0) == true) goto L21;
        v5.i(this.f7212a, r0);     // Catch: Throwable -> L23
    L21:
        f7211d = false;
    }

    public final String b() {
        String r0 = "";
        if (w5.f7948d == false) goto L13;
        r0 = v5.f(this.f7212a);     // Catch: Throwable -> L14
        long r1 = v5.h(this.f7212a);     // Catch: Throwable -> L14
        long r3 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r0) == false) goto L10;
        r1 r2 = r1.f();     // Catch: Throwable -> L14
        s1 r4 = new a(this);     // Catch: Throwable -> L14
    L8:
        r2.d(r4);     // Catch: Throwable -> L14
        goto L13
    L10:
        if ((r3 - r1) <= w5.f7946b) goto L13;
        r2 = r1.f();     // Catch: Throwable -> L14
        r4 = new b(this);     // Catch: Throwable -> L14
    L13:
        return r0;
    }
}
