package com.ttnet.org.chromium.base.metrics;

import a.a;
import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bytedance.keva.KevaImpl;
import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.build.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
final class CachingUmaRecorder implements UmaRecorder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_HISTOGRAM_COUNT = 256;

    @VisibleForTesting
    static final int MAX_USER_ACTION_COUNT = 256;
    private static final String TAG = "CachingUmaRecorder";

    @Nullable
    @GuardedBy
    private UmaRecorder mDelegate;
    private AtomicInteger mDroppedHistogramSampleCount;

    @GuardedBy
    private int mDroppedUserActionCount;

    @GuardedBy
    private Map<String, Histogram> mHistogramByName;
    private final ReentrantReadWriteLock mRwLock;

    @Nullable
    @GuardedBy
    private List<Callback<String>> mUserActionCallbacksForTesting;

    @GuardedBy
    private List<UserAction> mUserActions;

    @VisibleForTesting
    public static class Histogram {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @VisibleForTesting
        static final int MAX_SAMPLE_COUNT = 256;
        private final int mMax;
        private final int mMin;
        private final String mName;
        private final int mNumBuckets;

        @GuardedBy
        private final List<Integer> mSamples;
        private final int mType;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
            public static final int BOOLEAN = 1;
            public static final int EXPONENTIAL = 2;
            public static final int LINEAR = 3;
            public static final int SPARSE = 4;
        }

        public Histogram(int r1, String r2, int r3, int r4, int r5) {
            this.mType = r1;
            this.mName = r2;
            this.mMin = r3;
            this.mMax = r4;
            this.mNumBuckets = r5;
            this.mSamples = new ArrayList(1);
        }

        public static /* synthetic */ List access$000(Histogram r0) {
            return r0.mSamples;
        }

        public synchronized boolean addSample(int r1, String r2, int r3, int r4, int r5, int r6) {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (this.mSamples.size() < 256) goto L9;
            monitor-exit(this);
            return false;
        L9:
            this.mSamples.add(Integer.valueOf(r3));     // Catch: Throwable -> L13
            monitor-exit(this);
            return true;
        }

        public synchronized int flushTo(UmaRecorder r9) {
            monitor-enter(this);
            int r0 = this.mType;     // Catch: Throwable -> L15
            int r1 = 0;
            if (r0 != 1) goto L6;
            int r2 = 0;
        L25:
            if (r2 >= this.mSamples.size()) goto L31;
            int r3 = this.mSamples.get(r2).intValue();     // Catch: Throwable -> L15
            String r4 = this.mName;     // Catch: Throwable -> L15
            if (r3 == 0) goto L29;
            boolean r5 = true;
        L30:
            r9.recordBooleanHistogram(r4, r5);     // Catch: Throwable -> L15
            r2 = r2 + 1;     // Catch: Throwable -> L15
            goto L25
        L29:
            r5 = false;
        L31:
            int r10 = this.mSamples.size();     // Catch: Throwable -> L15
            this.mSamples.clear();     // Catch: Throwable -> L15
            monitor-exit(this);
            return r10;
        L6:
            if (r0 == 2) goto L21;
            if (r0 == 3) goto L18;
            if (r0 != 4) goto L31;
        L13:
            if (r1 >= this.mSamples.size()) goto L31;
            r9.recordSparseHistogram(this.mName, this.mSamples.get(r1).intValue());     // Catch: Throwable -> L15
            r1 = r1 + 1;     // Catch: Throwable -> L15
        L18:
            if (r1 >= this.mSamples.size()) goto L31;
            r9.recordLinearHistogram(this.mName, this.mSamples.get(r1).intValue(), this.mMin, this.mMax, this.mNumBuckets);     // Catch: Throwable -> L15
            r1 = r1 + 1;     // Catch: Throwable -> L15
        L21:
            if (r1 >= this.mSamples.size()) goto L31;
            r9.recordExponentialHistogram(this.mName, this.mSamples.get(r1).intValue(), this.mMin, this.mMax, this.mNumBuckets);     // Catch: Throwable -> L15
            r1 = r1 + 1;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        }
    }

    public static class UserAction {
        private final long mElapsedRealtimeMillis;
        private final String mName;

        public UserAction(String r1, long r2) {
            this.mName = r1;
            this.mElapsedRealtimeMillis = r2;
        }

        public void flushTo(UmaRecorder r4) {
            r4.recordUserAction(this.mName, this.mElapsedRealtimeMillis);
        }
    }

    public CachingUmaRecorder() {
        this.mRwLock = new ReentrantReadWriteLock(false);
        this.mHistogramByName = new HashMap();
        this.mDroppedHistogramSampleCount = new AtomicInteger();
        this.mUserActions = new ArrayList();
    }

    @GuardedBy
    private void cacheHistogramSampleAlreadyWriteLocked(int r10, String r11, int r12, int r13, int r14, int r15) {
        Histogram r1 = this.mHistogramByName.get(r11);
        if (r1 != null) goto L10;
        if (this.mHistogramByName.size() < 256) goto L8;
        this.mDroppedHistogramSampleCount.incrementAndGet();
        return;
    L8:
        Histogram r8 = new Histogram(r10, r11, r13, r14, r15);
        this.mHistogramByName.put(r11, r8);
        r1 = r8;
    L10:
        if (r1.addSample(r10, r11, r12, r13, r14, r15) == true) goto L13;
        this.mDroppedHistogramSampleCount.incrementAndGet();
        return;
    }

    private void cacheOrRecordHistogramSample(int r2, String r3, int r4, int r5, int r6, int r7) {
        if (tryAppendOrRecordSample(r2, r3, r4, r5, r6, r7) == false) goto L5;
        return;
    L5:
        this.mRwLock.writeLock().lock();
    L11:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    L7:
        if (this.mDelegate != null) goto L13;
        cacheHistogramSampleAlreadyWriteLocked(r2, r3, r4, r5, r6, r7);     // Catch: Throwable -> L11
        this.mRwLock.writeLock().unlock();
        return;
    L13:
        this.mRwLock.readLock().lock();     // Catch: Throwable -> L11
        this.mRwLock.writeLock().unlock();
        recordHistogramSampleAlreadyLocked(r2, r3, r4, r5, r6, r7);     // Catch: Throwable -> L18
        this.mRwLock.readLock().unlock();
        return;
    L18:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    }

    @GuardedBy
    private void flushHistogramsAlreadyLocked(Map<String, Histogram> r14, int r15) {
        int r2 = r14.size();
        Iterator<Histogram> r16 = r14.values().iterator();
        int r6 = 0;
    L4:
        if (r16.hasNext() == false) goto L6;
        r6 = r6 + r16.next().flushTo(this.mDelegate);
        goto L4
    L6:
        Log.i(TAG, "Flushed %d samples from %d histograms.", new Object[]{Integer.valueOf(r6), Integer.valueOf(r2)});
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.DroppedHistogramSampleCount", r15, 1, 1000000, 50);
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.FlushedHistogramCount", r2, 1, 100000, 50);
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.InputHistogramSampleCount", r6 + r15, 1, 1000000, 50);
    }

    private void flushUserActionsAlreadyLocked(List<UserAction> r17, int r18) {
        Iterator<UserAction> r1 = r17.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().flushTo(this.mDelegate);
        goto L4
    L6:
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.DroppedUserActionCount", r18, 1, 1000, 50);
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.InputUserActionCount", r17.size() + r18, 1, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, 50);
    }

    @GuardedBy
    private void recordHistogramSampleAlreadyLocked(int r8, String r9, int r10, int r11, int r12, int r13) {
        boolean r0 = true;
        if (r8 != 1) goto L5;
        UmaRecorder r7 = this.mDelegate;
        if (r10 != 0) goto L19;
        r0 = false;
    L19:
        r7.recordBooleanHistogram(r9, r0);
        return;
    L5:
        if (r8 != 2) goto L7;
        this.mDelegate.recordExponentialHistogram(r9, r10, r11, r12, r13);
        return;
    L7:
        if (r8 != 3) goto L9;
        this.mDelegate.recordLinearHistogram(r9, r10, r11, r12, r13);
        return;
    L9:
        if (r8 != 4) goto L12;
        this.mDelegate.recordSparseHistogram(r9, r10);
        return;
    L12:
        throw new UnsupportedOperationException(a.e(r8, "Unknown histogram type "));
    }

    @GuardedBy
    @SuppressLint({"VisibleForTests"})
    private void swapUserActionCallbacksForTesting(@Nullable UmaRecorder r3, @Nullable UmaRecorder r4) {
        if (this.mUserActionCallbacksForTesting != null) goto L5;
        return;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mUserActionCallbacksForTesting.size()) goto L13;
        if (r3 == null) goto L10;
        r3.removeUserActionCallbackForTesting(this.mUserActionCallbacksForTesting.get(r0));
    L10:
        if (r4 == null) goto L12;
        r4.addUserActionCallbackForTesting(this.mUserActionCallbacksForTesting.get(r0));
    L12:
        r0 = r0 + 1;
        goto L7
    }

    private boolean tryAppendOrRecordSample(int r10, String r11, int r12, int r13, int r14, int r15) {
        this.mRwLock.readLock().lock();
    L8:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    L4:
        if (this.mDelegate == null) goto L10;
        recordHistogramSampleAlreadyLocked(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L8
    L6:
        this.mRwLock.readLock().unlock();
        return true;
    L10:
        Histogram r2 = this.mHistogramByName.get(r11);     // Catch: Throwable -> L8
        if (r2 != null) goto L16;
        this.mRwLock.readLock().unlock();
        return false;
    L16:
        if (r2.addSample(r10, r11, r12, r13, r14, r15) == true) goto L6;
        this.mDroppedHistogramSampleCount.incrementAndGet();     // Catch: Throwable -> L8
        goto L6
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    @VisibleForTesting
    public void addUserActionCallbackForTesting(Callback<String> r2) {
        this.mRwLock.writeLock().lock();
    L6:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    L4:
        if (this.mUserActionCallbacksForTesting != null) goto L8;
        this.mUserActionCallbacksForTesting = new ArrayList();     // Catch: Throwable -> L6
    L8:
        this.mUserActionCallbacksForTesting.add(r2);     // Catch: Throwable -> L6
        UmaRecorder r0 = this.mDelegate;     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        r0.addUserActionCallbackForTesting(r2);     // Catch: Throwable -> L6
    L11:
        this.mRwLock.writeLock().unlock();
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    @VisibleForTesting
    public int getHistogramTotalCountForTesting(String r2) {
        this.mRwLock.readLock().lock();
        UmaRecorder r0 = this.mDelegate;     // Catch: Throwable -> L8
        if (r0 == null) goto L10;
        int r3 = r0.getHistogramTotalCountForTesting(r2);     // Catch: Throwable -> L8
        this.mRwLock.readLock().unlock();
        return r3;
    L10:
        Histogram r4 = this.mHistogramByName.get(r2);     // Catch: Throwable -> L8
        if (r4 != null) goto L14;
        this.mRwLock.readLock().unlock();
        return 0;
    L14:
        monitor-enter(r4);     // Catch: Throwable -> L8
        int r1 = Histogram.access$000(r4).size();     // Catch: Throwable -> L19
        monitor-exit(r4);     // Catch: Throwable -> L19
        this.mRwLock.readLock().unlock();
        return r1;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    @VisibleForTesting
    public int getHistogramValueCountForTesting(String r4, int r5) {
        this.mRwLock.readLock().lock();
        UmaRecorder r0 = this.mDelegate;     // Catch: Throwable -> L8
        if (r0 == null) goto L10;
        int r6 = r0.getHistogramValueCountForTesting(r4, r5);     // Catch: Throwable -> L8
        this.mRwLock.readLock().unlock();
        return r6;
    L10:
        Histogram r7 = this.mHistogramByName.get(r4);     // Catch: Throwable -> L8
        int r1 = 0;
        if (r7 != null) goto L15;
        this.mRwLock.readLock().unlock();
        return 0;
    L15:
        monitor-enter(r7);     // Catch: Throwable -> L8
        int r2 = 0;
    L32:
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L18:
        if (r1 >= Histogram.access$000(r7).size()) goto L25;
        if (((Integer) Histogram.access$000(r7).get(r1)).intValue() != r5) goto L22;
        r2 = r2 + 1;     // Catch: Throwable -> L23
    L22:
        r1 = r1 + 1;     // Catch: Throwable -> L23
        goto L32
    L25:
        monitor-exit(r7);     // Catch: Throwable -> L23
        this.mRwLock.readLock().unlock();
        return r2;
    L8:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordBooleanHistogram(String r8, boolean r9) {
        cacheOrRecordHistogramSample(1, r8, r9 ? 1 : 0, 0, 0, 0);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordExponentialHistogram(String r8, int r9, int r10, int r11, int r12) {
        cacheOrRecordHistogramSample(2, r8, r9, r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordLinearHistogram(String r8, int r9, int r10, int r11, int r12) {
        cacheOrRecordHistogramSample(3, r8, r9, r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordSparseHistogram(String r8, int r9) {
        cacheOrRecordHistogramSample(4, r8, r9, 0, 0, 0);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordUserAction(String r3, long r4) {
        this.mRwLock.readLock().lock();
        UmaRecorder r0 = this.mDelegate;     // Catch: Throwable -> L8
        if (r0 == null) goto L10;
        r0.recordUserAction(r3, r4);     // Catch: Throwable -> L8
        this.mRwLock.readLock().unlock();
        return;
    L10:
        this.mRwLock.readLock().unlock();
        this.mRwLock.writeLock().lock();
    L16:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    L12:
        if (this.mDelegate == null) goto L14;
        this.mRwLock.readLock().lock();     // Catch: Throwable -> L16
        this.mRwLock.writeLock().unlock();
        this.mDelegate.recordUserAction(r3, r4);     // Catch: Throwable -> L33
        this.mRwLock.readLock().unlock();
        return;
    L33:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    L14:
        if (this.mUserActions.size() >= 256) goto L18;
        this.mUserActions.add(new UserAction(r3, r4));     // Catch: Throwable -> L16
    L20:
        if (this.mUserActionCallbacksForTesting == null) goto L26;
        int r5 = 0;
    L23:
        if (r5 >= this.mUserActionCallbacksForTesting.size()) goto L26;
        this.mUserActionCallbacksForTesting.get(r5).onResult(r3);     // Catch: Throwable -> L16
        r5 = r5 + 1;
    L26:
        this.mRwLock.writeLock().unlock();
        return;
    L18:
        this.mDroppedUserActionCount++;     // Catch: Throwable -> L16
    L8:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    @VisibleForTesting
    public void removeUserActionCallbackForTesting(Callback<String> r2) {
        this.mRwLock.writeLock().lock();
        List<Callback<String>> r0 = this.mUserActionCallbacksForTesting;     // Catch: Throwable -> L11
        if (r0 != null) goto L7;
        this.mRwLock.writeLock().unlock();
        return;
    L7:
        r0.remove(r2);     // Catch: Throwable -> L11
        UmaRecorder r1 = this.mDelegate;     // Catch: Throwable -> L11
        if (r1 == null) goto L13;
        r1.removeUserActionCallbackForTesting(r2);     // Catch: Throwable -> L11
    L13:
        this.mRwLock.writeLock().unlock();
        return;
    L11:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    }

    public UmaRecorder setDelegate(@Nullable UmaRecorder r6) {
        this.mRwLock.writeLock().lock();
        UmaRecorder r0 = this.mDelegate;     // Catch: Throwable -> L7
        this.mDelegate = r6;     // Catch: Throwable -> L7
        if (BuildConfig.IS_FOR_TEST == false) goto L9;
        swapUserActionCallbacksForTesting(r0, r6);     // Catch: Throwable -> L7
    L9:
        if (r6 != null) goto L12;
        this.mRwLock.writeLock().unlock();
        return r0;
    L12:
        List<UserAction> r1 = null;
        int r2 = 0;
        if (this.mHistogramByName.isEmpty() == true) goto L15;
        Map<String, Histogram> r7 = this.mHistogramByName;     // Catch: Throwable -> L7
        this.mHistogramByName = new HashMap();     // Catch: Throwable -> L7
        int r3 = this.mDroppedHistogramSampleCount.getAndSet(0);     // Catch: Throwable -> L7
    L17:
        if (this.mUserActions.isEmpty() == true) goto L19;
        r1 = this.mUserActions;     // Catch: Throwable -> L7
        this.mUserActions = new ArrayList();     // Catch: Throwable -> L7
        int r4 = this.mDroppedUserActionCount;     // Catch: Throwable -> L7
        this.mDroppedUserActionCount = 0;     // Catch: Throwable -> L7
        r2 = r4;
    L19:
        this.mRwLock.readLock().lock();     // Catch: Throwable -> L7
        this.mRwLock.writeLock().unlock();
        if (r7 != null) goto L36;
    L25:
        if (r1 == null) goto L30;
        flushUserActionsAlreadyLocked(r1, r2);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    L30:
        this.mRwLock.readLock().unlock();
        return r0;
    L36:
        flushHistogramsAlreadyLocked(r7, r3);     // Catch: Throwable -> L23
        goto L25
    L15:
        r7 = null;
        r3 = 0;
    L7:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    }
}
