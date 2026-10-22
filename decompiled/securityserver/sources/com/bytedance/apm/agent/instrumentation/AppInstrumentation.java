package com.bytedance.apm.agent.instrumentation;

import androidx.annotation.Keep;
import com.bytedance.apm.agent.monitor.MonitorTool;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class AppInstrumentation {
    private static final String TAG = "AppInstrumentation";
    private static long attachBaseContextEndTime = 0;
    private static long attachBaseContextStartTime = 0;
    private static long constructorEndTime = 0;
    private static long constructorStartTime = 0;
    private static boolean isValid = false;
    private static long launcherActivityCreateEndTime;
    private static long launcherActivityCreateStartTime;
    private static String launcherActivityName;
    private static long launcherActivityOnWindowFocusChangedTime;
    private static long launcherActivityResumeEndTime;
    private static long launcherActivityResumeStartTime;
    private static long onCreateEndTime;
    private static long onCreateStartTime;

    public AppInstrumentation() {
    }

    @Keep
    public static void attachBaseContextEnd() {
        if (attachBaseContextEndTime != 0) goto L6;
        attachBaseContextEndTime = System.currentTimeMillis();
        return;
    }

    @Keep
    public static void attachBaseContextStart() {
        if (attachBaseContextStartTime != 0) goto L6;
        attachBaseContextStartTime = System.currentTimeMillis();
        return;
    }

    @Keep
    public static void initEnd() {
        if (constructorEndTime != 0) goto L6;
        constructorEndTime = System.currentTimeMillis();
        return;
    }

    @Keep
    public static void initStart() {
        if (constructorStartTime != 0) goto L6;
        constructorStartTime = System.currentTimeMillis();
        return;
    }

    @Keep
    public static void launcherActivityOnCreateEnd() {
        if (launcherActivityCreateEndTime == 0) goto L5;
        return;
    L5:
        if (isValid == false) goto L9;
        launcherActivityCreateEndTime = System.currentTimeMillis();
        return;
    }

    @Keep
    public static void launcherActivityOnCreateStart(String r4) {
        if (launcherActivityCreateStartTime != 0) goto L8;
        long r0 = System.currentTimeMillis();
        launcherActivityCreateStartTime = r0;
        if ((r0 - onCreateEndTime) >= 800) goto L9;
        isValid = true;
        launcherActivityName = r4;
        return;
    L9:
        return;
    }

    @Keep
    public static void launcherActivityOnResumeEnd() {
        if (launcherActivityResumeEndTime == 0) goto L5;
        return;
    L5:
        if (isValid == false) goto L9;
        launcherActivityResumeEndTime = System.currentTimeMillis();
        return;
    }

    @Keep
    public static void launcherActivityOnResumeStart(String r4) {
        if (launcherActivityResumeStartTime == 0) goto L5;
        return;
    L5:
        if (isValid == false) goto L9;
        launcherActivityResumeStartTime = System.currentTimeMillis();
        return;
    }

    @Keep
    public static void launcherActivityOnWindowFocusChangedEnd() {
    }

    @Keep
    public static void launcherActivityOnWindowFocusChangedStart(String r12) {
        if (launcherActivityOnWindowFocusChangedTime == 0) goto L5;
        return;
    L5:
        if (onCreateStartTime > 0) goto L7;
        return;
    L7:
        if (isValid == false) goto L20;
        long r2 = System.currentTimeMillis();
        launcherActivityOnWindowFocusChangedTime = r2;
        long r3 = r2 - constructorStartTime;
        if (r3 > 0) goto L11;
        return;
    L11:
        if (r3 >= 15000) goto L22;
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L15
        r6.put("application_constructor", constructorEndTime - constructorStartTime);     // Catch: Exception -> L15
        r6.put("application_attachBaseContext", attachBaseContextEndTime - attachBaseContextStartTime);     // Catch: Exception -> L15
        r6.put("application_onCreate", onCreateEndTime - onCreateStartTime);     // Catch: Exception -> L15
        r6.put("launcher_activity_onCreate", launcherActivityCreateEndTime - launcherActivityCreateStartTime);     // Catch: Exception -> L15
        r6.put("launcher_activity_onResume", launcherActivityResumeEndTime - launcherActivityResumeStartTime);     // Catch: Exception -> L15
        r6.put("app_to_first_activity_windowfocus", r3);     // Catch: Exception -> L15
        r6.put("app_to_first_activity_windowfocus#" + launcherActivityName, r3);     // Catch: Exception -> L15
        r6.put("launcher_activity_onCreate#" + launcherActivityName, launcherActivityCreateEndTime - launcherActivityCreateStartTime);     // Catch: Exception -> L15
        r6.put("launcher_activity_onResume#" + launcherActivityName, launcherActivityResumeEndTime - launcherActivityResumeStartTime);     // Catch: Exception -> L15
        MonitorTool.monitorStart(r6, constructorStartTime, launcherActivityResumeEndTime);     // Catch: Exception -> L15
    L13:
        onCreateStartTime = 0;
        isValid = false;
        return;
    L22:
        return;
    }

    @Keep
    public static void onCreateEnd() {
        if (onCreateEndTime != 0) goto L6;
        onCreateEndTime = System.currentTimeMillis();
        return;
    }

    @Keep
    public static void onCreateStart() {
        if (onCreateStartTime != 0) goto L6;
        onCreateStartTime = System.currentTimeMillis();
        return;
    }
}
