package com.bytedanceos.security;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppExitTrace {
    private static final long MAX_TRACE_TIME = 60000;
    private static final String TAG = "AppExitTrace";
    public static final String TASK_DRH_CONFIGURE_RESOLUTION = "TASK_DRH_CONFIGURE_RESOLUTION";
    public static final String TASK_IHJ_REPORT_INVODE_HISTORY = "TASK_IHJ_REPORT_INVODE_HISTORY";
    public static final String TASK_NRDS_INIT_DATA = "TASK_NRDS_INIT_DATA";
    public static final String TASK_NRDS_INIT_DOZE_DATA = "TASK_NRDS_INIT_DOZE_DATA";
    public static final String TASK_NRDS_UPDATE_DOZE_DATA = "TASK_NRDS_UPDATE_DOZE_DATA";
    private static volatile AppExitTrace sTrace;
    private List<String> mExitTasks;
    private boolean mHasCancel;
    private long mStartTime;

    private AppExitTrace() {
        this.mExitTasks = Collections.synchronizedList(new ArrayList());
    }

    public static AppExitTrace getInstance() {
        if (sTrace != null) goto L16;
        monitor-enter(AppExitTrace.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (sTrace != null) goto L9;
        sTrace = new AppExitTrace();     // Catch: Throwable -> L12
    L9:
        AppExitTrace r1 = sTrace;     // Catch: Throwable -> L12
        monitor-exit(AppExitTrace.class);     // Catch: Throwable -> L12
        return r1;
    L16:
        return sTrace;
    }

    public void init() {
        OLog.e(TAG, "init");
        this.mStartTime = System.currentTimeMillis();
        this.mExitTasks.clear();
    }

    public void addTask(String task) {
        if (task != null) goto L4;
        return;
    L4:
        this.mExitTasks.add(task);
    }

    public void cancelExit() {
        this.mHasCancel = true;
    }

    public static String getCurrentProcessName(Context context) {
        int r0 = Process.myPid();
        ActivityManager r3 = (ActivityManager) context.getSystemService("activity");
        if (r3 == null) goto L11;
        Iterator<ActivityManager.RunningAppProcessInfo> r4 = r3.getRunningAppProcesses().iterator();
    L6:
        if (r4.hasNext() == false) goto L16;
        ActivityManager.RunningAppProcessInfo r1 = r4.next();
        if (r1.pid != r0) goto L6;
        return r1.processName;
    L16:
        return null;
    L11:
        return null;
    }

    public static void printStackTrace() {
        OLog.e(TAG, "printStackTrace:");
        StackTraceElement[] r0 = new Exception().getStackTrace();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        OLog.e(TAG, " -- " + r0[r3].toString());
        r3 = r3 + 1;
        goto L3
    }

    public void finishTask(String task) {
        if (task != null) goto L4;
        return;
    L4:
        if (this.mHasCancel == true) goto L15;
        OLog.e(TAG, "finishTask task = " + task);
        this.mExitTasks.remove(task);
        long r0 = System.currentTimeMillis();
        if (this.mExitTasks.size() == 0) goto L9;
        return;
    L9:
        if ((r0 - this.mStartTime) >= 60000) goto L14;
        forceStopApp();
        this.mHasCancel = true;
        return;
    L14:
        return;
    }

    private void forceStopApp() {
        OLog.e(TAG, "forceStopApp");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        OLog.d(TAG, "forceStopApp exception =" + e);
    }
}
