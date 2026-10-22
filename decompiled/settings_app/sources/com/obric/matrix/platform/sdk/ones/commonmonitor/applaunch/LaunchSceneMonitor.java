package com.obric.matrix.platform.sdk.ones.commonmonitor.applaunch;

import android.os.SystemClock;
import com.android.launcher3.icons.cache.BaseIconCache;
import kotlin.Metadata;

/* JADX INFO: compiled from: LaunchSceneMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/applaunch/LaunchSceneMonitor;", "", "()V", "EXECUTE_TRANSACTION", "", "LAUNCH_ACTIVITY", "LAUNCH_WITHOUT_ACT", "LAUNCH_WITH_MAIN_ACT", "LAUNCH_WITH_OTHER_ACT", "TAG", "", "appStartTime", "", "getAppStartTime", "()J", "setAppStartTime", "(J)V", BaseIconCache.IconDB.COLUMN_COMPONENT, "getComponentName", "()Ljava/lang/String;", "setComponentName", "(Ljava/lang/String;)V", "launchScene", "getLaunchScene", "()I", "setLaunchScene", "(I)V", "inject", "", "launchWithAct", "", "launchWithMainAct", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LaunchSceneMonitor {
    private static final int EXECUTE_TRANSACTION = 159;
    public static final LaunchSceneMonitor INSTANCE = null;
    private static final int LAUNCH_ACTIVITY = 100;
    public static final int LAUNCH_WITHOUT_ACT = 2;
    public static final int LAUNCH_WITH_MAIN_ACT = 0;
    public static final int LAUNCH_WITH_OTHER_ACT = 1;
    private static final String TAG = "LaunchSceneMonitor";
    private static long appStartTime;
    private static String componentName;
    private static int launchScene;

    private LaunchSceneMonitor() {
    }

    public final int getLaunchScene() {
        return launchScene;
    }

    public final void setLaunchScene(int r1) {
        launchScene = r1;
    }

    public final String getComponentName() {
        return componentName;
    }

    public final void setComponentName(String r1) {
        componentName = r1;
    }

    static {
        INSTANCE = new LaunchSceneMonitor();
        appStartTime = -1;
    }

    public final long getAppStartTime() {
        return appStartTime;
    }

    public final void setAppStartTime(long r1) {
        appStartTime = r1;
    }

    public final void inject() {
        appStartTime = SystemClock.elapsedRealtime();
    }

    public final boolean launchWithMainAct() {
        if (launchScene != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean launchWithAct() {
        if (launchScene == 2) goto L5;
        return true;
    L5:
        return false;
    }
}
