package com.ttnet.org.chromium.base.jank_tracker;

import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.build.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
class FrameMetricsStore {
    private final Object mLock;

    @GuardedBy
    private final HashMap<Integer, Long> mScenarioPreviousFrameTimestampNs;

    @GuardedBy
    private final ArrayList<Integer> mSkippedFrames;

    @GuardedBy
    private final ArrayList<Long> mTimestampsNs;

    @GuardedBy
    private final ArrayList<Long> mTotalDurationsNs;

    public FrameMetricsStore() {
        this.mLock = new Object();
        this.mTimestampsNs = new ArrayList();
        this.mTotalDurationsNs = new ArrayList();
        this.mSkippedFrames = new ArrayList();
        this.mScenarioPreviousFrameTimestampNs = new HashMap();
    }

    @GuardedBy
    private long findFirstUsedTimestamp() {
        Iterator<Long> r5 = this.mScenarioPreviousFrameTimestampNs.values().iterator();
        long r0 = Long.MAX_VALUE;
    L4:
        if (r5.hasNext() == false) goto L8;
        long r2 = r5.next().longValue();
        if (r2 >= r0) goto L4;
        r0 = r2;
        goto L4
    L8:
        return r0;
    }

    @GuardedBy
    private void removeUnusedFrames() {
        if (this.mScenarioPreviousFrameTimestampNs.isEmpty() == false) goto L6;
        this.mTimestampsNs.clear();
        this.mTotalDurationsNs.clear();
        this.mSkippedFrames.clear();
        return;
    L6:
        long r0 = findFirstUsedTimestamp();
        if (r0 != 0) goto L9;
        return;
    L9:
        int r1 = this.mTimestampsNs.indexOf(Long.valueOf(r0));
        if (r1 == (-1)) goto L12;
        this.mTimestampsNs.subList(0, r1).clear();
        this.mTotalDurationsNs.subList(0, r1).clear();
        this.mSkippedFrames.subList(0, r1).clear();
        return;
    L12:
        if (BuildConfig.ENABLE_ASSERTS == true) goto L15;
        return;
    L15:
        throw new IllegalStateException("Timestamp for tracked scenario not found");
    }

    public void addFrameMeasurement(long r3, long r5, int r7) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mScenarioPreviousFrameTimestampNs.isEmpty() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mTimestampsNs.add(Long.valueOf(r3));     // Catch: Throwable -> L8
        this.mTotalDurationsNs.add(Long.valueOf(r5));     // Catch: Throwable -> L8
        this.mSkippedFrames.add(Integer.valueOf(r7));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    @VisibleForTesting
    public FrameMetrics getAllStoredMetricsForTesting() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList<Long> r1 = this.mTimestampsNs;     // Catch: Throwable -> L7
        Long[] r2 = (Long[]) r1.toArray(new Long[r1.size()]);     // Catch: Throwable -> L7
        ArrayList<Long> r3 = this.mTotalDurationsNs;     // Catch: Throwable -> L7
        Long[] r4 = (Long[]) r3.toArray(new Long[r3.size()]);     // Catch: Throwable -> L7
        ArrayList<Integer> r5 = this.mSkippedFrames;     // Catch: Throwable -> L7
        FrameMetrics r6 = new FrameMetrics(r2, r4, (Integer[]) r5.toArray(new Integer[r5.size()]));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r6;
    L7:
        th = move-exception;
        throw th;
    }

    public void startTrackingScenario(int r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mScenarioPreviousFrameTimestampNs.containsKey(Integer.valueOf(r4)) == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Long r1 = 0L;     // Catch: Throwable -> L8
        if (this.mTimestampsNs.isEmpty() == true) goto L13;
        ArrayList<Long> r2 = this.mTimestampsNs;     // Catch: Throwable -> L8
        r1 = r2.get(r2.size() - 1);     // Catch: Throwable -> L8
    L13:
        this.mScenarioPreviousFrameTimestampNs.put(Integer.valueOf(r4), r1);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public FrameMetrics stopTrackingScenario(int r7) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Long r8 = this.mScenarioPreviousFrameTimestampNs.remove(Integer.valueOf(r7));     // Catch: Throwable -> L9
        if (r8 != null) goto L12;
        FrameMetrics r6 = new FrameMetrics();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r6;
    L12:
        if (r8.longValue() != 0) goto L14;
        int r9 = 0;
    L19:
        int r1 = this.mTimestampsNs.size();     // Catch: Throwable -> L9
        int r2 = r1 - r9;     // Catch: Throwable -> L9
        FrameMetrics r3 = new FrameMetrics((Long[]) this.mTimestampsNs.subList(r9, r1).toArray(new Long[r2]), (Long[]) this.mTotalDurationsNs.subList(r9, r1).toArray(new Long[r2]), (Integer[]) this.mSkippedFrames.subList(r9, r1).toArray(new Integer[r2]));     // Catch: Throwable -> L9
        removeUnusedFrames();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L14:
        r9 = this.mTimestampsNs.indexOf(r8) + 1;     // Catch: Throwable -> L9
        if (r9 < this.mTimestampsNs.size()) goto L19;
        FrameMetrics r10 = new FrameMetrics();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r10;
    L9:
        th = move-exception;
        throw th;
    }
}
