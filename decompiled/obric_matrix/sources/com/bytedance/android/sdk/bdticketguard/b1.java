package com.bytedance.android.sdk.bdticketguard;

/* JADX INFO: loaded from: classes.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile k1 f699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b1 f700b = null;

    static {
        f700b = new b1();
    }

    private b1() {
    }

    public static final void a(c1 r3) {
        c(r3, false, 2, null);
    }

    public static final void b(c1 r4, boolean r5) {
        kotlin.n0.d.o.g(r4, "ticketGuardInitParam");
        if (f699a != null) goto L19;
        b1 r0 = f700b;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (f699a != null) goto L13;
        s0.f1065a.e("TicketGuardFramework", "ticket guard init");     // Catch: Throwable -> L16
        if (r5 == false) goto L11;
        f1 r6 = new a0();     // Catch: Throwable -> L16
    L12:
        f699a = r6;     // Catch: Throwable -> L16
        x0.f1087b.b(r6);     // Catch: Throwable -> L16
        d1.f706b.b(r6);     // Catch: Throwable -> L16
        r6.T(r4);     // Catch: Throwable -> L16
        goto L13
    L11:
        r6 = new q0();     // Catch: Throwable -> L16
    L13:
        kotlin.f0 r7 = kotlin.f0.f18324a;     // Catch: Throwable -> L16
        monitor-exit(r0);
        return;
    }

    public static /* synthetic */ void c(c1 r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = com.bytedance.android.sdk.bdticketguard.q1.a.f1050c.g(r0.e());
    L5:
        b(r0, r1);
    }

    public static final void d(c1 r3, kotlin.n0.c.l<? super Boolean, kotlin.f0> r4) {
        kotlin.n0.d.o.g(r3, "ticketGuardInitParam");
        com.bytedance.android.sdk.bdticketguard.n1.k.g();
        c(r3, false, 2, null);
        k1 r0 = f699a;
        if (r0 == null) goto L6;
        r0.b(r3, r4);
        return;
    }
}
