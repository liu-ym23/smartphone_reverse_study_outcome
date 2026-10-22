package com.bytedance.apm.battery.stats;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.stats.info.BaseHookInfo;
import com.bytedance.apm.battery.util.BatteryUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsHookStatsTask<T extends BaseHookInfo> implements IBatteryStats {
    ConcurrentHashMap<Integer, T> mDetectMap;
    volatile boolean mIsCharging;
    volatile boolean mIsFront;
    volatile long mLastPollingTime;
    private final String mType;

    protected abstract void checkStats(T r1, long r2, long r4);

    AbsHookStatsTask(String r3) {
        this.mDetectMap = new ConcurrentHashMap();
        this.mType = r3;
        this.mIsFront = ActivityLifeObserver.getInstance().isForeground();
        this.mLastPollingTime = System.currentTimeMillis();
        this.mIsCharging = BatteryUtils.isCharging(ApmContext.getContext());
    }

    public String getType() {
        return this.mType;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onFront(boolean r1) {
        this.mIsFront = true;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onBack(boolean r1) {
        this.mIsFront = false;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onTimer(boolean r9) {
        long r6 = System.currentTimeMillis();
        if (this.mDetectMap.size() == 0) goto L5;
        pollingTask(this.mLastPollingTime, r6, r9);
    L5:
        this.mLastPollingTime = r6;
    }

    protected void pollingTask(long r8, long r10, boolean r12) {
        Iterator<Map.Entry<Integer, T>> r13 = this.mDetectMap.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L19;
        T r2 = r13.next().getValue();
        if (0 >= r2.endTime) goto L11;
        if (r2.endTime >= r2.startTime) goto L11;
        r13.remove();
    L11:
        if (0 >= r2.endTime) goto L16;
        if (r2.endTime >= r8) goto L16;
        r13.remove();
    L16:
        if (r10 < r2.startTime) goto L4;
        checkStats(r2, r8, r10);
        goto L4
    }
}
