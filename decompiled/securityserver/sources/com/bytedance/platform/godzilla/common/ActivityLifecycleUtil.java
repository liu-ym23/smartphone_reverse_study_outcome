package com.bytedance.platform.godzilla.common;

import android.app.Activity;
import android.app.Application;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityLifecycleUtil {
    public static final int ACTIVITY_STATE_DESTORY = 3;
    public static final int ACTIVITY_STATE_PAUSE = 1;
    public static final int ACTIVITY_STATE_RESUME = 0;
    public static final int ACTIVITY_STATE_STOP = 2;
    private static Map<Integer, WeakReference<Activity>> mActivityMaps;
    private static WeakReference<Activity> mLastDestoryActivity;
    private static WeakReference<Activity> mLastPauseActivity;
    private static WeakReference<Activity> mLastResumedActivity;
    private static WeakReference<Activity> mLastStopActivity;

    static {
        mActivityMaps = new HashMap();
        mLastResumedActivity = null;
        mLastPauseActivity = null;
        mLastStopActivity = null;
        mLastDestoryActivity = null;
    }

    private ActivityLifecycleUtil() {
    }

    public static /* synthetic */ Map access$000() {
        return mActivityMaps;
    }

    public static Activity getActivity(int r2) {
        if (mActivityMaps.get(Integer.valueOf(r2)) != null) goto L5;
        return null;
    L5:
        return mActivityMaps.get(Integer.valueOf(r2)).get();
    }

    public static void initActivityLifecycle(Application r1) {
        r1.registerActivityLifecycleCallbacks(new AnonymousClass1());
    }
}
