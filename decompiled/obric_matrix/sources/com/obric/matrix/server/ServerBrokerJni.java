package com.obric.matrix.server;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ServerBrokerJni {
    private static final String TAG = "ServerBrokerJni";
    private static volatile boolean isInit = false;
    private static volatile boolean isServerBrokerJniInited = false;

    static {
    }

    public ServerBrokerJni() {
    }

    public static long getPackageVersionCode(Context r1, String r2) {
        return r1.getPackageManager().getPackageInfo(r2, 0).getLongVersionCode();
    L4:
        e = move-exception;
        Log.e(TAG, "getPackageVersionCode failed", e);
        return 0;
    }

    public static String getPackageVersionName(Context r1, String r2) {
        return r1.getPackageManager().getPackageInfo(r2, 0).versionName;
    L4:
        e = move-exception;
        Log.e(TAG, "getPackageVersionName failed", e);
        return "";
    }

    public static byte[] getSignHeaders(boolean r1, String r2, String r3, byte[] r4) {
        return com.obric.matrix.q.g.j.a(r1, r2, "", r3, r4);
    }

    public static synchronized void init(Context r5, String r6) {
        monitor-enter(ServerBrokerJni.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (isInit == false) goto L8;
        monitor-exit(ServerBrokerJni.class);
        return;
    L8:
        com.obric.matrix.platform.c r1 = com.obric.matrix.platform.c.f9489a;     // Catch: Throwable -> L11
        r1.d();     // Catch: Throwable -> L11
        isInit = true;     // Catch: Throwable -> L11
        com.obric.matrix.server.t.b.a.f10022a.e(r5);     // Catch: Throwable -> L11
        com.obric.matrix.server.t.b.b.a(TAG, "init() called with: context = [" + r5 + "], appId = [" + r6 + "]");     // Catch: Throwable -> L11
        initServerBrokerJniInner(r5);     // Catch: Throwable -> L11
        com.obric.matrix.server.t.a.c.f10010a.k(r5, r6);     // Catch: Throwable -> L11
        com.obric.matrix.platform.b.h(r5, r6);     // Catch: Throwable -> L11
        r1.c();     // Catch: Throwable -> L11
        monitor-exit(ServerBrokerJni.class);
    }

    public static void initEventLogForBusiness(Context r1) {
        initServerBrokerJniInner(r1);
        com.obric.matrix.server.t.a.c.f10010a.j(r1);
    }

    private static void initServerBrokerJniInner(Context r1) {
        if (isServerBrokerJniInited == false) goto L5;
        return;
    L5:
        isServerBrokerJniInited = true;
        q.f9994a.l(r1);
    }

    @SuppressLint({"CheckResult"})
    public static void invokeAsync(int r6, String r7, byte[] r8, long r9) {
        q.f9994a.m(r6, r7, r8, r9);
    }

    public static void onEvent(String r2, String r3) {
        JSONObject r0 = new JSONObject(r3);     // Catch: Exception -> L4
    L6:
        com.obric.matrix.server.t.a.c.f10010a.m(r2, r0);
        return;
    L4:
        e = move-exception;
        com.obric.matrix.server.t.b.b.i(TAG, "onEvent json parse error ", e);
        r0 = null;
        goto L6
    }

    public static void onEventForBusiness(String r0, String r1, String r2, String r3) {
        JSONObject r4 = new JSONObject(r3);     // Catch: Exception -> L4
    L6:
        com.obric.matrix.server.t.a.c.f10010a.m(r2, r4);
        return;
    L4:
        e = move-exception;
        com.obric.matrix.server.t.b.b.i(TAG, "onEvent json parse error ", e);
        r4 = null;
        goto L6
    }

    public static void onLog(int r1, String r2, String r3) {
        com.obric.matrix.server.t.b.a.f10022a.b(r1, r2, r3);
    }

    public static native void onNotification(int r0, byte[] r1);

    public static native void onReportTtNetParams(String r0);

    public static native void onResponse(int r0, String r1, byte[] r2, long r3);
}
