package com.bytedance.sdk.account.ticketguard;

import android.content.Context;
import com.bytedance.android.sdk.bdticketguard.p1.k;
import com.ss.android.i.j;
import kotlin.f0;
import kotlin.n0.d.e0;
import kotlin.n0.d.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f5775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f5776b = null;

    static final /* synthetic */ class a extends l implements kotlin.n0.c.a<JSONObject> {
        a(e r2) {
            super(0, r2);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "getTicketGuardSettings";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return e0.b(e.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "getTicketGuardSettings()Lorg/json/JSONObject;";
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ JSONObject invoke() {
            return m();
        }

        public final JSONObject m() {
            return ((e) this.receiver).b();
        }
    }

    static final class b extends q implements kotlin.n0.c.a<Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f5777f = null;

        static {
            f5777f = new b();
        }

        b() {
            super(0);
        }

        public final boolean a() {
            return com.bytedance.sdk.account.ticketguard.f.p();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(a());
        }
    }

    static final class c extends q implements kotlin.n0.c.a<Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f5778f = null;

        static {
            f5778f = new c();
        }

        c() {
            super(0);
        }

        public final boolean a() {
            return com.bytedance.sdk.account.ticketguard.f.j().a();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(a());
        }
    }

    static final class d extends q implements kotlin.n0.c.a<Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f5779f = null;

        static {
            f5779f = new d();
        }

        d() {
            super(0);
        }

        public final boolean a() {
            return com.bytedance.sdk.account.ticketguard.f.j().g();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(a());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.account.ticketguard.e$e, reason: collision with other inner class name */
    static final class C0185e extends q implements kotlin.n0.c.a<Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0185e f5780f = null;

        static {
            f5780f = new C0185e();
        }

        C0185e() {
            super(0);
        }

        public final boolean a() {
            return com.bytedance.sdk.account.ticketguard.f.j().b();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(a());
        }
    }

    static final class f extends q implements kotlin.n0.c.a<Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f5781f = null;

        static {
            f5781f = new f();
        }

        f() {
            super(0);
        }

        public final boolean a() {
            return com.bytedance.sdk.account.ticketguard.f.j().h();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(a());
        }
    }

    static final class g extends q implements kotlin.n0.c.a<Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final g f5782f = null;

        static {
            f5782f = new g();
        }

        g() {
            super(0);
        }

        public final boolean a() {
            return com.bytedance.sdk.account.ticketguard.f.j().c();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(a());
        }
    }

    static {
        f5776b = new e();
    }

    private e() {
    }

    private final void a() {
        d.b.s.a.a0.a.d("TicketGuardSettingsInit", "doInit start");
        d();
        k r0 = k.f1023J;
        r0.f(new a(this));
        r0.V(r0.d(b.f5777f));
        r0.S(r0.d(c.f5778f));
        r0.U(r0.d(d.f5779f));
        r0.Q(r0.d(C0185e.f5780f));
        r0.T(r0.d(f.f5781f));
        r0.R(r0.d(g.f5782f));
    }

    public final JSONObject b() {
        com.ss.android.d r2 = j.l();
        if (r2 == null) goto L5;
        Context r3 = r2.e();
    L6:
        if (r3 == null) goto L8;
        d.b.s.a.d0.r.a r4 = com.bytedance.sdk.account.impl.g.b(r3);
        o.b(r4, "BDAccountDelegateInner.getSettingsInstance(it)");
        JSONObject r5 = r4.b();
    L9:
        if (r5 != null) goto L11;
        return null;
    L11:
        return r5.optJSONObject("bd_ticket_guard_config");
    L8:
        r5 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public final void c() {
        if (f5775a == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (f5775a == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        f5776b.a();     // Catch: Throwable -> L13
        f5775a = true;     // Catch: Throwable -> L13
        f0 r0 = f0.f18324a;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public final void d() {
        monitor-enter(this);
        com.ss.android.d r0 = j.l();     // Catch: Throwable -> L14
        JSONObject r1 = null;
        if (r0 == null) goto L6;
        Context r2 = r0.e();     // Catch: Throwable -> L14
    L7:
        if (r2 == null) goto L9;
        d.b.s.a.d0.r.a r3 = com.bytedance.sdk.account.impl.g.b(r2);     // Catch: Throwable -> L14
        o.b(r3, "BDAccountDelegateInner.getSettingsInstance(it)");     // Catch: Throwable -> L14
        r1 = r3.b();     // Catch: Throwable -> L14
    L9:
        if (r1 == null) goto L11;
        JSONObject r4 = r1.optJSONObject("bd_ticket_guard_config");     // Catch: Throwable -> L14
        d.b.s.a.a0.a.d("TicketGuardSettingsInit", "onAccountSettingsUpdate, settings changed: " + r4);     // Catch: Throwable -> L14
        f5776b.e(r4);     // Catch: Throwable -> L14
    L11:
        f0 r5 = f0.f18324a;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L6:
        r2 = null;
    L14:
        th = move-exception;
        throw th;
    }

    public final void e(JSONObject r1) {
        k.f1023J.k(r1);
    }
}
