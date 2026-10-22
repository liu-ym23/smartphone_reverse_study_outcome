package com.bytedance.boost_multidex;

import android.os.Looper;
import android.util.Log;
import com.bytedance.bdlocation.client.BDLocationConfig;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class Monitor {
    private static final boolean enableLog = true;
    private static Monitor sMonitor;
    private ScheduledExecutorService mExecutor;
    private String mProcessName;

    public Monitor() {
        this.mExecutor = Executors.newScheduledThreadPool(1);
    }

    static /* synthetic */ ScheduledExecutorService access$000(Monitor r0) {
        return r0.getExecutor();
    }

    static Monitor get() {
        return sMonitor;
    }

    private ScheduledExecutorService getExecutor() {
        return this.mExecutor;
    }

    static void init(Monitor r0) {
        if (r0 != null) goto L5;
        r0 = new Monitor();
    L5:
        sMonitor = r0;
    }

    protected void doAfterInstall(final Runnable r3) {
        Looper.myQueue().addIdleHandler(new AnonymousClass1(this, r3));
    }

    protected void doBeforeHandleOpt() {
        Thread.sleep(BDLocationConfig.sScanBleMaxInterval);     // Catch: InterruptedException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    String getProcessName() {
        return this.mProcessName;
    }

    protected boolean isEnableNativeCheckSum() {
        return true;
    }

    protected void loadLibrary(String r1) {
        System.loadLibrary(r1);
    }

    protected void logDebug(String r1) {
        Log.d(Constants.TAG, r1);
    }

    protected void logError(String r2) {
        Log.println(6, Constants.TAG, r2);
    }

    protected void logError(String r1, Throwable r2) {
        Log.e(Constants.TAG, r1, r2);
    }

    protected void logErrorAfterInstall(String r1, Throwable r2) {
        Log.e(Constants.TAG, r1, r2);
    }

    protected void logInfo(String r1) {
        Log.i(Constants.TAG, r1);
    }

    protected void logWarning(String r1) {
        Log.w(Constants.TAG, r1);
    }

    protected void logWarning(String r1, Throwable r2) {
        Log.w(Constants.TAG, r1, r2);
    }

    protected void reportAfterInstall(long r2, long r4, long r6, String r8) {
        Log.println(4, Constants.TAG, "Cost time: " + r2 + ", free space: " + r4 + ", reduced space: " + r6 + ", holder: " + r8);
    }

    public Monitor setExecutor(ScheduledExecutorService r1) {
        this.mExecutor = r1;
        return this;
    }

    public Monitor setProcessName(String r1) {
        this.mProcessName = r1;
        return this;
    }
}
