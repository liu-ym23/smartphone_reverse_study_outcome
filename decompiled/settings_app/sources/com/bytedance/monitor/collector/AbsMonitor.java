package com.bytedance.monitor.collector;

import android.util.Pair;
import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import com.bytedance.monitor.util.thread.TaskRunnable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsMonitor {
    protected volatile boolean isHyperMode;
    protected IAsyncTaskManager mAsyncTaskManager;
    protected String mCollectorType;
    protected int mRunMode;
    protected int mState;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RunMode {
        public static final int ASCRIBE = 3;
        public static final int NORMAL = 1;
        public static final int OFFLINE = 2;
        public static final int TURNOFF = 0;
    }

    Pair<String, ?> dumpInfo() {
        return null;
    }

    Pair<String, ?> dumpInfosRange(long r1, long r3) {
        return null;
    }

    void dumpInfosToALog(long r1, long r3, long r5) {
    }

    protected abstract void updateConfig(int r1);

    public AbsMonitor(int r3, String r4) {
        this.mState = 0;
        this.mRunMode = 1;
        this.isHyperMode = false;
        this.mCollectorType = r4;
        this.mRunMode = r3;
        PerfMonitorManager.getInstance().addCollector(this);
        this.mAsyncTaskManager = AsyncTaskUtil.getAsyncTaskManagerInstance();
    }

    public String getMonitorType() {
        return this.mCollectorType;
    }

    void start() {
        if (this.mState < 0) goto L7;
        this.mState = 2;
        return;
    L7:
        throw new IllegalStateException("collector has destroyed, can not start.");
    }

    void stop() {
        this.mState = 1;
    }

    void startHyperMode() {
        this.isHyperMode = true;
    }

    void stopHyperMode() {
        this.isHyperMode = false;
    }

    public final void refreshConfig(final int r2) {
        TaskRunnable r3 = AsyncTaskUtil.wrapLightWeightTask("refreshConfig", new AnonymousClass1(this, r2));
        IAsyncTaskManager r1 = this.mAsyncTaskManager;
        if (r1 == null) goto L6;
        r1.post(r3);
        return;
    }

    void destroy() {
        this.mState = -1;
    }
}
