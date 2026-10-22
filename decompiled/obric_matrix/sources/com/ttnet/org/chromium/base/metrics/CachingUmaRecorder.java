package com.ttnet.org.chromium.base.metrics;

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

/* JADX INFO: loaded from: classes2.dex */
final class CachingUmaRecorder implements UmaRecorder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_HISTOGRAM_COUNT = 256;

    @VisibleForTesting
    static final int MAX_USER_ACTION_COUNT = 256;
    private static final String TAG = "CachingUmaRecorder";

    @Nullable
    private UmaRecorder mDelegate;
    private AtomicInteger mDroppedHistogramSampleCount;
    private int mDroppedUserActionCount;
    private Map<String, Histogram> mHistogramByName;
    private final ReentrantReadWriteLock mRwLock;

    @Nullable
    private List<Callback<String>> mUserActionCallbacksForTesting;
    private List<UserAction> mUserActions;

    @VisibleForTesting
    static class Histogram {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @VisibleForTesting
        static final int MAX_SAMPLE_COUNT = 256;
        private final int mMax;
        private final int mMin;
        private final String mName;
        private final int mNumBuckets;
        private final List<Integer> mSamples;
        private final int mType;

        @Retention(RetentionPolicy.SOURCE)
        @interface Type {
            public static final int BOOLEAN = 1;
            public static final int EXPONENTIAL = 2;
            public static final int LINEAR = 3;
            public static final int SPARSE = 4;
        }

        static {
        }

        Histogram(int r1, String r2, int r3, int r4, int r5) {
            this.mType = r1;
            this.mName = r2;
            this.mMin = r3;
            this.mMax = r4;
            this.mNumBuckets = r5;
            this.mSamples = new ArrayList(1);
        }

        static /* synthetic */ List access$000(Histogram r0) {
            return r0.mSamples;
        }

        synchronized boolean addSample(int r1, String r2, int r3, int r4, int r5, int r6) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.mSamples.size() < 256) goto L9;
            boolean r7 = false;
        L7:
            monitor-exit(this);
            return r7;
        L9:
            this.mSamples.add(Integer.valueOf(r3));     // Catch: Throwable -> L11
            r7 = true;
            goto L7
        }

        synchronized int flushTo(UmaRecorder r9) {
            monitor-enter(this);
            int r0 = this.mType;     // Catch: Throwable -> L32
            int r1 = 0;
            if (r0 != 1) goto L6;
            int r2 = 0;
        L23:
            if (r2 >= this.mSamples.size()) goto L29;
            int r3 = this.mSamples.get(r2).intValue();     // Catch: Throwable -> L32
            String r4 = this.mName;     // Catch: Throwable -> L32
            if (r3 == 0) goto L27;
            boolean r5 = true;
        L28:
            r9.recordBooleanHistogram(r4, r5);     // Catch: Throwable -> L32
            r2 = r2 + 1;     // Catch: Throwable -> L32
            goto L23
        L27:
            r5 = false;
        L29:
            int r10 = this.mSamples.size();     // Catch: Throwable -> L32
            this.mSamples.clear();     // Catch: Throwable -> L32
            monitor-exit(this);
            return r10;
        L6:
            if (r0 == 2) goto L19;
            if (r0 == 3) goto L16;
            if (r0 != 4) goto L29;
        L13:
            if (r1 >= this.mSamples.size()) goto L29;
            r9.recordSparseHistogram(this.mName, this.mSamples.get(r1).intValue());     // Catch: Throwable -> L32
            r1 = r1 + 1;     // Catch: Throwable -> L32
        L16:
            if (r1 >= this.mSamples.size()) goto L29;
            r9.recordLinearHistogram(this.mName, this.mSamples.get(r1).intValue(), this.mMin, this.mMax, this.mNumBuckets);     // Catch: Throwable -> L32
            r1 = r1 + 1;     // Catch: Throwable -> L32
        L19:
            if (r1 >= this.mSamples.size()) goto L29;
            r9.recordExponentialHistogram(this.mName, this.mSamples.get(r1).intValue(), this.mMin, this.mMax, this.mNumBuckets);     // Catch: Throwable -> L32
            r1 = r1 + 1;     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            throw th;
        }
    }

    private static class UserAction {
        private final long mElapsedRealtimeMillis;
        private final String mName;

        UserAction(String r1, long r2) {
            this.mName = r1;
            this.mElapsedRealtimeMillis = r2;
        }

        void flushTo(UmaRecorder r4) {
            r4.recordUserAction(this.mName, this.mElapsedRealtimeMillis);
        }
    }

    static {
    }

    CachingUmaRecorder() {
        this.mRwLock = new ReentrantReadWriteLock(false);
        this.mHistogramByName = new HashMap();
        this.mDroppedHistogramSampleCount = new AtomicInteger();
        this.mUserActions = new ArrayList();
    }

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
    L19:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    L7:
        if (this.mDelegate != null) goto L11;
        cacheHistogramSampleAlreadyWriteLocked(r2, r3, r4, r5, r6, r7);     // Catch: Throwable -> L19
        this.mRwLock.writeLock().unlock();
        return;
    L11:
        this.mRwLock.readLock().lock();     // Catch: Throwable -> L19
        this.mRwLock.writeLock().unlock();
        recordHistogramSampleAlreadyLocked(r2, r3, r4, r5, r6, r7);     // Catch: Throwable -> L16
        this.mRwLock.readLock().unlock();
        return;
    L16:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    }

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
        throw new UnsupportedOperationException("Unknown histogram type " + r8);
    }

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
    L17:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    L4:
        if (this.mDelegate == null) goto L8;
        recordHistogramSampleAlreadyLocked(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L17
    L6:
        this.mRwLock.readLock().unlock();
        return true;
    L8:
        Histogram r2 = this.mHistogramByName.get(r11);     // Catch: Throwable -> L17
        if (r2 != null) goto L14;
        this.mRwLock.readLock().unlock();
        return false;
    L14:
        if (r2.addSample(r10, r11, r12, r13, r14, r15) == true) goto L6;
        this.mDroppedHistogramSampleCount.incrementAndGet();     // Catch: Throwable -> L17
        goto L6
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    @VisibleForTesting
    public void addUserActionCallbackForTesting(Callback<String> r2) {
        this.mRwLock.writeLock().lock();
    L11:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    L4:
        if (this.mUserActionCallbacksForTesting != null) goto L6;
        this.mUserActionCallbacksForTesting = new ArrayList();     // Catch: Throwable -> L11
    L6:
        this.mUserActionCallbacksForTesting.add(r2);     // Catch: Throwable -> L11
        UmaRecorder r0 = this.mDelegate;     // Catch: Throwable -> L11
        if (r0 == null) goto L9;
        r0.addUserActionCallbackForTesting(r2);     // Catch: Throwable -> L11
    L9:
        this.mRwLock.writeLock().unlock();
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    @VisibleForTesting
    public int getHistogramTotalCountForTesting(String r2) {
        this.mRwLock.readLock().lock();
        UmaRecorder r0 = this.mDelegate;     // Catch: Throwable -> L19
        if (r0 == null) goto L8;
        int r3 = r0.getHistogramTotalCountForTesting(r2);     // Catch: Throwable -> L19
    L6:
        this.mRwLock.readLock().unlock();
        return r3;
    L8:
        Histogram r4 = this.mHistogramByName.get(r2);     // Catch: Throwable -> L19
        if (r4 != null) goto L11;
        r3 = 0;
        goto L6
    L11:
        monitor-enter(r4);     // Catch: Throwable -> L19
        int r1 = Histogram.access$000(r4).size();     // Catch: Throwable -> L16
        monitor-exit(r4);     // Catch: Throwable -> L16
        this.mRwLock.readLock().unlock();
        return r1;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    @VisibleForTesting
    public int getHistogramValueCountForTesting(String r4, int r5) {
        this.mRwLock.readLock().lock();
        UmaRecorder r0 = this.mDelegate;     // Catch: Throwable -> L27
        if (r0 == null) goto L8;
        int r6 = r0.getHistogramValueCountForTesting(r4, r5);     // Catch: Throwable -> L27
        this.mRwLock.readLock().unlock();
        return r6;
    L8:
        Histogram r7 = this.mHistogramByName.get(r4);     // Catch: Throwable -> L27
        int r1 = 0;
        if (r7 != null) goto L13;
        this.mRwLock.readLock().unlock();
        return 0;
    L13:
        monitor-enter(r7);     // Catch: Throwable -> L27
        int r2 = 0;
    L30:
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L16:
        if (r1 >= Histogram.access$000(r7).size()) goto L21;
        if (((Integer) Histogram.access$000(r7).get(r1)).intValue() != r5) goto L20;
        r2 = r2 + 1;     // Catch: Throwable -> L24
    L20:
        r1 = r1 + 1;     // Catch: Throwable -> L24
        goto L30
    L21:
        monitor-exit(r7);     // Catch: Throwable -> L24
        this.mRwLock.readLock().unlock();
        return r2;
    L27:
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
        UmaRecorder r0 = this.mDelegate;     // Catch: Throwable -> L35
        if (r0 == null) goto L8;
        r0.recordUserAction(r3, r4);     // Catch: Throwable -> L35
        this.mRwLock.readLock().unlock();
        return;
    L8:
        this.mRwLock.readLock().unlock();
        this.mRwLock.writeLock().lock();
    L32:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    L10:
        if (this.mDelegate == null) goto L12;
        this.mRwLock.readLock().lock();     // Catch: Throwable -> L32
        this.mRwLock.writeLock().unlock();
        this.mDelegate.recordUserAction(r3, r4);     // Catch: Throwable -> L29
        this.mRwLock.readLock().unlock();
        return;
    L29:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    L12:
        if (this.mUserActions.size() >= 256) goto L14;
        this.mUserActions.add(new UserAction(r3, r4));     // Catch: Throwable -> L32
    L16:
        if (this.mUserActionCallbacksForTesting == null) goto L22;
        int r5 = 0;
    L19:
        if (r5 >= this.mUserActionCallbacksForTesting.size()) goto L22;
        this.mUserActionCallbacksForTesting.get(r5).onResult(r3);     // Catch: Throwable -> L32
        r5 = r5 + 1;
    L22:
        this.mRwLock.writeLock().unlock();
        return;
    L14:
        this.mDroppedUserActionCount++;     // Catch: Throwable -> L32
    L35:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    @VisibleForTesting
    public void removeUserActionCallbackForTesting(Callback<String> r2) {
        this.mRwLock.writeLock().lock();
        List<Callback<String>> r0 = this.mUserActionCallbacksForTesting;     // Catch: Throwable -> L12
        if (r0 != null) goto L7;
        this.mRwLock.writeLock().unlock();
        return;
    L7:
        r0.remove(r2);     // Catch: Throwable -> L12
        UmaRecorder r1 = this.mDelegate;     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        r1.removeUserActionCallbackForTesting(r2);     // Catch: Throwable -> L12
    L10:
        this.mRwLock.writeLock().unlock();
        return;
    L12:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    }

    public UmaRecorder setDelegate(@Nullable UmaRecorder r6) {
        this.mRwLock.writeLock().lock();
        UmaRecorder r0 = this.mDelegate;     // Catch: Throwable -> L29
        this.mDelegate = r6;     // Catch: Throwable -> L29
        if (BuildConfig.IS_FOR_TEST == false) goto L6;
        swapUserActionCallbacksForTesting(r0, r6);     // Catch: Throwable -> L29
    L6:
        if (r6 != null) goto L9;
        this.mRwLock.writeLock().unlock();
        return r0;
    L9:
        List<UserAction> r1 = null;
        int r2 = 0;
        if (this.mHistogramByName.isEmpty() == true) goto L12;
        Map<String, Histogram> r7 = this.mHistogramByName;     // Catch: Throwable -> L29
        this.mHistogramByName = new HashMap();     // Catch: Throwable -> L29
        int r3 = this.mDroppedHistogramSampleCount.getAndSet(0);     // Catch: Throwable -> L29
    L14:
        if (this.mUserActions.isEmpty() == true) goto L16;
        r1 = this.mUserActions;     // Catch: Throwable -> L29
        this.mUserActions = new ArrayList();     // Catch: Throwable -> L29
        int r4 = this.mDroppedUserActionCount;     // Catch: Throwable -> L29
        this.mDroppedUserActionCount = 0;     // Catch: Throwable -> L29
        r2 = r4;
    L16:
        this.mRwLock.readLock().lock();     // Catch: Throwable -> L29
        this.mRwLock.writeLock().unlock();
        if (r7 != null) goto L34;
    L22:
        if (r1 == null) goto L27;
        flushUserActionsAlreadyLocked(r1, r2);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    L27:
        this.mRwLock.readLock().unlock();
        return r0;
    L34:
        flushHistogramsAlreadyLocked(r7, r3);     // Catch: Throwable -> L20
        goto L22
    L12:
        r7 = null;
        r3 = 0;
    L29:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    }
}
