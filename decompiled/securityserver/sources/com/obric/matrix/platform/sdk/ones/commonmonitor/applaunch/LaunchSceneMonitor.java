package com.obric.matrix.platform.sdk.ones.commonmonitor.applaunch;

import android.os.SystemClock;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class LaunchSceneMonitor {
    private static final int EXECUTE_TRANSACTION = 159;

    @NotNull
    public static final LaunchSceneMonitor INSTANCE = null;
    private static final int LAUNCH_ACTIVITY = 100;
    public static final int LAUNCH_WITHOUT_ACT = 2;
    public static final int LAUNCH_WITH_MAIN_ACT = 0;
    public static final int LAUNCH_WITH_OTHER_ACT = 1;

    @NotNull
    private static final String TAG = "LaunchSceneMonitor";
    private static long appStartTime;

    @Nullable
    private static String componentName;
    private static int launchScene;

    static {
        INSTANCE = new LaunchSceneMonitor();
        appStartTime = -1;
    }

    private LaunchSceneMonitor() {
    }

    public final long getAppStartTime() {
        return appStartTime;
    }

    @Nullable
    public final String getComponentName() {
        return componentName;
    }

    public final int getLaunchScene() {
        return launchScene;
    }

    public final void inject() {
        appStartTime = SystemClock.elapsedRealtime();
    }

    public final boolean launchWithAct() {
        if (launchScene == 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean launchWithMainAct() {
        if (launchScene != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setAppStartTime(long r1) {
        appStartTime = r1;
    }

    public final void setComponentName(@Nullable String r1) {
        componentName = r1;
    }

    public final void setLaunchScene(int r1) {
        launchScene = r1;
    }
}
