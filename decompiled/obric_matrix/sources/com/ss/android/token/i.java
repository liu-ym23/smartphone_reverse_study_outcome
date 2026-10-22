package com.ss.android.token;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.a0;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile j f12214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f12215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f12216c = null;

    static {
        f12216c = new i();
    }

    private i() {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static /* synthetic */ void d(i r6, j r7, j r8, String r9, String r10, String r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        String r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = "";
    L8:
        r6.c(r7, r8, r9, r4, r11);
    }

    public final j b(Context r2) {
        kotlin.n0.d.o.g(r2, "context");
        if (f12215b == true) goto L9;
        j r0 = null;
        String r1 = a(r2, "bd_account_sec_time", 0).getString("sec_time_struct", null);
        if (r1 == null) goto L7;
        r0 = j.f12217f.a(r1);
    L7:
        f12214a = r0;
        f12215b = true;
    L9:
        return f12214a;
    }

    public final void c(j r20, j r21, String r22, String r23, String r24) {
        kotlin.n0.d.o.g(r20, "secTimeStruct");
        kotlin.n0.d.o.g(r22, "scene");
        kotlin.n0.d.o.g(r24, "path");
        String r5 = r20.b();
        long r6 = r20.c();
        long r8 = r20.d();
        long r10 = r20.a();
        if (r21 == null) goto L7;
        String r3 = r21.b();
        if (r3 == null) goto L7;
    L8:
        long r12 = 0;
        if (r21 == null) goto L11;
        long r14 = r21.c();
    L12:
        if (r21 == null) goto L14;
        long r16 = r21.d();
    L15:
        if (r21 == null) goto L17;
        r12 = r21.a();
    L17:
        com.bytedance.sdk.account.monitor.a.c("bd_ticket_guard_sec_ts_update", d.b.s.a.l0.i.a(new kotlin.u[]{a0.a("server_sec_ts", r5), a0.a("server_origin_ts", Long.valueOf(r6)), a0.a("local_ts", Long.valueOf(r8)), a0.a("local_system_run_ts", Long.valueOf(r10)), a0.a("last_server_sec_ts", r3), a0.a("last_server_origin_ts", Long.valueOf(r14)), a0.a("last_local_ts", Long.valueOf(r16)), a0.a("last_local_system_run_ts", Long.valueOf(r12)), a0.a("scene", r22), a0.a("logid", r23), a0.a("path", r24)}));
        return;
    L14:
        r16 = 0;
        goto L15
    L11:
        r14 = 0;
    L7:
        r3 = "";
        goto L8
    }

    public final long e(Context r15, String r16, String r17, long r18, long r20, long r22) {
        kotlin.n0.d.o.g(r15, "context");
        kotlin.n0.d.o.g(r17, "secTime");
        j r1 = f12214a;
        if (r1 == null) goto L5;
        long r4 = r1.c();
    L6:
        long r11 = r4;
        j r13 = new j(r17, r18, r22, r20, d.b.s.a.i0.f.f14823d.a(r15));
        f12214a = r13;
        a(r15, "bd_account_sec_time", 0).edit().putString("sec_time_struct", r13.f()).apply();
        if (r16 == null) goto L9;
        String r7 = r16;
    L10:
        d(this, r13, r1, "interceptor", null, r7, 8, null);
        return r18 - r11;
    L9:
        r7 = "";
        goto L10
    L5:
        r4 = 0;
        goto L6
    }
}
