package com.bytedance.badger.j;

import android.os.SystemClock;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.monitor.TriggerStage;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.b0;
import kotlin.c0;
import kotlin.m;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f2613a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f2614b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f2615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ScheduledExecutorService f2616d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile ScheduledFuture f2617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f2618f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f2619g = null;

    static {
        f2619g = new f();
        f2613a = new AtomicBoolean(true);
        f2614b = new AtomicBoolean(true);
        f2615c = b.f2610h;
        ScheduledExecutorService r0 = Executors.newSingleThreadScheduledExecutor(d.f2612f);
        o.b(r0, "Executors.newSingleThrea…e\n            }\n        }");
        f2616d = r0;
        f2618f = new Object();
    }

    private f() {
    }

    private final void a() {
        if (f2615c != b.f2610h) goto L6;
        com.bytedance.badger.d.g("BadgerReportHandler", "startTaskForCurrentMode - disabled");
        return;
    L6:
        boolean r0 = f2614b.getAndSet(false);
        int r1 = f2615c.ordinal();
        if (r1 != 0) goto L9;
        com.bytedance.badger.h.a r5 = com.bytedance.badger.h.a.t;
        u r2 = new u(Long.valueOf(r5.i().d()), Long.valueOf(r5.j().d()));
    L17:
        long r6 = ((Number) r2.a()).longValue();
        long r11 = ((Number) r2.b()).longValue();
        if (r0 == true) goto L20;
        long r9 = r11;
    L22:
        if (r9 >= 0) goto L24;
    L28:
        com.bytedance.badger.d.e("BadgerReportHandler", "startTaskForCurrentMode - invalid config");
        return;
    L24:
        if (r11 <= 0) goto L28;
        f2617e = f2616d.scheduleWithFixedDelay(new c(new e(this)), r9, r11, TimeUnit.SECONDS);
        return;
    L20:
        r9 = r6;
        goto L22
    L9:
        if (r1 != 1) goto L11;
        com.bytedance.badger.h.a r7 = com.bytedance.badger.h.a.t;
        r2 = new u(Long.valueOf(r7.g().d()), Long.valueOf(r7.h().d()));
        goto L17
    L11:
        if (r1 != 2) goto L14;
        r2 = new u(-1L, 0L);
        goto L17
    L14:
        throw new m();
    }

    public static final void b(f r25) {
        r25.getClass();
        com.bytedance.badger.h.a r0 = com.bytedance.badger.h.a.t;
        if (r0.p() == true) goto L5;
    L35:
        com.bytedance.badger.d.f("BadgerReportHandler", "executeReport - not enabled");
        return;
    L5:
        if (r0.q() == false) goto L35;
        boolean r1 = r0.e();
        boolean r10 = f2613a.getAndSet(false);
        if (r10 == false) goto L10;
        TriggerStage r3 = TriggerStage.periodic_first;
    L11:
        TriggerStage r12 = r3;
        if (r10 == false) goto L14;
        com.bytedance.badger.h.h r2 = r0.f();
    L15:
        long r5 = r2.c();
        long r15 = SystemClock.elapsedRealtime();
        String r4 = BadgerCore.Companion.a().getDeviceId();
        g r6 = g.f2620a;     // Catch: Exception -> L33
        Charset r7 = kotlin.u0.d.f21429a;     // Catch: Exception -> L33
        if (r4 == null) goto L32;
        byte[] r8 = r4.getBytes(r7);     // Catch: Exception -> L33
        o.b(r8, "(this as java.lang.String).getBytes(charset)");     // Catch: Exception -> L33
        int r9 = g.b(r6, r8, 0, 2, null);     // Catch: Exception -> L33
        c0.b(r9);     // Catch: Exception -> L33
        com.bytedance.badger.d.f("BadgerReportHandler", "executeReport - isFirst: " + r10 + ", triggerStage: " + r12 + ", timeout: " + r5);
        com.bytedance.badger.data.c r11 = new com.bytedance.badger.data.c(c0.j(r9), 23, r4, 0, 8, null);
        com.bytedance.badger.d.f("BadgerReportHandler", "Executing report in mode: " + f2615c + " at " + System.currentTimeMillis());     // Catch: Exception -> L29
        if (r1 == false) goto L27;
        com.bytedance.badger.i.g.f2604a.a(r11, "/passport/dtrait/sinr/", (int) r5, TriggerStage.login_finished);     // Catch: Exception -> L29
    L38:
        return;
    L27:
        com.bytedance.badger.i.g.f2604a.c(r11, "/passport/dtrait/sinr/", (int) r5, TriggerStage.login_finished, r10);     // Catch: Exception -> L29
    L29:
        e = move-exception;
        com.bytedance.badger.d.e("BadgerReportHandler", "Error executing report: " + e.getMessage());
        com.bytedance.badger.monitor.a.f2633a.a(r12, (int) r5, SystemClock.elapsedRealtime() - r15, e, r11);
        return;
    L32:
        throw new b0("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L33
    L33:
        e = move-exception;
        com.bytedance.badger.d.e("BadgerReportHandler", "genChallengeKey - failed to gen challenge key: " + e.getMessage());
        return;
    L14:
        r2 = r0.m();
        goto L15
    L10:
        r3 = TriggerStage.periodic;
        goto L11
    }

    public final void c(boolean r2) {
        com.bytedance.badger.h.a r1 = com.bytedance.badger.h.a.t;
        if (r1.p() == true) goto L5;
    L21:
        com.bytedance.badger.d.f("BadgerReportHandler", "startPeriodicReport - not enabled");
        return;
    L5:
        if (r1.q() == false) goto L21;
        if (r2 == false) goto L9;
        b r3 = b.f2609g;
    L10:
        com.bytedance.badger.d.f("BadgerReportHandler", "updateReportMode - mode: " + r3);
        Object r4 = f2618f;
        monitor-enter(r4);
        f2615c = r3;     // Catch: Throwable -> L18
        ScheduledFuture r5 = f2617e;     // Catch: Throwable -> L18
        if (r5 == null) goto L15;
        r5.cancel(false);     // Catch: Throwable -> L18
    L15:
        f2617e = null;     // Catch: Throwable -> L18
        f2619g.a();     // Catch: Throwable -> L18
        monitor-exit(r4);
        return;
    L18:
        th = move-exception;
        throw th;
    L9:
        r3 = b.f2608f;
        goto L10
    }
}
