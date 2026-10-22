package com.ss.android.token;

import android.content.Context;
import com.bytedance.android.sdk.bdticketguard.k1;
import com.bytedance.android.sdk.bdticketguard.x0;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.f0;
import kotlin.i0.m0;
import kotlin.n0.d.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements d.b.s.a.q.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicBoolean f12202f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static d.b.s.a.q.f f12203g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ThreadPoolExecutor f12204h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f12205i = null;

    static final class a implements RejectedExecutionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12206a = null;

        static {
            f12206a = new a();
        }

        a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r1, ThreadPoolExecutor r2) {
            d.b.s.a.a0.a.h("AttestSignCompensateTask", "Task rejected: executor is busy");
        }
    }

    static final /* synthetic */ class b extends kotlin.n0.d.l implements kotlin.n0.c.q<kotlin.v<? extends com.bytedance.android.sdk.bdticketguard.g>, Integer, Boolean, f0> {
        b(c r2) {
            super(3, r2);
        }

        @Override // kotlin.n0.c.q
        public /* bridge */ /* synthetic */ f0 f(kotlin.v<? extends com.bytedance.android.sdk.bdticketguard.g> r1, Integer r2, Boolean r3) {
            m(r1.i(), r2.intValue(), r3.booleanValue());
            return f0.f18324a;
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "onAttestationResult";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return e0.b(c.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "onAttestationResult(Ljava/lang/Object;IZ)V";
        }

        public final void m(Object r1, int r2, boolean r3) {
            ((c) this.receiver).e(r1, r2, r3);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.token.c$c, reason: collision with other inner class name */
    static final class RunnableC0318c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f12207f;

        RunnableC0318c(String r1) {
            this.f12207f = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.a(c.f12205i, this.f12207f);
        }
    }

    static {
        f12205i = new c();
        f12202f = new AtomicBoolean(false);
        f12204h = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new SynchronousQueue(), a.f12206a);
    }

    private c() {
    }

    public static final /* synthetic */ void a(c r0, String r1) {
        r0.c(r1);
    }

    private final void c(String r7) {
        d.b.s.a.a0.a.d("AttestSignCompensateTask", "tryCompensate request, scene: " + r7);
        com.ss.android.d r6 = com.ss.android.i.j.l();
        Integer r1 = null;
        if (r6 == null) goto L5;
        String r8 = r6.c();
    L6:
        if (r8 != null) goto L22;
        d.b.s.a.a0.a.b("AttestSignCompensateTask", "tryCompensate, host is null");
        return;
    L22:
        com.ss.android.h r9 = d.b.s.a.l0.l.d(Integer.MAX_VALUE, "https://" + r8 + "/passport/ticket_guard/get_attestkey/?compensate_scene=" + r7, m0.h(), kotlin.i0.r.g(), 0);     // Catch: Exception -> L12
    L14:
        if (r9 != null) goto L16;
    L17:
        StringBuilder r2 = new StringBuilder();
        r2.append("tryCompensate, scene: ");
        r2.append(r7);
        r2.append(", network error: ");
        if (r9 == null) goto L20;
        r1 = Integer.valueOf(r9.c());
    L20:
        r2.append(r1);
        d.b.s.a.a0.a.b("AttestSignCompensateTask", r2.toString());
        return;
    L16:
        if (r9.f() == false) goto L17;
        return;
    L12:
        e = move-exception;
        d.b.s.a.a0.a.c("AttestSignCompensateTask", "tryUpdateSecTime error", e);
        r9 = null;
        goto L14
    L5:
        r8 = null;
        goto L6
    }

    private final boolean d() {
        com.ss.android.d r1 = com.ss.android.i.j.l();
        if (r1 == null) goto L9;
        Context r2 = r1.e();
        if (r2 == null) goto L9;
        if (w.j(r2) != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // d.b.s.a.q.c
    public void F(d.b.s.a.q.b r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.f14879a == 0) goto L6;
        return;
    L6:
        if (d() == false) goto L11;
        d.b.s.a.a0.a.d("AttestSignCompensateTask", "Login status changed, check compensate");
        b("login");
        return;
    }

    public final void b(String r9) {
        kotlin.n0.d.o.g(r9, "scene");
        p r0 = p.K();
        kotlin.n0.d.o.b(r0, "TokenFactory.getInstance()");
        String r1 = r0.U().f12311c;
        kotlin.n0.d.o.b(r1, "TokenFactory.getInstance….tokenObject.attestTsSign");
        d.b.s.a.q.f r2 = f12203g;
        boolean r3 = false;
        if (r2 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        k1 r5 = x0.f1087b.a();
        if (r5 == null) goto L11;
        com.bytedance.android.sdk.bdticketguard.g r6 = r5.f();
    L12:
        if (r6 == null) goto L14;
        boolean r7 = true;
    L15:
        StringBuilder r8 = new StringBuilder();
        r8.append("checkAndCompensate, scene: ");
        r8.append(r9);
        r8.append(", attestSign:");
        if (r1.length() <= 0) goto L18;
        boolean r10 = true;
    L19:
        r8.append(r10);
        r8.append(", ");
        r8.append("isAttestationSuccess:");
        r8.append(r7);
        d.b.s.a.a0.a.d("AttestSignCompensateTask", r8.toString());
        if (r1.length() != 0) goto L22;
        r3 = true;
    L22:
        if (r3 == false) goto L27;
        if (r4 == false) goto L28;
        if (r7 == false) goto L29;
        d.b.s.a.a0.a.d("AttestSignCompensateTask", "checkAndCompensate, scene: " + r9 + ", need compensate");
        g(r9);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L18:
        r10 = false;
        goto L19
    L14:
        r7 = false;
        goto L15
    L11:
        r6 = null;
        goto L12
    L5:
        if (r2.m() != true) goto L7;
        r4 = true;
        goto L8
    }

    public final void e(Object r1, int r2, boolean r3) {
        if (kotlin.v.g(r1) == false) goto L16;
        d.b.s.a.a0.a.d("AttestSignCompensateTask", "onAttestationResult success");
        p r4 = p.K();
        kotlin.n0.d.o.b(r4, "TokenFactory.getInstance()");
        String r5 = r4.U().f12311c;
        kotlin.n0.d.o.b(r5, "TokenFactory.getInstance….tokenObject.attestTsSign");
        if (r5.length() != 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L14;
        d.b.s.a.q.f r7 = f12203g;
        if (r7 == null) goto L14;
        if (r7.m() != true) goto L14;
        g("attest_finish");
        return;
    L14:
        d.b.s.a.a0.a.d("AttestSignCompensateTask", "Looks like we have attestSign now, abort");
        return;
    L7:
        r6 = false;
        goto L8
    }

    public final void f(Context r3) {
        kotlin.n0.d.o.g(r3, "context");
        f12203g = com.bytedance.sdk.account.impl.g.d(r3);
        if (f12202f.compareAndSet(false, true) == true) goto L6;
        d.b.s.a.a0.a.d("AttestSignCompensateTask", "registerAttestationCallback already registered");
        return;
    L6:
        d.b.s.a.a0.a.d("AttestSignCompensateTask", "registerAttestationCallback");
        d.b.s.a.q.f r4 = f12203g;
        if (r4 == null) goto L9;
        r4.b(this);
    L9:
        k1 r5 = x0.f1087b.a();
        if (r5 == null) goto L13;
        r5.h(new b(this));
        return;
    }

    public final void g(String r2) {
        kotlin.n0.d.o.g(r2, "scene");
        d.b.s.a.a0.a.d("AttestSignCompensateTask", "tryCompensate, scene: " + r2);
        f12204h.execute(new RunnableC0318c(r2));
    }
}
