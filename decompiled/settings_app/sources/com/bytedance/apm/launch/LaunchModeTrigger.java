package com.bytedance.apm.launch;

import android.content.Intent;
import android.util.Pair;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.trace.LaunchTrace;

/* JADX INFO: loaded from: classes3.dex */
public class LaunchModeTrigger {
    private static Intent firstActivityIntent = null;
    private static String firstLaunchActivityName = "";
    private static boolean isBackground = false;
    private static boolean isRestore = false;
    private static boolean isWalkOnCreate = false;
    private static String lastPauseActivityName = "";
    private static DefaultLaunchMode launchMode;
    private static long onCreateBeginTime;
    private static long onStartBeginTime;

    static {
    }

    public LaunchModeTrigger() {
    }

    static /* synthetic */ String access$002(String r0) {
        firstLaunchActivityName = r0;
        return r0;
    }

    static /* synthetic */ boolean access$102(boolean r0) {
        isBackground = r0;
        return r0;
    }

    static /* synthetic */ boolean access$202(boolean r0) {
        isWalkOnCreate = r0;
        return r0;
    }

    static /* synthetic */ long access$302(long r0) {
        onCreateBeginTime = r0;
        return r0;
    }

    static /* synthetic */ boolean access$402(boolean r0) {
        isRestore = r0;
        return r0;
    }

    static /* synthetic */ String access$502(String r0) {
        lastPauseActivityName = r0;
        return r0;
    }

    static /* synthetic */ long access$602(long r0) {
        onStartBeginTime = r0;
        return r0;
    }

    public static void init() {
        firstActivityIntent = LaunchSceneHelper.getFirstActivityIntent();
        ActivityLifeObserver.getInstance().register(new AnonymousClass1());
    }

    public static Pair<DefaultLaunchMode, Long> getLaunchMode(String r3) {
        if (launchMode != null) goto L19;
        if (firstActivityIntent == null) goto L9;
        launchMode = DefaultLaunchMode.CLOD_LAUNCH;
        return new Pair(launchMode, Long.valueOf(LaunchTrace.getTraceStartTime()));
    L9:
        if (r3.equals(lastPauseActivityName) == true) goto L13;
        launchMode = DefaultLaunchMode.UNKNOWN_LAUNCH;
        return new Pair(launchMode, 0L);
    L13:
        if (r3.equals(firstLaunchActivityName) == true) goto L16;
        launchMode = DefaultLaunchMode.UNKNOWN_LAUNCH;
        return new Pair(launchMode, 0L);
    L16:
        launchMode = DefaultLaunchMode.WARM_LAUNCH;
        return new Pair(launchMode, Long.valueOf(onCreateBeginTime));
    L19:
        if (isBackground == false) goto L37;
        isBackground = false;
        if (r3.equals(lastPauseActivityName) == true) goto L25;
        launchMode = DefaultLaunchMode.UNKNOWN_LAUNCH;
        return new Pair(launchMode, 0L);
    L25:
        if (r3.equals(firstLaunchActivityName) == true) goto L28;
        launchMode = DefaultLaunchMode.UNKNOWN_LAUNCH;
        return new Pair(launchMode, 0L);
    L28:
        boolean r4 = isWalkOnCreate;
        if (r4 == true) goto L31;
    L34:
        if (r4 == true) goto L37;
        launchMode = DefaultLaunchMode.HOT_LAUNCH;
        return new Pair(launchMode, Long.valueOf(onStartBeginTime));
    L31:
        if (isRestore == true) goto L34;
        launchMode = DefaultLaunchMode.WARM_LAUNCH;
        return new Pair(launchMode, Long.valueOf(onCreateBeginTime));
    L37:
        launchMode = DefaultLaunchMode.UNKNOWN_LAUNCH;
        return new Pair(launchMode, 0L);
    }
}
