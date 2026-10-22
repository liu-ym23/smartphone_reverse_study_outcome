package com.bytedance.applog.util;

import androidx.core.app.NotificationCompat;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static h f2423a;

    static {
        f2423a = a();
    }

    private static h a() {
        Object r2 = Class.forName("com.bytedance.applog.et_verify.EventVerify").getMethod("inst", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L12 Exception -> L15
        if ((r2 instanceof h) == false) goto L7;
        h r3 = (h) r2;     // Catch: Throwable -> L12 Exception -> L15
    L8:
        if (r3 != null) goto L10;
        n.b("can't find event verify, should compile with ET", null);
    L19:
        return r3;
    L10:
        n.a(r3.toString());
        goto L19
    L7:
        r3 = null;
    L15:
        n.b("can't find event verify, should compile with ET", null);
        return null;
    L12:
        th = move-exception;
        n.b("can't find event verify, should compile with ET", null);
        throw th;
    }

    public static String b(com.bytedance.applog.w.a r1) {
        if ((r1 instanceof com.bytedance.applog.w.c) == false) goto L7;
        return NotificationCompat.CATEGORY_EVENT;
    L7:
        if ((r1 instanceof com.bytedance.applog.w.e) == false) goto L11;
        return "event_v3";
    L11:
        if ((r1 instanceof com.bytedance.applog.w.d) == false) goto L15;
        return "log_data";
    L15:
        if ((r1 instanceof com.bytedance.applog.w.f) == false) goto L19;
        return "launch";
    L19:
        if ((r1 instanceof com.bytedance.applog.w.i) == false) goto L22;
        return "terminate";
    L22:
        return null;
    }

    public static boolean c() {
        h r0 = f2423a;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.a();
    }

    public static void d(String r1, JSONArray r2) {
        h r0 = f2423a;
        if (r0 == null) goto L6;
        r0.b(r1, r2);
        return;
    }
}
