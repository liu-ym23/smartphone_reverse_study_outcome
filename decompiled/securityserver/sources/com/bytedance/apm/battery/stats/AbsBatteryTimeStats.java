package com.bytedance.apm.battery.stats;

import android.os.SystemClock;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.internal.BatteryDataManager;
import com.bytedance.apm.battery.stats.info.BaseHookInfo;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.thread.AsyncEventManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsBatteryTimeStats<T extends BaseHookInfo> extends AbsHookStatsTask<T> implements IBatteryStats {
    private static final Object innerLock = null;
    private volatile int mHoldCount;
    private volatile long mStartTime;
    private int mTotalCount;
    private long mTotalTime;

    static {
        innerLock = new Object();
    }

    public AbsBatteryTimeStats(String r1) {
        super(r1);
        this.mHoldCount = 0;
    }

    public static /* synthetic */ void access$000(AbsBatteryTimeStats r0, long r1, boolean r3, String r4) {
        r0.record(r1, r3, r4);
    }

    private void innerRecord(boolean r7) {
        Object r0 = innerLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mHoldCount > 0) goto L7;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.mStartTime <= 0) goto L14;
        long r1 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        if (r7 == false) goto L13;
        record(r1 - this.mStartTime, this.mIsFront, BatteryCollector.getInstance().getCurSceneSetStr());     // Catch: Throwable -> L11
    L13:
        this.mStartTime = r1;     // Catch: Throwable -> L11
        goto L14
    }

    private void record(long r11, boolean r13, String r14) {
        BatteryLogEntity r9 = new BatteryLogEntity(r13, System.currentTimeMillis(), getType(), this.mIsCharging, r11, r14);
        BatteryDataManager.getInstance().record(r9);
    }

    public void addHolderCount() {
        Object r1 = innerLock;
        monitor-enter(r1);
        ApmAlogHelper.i(Constants.TAG_BATTERY, "addHolderCount:" + this.mHoldCount + " type:" + getType());     // Catch: Throwable -> L7
        this.mHoldCount = this.mHoldCount + 1;     // Catch: Throwable -> L7
        if (this.mHoldCount != 1) goto L9;
        this.mStartTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask
    public void checkStats(T r8, long r9, long r11) {
        this.mTotalCount++;
        long r0 = r8.startTime;
        if (r0 < r9) goto L6;
        r9 = r0;
    L6:
        long r2 = r8.endTime;
        if (r2 > 0) goto L9;
    L12:
        reportSingleIssue(r8, r11 - r0);
        long r12 = r11 - r9;
        if (r12 <= 0) goto L16;
        this.mTotalTime += r12;
        return;
    L16:
        return;
    L9:
        if (r11 < r2) goto L12;
        r11 = r2;
        goto L12
    }

    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask, com.bytedance.apm.battery.stats.IBatteryStats
    public void onBack(boolean r1) {
        innerRecord(r1);
        super.onBack(r1);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onChargeStatusChange(boolean r1, boolean r2) {
        innerRecord(r2);
        this.mIsCharging = r1;
    }

    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask, com.bytedance.apm.battery.stats.IBatteryStats
    public void onFront(boolean r1) {
        innerRecord(r1);
        super.onFront(r1);
    }

    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask
    public void pollingTask(long r9, long r11, boolean r13) {
        this.mTotalCount = 0;
        this.mTotalTime = 0;
        innerRecord(r13);
        super.pollingTask(r9, r11, r13);
        long r10 = System.currentTimeMillis();
        reportAccumulatedIssue(((this.mTotalTime / (r10 - this.mLastPollingTime)) * 60000.0d) * 10.0d, ((((double) this.mTotalCount) / (r10 - this.mLastPollingTime)) * 60000.0d) * 10.0d);
    }

    public void reduceHolderCount() {
        Object r1 = innerLock;
        monitor-enter(r1);
        ApmAlogHelper.i(Constants.TAG_BATTERY, "reduceHolderCount:" + this.mHoldCount + " type:" + getType());     // Catch: Throwable -> L8
        if (this.mHoldCount != 0) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        this.mHoldCount--;     // Catch: Throwable -> L8
        if (this.mHoldCount != 0) goto L13;
        final boolean r0 = this.mIsFront;     // Catch: Throwable -> L8
        final long r2 = SystemClock.elapsedRealtime() - this.mStartTime;     // Catch: Throwable -> L8
        AsyncEventManager.getInstance().post(new AnonymousClass1(this, r2, r0));     // Catch: Throwable -> L8
        this.mStartTime = -1;     // Catch: Throwable -> L8
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public abstract void reportAccumulatedIssue(double r1, double r3);

    public abstract void reportSingleIssue(T r1, long r2);

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void startSceneMonitor(String r1, boolean r2) {
        innerRecord(r2);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void stopSceneMonitor(String r1, boolean r2) {
        innerRecord(r2);
    }
}
