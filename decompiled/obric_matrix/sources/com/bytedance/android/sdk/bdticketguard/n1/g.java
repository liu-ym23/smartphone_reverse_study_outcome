package com.bytedance.android.sdk.bdticketguard.n1;

import android.util.Log;
import com.bytedance.android.sdk.bdticketguard.s0;
import com.bytedance.android.sdk.bdticketguard.z0;
import com.bytedance.common.wschannel.WsConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.f0;
import kotlin.n0.c.p;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l[] f888a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<com.bytedance.android.sdk.bdticketguard.n1.b, com.bytedance.android.sdk.bdticketguard.n1.c> f889b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<com.bytedance.android.sdk.bdticketguard.n1.b, ReentrantLock> f890c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<com.bytedance.android.sdk.bdticketguard.n1.b, Long> f892e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final kotlin.h f893f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final kotlin.h f894g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g f895h = null;

    static final class a extends q implements kotlin.n0.c.l<Boolean, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.android.sdk.bdticketguard.n1.b f896f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ p f897g;

        a(com.bytedance.android.sdk.bdticketguard.n1.b r1, p r2) {
            this.f896f = r1;
            this.f897g = r2;
            super(1);
        }

        public final void a(boolean r3) {
            if (r3 == true) goto L4;
            s0.f1065a.e("TicketInitTaskManager", "TicketInitTaskManager doInitialize " + this.f896f + " success \nstackTrace: " + Log.getStackTraceString(new Throwable()));
        L4:
            p r4 = this.f897g;
            if (r4 == null) goto L8;
            f0 r2 = (f0) r4.invoke(this.f896f, com.bytedance.android.sdk.bdticketguard.n1.c.g.f882b);
            return;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Boolean r1) {
            a(r1.booleanValue());
            return f0.f18324a;
        }
    }

    static final class b extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.android.sdk.bdticketguard.n1.b f898f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ p f899g;

        b(com.bytedance.android.sdk.bdticketguard.n1.b r1, p r2) {
            this.f898f = r1;
            this.f899g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            s0.f1065a.b("TicketInitTaskManager", "TicketInitTaskManager doInitialize " + this.f898f + " fail, stackTrace: " + Log.getStackTraceString(new Throwable()));
            p r0 = this.f899g;
            if (r0 == null) goto L6;
            f0 r3 = (f0) r0.invoke(this.f898f, com.bytedance.android.sdk.bdticketguard.n1.c.b.f879b);
            return;
        }
    }

    static final class c extends q implements kotlin.n0.c.a<Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f900f = null;

        static {
            f900f = new c();
        }

        c() {
            super(0);
        }

        public final boolean a() {
            return com.bytedance.android.sdk.bdticketguard.p1.k.f1023J.x().b().booleanValue();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(a());
        }
    }

    static final class d extends q implements kotlin.n0.c.a<Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f901f = null;

        static {
            f901f = new d();
        }

        d() {
            super(0);
        }

        public final boolean a() {
            if (g.f895h.c() == true) goto L5;
        L7:
            return false;
        L5:
            if (com.bytedance.android.sdk.bdticketguard.p1.k.f1023J.y().b().booleanValue() == false) goto L7;
            return true;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(a());
        }
    }

    static {
        int r3 = 0;
        f888a = new kotlin.s0.l[]{e0.g(new y(e0.b(g.class), "enableInitOpt", "getEnableInitOpt()Z")), e0.g(new y(e0.b(g.class), "enableInitRefactor", "getEnableInitRefactor()Z"))};
        f895h = new g();
        f889b = new ConcurrentHashMap();
        f890c = new ConcurrentHashMap();
        f891d = new AtomicBoolean(false);
        f892e = new ConcurrentHashMap();
        f893f = kotlin.i.b(c.f900f);
        f894g = kotlin.i.b(d.f901f);
        com.bytedance.android.sdk.bdticketguard.n1.b[] r0 = com.bytedance.android.sdk.bdticketguard.n1.b.values();
        int r1 = r0.length;
    L3:
        if (r3 >= r1) goto L5;
        com.bytedance.android.sdk.bdticketguard.n1.b r2 = r0[r3];
        f889b.put(r2, com.bytedance.android.sdk.bdticketguard.n1.c.d.f880b);
        f890c.put(r2, new ReentrantLock());
        r3 = r3 + 1;
        goto L3
    }

    private g() {
    }

    private final void a() {
        Collection<com.bytedance.android.sdk.bdticketguard.n1.c> r0 = f889b.values();
        boolean r2 = true;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if ((((com.bytedance.android.sdk.bdticketguard.n1.c) r1.next()) instanceof com.bytedance.android.sdk.bdticketguard.n1.c.f) == true) goto L9;
        r2 = false;
    L13:
        if (r2 == false) goto L19;
        f();
        return;
    L19:
        return;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public final void b(com.bytedance.android.sdk.bdticketguard.n1.b r10, p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, f0> r11, kotlin.n0.c.l<? super com.bytedance.android.sdk.bdticketguard.n1.c.InterfaceC0031c, ? extends com.bytedance.android.sdk.bdticketguard.n1.c.f> r12) {
        o.g(r10, "task");
        o.g(r12, "initAction");
        a r0 = new a(r10, r11);
        b r1 = new b(r10, r11);
        com.bytedance.android.sdk.bdticketguard.n1.c r9 = e(r10);
        com.bytedance.android.sdk.bdticketguard.n1.c.g r13 = com.bytedance.android.sdk.bdticketguard.n1.c.g.f882b;
        if (o.a(r9, r13) == false) goto L6;
        r0.a(true);
        return;
    L6:
        ReentrantLock r14 = f890c.get(r10);
        if (r14 == null) goto L43;
        r14.lock();
        g r3 = f895h;     // Catch: Throwable -> L40
        com.bytedance.android.sdk.bdticketguard.n1.c r4 = r3.e(r10);     // Catch: Throwable -> L40
        if (o.a(r4, r13) == false) goto L14;
        r0.a(true);     // Catch: Throwable -> L40
        r14.unlock();
        return;
    L14:
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L40
        if (o.a(r4, com.bytedance.android.sdk.bdticketguard.n1.c.e.f881b) == false) goto L19;
        com.bytedance.android.sdk.bdticketguard.n1.c.f r15 = r12.invoke(com.bytedance.android.sdk.bdticketguard.n1.c.b.f879b);     // Catch: Throwable -> L40
    L17:
        com.bytedance.android.sdk.bdticketguard.n1.c.f r16 = r15;     // Catch: Throwable -> L40
        f892e.put(r10, Long.valueOf(System.currentTimeMillis() - r5));     // Catch: Throwable -> L40
        if (r16 == null) goto L38;
        r3.g(r10, r16);     // Catch: Throwable -> L40
        if ((r16 instanceof com.bytedance.android.sdk.bdticketguard.n1.c.g) == false) goto L32;
        r0.a(false);     // Catch: Throwable -> L40
    L35:
        f0 r17 = f0.f18324a;     // Catch: Throwable -> L40
        r14.unlock();
        return;
    L32:
        if ((r16 instanceof com.bytedance.android.sdk.bdticketguard.n1.c.b) == false) goto L34;
        r1.invoke2();     // Catch: Throwable -> L40
        goto L35
    L34:
        s0.f1065a.e("TicketInitTaskManager", "TicketInitTaskManager doInitialize " + r10 + " pending");     // Catch: Throwable -> L40
        goto L35
    L38:
        o.p();     // Catch: Throwable -> L40
        throw null;
    L19:
        if ((r4 instanceof com.bytedance.android.sdk.bdticketguard.n1.c.InterfaceC0031c) == true) goto L21;
        r4 = null;
    L21:
        com.bytedance.android.sdk.bdticketguard.n1.c r6 = (com.bytedance.android.sdk.bdticketguard.n1.c.InterfaceC0031c) r4;     // Catch: Throwable -> L40
        if (r6 != null) goto L25;
        r6 = com.bytedance.android.sdk.bdticketguard.n1.c.b.f879b;     // Catch: Throwable -> L40
    L25:
        r15 = r12.invoke(r6);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        r14.unlock();
        throw th;
    L43:
        r1.invoke2();
    }

    public final boolean c() {
        kotlin.h r2 = f893f;
        kotlin.s0.l r0 = f888a[0];
        return ((Boolean) r2.getValue()).booleanValue();
    }

    public final boolean d() {
        kotlin.h r2 = f894g;
        kotlin.s0.l r0 = f888a[1];
        return ((Boolean) r2.getValue()).booleanValue();
    }

    public final com.bytedance.android.sdk.bdticketguard.n1.c e(com.bytedance.android.sdk.bdticketguard.n1.b r1) {
        o.g(r1, "task");
        com.bytedance.android.sdk.bdticketguard.n1.c r0 = f889b.get(r1);
        if (r0 != null) goto L5;
        o.p();
        throw null;
    L5:
        return r0;
    }

    public final void f() {
        int r1 = 0;
        if (f891d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        s0.f1065a.e("TicketInitTaskManager", "TicketInitTaskManager onAllTaskCompleted, taskStates=" + f889b);
        k.c();
        com.bytedance.android.sdk.bdticketguard.n1.b[] r0 = com.bytedance.android.sdk.bdticketguard.n1.b.values();
        int r2 = r0.length;
    L6:
        if (r1 >= r2) goto L12;
        com.bytedance.android.sdk.bdticketguard.n1.b r3 = r0[r1];
        String r4 = r3.b();
        Long r5 = f892e.get(r3);
        if (r5 == null) goto L10;
        long r6 = r5.longValue();
    L11:
        k.f(r4, r6, String.valueOf(f889b.get(r3)));
        r1 = r1 + 1;
        goto L6
    L10:
        r6 = -1;
        goto L11
    L12:
        z0.x(f889b, c());
    }

    public final void g(com.bytedance.android.sdk.bdticketguard.n1.b r3, com.bytedance.android.sdk.bdticketguard.n1.c r4) {
        o.g(r3, "task");
        o.g(r4, WsConstants.KEY_CONNECTION_STATE);
        s0.f1065a.e("TicketInitTaskManager", "TicketInitTaskManager updateInitTaskState. task: " + r3 + ", state: " + r4);
        ReentrantLock r2 = f890c.get(r3);
        if (r2 == null) goto L13;
        r2.lock();
        f889b.put(r3, r4);     // Catch: Throwable -> L10
        if ((r4 instanceof com.bytedance.android.sdk.bdticketguard.n1.c.f) == false) goto L8;
        f895h.a();     // Catch: Throwable -> L10
    L8:
        f0 r5 = f0.f18324a;     // Catch: Throwable -> L10
        r2.unlock();
        return;
    L10:
        th = move-exception;
        r2.unlock();
        throw th;
    }
}
