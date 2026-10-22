package com.bytedance.platform.godzilla;

import android.app.Activity;
import android.app.Application;
import com.bytedance.platform.godzilla.common.ConsumeExceptionHandler;
import com.bytedance.platform.godzilla.common.ILog;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final enum GodzillaCore extends Enum<GodzillaCore> {
    private static final /* synthetic */ GodzillaCore[] $VALUES = null;
    private static final int ACTIVITY_STATE_DESTORY = 3;
    private static final int ACTIVITY_STATE_PAUSE = 1;
    private static final int ACTIVITY_STATE_RESUME = 0;
    private static final int ACTIVITY_STATE_STOP = 2;
    public static final GodzillaCore INSTANCE = null;
    private static final String TAG = "UncaughtExceptionPlugin";
    private static HashMap<Integer, WeakReference<Activity>> mActivityMaps;
    private ConsumeExceptionHandler mConsumeExceptionHandler;
    private WeakReference<Activity> mLastDestoryActivity;
    private WeakReference<Activity> mLastPauseActivity;
    private WeakReference<Activity> mLastResumedActivity;
    private WeakReference<Activity> mLastStopActivity;

    private GodzillaCore(String r1, int r2) {
        super(r1, r2);
        this.mLastResumedActivity = null;
        this.mLastPauseActivity = null;
        this.mLastStopActivity = null;
        this.mLastDestoryActivity = null;
        this.mConsumeExceptionHandler = null;
    }

    public static GodzillaCore valueOf(String r1) {
        return (GodzillaCore) Enum.valueOf(GodzillaCore.class, r1);
    }

    public static GodzillaCore[] values() {
        return (GodzillaCore[]) $VALUES.clone();
    }

    static {
        GodzillaCore r0 = new GodzillaCore("INSTANCE", 0);
        INSTANCE = r0;
        $VALUES = new GodzillaCore[]{r0};
        mActivityMaps = new HashMap();
    }

    public void init(Application r1, ILog r2, Logger.Level r3) {
        if (r2 == null) goto L4;
        Logger.setLog(r2);
    L4:
        if (r3 == null) goto L7;
        Logger.setLogLevel(r3);
        return;
    }

    private void registerExceptionHandlerIfNeed() {
        if (this.mConsumeExceptionHandler != null) goto L5;
        ConsumeExceptionHandler r0 = new ConsumeExceptionHandler();
        this.mConsumeExceptionHandler = r0;
        r0.register();
    L5:
        Logger.i(TAG, "init mConsumeExceptionHandler:" + this.mConsumeExceptionHandler);
    }

    public void addUncaughtExceptionConsumer(UncaughtExceptionConsumer r3) {
        registerExceptionHandlerIfNeed();
        Logger.i(TAG, "add consumer:" + r3);
        this.mConsumeExceptionHandler.addExceptionConsumer(r3);
    }

    public void removeUncaughtExceptionConsumer(UncaughtExceptionConsumer r3) {
        Logger.i(TAG, "remove consumer:" + r3);
        this.mConsumeExceptionHandler.removeExceptionConsumer(r3);
    }

    public void destroy() {
        ConsumeExceptionHandler r0 = this.mConsumeExceptionHandler;
        if (r0 == null) goto L6;
        r0.removeAllExceptionConsumer();
        return;
    }
}
