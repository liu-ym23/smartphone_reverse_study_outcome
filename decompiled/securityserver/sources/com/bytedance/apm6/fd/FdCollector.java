package com.bytedance.apm6.fd;

import android.os.Process;
import com.bytedance.apm6.fd.config.FdConfig;
import com.bytedance.apm6.fd.config.IFdConfigService;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.services.apm.api.IFdCheck;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class FdCollector {
    private static final long DEFAULT_DELAY_CHECK_MS = 1200000;
    private static FdCollector instance;
    private FdConfig config;
    private AsyncTask delayTask;
    private IFdCheck fdChecker;
    private volatile boolean isInited;
    private volatile boolean isReady;
    private volatile boolean isStarted;

    static {
        instance = new FdCollector();
    }

    public FdCollector() {
        this.isReady = false;
    }

    public static /* synthetic */ AsyncTask access$000(FdCollector r0) {
        return r0.delayTask;
    }

    public static /* synthetic */ AsyncTask access$002(FdCollector r0, AsyncTask r1) {
        r0.delayTask = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$102(FdCollector r0, boolean r1) {
        r0.isReady = r1;
        return r1;
    }

    public static /* synthetic */ void access$200(FdCollector r0) {
        r0.start();
    }

    public static /* synthetic */ void access$300(FdCollector r0) {
        r0.collect();
    }

    private void collect() {
        if (this.config != null) goto L5;
        return;
    L5:
        ActivityLifecycleService r0 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
        if (r0 == null) goto L8;
        boolean r1 = r0.isForeground();
    L9:
        int r2 = getFdCount();
        if (r2 > 0) goto L12;
    L15:
        IFdCheck r6 = getFdChecker();
        if (r6 != null) goto L18;
        return;
    L18:
        Monitor.record(new FdEvent(r2, r6.getFdList(), r1));
        return;
    L12:
        if (r2 >= this.config.getFdCountThreshold()) goto L15;
        Monitor.record(new FdEvent(r2, null, r1));
        return;
    L8:
        r1 = false;
        goto L9
    }

    private IFdCheck getFdChecker() {
        if (this.fdChecker != null) goto L6;
        this.fdChecker = (IFdCheck) com.bytedance.news.common.service.manager.ServiceManager.getService(IFdCheck.class);
    L6:
        return this.fdChecker;
    }

    private int getFdCount() {
        return new File("/proc/" + Process.myPid() + "/fd").listFiles().length;
    L5:
        return 0;
    }

    public static FdCollector getInstance() {
        return instance;
    }

    private synchronized void start() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.isReady == false) goto L17;
        FdConfig r0 = this.config;     // Catch: Throwable -> L15
        if (r0 == null) goto L17;
        if (r0.isSampled() == false) goto L17;
        if (this.isStarted == true) goto L17;
        this.isStarted = true;     // Catch: Throwable -> L15
        AsyncTaskManager r1 = AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT);     // Catch: Throwable -> L15
        final long r5 = this.config.getCollectIntervalMs();     // Catch: Throwable -> L15
        final long r3 = 0;
        r1.sendTask(new AnonymousClass2(this, r3, r5));     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L17:
        monitor-exit(this);
    }

    public void init() {
        if (this.isInited == false) goto L5;
        return;
    L5:
        this.isInited = true;
        IFdConfigService r0 = (IFdConfigService) ServiceManager.getService(IFdConfigService.class);
        if (r0 == null) goto L8;
        updateConfig(r0.getConfig());
    L8:
        final long r1 = 1200000;
        this.delayTask = new AnonymousClass1(this, r1);
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.delayTask);
    }

    public synchronized void updateConfig(FdConfig r4) {
        monitor-enter(this);
        if (r4 != null) goto L17;
        monitor-exit(this);
        return;
    L17:
        this.config = r4;     // Catch: Throwable -> L10
        if (ApmBaseContext.isDebugMode() == false) goto L12;
        Logger.d(Constants.TAG, "updateConfig:" + r4);     // Catch: Throwable -> L10
    L12:
        start();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
