package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.ServiceManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ApmAgentService {
    protected static IApmAgent sInstance = null;
    protected static volatile boolean sIsStrictMode = false;

    static {
    }

    protected ApmAgentService() {
    }

    public static void injectService() {
        final IApmAgent r0 = (IApmAgent) Class.forName("com.bytedance.apm.impl.ApmAgentServiceImpl").newInstance();     // Catch: Throwable -> L4
        ServiceManager.registerService(IApmAgent.class, new AnonymousClass1(r0));     // Catch: Throwable -> L4
        return;
    }

    public static void setApmAgentService(IApmAgent r0) {
        sInstance = r0;
    }

    public static void monitorEventSafely(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
        IApmAgent r0 = sInstance;
        if (r0 == null) goto L5;
        r0.monitorEvent(r1, r2, r3, r4);
        return;
    L5:
        if (sIsStrictMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement IApmAgent and set sInstance first");
    }

    public static void monitorLogSafely(String r1, JSONObject r2) {
        IApmAgent r0 = sInstance;
        if (r0 == null) goto L5;
        r0.monitorLog(r1, r2);
        return;
    L5:
        if (sIsStrictMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement IApmAgent and set sInstance first");
    }

    @Deprecated
    public static void monitorStatusRateSafely(String r1, int r2, JSONObject r3) {
        IApmAgent r0 = sInstance;
        if (r0 == null) goto L5;
        r0.monitorStatusRate(r1, r2, r3);
        return;
    L5:
        if (sIsStrictMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement IApmAgent and set sInstance first");
    }

    @Deprecated
    public static void monitorDurationSafely(String r1, JSONObject r2, JSONObject r3) {
        IApmAgent r0 = sInstance;
        if (r0 == null) goto L5;
        r0.monitorDuration(r1, r2, r3);
        return;
    L5:
        if (sIsStrictMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement IApmAgent and set sInstance first");
    }

    @Deprecated
    public static void monitorStatusAndDurationSafely(String r1, int r2, JSONObject r3, JSONObject r4) {
        IApmAgent r0 = sInstance;
        if (r0 == null) goto L5;
        r0.monitorStatusAndDuration(r1, r2, r3, r4);
        return;
    L5:
        if (sIsStrictMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement IApmAgent and set sInstance first");
    }

    public static boolean isImplInjected() {
        if (sInstance == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isIsStrictMode() {
        return sIsStrictMode;
    }

    public static void setIsStrictMode(boolean r0) {
        sIsStrictMode = r0;
    }
}
