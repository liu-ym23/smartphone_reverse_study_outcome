package com.bytedance.ttnet;

import com.bytedance.frameworks.baselib.network.http.cronet.e.j;
import com.ss.android.agilelogger.ALog;

/* JADX INFO: loaded from: classes.dex */
public class TTALog {
    private static final String TAG = "TTNET_ALog";
    private static volatile long sALogFuncAddr;

    public TTALog() {
    }

    static /* synthetic */ void a(long r4) {
        if (sALogFuncAddr == 0) goto L6;
        return;
    L6:
        if (r4 != 0) goto L8;
        return;
    L8:
        sALogFuncAddr = r4;
        j r5 = getCronetHttpClient();     // Catch: Exception -> L13
        if (r5 == null) goto L16;
        r5.J(sALogFuncAddr);     // Catch: Exception -> L13
        return;
    L16:
        return;
    }

    private static void ensureALogInitialized() {
        sALogFuncAddr = ALog.getALogWriteFuncAddr();
        if (sALogFuncAddr != 0) goto L6;
        ALog.addNativeFuncAddrCallback(a.f6289a);
        return;
    }

    public static long getALogFuncAddr() {
        return sALogFuncAddr;
    }

    private static j getCronetHttpClient() {
        if (d.c() == true) goto L5;
        return null;
    L5:
        return j.w(TTNetInit.getTTNetDepend().getContext());
    }

    public static void init() {
        ensureALogInitialized();
    }
}
