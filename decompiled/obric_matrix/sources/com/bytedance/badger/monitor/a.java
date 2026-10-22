package com.bytedance.badger.monitor;

import com.bytedance.badger.d;
import com.bytedance.badger.data.b;
import com.bytedance.badger.data.e;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Map;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.n0.d.o;
import kotlin.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2633a = null;

    static {
        f2633a = new a();
    }

    private a() {
    }

    public static /* synthetic */ void c(a r10, TriggerStage r11, CollectStage r12, b r13, com.bytedance.badger.data.a r14, int r15, long r16, String r18, int r19, Object r20) {
        if ((r19 & 16) == 0) goto L5;
        int r6 = 0;
    L7:
        if ((r19 & 32) == 0) goto L9;
        long r7 = 0;
    L11:
        if ((r19 & 64) == 0) goto L13;
        String r0 = "";
    L14:
        r10.b(r11, r12, r13, r14, r6, r7, r0);
        return;
    L13:
        r0 = null;
        goto L14
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }

    private final void d(String r3, String r4, String r5, boolean r6, int r7, long r8, boolean r10, String r11, String r12, int r13, String r14) {
        Map r9 = m0.k(new u[]{a0.a("path", r3), a0.a("trigger_stage", r4), a0.a("collect_stage", r5), a0.a(LocationMonitorConst.TIMEOUT, Integer.valueOf(r7)), a0.a("collect_duration", Long.valueOf(r8)), a0.a("logid", r11), a0.a("login_logid", r12), a0.a("errCode", Integer.valueOf(r13)), a0.a("result", Integer.valueOf(r6 ? 1 : 0)), a0.a("errDesc", r14), a0.a("is_full_finished", Integer.valueOf(r10 ? 1 : 0)), a0.a("report_version", 1), a0.a("sdkVersion", "0.0.1-alpha.172"), a0.a("config_version", com.bytedance.badger.h.a.t.l())});
        o.g("badger_detector_report", "eventName");
        o.g(r9, "eventParams");
        d.f("BadgerMonitor", "onEvent: badger_detector_report");     // Catch: Throwable -> L5
        d.f2526b.d("badger_detector_report", new JSONObject(r9));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.c("BadgerMonitor", "Failed to parse event params: " + th.getMessage(), th);
    }

    public final void a(TriggerStage r19, int r20, long r21, Throwable r23, b r24) {
        o.g(r19, "triggerStage");
        o.g(r23, "exception");
        boolean r2 = r23 instanceof com.bytedance.badger.j.a;
        if (r2 == false) goto L5;
        int r4 = ((com.bytedance.badger.j.a) r23).b();
    L6:
        int r16 = r4;
        if (r2 == false) goto L9;
        String r5 = ((com.bytedance.badger.j.a) r23).c();
    L10:
        String r17 = r5;
        if (r2 == false) goto L13;
        CollectStage r0 = ((com.bytedance.badger.j.a) r23).a();
    L14:
        boolean r3 = r24 instanceof e;
        if (r3 == false) goto L17;
        String r6 = ((e) r24).e();
    L18:
        String r7 = r19.name();
        String r8 = r0.name();
        if (r3 == false) goto L21;
        String r15 = ((e) r24).a();
    L22:
        d(r6, r7, r8, false, r20, r21, false, "", r15, r16, r17);
        return;
    L21:
        r15 = "";
        goto L22
    L17:
        r6 = "";
        goto L18
    L13:
        r0 = CollectStage.unknown;
        goto L14
    L9:
        r5 = r23.toString();
        goto L10
    L5:
        r4 = -1000;
        goto L6
    }

    public final void b(TriggerStage r16, CollectStage r17, b r18, com.bytedance.badger.data.a r19, int r20, long r21, String r23) {
        o.g(r16, "triggerStage");
        o.g(r17, "collectStage");
        o.g(r23, "logId");
        boolean r1 = r18 instanceof e;
        if (r1 == false) goto L5;
        String r5 = ((e) r18).e();
    L6:
        String r6 = r16.name();
        String r7 = r17.name();
        if (r19 == null) goto L9;
        boolean r2 = r19.c();
    L10:
        boolean r10 = r2;
        if (r1 == false) goto L13;
        String r12 = ((e) r18).a();
    L14:
        d(r5, r6, r7, true, r20, r21, r10, r23, r12, 0, "");
        return;
    L13:
        r12 = "";
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r5 = "";
        goto L6
    }
}
