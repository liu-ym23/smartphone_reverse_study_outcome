package com.slardaros.client.monitor.startup;

import android.text.TextUtils;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
public class AppAgent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f11705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f11706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f11707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f11708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f11709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f11710f;

    public AppAgent() {
    }

    @Keep
    public static void onTrace(String r12, boolean r13) {
        if (TextUtils.equals(r12, "<init>") == false) goto L8;
        if (r13 == false) goto L6;
        f11705a = System.currentTimeMillis();
        return;
    L6:
        f11706b = System.currentTimeMillis();
        return;
    L8:
        if (TextUtils.equals(r12, "attachBaseContext") == false) goto L13;
        if (r13 == false) goto L11;
        f11707c = System.currentTimeMillis();
        return;
    L11:
        f11708d = System.currentTimeMillis();
        return;
    L13:
        if (TextUtils.equals(r12, "onCreate") == false) goto L22;
        if (r13 == false) goto L16;
        f11709e = System.currentTimeMillis();
        return;
    L16:
        long r10 = System.currentTimeMillis();
        f11710f = r10;
        a.a(f11705a, f11706b, f11707c, f11708d, f11709e, r10);
        return;
    }
}
