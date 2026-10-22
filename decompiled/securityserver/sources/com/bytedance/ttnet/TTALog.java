package com.bytedance.ttnet;

import android.util.Log;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.ss.android.agilelogger.ALog;

/* JADX INFO: loaded from: classes.dex */
public class TTALog {
    private static final String TAG = "TTNET_ALog";
    private static volatile long sALogFuncAddr;

    public TTALog() {
    }

    public static /* synthetic */ void a(long r0) {
        lambda$ensureALogInitialized$0(r0);
    }

    private static void ensureALogInitialized() {
        sALogFuncAddr = ALog.getALogWriteFuncAddr();
        Log.i(TAG, "ALog function address is " + sALogFuncAddr);
        if (sALogFuncAddr != 0) goto L6;
        ALog.addNativeFuncAddrCallback(new a());
        return;
    }

    public static long getALogFuncAddr() {
        return sALogFuncAddr;
    }

    private static SsCronetHttpClient getCronetHttpClient() {
        if (HttpClient.isCronetClientEnable() == true) goto L5;
        return null;
    L5:
        return SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext());
    }

    public static void init() {
        ensureALogInitialized();
    }

    private static /* synthetic */ void lambda$ensureALogInitialized$0(long r4) {
        if (sALogFuncAddr == 0) goto L7;
        Log.i(TAG, "ALog function address has initialized.");
        return;
    L7:
        if (r4 != 0) goto L10;
        Log.w(TAG, "Cannot get ALog function address in init callback.");
        return;
    L10:
        sALogFuncAddr = r4;
        Log.i(TAG, "ALog function address is " + sALogFuncAddr + " from callback.");
        SsCronetHttpClient r5 = getCronetHttpClient();     // Catch: Exception -> L15
        if (r5 == null) goto L20;
        r5.setAlogFuncAddr(sALogFuncAddr);     // Catch: Exception -> L15
        return;
    L20:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }
}
