package com.bytedance.ttnet.priority;

import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskManager;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RequestDelayController {
    private static final int DEFAULT_RANDOM_SEND_LOWER_BOUNDS_MS = 500;
    private static final int DEFAULT_RANDOM_SEND_UPPER_BOUNDS_MS = 3000;
    private static final int DEFAULT_SPARSE_SEND_INTERVAL_MS = 100;
    private int mAsyncReqDelayMaxCount;
    private final Map<Runnable, Executor> mAsyncReqExecutorMap;
    private final Set<Request> mAsyncSet;
    private String mOwnerStateName;
    private int mRandomSendLowerBoundMs;
    private int mRandomSendUpperBoundMs;
    private final ReadWriteLock mReleaseEnqueueLock;
    private final Lock mReleaseEnqueueWriteLock;
    private final Condition mReleaseExecuteCondition;
    private final Lock mReleaseExecuteLock;
    private int mSparseSendIntervalMs;
    private int mSyncReqDelayMaxCount;
    private final Set<Request> mSyncSet;

    public RequestDelayController() {
        this.mOwnerStateName = null;
        this.mSyncSet = new CopyOnWriteArraySet();
        this.mSyncReqDelayMaxCount = -1;
        ReentrantLock r1 = new ReentrantLock();
        this.mReleaseExecuteLock = r1;
        this.mReleaseExecuteCondition = r1.newCondition();
        this.mAsyncSet = new CopyOnWriteArraySet();
        this.mAsyncReqDelayMaxCount = -1;
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock();
        this.mReleaseEnqueueLock = r0;
        this.mReleaseEnqueueWriteLock = r0.writeLock();
        this.mAsyncReqExecutorMap = new ConcurrentHashMap();
        this.mRandomSendLowerBoundMs = 500;
        this.mRandomSendUpperBoundMs = 3000;
        this.mSparseSendIntervalMs = 100;
    }

    public static /* synthetic */ Lock access$000(RequestDelayController r0) {
        return r0.mReleaseEnqueueWriteLock;
    }

    public static /* synthetic */ Map access$100(RequestDelayController r0) {
        return r0.mAsyncReqExecutorMap;
    }

    private int getP1RandomDelayTime() {
        int r0 = this.mRandomSendLowerBoundMs;
        if (r0 > 0) goto L6;
        r0 = 500;
    L6:
        int r1 = this.mRandomSendUpperBoundMs;
        if (r1 > 0) goto L11;
        r1 = 3000;
    L11:
        if (r0 < r1) goto L13;
        return 0;
    L13:
        int r3 = this.mAsyncSet.size();
        if ((this.mSyncSet.size() + r3) > 8) goto L17;
        return 0;
    L17:
        return new Random().nextInt((r1 - r0) + 1) + r0;
    }

    private boolean useRandomOrSparse() {
        if (this.mSparseSendIntervalMs > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void initWithLocal(int r1, int r2, int r3) {
        this.mSyncReqDelayMaxCount = r1;
        this.mAsyncReqDelayMaxCount = r2;
        this.mSparseSendIntervalMs = r3;
    }

    public void initWithTncConfig(JSONObject r3, String r4) {
        this.mSyncReqDelayMaxCount = r3.optInt("sync_req_delay_max_count", -1);
        this.mAsyncReqDelayMaxCount = r3.optInt("async_req_delay_max_count", -1);
        this.mRandomSendLowerBoundMs = r3.optInt("random_send_lbound_ms", 500);
        this.mRandomSendUpperBoundMs = r3.optInt("random_send_ubound_ms", 3000);
        this.mSparseSendIntervalMs = r3.optInt("sparse_send_interval_ms", 100);
        setOwnerStateName(r4);
    }

    public void notifyRequestCompleted(Request r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.mSyncSet.remove(r2);
        this.mAsyncSet.remove(r2);
    }

    public void releaseAllDelayedRequests() {
        this.mReleaseExecuteLock.lock();
        this.mReleaseExecuteCondition.signalAll();     // Catch: Throwable -> L20
        this.mReleaseExecuteLock.unlock();
        this.mReleaseEnqueueWriteLock.lock();
        Iterator<Map.Entry<Runnable, Executor>> r0 = this.mAsyncReqExecutorMap.entrySet().iterator();     // Catch: Throwable -> L11
        int r1 = 0;
    L6:
        if (r0.hasNext() == false) goto L16;
        Map.Entry<Runnable, Executor> r2 = r0.next();     // Catch: Throwable -> L11
        final Runnable r10 = r2.getKey();     // Catch: Throwable -> L11
        final Executor r12 = r2.getValue();     // Catch: Throwable -> L11
        if (useRandomOrSparse() == false) goto L13;
        r1 = getP1RandomDelayTime();     // Catch: Throwable -> L11
    L14:
        final long r6 = r1;
        final long r8 = 0;
        final int r11 = r1;
        NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new AnonymousClass2(this, r6, r8, r10, r11, r12));     // Catch: Throwable -> L11
        goto L6
    L13:
        r1 = r1 + this.mSparseSendIntervalMs;     // Catch: Throwable -> L11
        goto L14
    L16:
        this.mReleaseEnqueueWriteLock.unlock();
        this.mAsyncSet.clear();
        this.mSyncSet.clear();
        return;
    L11:
        th = move-exception;
        this.mReleaseEnqueueWriteLock.unlock();
        throw th;
    L20:
        th = move-exception;
        this.mReleaseExecuteLock.unlock();
        throw th;
    }

    public boolean requestAsyncDelay(Request r13, boolean r14, final long r15, final Runnable r17, final Executor r18, final RetrofitMetrics r19) {
        if (r15 > 0) goto L5;
        return false;
    L5:
        if (r14 == false) goto L7;
    L9:
        this.mAsyncReqExecutorMap.put(r17, r18);
        this.mAsyncSet.add(r13);
        r19.delayStartTimeStamp = SystemClock.uptimeMillis();
        r19.delayStateName = this.mOwnerStateName;
        r19.asyncDelayCount = this.mAsyncSet.size();
        r19.delayedWithState = true;
        final long r4 = 0;
        NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new AnonymousClass1(this, r15, r4, r17, r18, r19));
        return true;
    L7:
        if (this.mAsyncSet.size() < this.mAsyncReqDelayMaxCount) goto L9;
        return false;
    }

    public void requestBlockingDelay(Request r3, boolean r4, boolean r5, long r6, RetrofitMetrics r8) {
        this.mReleaseExecuteLock.lock();
        if (r6 > 0) goto L6;
    L4:
        this.mReleaseExecuteLock.unlock();
        return;
    L6:
        if (r4 == false) goto L25;
    L12:
        long r0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L10 Exception -> L20
        this.mSyncSet.add(r3);     // Catch: Throwable -> L10 Exception -> L20
        r8.syncDelayCount = this.mSyncSet.size();     // Catch: Throwable -> L10 Exception -> L20
        r8.delayStateName = this.mOwnerStateName;     // Catch: Throwable -> L10 Exception -> L20
        r8.delayedWithState = true;     // Catch: Throwable -> L10 Exception -> L20
        this.mReleaseExecuteCondition.await(r6, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10 Exception -> L20
        if (r5 == false) goto L18;
        int r7 = getP1RandomDelayTime();     // Catch: Throwable -> L10 Exception -> L20
        if (r7 <= 0) goto L17;
        Thread.sleep(r7);     // Catch: Throwable -> L10 Exception -> L20
    L17:
        r8.randomSendTime = r7;     // Catch: Throwable -> L10 Exception -> L20
    L18:
        r8.stateDelayTime = SystemClock.uptimeMillis() - r0;     // Catch: Throwable -> L10 Exception -> L20
    L19:
        this.mReleaseExecuteLock.unlock();
        return;
    L20:
        Logger.e("sleeping interrupted");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mReleaseExecuteLock.unlock();
        throw th;
    L25:
        if (this.mSyncSet.size() < this.mSyncReqDelayMaxCount) goto L12;
        goto L12
    }

    public void setOwnerStateName(String r1) {
        this.mOwnerStateName = r1;
    }
}
