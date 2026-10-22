package com.obric.matrix.r.c;

import android.content.Context;
import android.util.Log;
import com.ss.android.agilelogger.ALog;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f9918a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ALog.i f9919b;

    static {
    }

    public static void a(String r2, String r3) {
        if (f9918a == false) goto L5;
        Log.i(r2, "operation_log: " + r3);
    L5:
        ALog.i r0 = f9919b;
        if (r0 == null) goto L9;
        r0.b(r2, r3);
        return;
    }

    public static void b(Context r2, boolean r3) {
        Context r0 = r2.getApplicationContext();
        if (r0 != null) goto L5;
        r0 = r2;
    L5:
        String r4 = r2.getFilesDir().getAbsolutePath() + "/ALOG/OperationLog";
        com.ss.android.agilelogger.a.b r1 = new com.ss.android.agilelogger.a.b(r0);
        r1.f(31457280);
        r1.g(2097152);
        r1.e(20);
        r1.b(r4);
        r1.d(r4);
        if (r3 == false) goto L8;
        int r5 = 2;
    L9:
        r1.c(r5);
        com.ss.android.agilelogger.a r6 = ALog.sConfig;
        ALog.sConfig = null;
        f9919b = ALog.createInstance("Operation", r1.a());
        ALog.sConfig = r6;
        f9918a = r3;
        return;
    L8:
        r5 = 3;
        goto L9
    }
}
