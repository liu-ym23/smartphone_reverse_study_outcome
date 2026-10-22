package com.bytedance.monitor.collector;

import android.util.Pair;
import androidx.annotation.CallSuper;
import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import com.bytedance.monitor.util.thread.TaskRunnable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
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

    public AbsMonitor(int r3, String r4) {
        this.mState = 0;
        this.mRunMode = 1;
        this.isHyperMode = false;
        this.mCollectorType = r4;
        this.mRunMode = r3;
        PerfMonitorManager.getInstance().addCollector(this);
        this.mAsyncTaskManager = AsyncTaskUtil.getAsyncTaskManagerInstance();
    }

    @CallSuper
    public void destroy() {
        this.mState = -1;
    }

    public Pair<String, ?> dumpInfo() {
        return null;
    }

    public Pair<String, ?> dumpInfosRange(long r1, long r3) {
        return null;
    }

    public void dumpInfosToALog(long r1, long r3, long r5) {
    }

    public String getMonitorType() {
        return this.mCollectorType;
    }

    public final void refreshConfig(final int r2) {
        TaskRunnable r3 = AsyncTaskUtil.wrapLightWeightTask("refreshConfig", new AnonymousClass1(this, r2));
        IAsyncTaskManager r1 = this.mAsyncTaskManager;
        if (r1 == null) goto L6;
        r1.post(r3);
        return;
    }

    @CallSuper
    public void start() {
        if (this.mState < 0) goto L7;
        this.mState = 2;
        return;
    L7:
        throw new IllegalStateException("collector has destroyed, can not start.");
    }

    @CallSuper
    public void startHyperMode() {
        this.isHyperMode = true;
    }

    @CallSuper
    public void stop() {
        this.mState = 1;
    }

    @CallSuper
    public void stopHyperMode() {
        this.isHyperMode = false;
    }

    public abstract void updateConfig(int r1);
}
