package com.bytedance.apm.npth;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NpthUtil {
    private static boolean hasStart = false;
    private static IMonitorListener sMonitorListener;
    private static INpthCallback sNpthCallback;

    public interface IGetUserData {
        Map<String, String> getUserData();
    }

    public interface IMonitorListener {
        void startMonitor();
    }

    public interface INpthCallback {
        void addAttachUserData(IGetUserData r1);

        void addTags(Map<String, String> r1);
    }

    public NpthUtil() {
    }

    public static void addNpthTags(Map<String, String> r1) {
        INpthCallback r0 = sNpthCallback;
        if (r0 == null) goto L6;
        r0.addTags(r1);
        return;
    }

    public static void addNpthUserData(IGetUserData r1) {
        INpthCallback r0 = sNpthCallback;
        if (r0 == null) goto L6;
        r0.addAttachUserData(r1);
        return;
    }

    public static void setMonitorListener(IMonitorListener r0) {
        sMonitorListener = r0;
    }

    public static void setNpthCallback(INpthCallback r0) {
        sNpthCallback = r0;
    }

    public static void startMonitor() {
        if (hasStart == false) goto L5;
        return;
    L5:
        IMonitorListener r0 = sMonitorListener;
        if (r0 == null) goto L9;
        r0.startMonitor();
        hasStart = true;
        return;
    }
}
