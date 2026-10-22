package com.ss.android.token;

import android.content.Context;
import com.bytedance.android.sdk.bdticketguard.k1;
import com.bytedance.android.sdk.bdticketguard.x0;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements d.b.s.a.q.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile boolean f12295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicBoolean f12296g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final q f12297h = null;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.q<kotlin.v<? extends com.bytedance.android.sdk.bdticketguard.g>, Integer, Boolean, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f12298f = null;

        static {
            f12298f = new a();
        }

        a() {
            super(3);
        }

        public final void a(Object r1, int r2, boolean r3) {
            d.b.s.a.a0.a.d("TokenGuardLoginListener", "startKeyAttestation success, retryCount: " + r2 + ", isLastAttempt: " + r3);
        }

        @Override // kotlin.n0.c.q
        public /* bridge */ /* synthetic */ f0 f(kotlin.v<? extends com.bytedance.android.sdk.bdticketguard.g> r1, Integer r2, Boolean r3) {
            a(r1.i(), r2.intValue(), r3.booleanValue());
            return f0.f18324a;
        }
    }

    static {
        f12297h = new q();
        f12296g = new AtomicBoolean(false);
    }

    private q() {
    }

    private final void a() {
        if (b() == false) goto L16;
        com.bytedance.android.sdk.bdticketguard.p1.k r11 = com.bytedance.android.sdk.bdticketguard.p1.k.f1023J;
        if (r11.A().b().booleanValue() == true) goto L8;
        return;
    L8:
        if (f12296g.compareAndSet(false, true) == true) goto L11;
        d.b.s.a.a0.a.d("TokenGuardLoginListener", "doLoginAttestation, login attestation is triggered");
        return;
    L11:
        k1 r2 = x0.f1087b.a();
        if (r2 == null) goto L14;
        d.b.s.a.a0.a.d("TokenGuardLoginListener", "startKeyAttestation by login");
        r2.j(true, true, 1000, 1000 * r11.K().b().longValue(), r11.J().b().intValue(), a.f12298f);
        return;
    L14:
        d.b.s.a.a0.a.d("TokenGuardLoginListener", "startKeyAttestation service is null");
        return;
    }

    private final boolean b() {
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
    public void F(d.b.s.a.q.b r3) {
        com.ss.android.d r0 = com.ss.android.i.j.l();
        if (r0 == null) goto L15;
        Context r1 = r0.e();
        if (r1 == null) goto L16;
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.f14879a != 0) goto L18;
        d.b.s.a.a0.a.d("TokenGuardLoginListener", "Login status changed, check");
        d.b.s.a.q.f r2 = com.bytedance.sdk.account.impl.g.d(r1);
        kotlin.n0.d.o.b(r2, "BDAccountDelegateInner.instance(context)");
        if (r2.m() == true) goto L12;
        return;
    L12:
        if (f12295f == true) goto L20;
        d.b.s.a.a0.a.d("TokenGuardLoginListener", "Login status changed to login, do login attestation");
        a();
        return;
    L20:
        return;
    L18:
        return;
    L16:
        return;
    }

    public final void c(Context r2) {
        kotlin.n0.d.o.g(r2, "context");
        d.b.s.a.a0.a.d("TokenGuardLoginListener", "registerListeners");
        d.b.s.a.q.f r1 = com.bytedance.sdk.account.impl.g.d(r2);
        r1.b(f12297h);
        kotlin.n0.d.o.b(r1, "it");
        f12295f = r1.m();
    }
}
