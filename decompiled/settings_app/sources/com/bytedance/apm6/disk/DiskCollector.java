package com.bytedance.apm6.disk;

import com.bytedance.apm.listener.IStorageCheckListener;
import com.bytedance.apm6.disk.config.DiskConfig;
import com.bytedance.apm6.disk.config.DiskConfigService;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;

/* JADX INFO: loaded from: classes3.dex */
public class DiskCollector {
    private static final String KEY_DISK_CHECK_TIME = "check_disk_last_time";
    private static final String KEY_SP = "monitor_config";
    private static DiskCollector instance;
    private AsyncTask asyncTask;
    private DiskConfig config;
    private volatile boolean isAlreadyCollected;
    private volatile boolean isInited;

    public DiskCollector() {
    }

    static /* synthetic */ DiskConfig access$000(DiskCollector r0) {
        return r0.config;
    }

    static /* synthetic */ AsyncTask access$100(DiskCollector r0) {
        return r0.asyncTask;
    }

    static {
        instance = new DiskCollector();
    }

    public static DiskCollector getInstance() {
        return instance;
    }

    public void init() {
        if (this.isInited == false) goto L5;
        return;
    L5:
        this.isInited = true;
        DiskConfigService r0 = (DiskConfigService) ServiceManager.getService(DiskConfigService.class);
        if (r0 == null) goto L9;
        updateConfig(r0.getConfig());
        return;
    }

    public synchronized void updateConfig(DiskConfig r4) {
        monitor-enter(this);
        if (r4 != null) goto L27;
        monitor-exit(this);
        return;
    L27:
        this.config = r4;     // Catch: Throwable -> L24
        if (ApmContext.isDebugMode() == false) goto L11;
        Logger.d(Constants.TAG, "updateConfig:" + r4);     // Catch: Throwable -> L24
    L11:
        if (this.isInited == true) goto L14;
        monitor-exit(this);
        return;
    L14:
        ActivityLifecycleService r5 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);     // Catch: Throwable -> L24
        if (r5 != null) goto L17;
    L22:
        monitor-exit(this);
        return;
    L17:
        if (r5.isForeground() == true) goto L22;
        collect();     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public void setDiskCheckListener(IStorageCheckListener r1) {
        DiskStatistics.getInstance().setListener(r1);
    }

    private synchronized void collect() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.isAlreadyCollected == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        DiskConfig r0 = this.config;     // Catch: Throwable -> L22
        if (r0 != null) goto L10;
    L20:
        monitor-exit(this);
        return;
    L10:
        if (r0.isSample() == false) goto L20;
        if (ApmContext.isMainProcess() == true) goto L17;
        monitor-exit(this);
        return;
    L17:
        this.isAlreadyCollected = true;     // Catch: Throwable -> L22
        this.asyncTask = new AnonymousClass1(this);     // Catch: Throwable -> L22
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.asyncTask);     // Catch: Throwable -> L22
        monitor-exit(this);
    }
}
