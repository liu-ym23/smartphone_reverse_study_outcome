package com.bytedance.badger.i;

import android.os.SystemClock;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.monitor.CollectStage;
import com.bytedance.badger.monitor.TriggerStage;
import java.util.List;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.u;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f2604a = null;

    static {
        f2604a = new g();
    }

    private g() {
    }

    private final String b(String r9, com.bytedance.badger.data.a r10, com.bytedance.badger.data.b r11) {
        com.bytedance.badger.d.f("BadgerNetworkHandler", "sendFollowUpRequest doRequest start");
        com.bytedance.badger.k.b r0 = BadgerCore.Companion.a().getNetRequestInterface();
        String r1 = r0.b();
        if (r1.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        r1 = "aweme.snssdk.com";
    L8:
        String r12 = "https://" + r1 + r9;
        List r3 = r.g();
        u[] r5 = new u[2];
        String r13 = r10.b();
        if (r13 != null) goto L12;
        r13 = "";
    L12:
        r5[0] = a0.a("badger_payload_data", r13);
        r5[1] = a0.a("badger_signal", String.valueOf(r11.b()));
        com.bytedance.badger.k.f r8 = r0.a(new com.bytedance.badger.k.e(r12, r3, m0.k(r5)));     // Catch: Throwable -> L24
        if (r8.c() == false) goto L23;
        if (r8.b() != 200) goto L23;
        String r14 = com.bytedance.badger.k.c.b(r8.a(), "x-tt-logid", false, 2, null);
        if (r14 != null) goto L21;
        return "";
    L21:
        return r14;
    L23:
        throw new com.bytedance.badger.j.a("doPostRequest failed, status: " + r8.b(), -1201, CollectStage.report_finished);
    L24:
        th = move-exception;
        com.bytedance.badger.d.c("BadgerNetworkHandler", "sendFollowUpRequest - doPostRequest failed", th);
        throw new com.bytedance.badger.j.a("doPostRequest failed with exception: " + th.getClass().getName() + ": " + th.getMessage(), -1201, CollectStage.report_finished);
    L5:
        r2 = false;
        goto L6
    }

    private final void d(e r12) {
        com.bytedance.badger.monitor.a r0 = com.bytedance.badger.monitor.a.f2633a;
        TriggerStage r1 = r12.e();
        CollectStage r11 = CollectStage.collect_pre;
        int r5 = r12.d();
        com.bytedance.badger.monitor.a.c(r0, r1, r11, r12.c(), null, r5, 0, null, 96, null);
        if (BadgerCore.Companion.a().initCore() == true) goto L5;
        com.bytedance.badger.d.e("BadgerNetworkHandler", "sendBadgerRequest - BadgerCore init failed");
        throw new com.bytedance.badger.j.a("BadgerCore init failed", BadgerResult.ERROR_SDK_NOT_SUPPORT, r11);
    L5:
        if (k.q(r12.c().getDeviceId()) == true) goto L8;
        return;
    L8:
        throw new com.bytedance.badger.j.a("deviceId is blank", -1101, r11);
    }

    private final void e(e r12, com.bytedance.badger.data.a r13) {
        com.bytedance.badger.monitor.a r0 = com.bytedance.badger.monitor.a.f2633a;
        TriggerStage r1 = r12.e();
        CollectStage r2 = CollectStage.collect_finished;
        int r5 = r12.d();
        long r6 = r12.a();
        com.bytedance.badger.monitor.a.c(r0, r1, r2, r12.c(), r13, r5, r6, null, 64, null);
    }

    private final void f(e r8, Throwable r9, com.bytedance.badger.data.a r10) {
        com.bytedance.badger.monitor.a r0 = com.bytedance.badger.monitor.a.f2633a;
        TriggerStage r1 = r8.e();
        int r2 = r8.d();
        if (r9 == null) goto L6;
    L4:
        Throwable r5 = r9;
        r0.a(r1, r2, r8.a(), r5, r8.c());
        return;
    L6:
        if (r10 == null) goto L8;
        int r7 = r10.a();
    L9:
        r9 = new com.bytedance.badger.j.a("getBadgerReport failed, fullReport empty", r7, CollectStage.collect_finished);
        goto L4
    L8:
        r7 = -1;
        goto L9
    }

    private final void g(e r14, boolean r15) {
        com.bytedance.badger.data.a r1 = null;
        e = null;
        r1 = BadgerCore.Companion.a().getBadgerReportInstantly(r14.c());     // Catch: Exception -> L5
    L6:
        e(r14, r1);
        if (r1 != null) goto L9;
    L20:
        f(r14, e, r1);
        return;
    L9:
        if (r1.a() != 0) goto L20;
        String r11 = b(r14.b(), r1, r14.c());     // Catch: Exception -> L17
        com.bytedance.badger.monitor.a.f2633a.b(r14.e(), CollectStage.report_finished, r14.c(), r1, r14.d(), r14.a(), r11);     // Catch: Exception -> L17
        if (r15 == false) goto L14;
        String r13 = "collectFullReport - timeout upload end";
    L15:
        com.bytedance.badger.d.f("BadgerNetworkHandler", r13);
        return;
    L14:
        r13 = "collectFullReport - full report upload end";
    L17:
        e = move-exception;
        com.bytedance.badger.d.e("BadgerNetworkHandler", "Failed to upload report: " + e.getMessage());
        f(r14, e, r1);
        return;
    L5:
        e = e;
        goto L6
    }

    static /* synthetic */ void h(g r0, e r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.g(r1, r2);
    }

    public final com.bytedance.badger.data.a a(com.bytedance.badger.data.b r11, String r12, int r13, TriggerStage r14) {
        o.g(r11, "request");
        o.g(r12, "path");
        o.g(r14, "triggerStage");
        e r0 = new e(r11, r12, r13, r14, SystemClock.elapsedRealtime());
        d(r0);
        com.bytedance.badger.data.a r15 = BadgerCore.Companion.a().getBadgerReport(r11, r13);
        if (r15 == null) goto L11;
        if (r15.a() != 0) goto L9;
        e(r0, r15);
        String r9 = b(r0.b(), r15, r0.c());
        com.bytedance.badger.monitor.a r1 = com.bytedance.badger.monitor.a.f2633a;
        TriggerStage r2 = r0.e();
        CollectStage r3 = CollectStage.report_finished;
        int r6 = r0.d();
        long r7 = r0.a();
        r1.b(r2, r3, r0.c(), r15, r6, r7, r9);
        com.bytedance.badger.d.f("BadgerNetworkHandler", "sendFollowUpRequest end");
        return r15;
    L9:
        throw new com.bytedance.badger.j.a("getBadgerReport failed", r15.a(), CollectStage.collect_finished);
    L11:
        throw new com.bytedance.badger.j.a("getBadgerReport failed", -1, CollectStage.collect_finished);
    }

    public final void c(com.bytedance.badger.data.b r9, String r10, int r11, TriggerStage r12, boolean r13) {
        o.g(r9, "request");
        o.g(r10, "path");
        o.g(r12, "triggerStage");
        e r0 = new e(r9, r10, r11, r12, SystemClock.elapsedRealtime());
        d(r0);
        if (BadgerCore.Companion.a().awaitUpdateWithFullCallback(r11, new f(r0)) != com.bytedance.badger.data.d.f2541h) goto L7;
        if (r13 == false) goto L8;
        com.bytedance.badger.d.f("BadgerNetworkHandler", "collectFullReport - timeout, doUploadWhenTimeout");
        g(r0, true);
        com.bytedance.badger.d.f("BadgerNetworkHandler", "collectFullReport - timeout upload end");
        return;
    L8:
        return;
    }
}
