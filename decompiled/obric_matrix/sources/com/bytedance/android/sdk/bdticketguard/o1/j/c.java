package com.bytedance.android.sdk.bdticketguard.o1.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Base64;
import com.bytedance.android.sdk.bdticketguard.c1;
import com.bytedance.android.sdk.bdticketguard.d1;
import com.bytedance.android.sdk.bdticketguard.f1;
import com.bytedance.android.sdk.bdticketguard.s0;
import com.bytedance.android.sdk.bdticketguard.y0;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.f0;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ l[] f973a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicReference<com.bytedance.android.sdk.bdticketguard.o1.j.b> f974b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReference<com.bytedance.android.sdk.bdticketguard.m1.a> f975c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f976d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f977e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final kotlin.h f978f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ThreadPoolExecutor f979g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f980h = null;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.android.sdk.bdticketguard.m1.a f981f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.l f982g;

        a(com.bytedance.android.sdk.bdticketguard.m1.a r1, kotlin.n0.c.l r2) {
            this.f981f = r1;
            this.f982g = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.sdk.bdticketguard.m1.c r0 = c.a(c.f980h, this.f981f);
            kotlin.n0.c.l r2 = this.f982g;
            if (r2 == null) goto L6;
            f0 r3 = (f0) r2.invoke(r0);
            return;
        }
    }

    static final class b extends q implements kotlin.n0.c.a<SharedPreferences> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f983f = null;

        static {
            f983f = new b();
        }

        b() {
            super(0);
        }

        @Proxy("getSharedPreferences")
        @TargetClass(scope = Scope.SELF, value = "android.content.Context")
        public static SharedPreferences a(Context r0, String r1, int r2) {
            return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
        }

        public final SharedPreferences b() {
            f1 r2 = d1.f706b.a();
            if (r2 == null) goto L9;
            c1 r3 = r2.G();
            if (r3 == null) goto L9;
            Context r4 = r3.e();
            if (r4 == null) goto L9;
            return a(r4, "sp_TicketGuardManager", 0);
        L9:
            return null;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ SharedPreferences invoke() {
            return b();
        }
    }

    static {
        f973a = new l[]{e0.g(new y(e0.b(c.class), "sp", "getSp()Landroid/content/SharedPreferences;"))};
        f980h = new c();
        f974b = new AtomicReference(null);
        f975c = new AtomicReference(null);
        f976d = new AtomicBoolean(false);
        f977e = new Object();
        f978f = kotlin.i.b(b.f983f);
        f979g = new ThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadPoolExecutor.AbortPolicy());
    }

    private c() {
    }

    public static final /* synthetic */ com.bytedance.android.sdk.bdticketguard.m1.c a(c r0, com.bytedance.android.sdk.bdticketguard.m1.a r1) {
        return r0.e(r1);
    }

    private final String b(String r1, com.bytedance.android.sdk.bdticketguard.m1.a r2) {
        g r0 = d.f987d.b(r1);
        byte[] r3 = r2.a();
        if (r3 == null) goto L7;
        String r4 = Base64.encodeToString(r0.i(r3), 2);
        o.b(r4, "Base64.encodeToString(attestSign, Base64.NO_WRAP)");
        return r4;
    L7:
        throw new IllegalStateException("sign content encoded is null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(c r0, com.bytedance.android.sdk.bdticketguard.m1.a r1, kotlin.n0.c.l r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.c(r1, r2);
    }

    private final com.bytedance.android.sdk.bdticketguard.m1.c e(com.bytedance.android.sdk.bdticketguard.m1.a r11) {
        com.bytedance.android.sdk.bdticketguard.m1.a r1 = null;
        com.bytedance.android.sdk.bdticketguard.g r2 = e.f994e.b();     // Catch: Exception -> L5
    L7:
        if (r2 != null) goto L10;
        f975c.set(r11);
        return new com.bytedance.android.sdk.bdticketguard.m1.c.b("", new IllegalStateException("no attestation result"));
    L10:
        AtomicReference<com.bytedance.android.sdk.bdticketguard.o1.j.b> r3 = f974b;
        com.bytedance.android.sdk.bdticketguard.o1.j.b r5 = r3.get();
        if (r5 == null) goto L14;
        r1 = r5.c();
    L14:
        if (o.a(r11, r1) == true) goto L16;
        String r4 = r2.a();
        long r6 = System.nanoTime();     // Catch: Exception -> L20
        String r7 = b(r4, r11);     // Catch: Exception -> L20
        long r8 = System.nanoTime() - r6;     // Catch: Exception -> L20
        com.bytedance.android.sdk.bdticketguard.o1.j.b r9 = new com.bytedance.android.sdk.bdticketguard.o1.j.b(r7, r4, r11);     // Catch: Exception -> L20
        r3.set(r9);     // Catch: Exception -> L20
        j(r9);     // Catch: Exception -> L20
        return new com.bytedance.android.sdk.bdticketguard.m1.c.d(r4, r7, false, r11, r8);
    L20:
        e = move-exception;
        return new com.bytedance.android.sdk.bdticketguard.m1.c.b("", e);
    L16:
        return new com.bytedance.android.sdk.bdticketguard.m1.c.d(r5.a(), r5.b(), true, r11, 0);
    L5:
        r2 = null;
        goto L7
    }

    private final SharedPreferences g() {
        kotlin.h r2 = f978f;
        l r0 = f973a[0];
        return (SharedPreferences) r2.getValue();
    }

    private final void i() {
        SharedPreferences r5 = g();
        if (r5 == null) goto L26;
        String r6 = r5.getString("bd_ticket_guard_attest_sign_cache", "");
        boolean r1 = false;
        if (r6 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L27;
        com.bytedance.android.sdk.bdticketguard.o1.j.b r7 = (com.bytedance.android.sdk.bdticketguard.o1.j.b) y0.a().m(r6, com.bytedance.android.sdk.bdticketguard.o1.j.b.class);     // Catch: Exception -> L19
        if (r7.b().length() <= 0) goto L15;
        r1 = true;
    L15:
        if (r1 == false) goto L17;
        f974b.set(r7);     // Catch: Exception -> L19
        s0.f1065a.e("AttestSignManager", "readFromSp success");     // Catch: Exception -> L19
    L22:
        return;
    L17:
        s0.f1065a.b("AttestSignManager", "readFromSp failed, cache is empty");     // Catch: Exception -> L19
    L19:
        e = move-exception;
        s0.f1065a.c("AttestSignManager", "readFromSp Failed", e);
        return;
    L27:
        return;
    L7:
        if (r6.length() == 0) goto L10;
        r3 = false;
        goto L11
    }

    private final void j(com.bytedance.android.sdk.bdticketguard.o1.j.b r3) {
        SharedPreferences r2 = g();
        if (r2 == null) goto L11;
        String r4 = y0.a().v(r3);     // Catch: Exception -> L6
        r2.edit().putString("bd_ticket_guard_attest_sign_cache", r4).apply();     // Catch: Exception -> L6
        s0.f1065a.e("AttestSignManager", "saveToSp success");     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        s0.f1065a.c("AttestSignManager", "saveTpSp failed", e);
        return;
    }

    public final void c(com.bytedance.android.sdk.bdticketguard.m1.a r9, kotlin.n0.c.l<? super com.bytedance.android.sdk.bdticketguard.m1.c, f0> r10) {
        o.g(r9, "signContent");
        com.bytedance.android.sdk.bdticketguard.o1.j.b r8 = f974b.get();
        if (r8 == null) goto L5;
        com.bytedance.android.sdk.bdticketguard.m1.a r0 = r8.c();
    L7:
        if (o.a(r9, r0) == false) goto L12;
        if (r10 == null) goto L23;
        f0 r11 = r10.invoke(new com.bytedance.android.sdk.bdticketguard.m1.c.d(r8.a(), r8.b(), true, r9, 0));
        return;
    L23:
        return;
    L12:
        if (Build.VERSION.SDK_INT >= 24) goto L21;
        if (r10 == null) goto L24;
        f0 r12 = r10.invoke(new com.bytedance.android.sdk.bdticketguard.m1.c.b("", new IllegalStateException("AttestationSign not supported, android version too low")));
        return;
    L24:
        return;
    L21:
        f979g.submit(new a(r9, r10));     // Catch: RejectedExecutionException -> L18
        return;
    L18:
        if (r10 == null) goto L25;
        f0 r13 = r10.invoke(new com.bytedance.android.sdk.bdticketguard.m1.c.b("Task rejected", new IllegalStateException("Another task is already running")));
        return;
    L25:
        return;
    L5:
        r0 = null;
        goto L7
    }

    public final com.bytedance.android.sdk.bdticketguard.m1.c f() {
        AtomicReference<com.bytedance.android.sdk.bdticketguard.o1.j.b> r8 = f974b;
        if (r8.get() != null) goto L19;
        AtomicBoolean r0 = f976d;
        if (r0.get() == true) goto L19;
        Object r1 = f977e;
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (r8.get() == null) goto L11;
    L13:
        f0 r2 = f0.f18324a;     // Catch: Throwable -> L16
        monitor-exit(r1);
        goto L19
    L11:
        if (r0.compareAndSet(false, true) == false) goto L13;
        f980h.i();     // Catch: Throwable -> L16
    L19:
        com.bytedance.android.sdk.bdticketguard.o1.j.b r9 = r8.get();
        if (r9 == null) goto L23;
        return new com.bytedance.android.sdk.bdticketguard.m1.c.d(r9.a(), r9.b(), true, r9.c(), 0);
    L23:
        return new com.bytedance.android.sdk.bdticketguard.m1.c.b("", new com.bytedance.android.sdk.bdticketguard.m1.c.C0030c());
    }

    public final void h(com.bytedance.android.sdk.bdticketguard.g r6) {
        o.g(r6, "result");
        if (f974b.get() == null) goto L6;
        s0.f1065a.e("AttestSignManager", "handleAttestationResultAvailable, currentCache is not null");
        return;
    L6:
        AtomicReference<com.bytedance.android.sdk.bdticketguard.m1.a> r5 = f975c;
        com.bytedance.android.sdk.bdticketguard.m1.a r1 = r5.getAndSet(null);
        if (r1 == null) goto L10;
        s0.f1065a.e("AttestSignManager", "handleAttestationResultAvailable, create sign with cache: " + r5);
        d(f980h, r1, null, 2, null);
        return;
    }
}
