package com.bytedance.apm.agent.v2.instrumentation;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.apm.agent.tracing.a;

/* JADX INFO: loaded from: classes.dex */
public class AppAgent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f1282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f1283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f1284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f1285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f1286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f1287f;

    public AppAgent() {
    }

    @Keep
    public static void onTrace(String r12, boolean r13) {
        if (TextUtils.equals(r12, "<init>") == false) goto L8;
        if (r13 == false) goto L6;
        f1282a = System.currentTimeMillis();
        return;
    L6:
        f1283b = System.currentTimeMillis();
        return;
    L8:
        if (TextUtils.equals(r12, "attachBaseContext") == false) goto L13;
        if (r13 == false) goto L11;
        f1284c = System.currentTimeMillis();
        return;
    L11:
        f1285d = System.currentTimeMillis();
        return;
    L13:
        if (TextUtils.equals(r12, "onCreate") == false) goto L22;
        if (r13 == false) goto L16;
        f1286e = System.currentTimeMillis();
        return;
    L16:
        long r10 = System.currentTimeMillis();
        f1287f = r10;
        a.b(f1282a, f1283b, f1284c, f1285d, f1286e, r10);
        return;
    }
}
