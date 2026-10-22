package com.bytedance.badger.i;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.monitor.TriggerStage;
import kotlin.f0;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
final class b extends q implements kotlin.n0.c.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f2590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ TriggerStage f2591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ com.bytedance.badger.data.e f2592h;

    b(long r1, TriggerStage r3, com.bytedance.badger.data.e r4) {
        this.f2590f = r1;
        this.f2591g = r3;
        this.f2592h = r4;
        super(0);
    }

    @Override // kotlin.n0.c.a
    public Object invoke() {
        long r0 = this.f2590f;
        if (r0 <= 0) goto L6;
        Thread.sleep(r0);
    L6:
        if (this.f2591g != TriggerStage.recollect) goto L8;
        this.f2592h.g(System.currentTimeMillis());
        this.f2592h.f(BadgerCore.Companion.a().getDeviceId());
    L8:
        long r1 = SystemClock.elapsedRealtime();
        long r2 = com.bytedance.badger.h.a.t.m().c();
        g r5 = g.f2604a;     // Catch: Throwable -> L22
        com.bytedance.badger.data.e r6 = this.f2592h;     // Catch: Throwable -> L22
        int r8 = (int) r2;
        com.bytedance.badger.data.a r7 = r5.a(r6, "/passport/device/link/", r8, this.f2591g);     // Catch: Throwable -> L22
        SharedPreferences.Editor r9 = d.b(d.f2597c, null, 1, null).edit();     // Catch: Throwable -> L22
        if (r9 != null) goto L15;
        return null;
    L15:
        if (r7.c() == false) goto L17;
        String r10 = "done";
    L18:
        SharedPreferences.Editor r11 = r9.putString("badger_status", r10);     // Catch: Throwable -> L22
        if (r11 == null) goto L28;
        r11.apply();     // Catch: Throwable -> L22
        return f0.f18324a;
    L28:
        return null;
    L17:
        r10 = "partly";
    L22:
        th = move-exception;
        com.bytedance.badger.monitor.a.f2633a.a(this.f2591g, (int) r2, SystemClock.elapsedRealtime() - r1, th, this.f2592h);
        return f0.f18324a;
    }
}
