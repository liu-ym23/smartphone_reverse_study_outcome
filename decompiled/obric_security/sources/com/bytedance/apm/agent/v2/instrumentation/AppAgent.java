package com.bytedance.apm.agent.v2.instrumentation;

import android.text.TextUtils;
import com.bytedance.apm.agent.tracing.AutoLaunchTraceHelper;

/* JADX INFO: loaded from: classes.dex */
public class AppAgent {
    private static final String ATTACH_BASE_CONTEXT = "attachBaseContext";
    private static final String CONSTRUCT = "<init>";
    private static final String ON_CREATE = "onCreate";
    private static long attachBaseContextEndTime;
    private static long attachBaseContextStartTime;
    private static long constructorEndTime;
    private static long constructorStartTime;
    private static long onCreateEndTime;
    private static long onCreateStartTime;

    public AppAgent() {
    }

    public static void onTrace(String r12, boolean r13) {
        if (TextUtils.equals(r12, CONSTRUCT) == false) goto L8;
        if (r13 == false) goto L6;
        constructorStartTime = System.currentTimeMillis();
        return;
    L6:
        constructorEndTime = System.currentTimeMillis();
        return;
    L8:
        if (TextUtils.equals(r12, ATTACH_BASE_CONTEXT) == false) goto L13;
        if (r13 == false) goto L11;
        attachBaseContextStartTime = System.currentTimeMillis();
        return;
    L11:
        attachBaseContextEndTime = System.currentTimeMillis();
        return;
    L13:
        if (TextUtils.equals(r12, "onCreate") == false) goto L22;
        if (r13 == false) goto L16;
        onCreateStartTime = System.currentTimeMillis();
        return;
    L16:
        long r10 = System.currentTimeMillis();
        onCreateEndTime = r10;
        AutoLaunchTraceHelper.assignAppTime(constructorStartTime, constructorEndTime, attachBaseContextStartTime, attachBaseContextEndTime, onCreateStartTime, r10);
        return;
    }
}
