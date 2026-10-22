package com.ss.android.account.group_onekey;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Integer> f11724a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<String, String> f11725b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashMap<String, SoftReference<d.b.s.a.d0.s.a>> f11726c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Handler f11727d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final HashMap<String, com.ss.android.account.group_onekey.c.a> f11728e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f11729f = null;

    static {
        f11729f = new a();
        f11724a = new HashMap();
        f11725b = new HashMap();
        f11726c = new HashMap();
        f11727d = new Handler(Looper.getMainLooper());
        f11728e = new HashMap();
    }

    private a() {
    }

    public static /* synthetic */ void b(a r0, String r1, Intent r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.a(r1, r2, r3);
    }

    private final void c(Bundle r1, long r2, long r4) {
        r1.putLong("monitor_start_activity_time", r2);
        r1.putLong("monitor_server_app_callback_time", r4);
    }

    public final void a(String r12, Intent r13, boolean r14) {
        o.g(r12, "challenge");
        o.g(r13, "data");
        long r4 = System.currentTimeMillis();
        f11727d.removeCallbacksAndMessages(null);
        String r11 = f11725b.remove(r12);
        SoftReference<d.b.s.a.d0.s.a> r0 = f11726c.remove(r12);
        f11724a.remove(r12);
        com.ss.android.account.group_onekey.c.a r15 = f11728e.remove(r12);
        if (r0 == null) goto L33;
        d.b.s.a.d0.s.a r6 = r0.get();
        if (r6 == null) goto L34;
        int r1 = r13.getIntExtra("code", -1);
        String r2 = r13.getStringExtra("auth_token");
        if (r1 != 0) goto L20;
        if (r2 != null) goto L10;
    L13:
        boolean r10 = true;
    L14:
        if (r10 == true) goto L20;
        Bundle r16 = new Bundle();
        r16.putString("auth_token", r2);
        r16.putString("token_verifier", r11);
        r16.putBundle("server_app_original_result", r13.getExtras());
        a r3 = f11729f;
        if (r15 == null) goto L18;
        long r5 = r15.a();
    L19:
        r3.c(r16, r5, r4);
        r6.b(r16);
        return;
    L18:
        r5 = 0;
        goto L19
    L10:
        if (r2.length() == 0) goto L13;
        r10 = false;
    L20:
        String r17 = r13.getStringExtra("message");
        Bundle r7 = r13.getExtras();
        if (r7 != null) goto L23;
    L25:
        if (r14 == false) goto L27;
        r1 = -10;
        r17 = "user cancel";
    L27:
        d.b.s.a.d0.s.b r9 = new d.b.s.a.d0.s.b(r1, r17);
        r9.f14707b = r14;
        Bundle r18 = new Bundle();
        r18.putBundle("server_app_original_result", r13.getExtras());
        a r8 = f11729f;
        if (r15 == null) goto L30;
        long r19 = r15.a();
    L31:
        r8.c(r18, r19, r4);
        r9.f14711f = r18;
        r6.a(r9);
        return;
    L30:
        r19 = 0;
        goto L31
    L23:
        if (r7.isEmpty() != true) goto L25;
        r17 = "result intent is empty";
        goto L25
    L34:
        return;
    }
}
